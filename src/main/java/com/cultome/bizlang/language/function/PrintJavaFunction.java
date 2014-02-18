package com.cultome.bizlang.language.function;

import java.io.PrintStream;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

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
		} catch(RuntimeException e){
			System.err.println(b.toString());
		}
		
		
		return b.toString();
	}

}
