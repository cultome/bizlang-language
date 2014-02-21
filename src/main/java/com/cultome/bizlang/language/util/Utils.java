package com.cultome.bizlang.language.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangValue;
import com.cultomebizlang.language.interpreter.Bindings;

public class Utils {

	private static final SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
	
	public static Date parseDate(String dateStr) throws BizlangException {
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new BizlangException("Date format invalid: " + dateStr + ". Try dd/mm/yyyy.");
		}
	}
	
	public static String formatDate(Date date) {
		return formatter.format(date);
	}

	public static boolean areEquivalentNumbers(String nbr1, String nbr2) {
		boolean nbr1IsDecimal = nbr1.contains(".");
		boolean nbr2IsDecimal = nbr2.contains(".");
		
		if(nbr1IsDecimal && nbr2IsDecimal){
			// ambos decimales
			int maxPrecision = Math.max(getPrecision(nbr1), getPrecision(nbr2));
			return areEquivalentNumbers(nbr1, nbr2, maxPrecision);
		} else if(!nbr1IsDecimal && !nbr2IsDecimal){
			// ambos enteros
			return nbr1.equals(nbr2);
		} else {
			// uno de los dos es decimal
			if(nbr1IsDecimal){
				return areEquivalentNumbers(nbr1, nbr2, getPrecision(nbr1));
			} else {
				return areEquivalentNumbers(nbr1, nbr2, getPrecision(nbr2));
			}
		}
	}

	public static boolean compareArrays(List<BizlangValue> thisValue, List<BizlangValue> otherValue) {
		return thisValue.equals(otherValue);
	}

	public static boolean containsFinalValue(List<BizlangValue> values, Object thisValue, Bindings bindings) throws BizlangException {
		for (BizlangValue bizlangValue : values) {
			if(bizlangValue.execute(bindings).equals(thisValue)){
				return true;
			}
		}
		return false;
	}
	
	public static int getPrecision(String nbr) {
		return nbr.substring(nbr.lastIndexOf(".")+1).length();
	}
	
	public static int getPrecision(BigDecimal nbr) {
		return nbr.toPlainString().substring(nbr.toPlainString().lastIndexOf(".")+1).length();
	}

	public static boolean areAllOfThisTypes(List<Object> values, String... classNames){
		boolean keepOn = false;
		for (Object obj : values) {
			keepOn = false;
			for (String className : classNames) {
				if(obj.getClass().getName().endsWith(className)){
					keepOn = true;
					break;
				}
			}
			if(!keepOn){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean areAnyOfThisTypes(List<Object> values, String... classNames){
		for (Object obj : values) {
			for (String className : classNames) {
				if(obj.getClass().getName().endsWith(className)){
					return true;
				}
			}
		}
		
		return false;
	}

	public static List<BizlangValue> cloneList(List<BizlangValue> list) {
		List<BizlangValue> newList = new ArrayList<BizlangValue>();
		for (BizlangValue value : list) {
			newList.add(value);
		}
		return newList;
	}

	public static String replacePlaceholders(String expression, Bindings bindings) {
		if(expression == null){
			return null;
		}
		
		Pattern pattern = Pattern.compile("\\{([\\w\\d_]+?)\\}");
		Matcher matcher = pattern.matcher(expression);
		int idx = 0;
		
		String retunValue = expression.intern();
		String placeholder;
		while(matcher.find(idx)){
			placeholder = matcher.group(1);
			retunValue = retunValue.replaceAll("\\{" + placeholder + "}", bindings.getBinding(placeholder).toString());
			idx = matcher.end();
		}
		
		return retunValue;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> addToTree(Map<String, Object> tree, String name, Object value) {
		// name: uno.dos.tres         value: "algo"
		int dotIdx = name.lastIndexOf(".");
		if (dotIdx < 0) {
			if(name.matches(".*\\[[\\d]+\\].*")){
				String arrayLeafName = name.substring(0, name.indexOf("["));
				String idxStr = name.replaceFirst(arrayLeafName, "").replaceAll("[\\[\\]]", "");
				int idx = Integer.parseInt(idxStr);
				List array = (List) tree.get(arrayLeafName);
				if(array == null){
					array = new ArrayList<Object>();
				}
				// array = [{uno: 1, dos: 2}, {uno: 1, dos: 2}]
				if(array.size() <= idx){
					while(array.size() < idx){
						array.add(null);
					}
					
					// idx = 4, array = [{uno: 1, dos: 2}, {uno: 1, dos: 2}, null, null]
					array.add(value);
					// idx = 4, array = [{uno: 1, dos: 2}, {uno: 1, dos: 2}, null, null, {uno: 1}]
				} else {
					Object mapOrList = array.get(idx);
					if(mapOrList instanceof List){
						((List) mapOrList).add(value);
					} else if(mapOrList instanceof Map){
						merge(mapOrList, value);
					}
				}
				
				tree.put(arrayLeafName, array);
			} else if(tree.get(name) != null){
				Object existingValue = tree.get(name);
				if(existingValue instanceof List){
					((List) existingValue).add(value);
				} else if(existingValue != value){
					ArrayList<Object> newList = new ArrayList<Object>();
					newList.add(existingValue);
					newList.add(value);
					tree.put(name, newList);
				}
			} else {
				tree.put(name, value);
			}
			
			return tree;
		} else {
			String rootName = name.substring(0, dotIdx);
			String leafName = name.substring(dotIdx + 1);
			Object subTree = getSubTree(tree, rootName);
			if (subTree == null) {
				subTree = new HashMap<String, Object>();
			}
			
			Map<String, Object> leaf = null;
			if(subTree instanceof Map){
				leaf = addToTree((Map) subTree, leafName, value);
			} else if(subTree instanceof List){
				List l = ((List) subTree);
				Map lastMapInList = (Map) l.get(l.size()-1);
				leaf = addToTree(lastMapInList, leafName, value);
			}
			Map<String, Object> newTree = addToTree(tree, rootName, leaf);
			
			return newTree;
		}
	}

	@SuppressWarnings("rawtypes")
	private static void merge(Object original, Object merger) {
		if(original instanceof List && merger instanceof List){
			merge((List) original, (List) merger);
		} else if(original instanceof Map && merger instanceof Map){
			merge((Map) original, (Map) merger);
		} else if(merger == null){
			// no-op
		} else {
			throw new RuntimeException("Unrecognized combination");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void merge(Map original, Map merger) {
		Set originalKS = original.keySet();
		Set mergerKS = merger.keySet();
		
		// {tres=[{cuatro=1}]} => {tres=[{cinco=2}]}
		for (Object key : originalKS) {
			if(mergerKS.contains(key)){
				merge(original.get(key), merger.get(key));
			}
		}
		
		for (Object key : mergerKS) {
			if(!originalKS.contains(key)){
				original.put(key, merger.get(key));
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(List original, List merger) {
		int i;
		for(i = 0; i < original.size() && i < merger.size(); i++){
			merge(original.get(i), merger.get(i));
		}
		
		if(merger.size() > original.size()){
			for(; i < merger.size(); i++)
			original.add(merger.get(i));
		}
	}

	public static Object getPropertyFrom(Map<String, Object> map, String id) {
		Object currentObj = map;
		String[] split = id.split("\\.");
		for(int i = 0; i < split.length; i++){
			String propName = split[i];
			if(propName.contains("[")){
				currentObj = getIndexedProperty(currentObj, propName);
			} else {
				currentObj = getPropertyFromObject(currentObj, propName);
			}
		}
		
		if(currentObj != null && currentObj.toString().matches("^[\\d]*(.[\\d]+)?$")){
			return new BigDecimal(currentObj.toString());
		}
		
		return currentObj;
	}
	
	private static Object getIndexedProperty(Object obj, String name) {
		String[] split = name.split("[\\[\\]]");
		Object list = getPropertyFromObject(obj, split[0]);
		int idx = Integer.parseInt(split[1]);
		
		if(list instanceof List){
			List<?> resList = (List<?>) list;
			if(resList.size() <= idx){
				return null;
			}
			return resList.get(idx);
		} else if(list.getClass().getName().startsWith("[L")){
			return ((Object[]) list)[idx];
		}
		
		return null;
	}

	private static Object getPropertyFromObject(Object obj, String property) {
			try {
				if(obj instanceof Bindings){
					return ((Bindings) obj).getBinding(property);
				} else if(obj instanceof Map){
					return ((Map<?, ?>) obj).get(property);
				} else if(property.contains("[")){
					return getIndexedProperty(obj, property);
				} else {
					Method getter = getAppropiateGetter(obj, property);
					return getter.invoke(obj);
				}
			} catch (IllegalArgumentException e) {
				throw new RuntimeException("Imposible to extract property [" + property + "] from object [" + obj.getClass().getName() + "]. Invalid arguments.");
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Imposible to extract property [" + property + "] from object [" + obj.getClass().getName() + "]. Illegal access.");
			} catch (InvocationTargetException e) {
				throw new RuntimeException("Imposible to extract property [" + property + "] from object [" + obj.getClass().getName() + "]. Invocation target.");
			}
	}

	private static Method getAppropiateGetter(Object obj, String property) {
		// buscamos la propiedad con los prototipos de getters
		try {
			return obj.getClass().getMethod(property);
		} catch (Exception e) {}
		
		try {
			return obj.getClass().getMethod("get" + property.substring(0, 1).toUpperCase() + property.substring(1));
		} catch (Exception e) {}
		
		throw new RuntimeException("There is no getter method for property [" + property + "] in class [" + obj.getClass().getName() + "].");
	}
	
	public static Object getSubTree(Object obj, String rootName) {
		if(rootName == null || obj == null){
			return null;
		}
		
		if(!(obj instanceof Map)){
			return null;
		}
		
		Map<?,?> tree = (Map<?,?>) obj;
		if(rootName.contains(".")){
			int firstLevelIdx = rootName.indexOf(".");
				return getSubTree(tree.get(rootName.substring(0, firstLevelIdx)), rootName.substring(firstLevelIdx+1));
		} else {
			Object x = tree.get(rootName);
			return x;
		}
	}

	private static boolean areEquivalentNumbers(String nbr1, String nbr2, int precision) {
		BigDecimal bd1 = new BigDecimal(nbr1).setScale(precision);
		BigDecimal bd2 = new BigDecimal(nbr2).setScale(precision);
		return bd1.equals(bd2);
	}
}
