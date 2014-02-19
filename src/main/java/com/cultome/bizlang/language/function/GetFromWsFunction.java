package com.cultome.bizlang.language.function;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.cultome.bizlang.dataaccess.WSReader;
import com.cultome.bizlang.dataaccess.object.HttpMethod;
import com.cultome.bizlang.dataaccess.object.WsResponse;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.util.Utils;
import com.cultomebizlang.language.interpreter.Bindings;

public class GetFromWsFunction implements JavaFunction {

	public static final String ACCESSOR = "accessor";
	public static final String ENDPOINT_PROPERTY = "endpoint";
	public static final String HTTP_METHOD_PROPERTY = "httpMethod";
	public static final String CONTENT_PROPERTY = "content";
	public static final String HEADERS_PROPERTY = "headers";
	private static final String XML_MIME_TYPE = "application/xml";
	
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		try {
			if(params.length < 1){
				throw new RuntimeException("getFromWs function requires at least one parameter: web service alias.");
			}
			
			String wsAlias = (String) params[0].execute(bindings);
			
			// extraemos los objetos necesarios
			WSReader accessor = bindings.getConfig(Bindings.CNFG_NS_WEBSERVICES, ACCESSOR, WSReader.class);
			Map<String, Object> config = bindings.getConfig(Bindings.CNFG_NS_WEBSERVICES, wsAlias, Map.class);
			// sacamos las configuracion de la peticion
			String endpoint = (String) config.get(ENDPOINT_PROPERTY);
			HttpMethod method = HttpMethod.valueOf(((String) config.get(HTTP_METHOD_PROPERTY)).toUpperCase());
			String content = (String) config.get(CONTENT_PROPERTY);
			Map<String, String> headers = (Map<String, String>) config.get(HEADERS_PROPERTY);
			// hacemos el remplazo de datos para la peticion
			endpoint = Utils.replacePlaceholders(endpoint, bindings);
			content = Utils.replacePlaceholders(content, bindings);
			Set<String> keySet = headers.keySet();
			for(String key : keySet){
				headers.put(key, Utils.replacePlaceholders(headers.get(key), bindings));
			}
			
			WsResponse response = accessor.call(endpoint, method, content, headers);
			
			Map<String, Object> flatResponse = flattenResponse(response);
			
			return flatResponse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizlangException(e);
		}
	}

	protected Map<String, Object> flattenResponse(WsResponse response) {
		if(XML_MIME_TYPE.equals(response.getContentType())){
			return parseXml(response.getContentBody());
		}
		return null;
	}

	protected Map<String, Object> parseXml(String contentBody) {
		Stack<String> paramTree = new Stack<String>();
		Map<String, Object> returnValue = new HashMap<String, Object>();
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(new ByteArrayInputStream(contentBody.getBytes()));
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					paramTree.push(startElement.getName().getLocalPart());
				} else if (event.isCharacters()) {
					Characters chars = event.asCharacters();
					String data = chars.getData();
					if(!data.matches("^[\\s]+$")){
						String route = getTreeRoute(paramTree);
						Utils.addToTree(returnValue, route, data);
					}
				} else if (event.isEndElement()) {
					if(!paramTree.isEmpty()){
						paramTree.pop();
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return returnValue;
	}
	
	// TODO REUSED
	private String getTreeRoute(Stack<String> paramTree) {
		StringBuilder b = new StringBuilder();
		boolean first = true;
		for (Iterator<String> it = paramTree.iterator(); it.hasNext();) {
			if (first) {
				b.append(it.next());
				first = false;
			} else {
				b.append("." + it.next());
			}
		}
		return b.toString();
	}

}
