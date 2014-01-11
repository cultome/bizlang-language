package com.fedex.lac.bizlang.language.function;

import com.fedex.lac.bizlang.language.BizlangException;

/* 
 * BizlangJavaFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public interface BizlangJavaFunction {
	Object execute(Object... params) throws BizlangException;
}
