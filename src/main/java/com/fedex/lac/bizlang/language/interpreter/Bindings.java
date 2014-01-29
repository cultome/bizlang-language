package com.fedex.lac.bizlang.language.interpreter;

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

	public static final String FNCT_NS = "__functions__";
	public static final String CNFG_NS = "__configs__";
	public static final String CNFG_NS_DATABASES = "databases";

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
		((Map<String, BizlangRule>) getBinding(FNCT_NS)).put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <E> E getConfig(String configSpaceName, String configName, Class<E> clazz) {
		Map<String, Object> configNS = (Map<String, Object>) getBinding(CNFG_NS);
		Map<String, Object> cnfgs = (Map<String, Object>) configNS.get(configSpaceName);
		return (E) cnfgs.get(configName);
	}
	
	@SuppressWarnings("unchecked")
	public void addConfig(String configSpaceName, String configName, Object configValue) {
		ensureConfigSpaceExist();
		Map<String, Object> configNS = (Map<String, Object>) getBinding(CNFG_NS);
		Map<String, Object> cnfgs = (Map<String, Object>) configNS.get(configSpaceName);
		if(cnfgs == null){
			cnfgs = new HashMap<String, Object>();
			configNS.put(configSpaceName, cnfgs);
		}
		cnfgs.put(configName, configValue);
	}

	public void addBindings(Map<String, Object> valueMap) {
		getBindings().putAll(valueMap);
	}

	private void ensureConfigSpaceExist() {
		try{
			getBinding(CNFG_NS);
		} catch(RuntimeException e){
			addBinding(CNFG_NS, new HashMap<String, Object>());
		}
	}

	private void ensureFunctionSpaceExist() {
		try{
			getBinding(FNCT_NS);
		} catch(RuntimeException e){
			addBinding(FNCT_NS, new HashMap<String, BizlangRule>());
		}
	}

}
