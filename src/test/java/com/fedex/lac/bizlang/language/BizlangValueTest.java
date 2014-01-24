package com.fedex.lac.bizlang.language;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

public class BizlangValueTest {
	
	private Bindings bindings;

	@Before
	public void setUp() throws Exception {
		bindings = new Bindings();
	}

	@Test
	public void testEqualsStringVsString() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.STR, "uno", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.STR, "1", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "uno", 1);
		assertFalse(v1.equals(v2, bindings));
		assertTrue(v1.equals(v3, bindings));
	}
	
	@Test
	public void testEqualsStringVsNumber() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.STR, "1", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.NBR, "1", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "uno", 1);
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}
	
	
	@Test
	public void testEqualsStringVsDate() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.STR, "1/3/2010", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.DATE, "15/7/2013", 1);
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}
	
	@Test
	public void testEqualsStringVsArray() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.STR, "1", 1);
		
		BizlangArray arrayTrue = new BizlangArray("__array__", 1);
		arrayTrue.addElement(new BizlangValue(BizlangLexer.NBR, "1", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.STR, "uno", 1));
		
		BizlangArray arrayFalse = new BizlangArray("__array__", 1);
		arrayFalse.addElement(new BizlangValue(BizlangLexer.NBR, "2", 1));
		arrayFalse.addElement(new BizlangValue(BizlangLexer.STR, "dos", 1));
		
		assertTrue(v1.equals(arrayTrue, bindings));
		assertFalse(v1.equals(arrayFalse, bindings));
	}

}
