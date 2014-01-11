package com.fedex.lac.bizlang.language.function;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;

/* 
 * BizlangJavaFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public interface BizlangJavaFunction {
	Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException;
}
