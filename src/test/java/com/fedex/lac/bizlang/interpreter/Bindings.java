package com.fedex.lac.bizlang.interpreter;

import java.util.HashMap;
import java.util.Map;

/* 
 * Bindings.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class Bindings {
	
	Map<String, Object> bindings;

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
			throw new RuntimeException("Binding dont exist. [" + id + "]");
		}
		return value;
	}

}
