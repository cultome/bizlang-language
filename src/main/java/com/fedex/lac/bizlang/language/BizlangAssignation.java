package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangAssignation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangAssignation extends BizlangExpression {
	
	private BizlangExpression rValue;

	public BizlangAssignation(String lVal, int srcLineDefinedAt) {
		super(lVal, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Object result = rValue.execute(bindings);
		bindings.addBinding(name, result);
		return result;
	}

	public BizlangExpression addLValue(BizlangExpression rValue) {
		this.rValue = rValue;
		return rValue;
	}
	
	@Override
	public String toString() {
		return getName() + " = " + rValue;
	}

}
