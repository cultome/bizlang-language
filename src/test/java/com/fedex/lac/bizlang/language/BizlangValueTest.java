package com.fedex.lac.bizlang.language;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

public class BizlangValueTest {
	
	private Bindings bindings;
	
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
	 * Range/Arrays VS
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

	/*
	 * 
	 * ID's VS
	 * 
	 * 
	 */

	private BizlangValue v1;
	private BizlangValue v2;
	private BizlangValue v3;
	private BizlangValue v4;
	
	@Before
	public void setUp() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 2, 1);
		
		bindings = new Bindings();
		bindings.addBinding("id_str", "myValue");
		bindings.addBinding("id_nbr", new BigDecimal("12.34"));
		bindings.addBinding("id_date", cal.getTime());
		bindings.addBinding("id_obj", new Object());
		
		v1 = new BizlangValue(BizlangLexer.ID, "id_str", 1);
		v2 = new BizlangValue(BizlangLexer.ID, "id_nbr", 1);
		v3 = new BizlangValue(BizlangLexer.ID, "id_date", 1);
		v4 = new BizlangValue(BizlangLexer.ID, "id_obj", 1);
	}
	
	@Test
	public void testEqualsIdVsString() throws BizlangException {
		BizlangValue ref1 = new BizlangValue(BizlangLexer.STR, "myValue", 1);
		BizlangValue ref2 = new BizlangValue(BizlangLexer.STR, "anotherValue", 1);
		assertTrue(v1.equals(ref1, bindings));
		assertFalse(v2.equals(ref1, bindings));
		assertFalse(v3.equals(ref1, bindings));
		assertFalse(v4.equals(ref1, bindings));
		
		assertFalse(v1.equals(ref2, bindings));
		assertFalse(v2.equals(ref2, bindings));
		assertFalse(v3.equals(ref2, bindings));
		assertFalse(v4.equals(ref2, bindings));
		
	}
	
	@Test
	public void testEqualsIdVsNumber() throws BizlangException {
		BizlangValue ref1 = new BizlangValue(BizlangLexer.NBR, "12.34", 1);
		BizlangValue ref2 = new BizlangValue(BizlangLexer.NBR, "1234", 1);
		assertFalse(v1.equals(ref1, bindings));
		assertTrue(v2.equals(ref1, bindings));
		assertFalse(v3.equals(ref1, bindings));
		assertFalse(v4.equals(ref1, bindings));
		
		assertFalse(v1.equals(ref2, bindings));
		assertFalse(v2.equals(ref2, bindings));
		assertFalse(v3.equals(ref2, bindings));
		assertFalse(v4.equals(ref2, bindings));
	}
	
	@Test
	public void testEqualsIdVsDate() throws BizlangException {
		BizlangValue ref1 = new BizlangValue(BizlangLexer.DATE, "01/03/2010", 1);
		BizlangValue ref2 = new BizlangValue(BizlangLexer.DATE, "2/10/1983", 1);
		assertFalse(v1.equals(ref1, bindings));
		assertFalse(v2.equals(ref1, bindings));
		assertTrue(v3.equals(ref1, bindings));
		assertFalse(v4.equals(ref1, bindings));
		
		assertFalse(v1.equals(ref2, bindings));
		assertFalse(v2.equals(ref2, bindings));
		assertFalse(v3.equals(ref2, bindings));
		assertFalse(v4.equals(ref2, bindings));
	}
	
	@Test
	public void testEqualsIdVsArray() throws BizlangException {
		BizlangArray ref1 = new BizlangArray("__array__", 1);
		ref1.addElement(new BizlangValue(BizlangLexer.STR, "myValue", 1));
		ref1.addElement(new BizlangValue(BizlangLexer.NBR, "12.34", 1));
		ref1.addElement(new BizlangValue(BizlangLexer.DATE, "01/03/2010", 1));
		
		BizlangArray ref2 = new BizlangArray("__array__", 1);
		ref1.addElement(new BizlangValue(BizlangLexer.STR, "anotherValue", 1));
		ref1.addElement(new BizlangValue(BizlangLexer.NBR, "1234", 1));
		ref1.addElement(new BizlangValue(BizlangLexer.DATE, "2/03/2010", 1));
		
		assertTrue(v1.equals(ref1, bindings));
		assertTrue(v2.equals(ref1, bindings));
		assertTrue(v3.equals(ref1, bindings));
		assertFalse(v4.equals(ref1, bindings));
		
		assertFalse(v1.equals(ref2, bindings));
		assertFalse(v2.equals(ref2, bindings));
		assertFalse(v3.equals(ref2, bindings));
		assertFalse(v4.equals(ref2, bindings));
	}
	
	@Test
	public void testEqualsIdVsRange() throws BizlangException {
		BizlangRange ref1 = new BizlangRange("__range__", 1);
		ref1.setLowerLimit(new BizlangValue(BizlangLexer.NBR, "12.30", 1));
		ref1.setUpperLimit(new BizlangValue(BizlangLexer.NBR, "12.40", 1));
		
		BizlangRange ref2 = new BizlangRange("__range__", 1);
		ref2.setLowerLimit(new BizlangValue(BizlangLexer.DATE, "1/3/2010", 1));
		ref2.setUpperLimit(new BizlangValue(BizlangLexer.DATE, "5/3/2010", 1));
		
		assertFalse(v1.equals(ref1, bindings));
		assertTrue(v2.equals(ref1, bindings));
		assertFalse(v3.equals(ref1, bindings));
		assertFalse(v4.equals(ref1, bindings));
		
		assertFalse(v1.equals(ref2, bindings));
		assertFalse(v2.equals(ref2, bindings));
		assertTrue(v3.equals(ref2, bindings));
		assertFalse(v4.equals(ref2, bindings));
	}
	
	@Test
	public void testEqualsIdVsId() throws BizlangException {
	}
}
