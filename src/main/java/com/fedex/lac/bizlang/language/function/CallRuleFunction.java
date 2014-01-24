package com.fedex.lac.bizlang.language.function;

import java.util.Map;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangRule;

/* 
 * CallRuleFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	24/01/2014
 */
public class CallRuleFunction implements JavaFunction {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		Object fnctName = params[0].execute(bindings);
		BizlangRule bizlangRule = ((Map<String, BizlangRule>) bindings.getBinding(Bindings.FNCT_SPC_NM)).get(fnctName);
		return bizlangRule.call(bindings);
	}
}
