package com.fedex.lac.bizlang.language;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.util.Utils;

/* 
 * BizlangRangeTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	24/01/2014
 */
public class BizlangRangeTest {
	
	private Bindings bindings;
	
	@Before
	public void setup(){
		bindings = new Bindings();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateIntegerRange() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.NBR, "3", 1), 
				new BizlangValue(BizlangLexer.NBR, "5", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(3, list.size());
		for(int i = 3, j = 0; i <= 5; i++, j++){
			assertEquals(String.valueOf(i), list.get(j).execute(bindings).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateIntegerRangeInverse() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.NBR, "5", 1), 
				new BizlangValue(BizlangLexer.NBR, "1", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(5, list.size());
		for(int i = 5, j = 0; i >= 1; i--, j++){
			assertEquals(String.valueOf(i), list.get(j).execute(bindings).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateDecimalRange() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.NBR, "3.35", 1), 
				new BizlangValue(BizlangLexer.NBR, "3.5", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(16, list.size());
		for(int i = 35, j = 0; i <= 50; i++, j++){
			assertEquals("3." + i, list.get(j).execute(bindings).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateDecimalRangeReverse() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.NBR, "1.1", 1), 
				new BizlangValue(BizlangLexer.NBR, "1.5", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(5, list.size());
		for(int i = 1, j = 0; i <= 5; i++, j++){
			assertEquals("1." + i, list.get(j).execute(bindings).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateDateRange() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.DATE, "1/1/2012", 1), 
				new BizlangValue(BizlangLexer.DATE, "3/1/2012", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(3, list.size());
		Calendar cal = Calendar.getInstance();
		Date base = Utils.parseDate("01/01/2012");
		cal.setTime(base);
		
		for (BizlangValue bizlangValue : list) {
			assertEquals(cal.getTime(), bizlangValue.execute(bindings));
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGenerateDateRangeReverse() throws BizlangException {
		BizlangRange range = new BizlangRange("__range__", 1, 
				new BizlangValue(BizlangLexer.DATE, "5/1/2012", 1), 
				new BizlangValue(BizlangLexer.DATE, "2/1/2012", 1));
		Object r = range.execute(bindings);
		
		assertTrue(r instanceof List<?>);
		List<BizlangValue> list = (List<BizlangValue>) r;
		assertEquals(4, list.size());
		Calendar cal = Calendar.getInstance();
		Date base = Utils.parseDate("05/01/2012");
		cal.setTime(base);
		
		for (BizlangValue bizlangValue : list) {
			assertEquals(cal.getTime(), bizlangValue.execute(bindings));
			cal.add(Calendar.DAY_OF_YEAR, -1);
		}
	}

}
