package com.cultomebizlang.language.interpreter;

import java.util.HashMap;
import java.util.Map;

import com.cultome.bizlang.language.BizlangRule;
import com.cultome.bizlang.language.util.Utils;

public class Bindings {

	public static final String FNCT_NS = "__functions__";
	public static final String CNFG_NS = "__configs__";
	public static final String CNFG_NS_DATABASES = "databases";
	public static final String CNFG_NS_WEBSERVICES = "webservices";

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
			Object property = Utils.getPropertyFrom(bindings, id);
			if(property == null){
				throw new RuntimeException("Binding dont exist. [" + id + "]");
			}
			return property;
		}
		return value;
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
