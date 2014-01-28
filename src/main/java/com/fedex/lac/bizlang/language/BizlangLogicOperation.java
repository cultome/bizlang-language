package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;
import java.util.Date;

import com.fedex.lac.bizlang.language.interpreter.Bindings;

/* 
 * BizlangLogicOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
public class BizlangLogicOperation extends BizlangExpression {
	
	private BizlangValue leftValue;
	private BizlangValue rightValue;

	public BizlangLogicOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Object lVal = leftValue.execute(bindings);
		Object rVal = rightValue.execute(bindings);
		Integer compare = -2;
		
		if(lVal instanceof Date && rVal instanceof Date){
			compare = compareWithDate((Date) lVal, (Date) rVal);
		} else if(lVal instanceof String){
			compare = compareWithString(lVal.toString(), rVal.toString());
			
		} else if(lVal instanceof BigDecimal){
			compare = compareWithBigDecimal((BigDecimal) lVal, rVal);
			
		}
		
		if("<".equals(getName()) && compare < 0){
			return true;
		} else if(">".equals(getName()) && compare > 0){
			return true;
		} else if("<=".equals(getName()) && compare <= 0){
			return true;
		} else if(">=".equals(getName()) && compare >= 0){
			return true;
		} else if("==".equals(getName()) && compare == 0){
			return true;
		} else if("!=".equals(getName()) && compare != 0){
			return true;
		}
		
		return false;
	}

	private Integer compareWithDate(Date lVal, Date rVal) {
		return lVal.compareTo(rVal);
	}

	private Integer compareWithBigDecimal(BigDecimal lValBigDec, Object rVal) {
		if(rVal instanceof String){ // si el primero es NBR y el segundo STR...
			if(((String) rVal).matches("^[\\d]+(.[\\d]+)$")){ // si es un numero
				return lValBigDec.compareTo(new BigDecimal((String) rVal)); // convertimos a NBR
			} else {
				return lValBigDec.toString().compareTo(rVal.toString()); // convertimos el NBR a STR
			}
		} else if(rVal instanceof BigDecimal){ // ambos son NBR
			return lValBigDec.compareTo((BigDecimal) rVal);
		}
		return -2;
	}

	private Integer compareWithString(String lVal, String rVal) {
		return lVal.compareTo(rVal);
	}

	public void addParam(BizlangValue value) {
		if(leftValue == null){
			leftValue = value;
		} else {
			rightValue = value;
		}
	}

	public BizlangValue getLeftValue() {
		return leftValue;
	}

	public BizlangValue getRightValue() {
		return rightValue;
	}

}
