package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;


/* 
 * BizlangRule.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	24/01/2014
 */
public class BizlangRule extends BizlangBlock {

	public BizlangRule(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}
	
	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		return null;
	}
	
	public Object call(Bindings bindings) throws BizlangException{
		Object returnValue = super.getValue(bindings);
		bindings.addBinding(getName(), returnValue);
		return returnValue;
	}
	
	@Override
	public String toString() {
		return "rule: " + getName();
	}
}
