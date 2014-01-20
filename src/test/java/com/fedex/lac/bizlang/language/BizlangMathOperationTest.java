package com.fedex.lac.bizlang.language;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

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
		op.addParam(new BizlangValue(BizlangLexer.NBR, "1", 1));
		op.addParam(new BizlangValue(BizlangLexer.NBR, "5", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.math.BigDecimal", r.getClass().getName());
		assertEquals("6", ((BigDecimal) r).toPlainString());
	}
	
	@Test
	public void testExecuteStringConcatenation() throws BizlangException {
		BizlangMathOperation op = new BizlangMathOperation("+", 1);
		op.addParam(new BizlangValue(BizlangLexer.STR, "hola ", 1));
		op.addParam(new BizlangValue(BizlangLexer.STR, "mundo!", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.lang.String", r.getClass().getName());
		assertEquals("hola mundo!", (String) r);
	}
	
	@Test
	public void testExecuteDateSum() throws BizlangException {
		BizlangMathOperation op = new BizlangMathOperation("+", 1);
		op.addParam(new BizlangValue(BizlangLexer.DATE, "1/1/2014", 1));
		op.addParam(new BizlangValue(BizlangLexer.NBR, "7", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.util.Date", r.getClass().getName());
		assertEquals("8/1/2014", new SimpleDateFormat("d/M/yyyy").format((Date) r));
	}
	
	@Test
	public void testExecuteDateSubstract() throws BizlangException {
		BizlangMathOperation op = new BizlangMathOperation("+", 1);
		op.addParam(new BizlangValue(BizlangLexer.DATE, "1/1/2014", 1));
		op.addParam(new BizlangValue(BizlangLexer.NBR, "-2", 1));
		Object r = op.execute(new Bindings());
		assertEquals("java.util.Date", r.getClass().getName());
		assertEquals("30/12/2013", new SimpleDateFormat("d/M/yyyy").format((Date) r));
	}

}
