package com.cultome.bizlang.language;

import java.util.List;

import com.cultomebizlang.language.interpreter.Bindings;

/* 
 * BizlangCustomLogicOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangCustomLogicOperation extends BizlangLogicOperation {

	public BizlangCustomLogicOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Object lVal = getLeftValue().execute(bindings);
		Object rVal = getRightValue().execute(bindings);
		
		if("><".equals(getName())){
			if(!(rVal instanceof List)){
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
}
