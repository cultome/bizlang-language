package com.fedex.lac.bizlang.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fedex.lac.bizlang.language.BizlangRule;

/* 
 * Bindings.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class Bindings {

	public static final String FNCT_SPC_NM = "__functions__";

	private Map<String, Object> bindings;

	public Object addBinding(String name, Object value) {
		return getBindings().put(name, value);
	}

	public Map<String, Object> getBindings() {
		if(bindings == null){
			bindings = new HashMap<String, Object>();
		}
		return bindings;
	}

	public Object getBinding(String id) {
		Object value = bindings.get(id);
		if(value == null){
			if(id.contains(".")){
				return getNestedProperty(id);
			}
			
			throw new RuntimeException("Binding dont exist. [" + id + "]");
		}
		return value;
	}

	private Object getNestedProperty(String id) {
		String[] split = id.split("\\.");
		Object rootObj = bindings.get(split[0]);
		if(rootObj == null){
			throw new RuntimeException("Binding dont exist. [" + id + "]");
		}

		Object currentObj = rootObj;
		for(int i = 1; i < split.length; i++){
			currentObj = getPropertyFromObject(currentObj, split[i]);
		}
		
		if(currentObj.toString().matches("^[\\d]*(.[\\d]+)?$")){
			return new BigDecimal(currentObj.toString());
		}
		
		return currentObj;
	}

	private Object getPropertyFromObject(Object obj, String property) {
			try {
				if(obj instanceof Map){
					return ((Map<?, ?>) obj).get(property);
				} else if(property.contains("[")){
					String[] split = property.split("[\\[\\]]");
					Object list = getPropertyFromObject(obj, split[0]);
					int idx = Integer.parseInt(split[1]);
					
					if(list instanceof List){
						return ((List<?>) list).get(idx);
					} else if(list.getClass().getName().startsWith("[L")){
						return ((Object[]) list)[idx];
					}
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
			return null;
	}
	
	private Method getAppropiateGetter(Object obj, String property) {
		// buscamos la propiedad con los prototipos de getters
		try {
			return obj.getClass().getMethod(property);
		} catch (Exception e) {}
		
		try {
			return obj.getClass().getMethod("get" + property.substring(0, 1).toUpperCase() + property.substring(1));
		} catch (Exception e) {}
		
		throw new RuntimeException("There is no getter method for property [" + property + "] in class [" + obj.getClass().getName() + "].");
	}

	@SuppressWarnings("unchecked")
	public void addRule(String key, BizlangRule value) {
		ensureFunctionSpaceExist();
		((Map<String, BizlangRule>) getBinding(FNCT_SPC_NM)).put(key, value);
	}

	private void ensureFunctionSpaceExist() {
		try{
			getBinding(FNCT_SPC_NM);
		} catch(RuntimeException e){
			addBinding(FNCT_SPC_NM, new HashMap<String, BizlangRule>());
		}
	}

}
