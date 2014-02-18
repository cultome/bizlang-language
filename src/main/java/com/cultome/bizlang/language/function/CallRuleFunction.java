package com.cultome.bizlang.language.function;

import java.util.Map;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.BizlangRule;
import com.cultomebizlang.language.interpreter.Bindings;

public class CallRuleFunction implements JavaFunction {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		Object fnctName = params[0].execute(bindings);
		BizlangRule bizlangRule = ((Map<String, BizlangRule>) bindings.getBinding(Bindings.FNCT_NS)).get(fnctName);
		return bizlangRule.call(bindings);
	}
}
