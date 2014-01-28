package com.fedex.lac.bizlang.language.function;

import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.interpreter.Bindings;

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
