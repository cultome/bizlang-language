package com.fedex.lac.bizlang.util;

import static org.junit.Assert.*;

import org.junit.Test;

/* 
 * UtilsTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	24/01/2014
 */
public class UtilsTest {

	@Test
	public void testAreEquivalentNumbersDecimals() {
		assertTrue(Utils.areEquivalentNumbers("1.9", "1.90"));
		assertFalse(Utils.areEquivalentNumbers("10000.99", "10000.9"));
	}
	
	@Test
	public void testAreEquivalentNumbersIntegers() {
		assertTrue(Utils.areEquivalentNumbers("1", "1"));
		assertFalse(Utils.areEquivalentNumbers("10000", "10001"));
	}
	
	@Test
	public void testAreEquivalentNumbersMixed() {
		assertTrue(Utils.areEquivalentNumbers("1.0", "1"));
		assertFalse(Utils.areEquivalentNumbers("1.0", "1.01"));
		assertFalse(Utils.areEquivalentNumbers("10", "10.001"));
		assertTrue(Utils.areEquivalentNumbers("10", "10.00"));
	}

}
