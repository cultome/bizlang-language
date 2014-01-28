package com.fedex.lac.bizlang.language.function;

import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.BizlangArray;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;

/* 
 * CountFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	28/01/2014
 */
public class CountFunction implements JavaFunction {

	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		Object exp = params[0].execute(bindings);
		if(exp instanceof List<?>){
			return ((List<?>) exp).size();
		} else if(exp instanceof BizlangArray){
			return execute(bindings, (BizlangArray) exp);
		}
		return -1;
	}

}
