package com.fedex.lac.bizlang.language.function;

import java.io.PrintStream;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;

/* 
 * PrintJavaFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class PrintJavaFunction implements JavaFunction {

	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		StringBuilder b = new StringBuilder();
		for (BizlangExpression obj : params) {
			b.append(obj.execute(bindings).toString() + " ");
		}
		
		if(b.length() > 1){
			b.deleteCharAt(b.length()-1);
		}
		
		try{
			PrintStream out = (PrintStream) bindings.getBinding("STDOUT");
			out.println(b.toString());
		} catch(Exception e){
			e.printStackTrace();
			System.err.println(b.toString());
		}
		
		
		return b.toString();
	}

}
