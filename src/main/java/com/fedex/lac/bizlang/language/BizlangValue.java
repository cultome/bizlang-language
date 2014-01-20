package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	
	public static final int COMPLEX_TYPE_ARRAY = 100;
	public static final int COMPLEX_TYPE_RANGE = 101;
	
	protected int type;
	protected String value;

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
		case BizlangLexer.DATE:
			return parseDate(value);
		}
		
		return null;
	}

	private Object parseDate(String dateStr) throws BizlangException {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new BizlangException("Date format invalid: " + dateStr + ". Try dd/mm/yyyy.");
		}
	}

	public int getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	
	public String inspect() {
		return "BizlangValue [type=" + type + ", value=" + value + "]";
	}

	@Override
	public String toString() {
		return value;
	}

}
