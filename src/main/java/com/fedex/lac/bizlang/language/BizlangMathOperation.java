package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * MathOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangMathOperation extends BizlangFunction {

	public BizlangMathOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		BigDecimal result = null;
		BigDecimal nbr;
		for(BizlangValue param : getParamList()){
			nbr = new BigDecimal(param.execute(bindings).toString());
			if(result == null){
				result = nbr;
			} else {
				if("+".equals(name)){
					result = result.add(nbr);
				} else if("-".equals(name)){
					result = result.subtract(nbr);
				} else if("*".equals(name)){
					result = result.multiply(nbr);
				} else if("/".equals(name)){
					result = result.divide(nbr);
				}
			}
		}
		return result;
	}
}
