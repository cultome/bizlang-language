package com.fedex.lac.bizlang.language;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;

/* 
 * BizlangCustomLogicOperationTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangCustomLogicOperationTest {
	
	private BizlangCustomLogicOperation op = new BizlangCustomLogicOperation("><", 1);

	@Before
	public void setup(){
		op = new BizlangCustomLogicOperation("><", 1);
	}
	
	@Test
	public void testReturnBooleanWithRange() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "3", 1));
		op.addParam(new BizlangRange("_range_", 1, 
				new BizlangValue(BizlangLexer.NBR, "1", 1),
				new BizlangValue(BizlangLexer.NBR, "10", 1)));
		Object r = op.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
	}
	
	@Test
	public void testReturnBooleanWithArray() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "3", 1));
		BizlangArray array = new BizlangArray("_range_", 1);
		array.addElement(new BizlangValue(BizlangLexer.NBR, "1", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "2", 1));
		op.addParam(array);
		Object r = op.execute(new Bindings());
		assertNotNull(r);
		assertTrue(r.getClass().getName().endsWith("Boolean"));
	}

	@Test
	public void testExecuteWithRangePositive() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "3", 1));
		op.addParam(new BizlangRange("_range_", 1, 
				new BizlangValue(BizlangLexer.NBR, "1", 1),
				new BizlangValue(BizlangLexer.NBR, "10", 1)));
		Object r = op.execute(new Bindings());
		assertTrue(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testExecuteWithRangeNegative() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "3", 1));
		op.addParam(new BizlangRange("_range_", 1, 
				new BizlangValue(BizlangLexer.NBR, "5", 1),
				new BizlangValue(BizlangLexer.NBR, "10", 1)));
		Object r = op.execute(new Bindings());
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testExecuteWithArrayPositive() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "7", 1));
		BizlangArray array = new BizlangArray("_range_", 1);
		array.addElement(new BizlangValue(BizlangLexer.NBR, "1", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "3", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "5", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "7", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "9", 1));
		
		op.addParam(array); 
		Object r = op.execute(new Bindings());
		assertTrue(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testExecuteWithArrayNegative() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.NBR, "7", 1));
		BizlangArray array = new BizlangArray("_range_", 1);
		array.addElement(new BizlangValue(BizlangLexer.NBR, "1", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "2", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "3", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "4", 1));
		array.addElement(new BizlangValue(BizlangLexer.NBR, "5", 1));
		
		op.addParam(array); 
		Object r = op.execute(new Bindings());
		assertFalse(((Boolean) r).booleanValue());
	}
	
	@Test
	public void testExecuteWithDates() throws BizlangException {
		op.addParam(new BizlangValue(BizlangLexer.DATE, "4/1/2014", 1));
		BizlangArray array = new BizlangArray("_range_", 1);
		array.addElement(new BizlangValue(BizlangLexer.DATE, "1/1/2014", 1));
		array.addElement(new BizlangValue(BizlangLexer.DATE, "2/1/2014", 1));
		array.addElement(new BizlangValue(BizlangLexer.DATE, "3/1/2014", 1));
		array.addElement(new BizlangValue(BizlangLexer.DATE, "4/1/2014", 1));
		array.addElement(new BizlangValue(BizlangLexer.DATE, "5/1/2014", 1));
		
		op.addParam(array); 
		Object r = op.execute(new Bindings());
		assertTrue(((Boolean) r).booleanValue());
	}
}
