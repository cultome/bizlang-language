package com.fedex.lac.bizlang.language;

import java.util.logging.Logger;

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
	
	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	protected String name;
	protected int definedAt;

	public BizlangExpression(String fnctName, int srcLineDefinedAt) {
		this.name = fnctName;
		this.definedAt = srcLineDefinedAt;
	}

	public Object execute(Bindings bindings) throws BizlangException {
		LOGGER.info("[ENTER]" + getClass().getSimpleName());
		Object returnValue = getValue(bindings);
		LOGGER.info("[EXIT]" + getClass().getSimpleName());
		return returnValue;
	}
	
	public abstract Object getValue(Bindings bindings) throws BizlangException;

	public String getName() {
		return name;
	}

	public int getDefinedAt() {
		return definedAt;
	}
}
