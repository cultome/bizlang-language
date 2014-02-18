package com.cultome.bizlang.language.function;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

/* 
 * JavaFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public interface JavaFunction {
	Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException;
}
