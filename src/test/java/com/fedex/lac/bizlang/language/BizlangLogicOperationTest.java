package com.fedex.lac.bizlang.language;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

/* 
 * BizlangLogicOperationTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
public class BizlangLogicOperationTest {
	
	@Test
	public void testCompareNumbers() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("<=", 1);
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "100", 1));
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "1", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
		assertFalse(((Boolean) r).booleanValue());
	}

	@Test
	public void testCompareString() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("<", 1);
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "xyz", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
		assertTrue(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypes() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypesReverse() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypesReverseWithNbr() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "10.0", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
		assertTrue(((Boolean) r).booleanValue());
	}

}
