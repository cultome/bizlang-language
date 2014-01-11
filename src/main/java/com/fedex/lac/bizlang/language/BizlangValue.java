package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangValue.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangValue extends BizlangExpression {
	
	private int type;
	private String value;

	public BizlangValue(int type, String value, int srcLineDefinedAt) {
		super("[" + type +":" + srcLineDefinedAt + "]", srcLineDefinedAt);
		this.type = type;
		this.value = value;
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		return value;
	}

	public int getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}
