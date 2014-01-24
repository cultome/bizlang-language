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
	
	/*
	 * 
	 * String VS
	 * 
	 * 
	 */

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
	
	/*
	 * 
	 * Number VS
	 * 
	 * 
	 */
	
	@Test
	public void testEqualsNumber() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.NBR, "10.9", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.NBR, "10.90", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "10", 1);
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}

	@Test
	public void testEqualsNumberVsString() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.NBR, "10.5", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.NBR, "2", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "10.5", 1);
		assertFalse(v1.equals(v2, bindings));
		assertTrue(v1.equals(v3, bindings));
	}
	
	@Test
	public void testEqualsNumberVsArray() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.NBR, "5", 1);
		
		BizlangArray arrayTrue = new BizlangArray("__array__", 1);
		arrayTrue.addElement(new BizlangValue(BizlangLexer.NBR, "5", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.STR, "cinco", 1));
		
		BizlangArray arrayFalse = new BizlangArray("__array__", 1);
		arrayFalse.addElement(new BizlangValue(BizlangLexer.NBR, "20", 1));
		arrayFalse.addElement(new BizlangValue(BizlangLexer.STR, "veinte", 1));
		
		assertTrue(v1.equals(arrayTrue, bindings));
		assertFalse(v1.equals(arrayFalse, bindings));
	}
	
	@Test
	public void testEqualsNumberVsRange() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.NBR, "7", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.NBR, "1", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.NBR, "20", 1);
		
		BizlangRange rangeTrue = new BizlangRange("__range__", 1);
		rangeTrue.setLowerLimit(new BizlangValue(BizlangLexer.NBR, "1", 1));
		rangeTrue.setUpperLimit(new BizlangValue(BizlangLexer.NBR, "20", 1));
		
		BizlangRange rangeFalse = new BizlangRange("__range__", 1);
		rangeFalse.setLowerLimit(new BizlangValue(BizlangLexer.NBR, "1", 1));
		rangeFalse.setUpperLimit(new BizlangValue(BizlangLexer.NBR, "6", 1));
		
		assertTrue(v1.equals(rangeTrue, bindings));
		assertTrue(v2.equals(rangeTrue, bindings));
		assertTrue(v3.equals(rangeTrue, bindings));
		assertFalse(v1.equals(rangeFalse, bindings));
	}

	/*
	 * 
	 * Date VS
	 * 
	 * 
	 */

	@Test
	public void testEqualsDateVsDate() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.DATE, "01/03/2010", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "10", 1);
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}

	@Test
	public void testEqualsDateVsString() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.STR, "01/03/2010", 1);
		BizlangValue v3 = new BizlangValue(BizlangLexer.STR, "1/4/2010", 1);
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}
	
	@Test
	public void testEqualsDateVsArray() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1);
		
		BizlangArray arrayTrue = new BizlangArray("__array__", 1);
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "2/10/1983", 1));
		
		BizlangArray arrayFalse = new BizlangArray("__array__", 1);
		arrayFalse.addElement(new BizlangValue(BizlangLexer.DATE, "2/10/2010", 1));
		arrayFalse.addElement(new BizlangValue(BizlangLexer.DATE, "28/10/2010", 1));
		
		assertTrue(v1.equals(arrayTrue, bindings));
		assertFalse(v1.equals(arrayFalse, bindings));
	}
	
	@Test
	public void testEqualsDateVsRange() throws BizlangException {
		BizlangValue v1 = new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1);
		BizlangValue v2 = new BizlangValue(BizlangLexer.DATE, "1/4/2010", 1);
		
		BizlangRange rangeTrue = new BizlangRange("__range__", 1);
		rangeTrue.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		rangeTrue.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "1/4/2010", 1));
		
		BizlangRange rangeFalse = new BizlangRange("__range__", 1);
		rangeFalse.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "2/3/2010", 1));
		rangeFalse.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "1/4/2010", 1));
		
		assertTrue(v1.equals(rangeTrue, bindings));
		assertTrue(v2.equals(rangeTrue, bindings));
		assertFalse(v1.equals(rangeFalse, bindings));
	}

	/*
	 * 
	 * Range VS
	 * 
	 * 
	 */

	@Test
	public void testEqualsRangeVsRange() throws BizlangException {
		BizlangRange v1 = new BizlangRange("__range__", 1);
		v1.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		v1.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "4/3/2010", 1));
		
		BizlangRange v2 = new BizlangRange("__range__", 1);
		v2.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		v2.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "4/3/2010", 1));
		
		BizlangRange v3 = new BizlangRange("__range__", 1);
		v3.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		v3.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "3/3/2010", 1));
		
		assertTrue(v1.equals(v2, bindings));
		assertFalse(v1.equals(v3, bindings));
	}

	@Test
	public void testEqualsRangeVsArray() throws BizlangException {
		BizlangRange v1 = new BizlangRange("__range__", 1);
		v1.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		v1.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "4/3/2010", 1));
		
		BizlangArray arrayTrue = new BizlangArray("__array__", 1);
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "2/3/2010", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "3/3/2010", 1));
		arrayTrue.addElement(new BizlangValue(BizlangLexer.DATE, "4/3/2010", 1));
		
		BizlangArray arrayFalse = new BizlangArray("__array__", 1);
		arrayFalse.addElement(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		arrayFalse.addElement(new BizlangValue(BizlangLexer.DATE, "3/3/2010", 1));
		arrayFalse.addElement(new BizlangValue(BizlangLexer.DATE, "4/3/2010", 1));
		
		assertTrue(v1.equals(arrayTrue, bindings));
		assertFalse(v1.equals(arrayFalse, bindings));
	}
	
}
