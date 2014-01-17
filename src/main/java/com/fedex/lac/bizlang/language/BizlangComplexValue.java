package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;


/* 
 * BizlangComplexValue.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangComplexValue extends BizlangValue {
	
	private Object complexValue;

	public BizlangComplexValue(int type, String strRepr, int srcLineDefinedAt, Object value) {
		super(type, strRepr, srcLineDefinedAt);
		complexValue = value;
	}
	
	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		return complexValue;
	}

	public Object getComplexValue() {
		return complexValue;
	}

	@Override
	public String toString() {
		return complexValue.toString();
	}
	
	public String inspect() {
		return "BizlangComplexValue [complexValue=" + complexValue + "]";
	}
	
	

}
