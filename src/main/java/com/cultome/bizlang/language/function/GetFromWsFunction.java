package com.cultome.bizlang.language.function;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	private static final String APPLICATION_XML_MIME_TYPE = "application/xml";
	private static final String TEXT_XML_MIME_TYPE = "text/xml";
	
	private XMLInputFactory inputFactory;
	
	public GetFromWsFunction() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
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
		if(APPLICATION_XML_MIME_TYPE.equals(response.getContentType()) || TEXT_XML_MIME_TYPE.equals(response.getContentType())){
			return parseXml(response.getContentBody());
		}
		return null;
	}

	protected Map<String, Object> parseXml(String contentBody) {
		final Map<String, Object> returnValue = new HashMap<String, Object>();
		final List<String> expandedRoutes = new ArrayList<String>();
		DataNodeListener router = new DataNodeListener() {
			@Override public void onData(String route, String data) {
				expandedRoutes.add(route);
			}
		};
		searchForDataNodes(contentBody, router);
		final Map<String, String> routesDic = parseNestedRoutes(expandedRoutes);
		//tokens.token.requestor.display_name=tokens.token[].requestor.display_name
		//tokens.token.requestor.username    =tokens.token[].requestor.username
		//tokens.token.requestor.password    =tokens.token[].requestor.password
		//tokens.token.requestor.id          =tokens.token.requestor[].id
		DataNodeListener walker = new DataNodeListener() {
			protected int idx = 0;
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override public void onData(String route, String data) {
				String actualRoute = routesDic.get(route);
				if(actualRoute.contains("[]")){
					String subTreeRoute = actualRoute.substring(0, actualRoute.indexOf("["));
					String leafRoute = actualRoute.substring(actualRoute.indexOf("[") + 3);
					Object subTree = Utils.getSubTree(returnValue, subTreeRoute);
					Map lastMapInserted = null;
					if(subTree instanceof Map){
						lastMapInserted = (Map) subTree;
					} else if(subTree instanceof List){
						List l = ((List) subTree);
						lastMapInserted = (Map) l.get(l.size() - 1);
					}
					// agregamos a un mapa existente o es un nuevo nodo?
					if(lastMapInserted != null && Utils.getSubTree(lastMapInserted, leafRoute) == null){
						Utils.addToTree(lastMapInserted, leafRoute, data);
					} else {
						actualRoute = actualRoute.replaceFirst("\\[\\]", "[" + idx++ + "]");
						Utils.addToTree(returnValue, actualRoute, data);
					}
				}
			}
		};
		searchForDataNodes(contentBody, walker);
		return returnValue;
	}
	
	private void searchForDataNodes(String contentBody, DataNodeListener listener){
		Stack<String> paramTree = new Stack<String>();
		
		try {
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
						listener.onData(route, data);
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
	}
	
	/*
	uno.dos.tres   => uno.dos.tres
	uno.dos.cuatro => uno.dos.cuatro
	uno.tres       => uno.tres
	---------
	uno.dos.tres   => uno.dos.tres[]
	uno.dos.cuatro => uno.dos.cuatro[]
	uno.tres       => uno.tres
	---------
	uno.dos.tres   => uno.dos[].tres
	uno.dos.cuatro => uno.dos[].cuatro
	uno.tres       => uno.tres
	*/
	
	protected Map<String, String> parseNestedRoutes(List<String> expandedRoutes){
		Map<String, String> routesDic = new HashMap<String, String>();
		// 1) detectamos las rutas que se repiten
		for (String route : expandedRoutes) {
			String existingRoute = routesDic.get(route);
			if(existingRoute == null){
				routesDic.put(route, route);
			} else if(!existingRoute.endsWith("[]")) {
				routesDic.put(route, existingRoute + "[]");
			}
		}
//		{
//			Envelope.Body.getCountryListResponse.return.action=Envelope.Body.getCountryListResponse.return.action[], 
//			Envelope.Body.getCountryListResponse.return.countryCode=Envelope.Body.getCountryListResponse.return.countryCode[], 
//			Envelope.Body.getCountryListResponse.return.countryName=Envelope.Body.getCountryListResponse.return.countryName[]
//		}
		// 2) intentamos agrupar por el nivel mas profundo
		for(Entry<String, String> entry : routesDic.entrySet()){
			if(entry.getValue().endsWith("[]")){
				int depth = countLevels(entry.getValue());
				if(depth > 0){
					for(String nestedRoute : routesDic.values()){
						if(!nestedRoute.equals(entry.getValue())){
							if(countLevels(nestedRoute) == depth){
								for(int i = depth-1; i > 0; i--){
									String levelName = getLevelName(entry.getValue(), i);
									String nestedLevelName = getLevelName(nestedRoute, i);
									if(nestedLevelName.equals(levelName) || nestedLevelName.equals(levelName + "[]")){
										// agrupamos
										String newNestedRoute = insertNestedLevel(entry.getValue(), i);
										// eliminamos la anidacion del final
										newNestedRoute = removeLastNestIndication(newNestedRoute);
										routesDic.put(entry.getKey(), newNestedRoute);
									}
								}
							}
						}
					}
				}
			}
		}
//		{
//			Envelope.Body.getCountryListResponse.return.action=Envelope.Body[].getCountryListResponse.return.action, 
//			Envelope.Body.getCountryListResponse.return.countryCode=Envelope.Body[].getCountryListResponse.return.countryCode, 
//			Envelope.Body.getCountryListResponse.return.countryName=Envelope.Body[].getCountryListResponse.return.countryName
//		}
		// 3) Buscamos elementos raiz en reversa
		Collection<String> groupedRoutes = routesDic.values();
		if(groupedRoutes.size() > 1){
			boolean isCommonToAll = true;
			
			do{
				String reference = "";
				String subRoute;
				boolean first = true;
				for (String route : groupedRoutes) {
					if(first){
						reference = getLevelAfterFirstCollection(route);
						first = false;
					} else {
						subRoute = getLevelAfterFirstCollection(route);
						if(!subRoute.equals(reference)){
							isCommonToAll = false;
							break;
						}
					}
				}
				
				if(isCommonToAll){
					int actualLevel = countLevels(reference);
					for(String key : routesDic.keySet()){
						String actualValue = routesDic.get(key);
						String twoLevels = insertNestedLevel(actualValue, actualLevel + 1);
						String newLevel = removeFirstNestIndication(twoLevels);
						routesDic.put(key, newLevel);
					}
				}
			} while(isCommonToAll);
		}
		
		return routesDic;
	}
	
	private String getLevelAfterFirstCollection(String route) {
		int collectionIdx = route.indexOf("[");
		int idx = route.indexOf(".", collectionIdx + 3);
		if(idx > 0){
			return route.substring(0, idx);
		}
		return route;
	}

	protected String removeFirstNestIndication(String doubleNestedRoute) {
		int idx = doubleNestedRoute.indexOf("[");
		return doubleNestedRoute.substring(0, idx) + doubleNestedRoute.substring(idx + 2);
	}
	
	protected String removeLastNestIndication(String doubleNestedRoute) {
		int idx = doubleNestedRoute.lastIndexOf("[");
		return doubleNestedRoute.substring(0, idx) + doubleNestedRoute.substring(idx + 2);
	}

	protected String insertNestedLevel(String route, int level) {
		StringBuilder b = new StringBuilder();
		String[] split = route.split("\\.");
		boolean first = true;
		for(int i = 0; i < split.length; i++){
			// ponemos el punto?
			if(first){
				first = false;
			} else {
				b.append(".");
			}
			// el pedazo de ruta
			b.append(split[i]);
			
			// la indicacion de anidado
			if(i == level){
				b.append("[]");
			}
		}
		return b.toString();
	}

	// uno.dos.cuatro
	protected String getLevelName(String route, int level) {
		String[] split = route.split("\\.");
		if(level >= split.length){
			return null;
		}
		return split[level];
	}

	protected int countLevels(String value) {
		int idx = 0;
		int count = 0;
		while((idx = value.indexOf(".", idx+1)) > 0){
			count++;
		}
		return count;
	}

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
	
	interface DataNodeListener {
		void onData(String route, String data);
	}

}
