package com.cultome.bizlang.language.function;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
		Map<String, String> detectCollections = detectCollections(contentBody);
		return fillMap(detectCollections, contentBody);
	}

	protected Map<String, Object> fillMap(final Map<String, String> routes, String contentBody) {
		final Map<String, Object> returnValue = new HashMap<String, Object>();
		
		searchForDataNodes(contentBody, new DataNodeListener() {
			protected Map<String, Integer> idxs = new HashMap<String, Integer>();
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override public void onData(String route, String data) {
				String actualRoute = routes.get(route);
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
						if(leafRoute.contains("[]")){
							if(idxs.get(leafRoute) == null){
								idxs.put(leafRoute, 0);
							}
							
							String actualLeafRoute = setIndexes(leafRoute);
							Utils.addToTree(lastMapInserted, actualLeafRoute, data);
						} else {
							Utils.addToTree(lastMapInserted, leafRoute, data);
						}
					} else {
						if(idxs.get(subTreeRoute) == null){
							idxs.put(subTreeRoute, 0);
						}
						
						actualRoute = actualRoute.replaceFirst("\\[\\]", "[" + idxs.get(subTreeRoute) + "]");
						int newIdx = idxs.get(subTreeRoute) + 1;
						// reseteamos los indices
						for(String key : idxs.keySet()){
							idxs.put(key, 0);
						}
						// restauramos el indice principal
						idxs.put(subTreeRoute, newIdx);
						
						Utils.addToTree(returnValue, actualRoute, data);
					}
				} else {
					Utils.addToTree(returnValue, actualRoute, data);
				}
			}

			private String setIndexes(String route) {
				//licensePortList[].action
				// 1) contamos los indices a sustituir
//				int idx = 0;
//				int count = 0;
//				while((idx = route.indexOf("[", idx)) > 0){
//					count++;
//					idx += 2;
//				}
				
				// 2) reemplazamos el ultimo indice
				int lastIdx = route.lastIndexOf("[");
				String replaced = route.substring(0, lastIdx) + "[" + idxs.get(route) + "]" + route.substring(lastIdx + 2);
				idxs.put(route, idxs.get(route) + 1);
				
				return replaced;
			}
		});
		
		return returnValue;
	}

	protected Map<String, String> detectCollections(String contentBody) {
		final Map<String, String> routes = new HashMap<String, String>();
		
		searchForDataNodes(contentBody, new DataNodeListener() {
			boolean isParsingFirstNode = true;
			boolean isFirstDataNode = true;
			String firstElementRoute = "";

			@Override
			public void onData(String route, String data) {
				if (isFirstDataNode) {
					firstElementRoute = route;
					isFirstDataNode = false;
				} else {
					if (isParsingFirstNode && route.equals(firstElementRoute)) {
						isParsingFirstNode = false;
					}
				}

				if (isParsingFirstNode) {
					if (routes.get(route) == null) {
						routes.put(route, route);
					} else {
						routes.put(route, insertNestedLevel(route, countLevels(route) - 1));
					}

				} else {
					String detectedRoute = routes.get(route);
					if (detectedRoute == null) {
						throw new RuntimeException("Invalid format in response document.");
					}

					int lvl = countLevels(detectedRoute) - 1;
					String parentLvlName = getLevelName(detectedRoute, lvl);
					if (!parentLvlName.endsWith("[]")) {
						for (String key : routes.keySet()) {
							String routeValue = routes.get(key);
							int routeValueLvl = countLevels(routeValue) - 1;
							if (routeValueLvl >= lvl) {
								// uno.dos.tres   uno.dos
								String refParentLvlName = getLevelName(detectedRoute, lvl);
								String existingParentLvlName = getLevelName(routeValue, lvl);
								if (refParentLvlName.equals(existingParentLvlName)) {
									int idxBeforeChange = routeValue.indexOf("[");
									String newNestedLevel = insertNestedLevel(routeValue, lvl);
									int idxAfterChange = newNestedLevel.indexOf("[");

									if ((idxBeforeChange < 0 && idxAfterChange > 0) || (idxBeforeChange > 0 && idxAfterChange > 0 && idxBeforeChange != idxAfterChange)) {
										routes.put(key, newNestedLevel);
									}
								}

							}
						}
					}
				}
			}
		});

		return routes;
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
	
//	protected Map<String, String> parseNestedRoutes(List<String> expandedRoutes){
//	}
//	
//	private String getLevelAfterFirstCollection(String route) {
//		int collectionIdx = route.indexOf("[");
//		int idx = route.indexOf(".", collectionIdx + 3);
//		if(idx > 0){
//			return route.substring(0, idx);
//		}
//		return route;
//	}
//
//	protected String removeFirstNestIndication(String doubleNestedRoute) {
//		int idx = doubleNestedRoute.indexOf("[");
//		return doubleNestedRoute.substring(0, idx) + doubleNestedRoute.substring(idx + 2);
//	}
//	
//	protected String removeLastNestIndication(String doubleNestedRoute) {
//		int idx = doubleNestedRoute.lastIndexOf("[");
//		return doubleNestedRoute.substring(0, idx) + doubleNestedRoute.substring(idx + 2);
//	}

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
