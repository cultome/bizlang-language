package com.cultome.bizlang.language.function;

import java.util.List;

import com.cultome.bizlang.language.BizlangArray;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

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
