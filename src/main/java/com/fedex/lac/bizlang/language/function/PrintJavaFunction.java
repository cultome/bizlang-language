package com.fedex.lac.bizlang.language.function;

import com.fedex.lac.bizlang.language.BizlangException;

/* 
 * PrintJavaFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class PrintJavaFunction implements BizlangJavaFunction {

	@Override
	public Object execute(Object... params) throws BizlangException {
		StringBuilder b = new StringBuilder();
		for (Object obj : params) {
			b.append(obj.toString() + " ");
		}
		
		if(b.length() > 1){
			b.deleteCharAt(b.length()-1);
		}
		
		System.out.println(b.toString());
		
		return b.toString();
	}

}
