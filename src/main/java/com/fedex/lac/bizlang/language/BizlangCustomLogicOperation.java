package com.fedex.lac.bizlang.language;

import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangCustomLogicOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangCustomLogicOperation extends BizlangExpression {

	private BizlangValue leftValue;
	private BizlangValue rightValue;
	
	public BizlangCustomLogicOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Object lVal = leftValue.execute(bindings);
		Object rVal = rightValue.execute(bindings);
		
		if("><".equals(getName())){
			if(!rVal.getClass().getName().endsWith("List")){
				throw new RuntimeException("The include operator only work with array/range in the rValue.");
			}
			
			List<BizlangValue> list = (List<BizlangValue>) rVal;
			
			Object finalVal;
			for (BizlangValue val : list) {
				finalVal = val.execute(bindings);
				if(finalVal.equals(lVal)){
					return true;
				}
			}
			
			return false;
		}
		return null;
	}

	public void addParam(BizlangValue value) {
		if(leftValue == null){
			leftValue = value;
		} else {
			rightValue = value;
		}		
	}

}
