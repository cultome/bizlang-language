package com.cultome.bizlang.language.function;

import java.util.Map;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.BizlangRule;
import com.cultomebizlang.language.interpreter.Bindings;

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
		BizlangRule bizlangRule = ((Map<String, BizlangRule>) bindings.getBinding(Bindings.FNCT_NS)).get(fnctName);
		return bizlangRule.call(bindings);
	}
}
