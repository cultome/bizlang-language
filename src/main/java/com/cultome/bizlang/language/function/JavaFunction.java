package com.cultome.bizlang.language.function;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

public interface JavaFunction {
	Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException;
}
