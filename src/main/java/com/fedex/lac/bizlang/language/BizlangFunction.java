package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.function.BizlangJavaFunction;
import com.fedex.lac.bizlang.language.function.PrintJavaFunction;

/* 
 * BizlangFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangFunction extends BizlangExpression {
	
	private List<BizlangValue> paramList;
	
	public BizlangFunction(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		BizlangJavaFunction fnct = getJavaImplementation(name, paramList);
		return fnct.execute(paramList.toArray());
	}

	private BizlangJavaFunction getJavaImplementation(String name, List<BizlangValue> paramList) {
		if("print".equals(name)){
			return new PrintJavaFunction();
		}
		return null;
	}

	public BizlangValue addParam(BizlangValue param) {
		getParamList().add(param);
		return param;
	}

	public List<BizlangValue> getParamList() {
		if(paramList == null){
			paramList = new ArrayList<BizlangValue>();
		}
		return paramList;
	}

}
