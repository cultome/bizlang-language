package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

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
		switch(type){
		case BizlangLexer.NBR:
			return new BigDecimal(value);
		case BizlangLexer.STR:
			return value.replaceAll("\"", "");
		case BizlangLexer.ID:
		case BizlangLexer.OBJPROP:
			return bindings.getBinding(value);
		}
		
		return null;
	}

	public int getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[" + BizlangLexer.tokenNames[type] + "] " + value;
	}

}