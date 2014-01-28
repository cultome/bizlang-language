package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.function.CallRuleFunction;
import com.fedex.lac.bizlang.language.function.CountFunction;
import com.fedex.lac.bizlang.language.function.JavaFunction;
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
	
	private List<BizlangExpression> paramList;
	
	public BizlangFunction(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		JavaFunction fnct = getJavaImplementation(name, paramList);
		return fnct.execute(bindings, paramList.toArray(new BizlangExpression[]{}));
	}

	protected List<Object> getFinalValues(Bindings bindings) throws BizlangException {
		List<Object> values = new ArrayList<Object>();
		for(BizlangExpression param : getParamList()){
			values.add(param.execute(bindings));
		}
		return values;
	}

	public BizlangExpression addParam(BizlangExpression param) {
		getParamList().add(param);
		return param;
	}

	public List<BizlangExpression> getParamList() {
		if(paramList == null){
			paramList = new ArrayList<BizlangExpression>();
		}
		return paramList;
	}

	private JavaFunction getJavaImplementation(String name, List<BizlangExpression> paramList) {
		if("print".equals(name)){
			return new PrintJavaFunction();
		} else if("callRule".equals(name)){
			return new CallRuleFunction();
		} else if("count".equals(name)){
			return new CountFunction();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return getName() + "()";
	}

}
