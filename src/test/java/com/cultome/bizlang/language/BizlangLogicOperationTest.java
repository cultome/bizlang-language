package com.cultome.bizlang.language;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangLogicOperation;
import com.cultome.bizlang.language.BizlangValue;
import com.cultome.bizlang.language.parser.BizlangLexer;
import com.cultomebizlang.language.interpreter.Bindings;

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
		assertTrue(r instanceof Boolean);
		assertFalse(((Boolean) r).booleanValue());
	}

	@Test
	public void testCompareString() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("<", 1);
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "xyz", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r instanceof Boolean);
		assertTrue(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypes() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r instanceof Boolean);
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypesReverse() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "abc", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r instanceof Boolean);
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testDiferentTypesReverseWithNbr() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("==", 1);
		cond.addParam(new BizlangValue(BizlangLexer.NBR, "10", 1));
		cond.addParam(new BizlangValue(BizlangLexer.STR, "10.0", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r instanceof Boolean);
		assertTrue(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testWithDates() throws BizlangException {
		BizlangLogicOperation cond = new BizlangLogicOperation("<=", 1);
		cond.addParam(new BizlangValue(BizlangLexer.DATE, "1/1/2014", 1));
		cond.addParam(new BizlangValue(BizlangLexer.DATE, "3/1/2014", 1));
		Object r = cond.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r instanceof Boolean);
		assertTrue(((Boolean) r).booleanValue());
	}

}
