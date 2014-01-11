package com.fedex.lac.bizlang.language;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangMathOperationTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangMathOperationTest {

	@Test
	public void testExecuteIntegerSum() throws BizlangException {
		BizlangMathOperation op = new BizlangMathOperation("+", 1);
		op.addParam(new BizlangValue(10, "1", 1));
		op.addParam(new BizlangValue(10, "5", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.math.BigDecimal", r.getClass().getName());
		assertEquals("6", ((BigDecimal) r).toPlainString());
	}
	
	@Test
	public void testExecuteStringConcatenation() throws BizlangException {
		BizlangMathOperation op = new BizlangMathOperation("+", 1);
		op.addParam(new BizlangValue(9, "hola ", 1));
		op.addParam(new BizlangValue(9, "mundo!", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.lang.String", r.getClass().getName());
		assertEquals("hola mundo!", (String) r);
	}

}
