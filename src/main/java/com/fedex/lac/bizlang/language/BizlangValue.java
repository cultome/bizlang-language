package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.util.Utils;

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
		super("[" + type + ":" + srcLineDefinedAt + "]", srcLineDefinedAt);
		this.type = type;
		this.value = value;
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		switch (type) {
		case BizlangLexer.NBR:
			return new BigDecimal(value);
		case BizlangLexer.STR:
			return value.replaceAll("\"", "");
		case BizlangLexer.ID:
		case BizlangLexer.OBJPROP:
			return bindings.getBinding(value);
		case BizlangLexer.DATE:
			return Utils.parseDate(value);
		}

		return null;
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BizlangValue) {
			BizlangValue bizVal = (BizlangValue) obj;
			
			switch (getType()) {
			case BizlangLexer.NBR:
				switch (bizVal.getType()) {
				case BizlangLexer.STR:
					return getValue().equalsIgnoreCase(bizVal.getValue());
				case BizlangLexer.NBR:
					return Utils.areEquivalentNumbers(getValue(), bizVal.getValue());
				case BizlangLexer.DATE:
					return false;
				}
				break;
			case BizlangLexer.STR:
				switch (bizVal.getType()) {
				case BizlangLexer.STR:
				case BizlangLexer.NBR:
				case BizlangLexer.DATE:
					return getValue().equalsIgnoreCase(bizVal.getValue());
				}
				break;
			case BizlangLexer.DATE:
				switch (bizVal.getType()) {
				case BizlangLexer.STR:
				case BizlangLexer.DATE:
					try {
						return Utils.parseDate(getValue()).equals(Utils.parseDate(bizVal.getValue()));
					} catch (BizlangException e) {
						return false;
					}
				case BizlangLexer.NBR:
					return false;
				}
				break;
			}
		}

		return false;
	}

	/**
	 * Las comparaciones se dan de acuerdo a la siguiente tabla:
	 * 
	 *       |   STR        |   NBR        |  DATE      | Range
	 * ------|--------------|--------------|------------|----------------
	 * STR   | Equals       | Equivalent   | Equivalent |
	 * NBR   | Equivalent   | Equivalent   | false      |
	 * DATE  | Equivalent   | false        | Equals     |
	 * ARRAY | Contains     | Contains     | Contains   |
	 * RANGE | false        | Contains     | Contains   |
	 * 
	 * @param obj
	 * @param bindings
	 * @return
	 * @throws BizlangException
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(BizlangValue obj, Bindings bindings) throws BizlangException {
		Object thisValue = execute(bindings);
		Object otherValue = obj.execute(bindings);

		switch (getType()) {
		case BizlangLexer.NBR:
			switch (obj.getType()) {
			case BizlangLexer.STR:
			case BizlangLexer.NBR:
			case BizlangLexer.DATE:
				return equals(obj);
			case COMPLEX_TYPE_ARRAY:
			case COMPLEX_TYPE_RANGE:
				return ((List<BizlangValue>) otherValue).contains(this);
			}
			break;
		case BizlangLexer.STR:
			switch (obj.getType()) {
			case BizlangLexer.STR:
			case BizlangLexer.NBR:
			case BizlangLexer.DATE:
				return equals(obj);
			case COMPLEX_TYPE_ARRAY:
				return ((List<BizlangValue>) otherValue).contains(this);
			case COMPLEX_TYPE_RANGE:
				return false;
			}
			break;
		case BizlangLexer.DATE:
			switch (obj.getType()) {
			case BizlangLexer.STR:
			case BizlangLexer.DATE:
			case BizlangLexer.NBR:
				return equals(obj);
			case COMPLEX_TYPE_ARRAY:
			case COMPLEX_TYPE_RANGE:
				return ((List<BizlangValue>) otherValue).contains(this);
			}
			break;
		case BizlangLexer.ID:
		case BizlangLexer.OBJPROP:
			switch (obj.getType()) {
			case BizlangLexer.STR:
				if(thisValue instanceof String){
					return ((String) thisValue).equalsIgnoreCase((String) otherValue);
				} else {
					return thisValue.toString().equalsIgnoreCase((String) otherValue);
				}
			case BizlangLexer.DATE:
				if(thisValue instanceof Date){
					return Utils.formatDate((Date) otherValue).equalsIgnoreCase(Utils.formatDate((Date) thisValue));
				} else {
					return Utils.formatDate((Date) otherValue).equalsIgnoreCase(thisValue.toString());
				}
			case BizlangLexer.NBR:
				if(thisValue instanceof BigDecimal){
					return Utils.areEquivalentNumbers(((BigDecimal) otherValue).toPlainString(), ((BigDecimal) thisValue).toPlainString());
				} else {
					return ((BigDecimal) otherValue).toPlainString().equals(thisValue.toString());
				}
			case COMPLEX_TYPE_ARRAY:
			case COMPLEX_TYPE_RANGE:
				// si se requiere formateamos el tipo de dato
				if(thisValue instanceof Date){
					thisValue = Utils.parseDate(Utils.formatDate((Date) thisValue));
				}
				return Utils.containsFinalValue((List<BizlangValue>) otherValue, thisValue, bindings);
			}
			break;
		case COMPLEX_TYPE_ARRAY:
		case COMPLEX_TYPE_RANGE:
			switch(obj.getType()){
				case COMPLEX_TYPE_ARRAY:
				case COMPLEX_TYPE_RANGE:
					return Utils.compareArrays((List<BizlangValue>) thisValue, (List<BizlangValue>) otherValue);
			}
			break;
		}

		return false;
	}
}
