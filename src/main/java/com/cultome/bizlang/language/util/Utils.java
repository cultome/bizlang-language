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
			if(tree.get(name) == null){
				tree.put(name, value);
				return tree;
			} else {
				Object existingValue = tree.get(name);
				if(existingValue != value){
					if(existingValue instanceof List<?>){
						((List) existingValue).add(value);
					} else {
						ArrayList<Object> multivalue = new ArrayList<Object>();
						multivalue.add(existingValue);
						multivalue.add(value);
						tree.put(name, multivalue);
					}
				}
				return tree;
			}
		} else {
			String rootName = name.substring(0, dotIdx);
			String leafName = name.substring(dotIdx + 1);
			Map<String, Object> subTree = getSubTree(tree, rootName);
			if (subTree == null) {
				subTree = new HashMap<String, Object>();
			}
			Map<String, Object> leaf = addToTree(subTree, leafName, value);
			Map<String, Object> newTree = addToTree(tree, rootName, leaf);
			return newTree;
		}
	}
	
	//----------------------------
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
	//----------------------------
	@SuppressWarnings("unchecked")
	private static Map<String, Object> getSubTree(Object obj, String rootName) {
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
			return (Map<String, Object>) tree.get(rootName);
		}
	}

	private static boolean areEquivalentNumbers(String nbr1, String nbr2, int precision) {
		BigDecimal bd1 = new BigDecimal(nbr1).setScale(precision);
		BigDecimal bd2 = new BigDecimal(nbr2).setScale(precision);
		return bd1.equals(bd2);
	}
}
