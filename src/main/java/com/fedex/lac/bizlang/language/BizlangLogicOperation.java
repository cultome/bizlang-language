package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangLogicOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
public class BizlangLogicOperation extends BizlangExpression{
	
	private BizlangValue leftValue;
	private BizlangValue rightValue;

	public BizlangLogicOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Object lVal = leftValue.execute(bindings);
		Object rVal = rightValue.execute(bindings);
		Integer compare = -2;
		
		if(lVal.getClass().getName().endsWith("String")){
			compare = ((String) lVal).compareTo(rVal.toString());
		} else if(lVal.getClass().getName().endsWith("BigDecimal")){
			BigDecimal lValBigDec = (BigDecimal) lVal;
			
			if(rVal.getClass().getName().endsWith("String")){ // si el primero es NBR y el segundo STR...
				if(((String) rVal).matches("^[\\d]+(.[\\d]+)$")){ // si es un numero
					compare = lValBigDec.compareTo(new BigDecimal((String) rVal)); // convertimos a NBR
				} else {
					compare = lValBigDec.toString().compareTo(rVal.toString()); // convertimos el NBR a STR
				}
			} else if(rVal.getClass().getName().endsWith("BigDecimal")){ // ambos son NBR
				compare = lValBigDec.compareTo((BigDecimal) rVal);
			}
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

	public void addParam(BizlangValue value) {
		if(leftValue == null){
			leftValue = value;
		} else {
			rightValue = value;
		}
	}

}
