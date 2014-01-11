package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangExpression.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public abstract class BizlangExpression {
	
	protected String name;
	protected int definedAt;

	public BizlangExpression(String fnctName, int srcLineDefinedAt) {
		this.name = fnctName;
		this.definedAt = srcLineDefinedAt;
	}

	public abstract Object execute(Bindings bindings) throws BizlangException;

	public String getName() {
		return name;
	}

	public int getDefinedAt() {
		return definedAt;
	}
}
