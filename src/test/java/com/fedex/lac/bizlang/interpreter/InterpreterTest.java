package com.fedex.lac.bizlang.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/* 
 * InterpreterTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class InterpreterTest {
	
	private final String NL = "\r\n";
	
	private Interpreter interpreter;
	private Bindings bindings;
	private ByteArrayOutputStream buffer;
	
	@Before
	public void setup(){
		interpreter = new Interpreter();
		bindings = new Bindings();
		bindings.addBinding("idNbr", "880475");
		bindings.addBinding("myObj", new TestingClass(3, "5.5"));
		
		buffer = new ByteArrayOutputStream();
		PrintStream logger = new PrintStream(buffer);
		bindings.addBinding("STDOUT", logger);
	}

	@Test
	public void testInterpretSourceCode() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/basic.biz");
		assertNotNull(flow);
		assertEquals(1, flow.getFlow().size());
	}
	
	@Test
	public void testExecute() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/exec.biz");
		interpreter.execute(flow, bindings);
		assertEquals("hola mundo" + NL + "6" + NL + "myId880475" + NL, buffer.toString());
	}
	
	@Test
	public void testConditional() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/conditional.biz");
		interpreter.execute(flow, bindings);
		assertEquals("<1>" + NL + "<2>" + NL + "<3>" + NL + "<4>" + NL + "<5>" + NL + "<6>" + NL, buffer.toString());
	}
	
	@Test
	public void testExecuteWithObject() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/objects.biz");
		interpreter.execute(flow, bindings);
		assertEquals("TestingClass [valueOne=3, valueTwo={entero=5.5}]" + NL + "8.5" + NL + "segundo" + NL + "abc" + NL, buffer.toString());
	}
	
	@Test
	public void testRepetition() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/repetition.biz");
		interpreter.execute(flow, bindings);
		assertEquals("a,b,c" + NL, buffer.toString());
	}
	
	@Test
	public void testArrays() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/arrays.biz");
		interpreter.execute(flow, bindings);
		assertEquals("'a'" + NL + "'b'" + NL + "'c'" + NL + "1" + NL + "\"dos\"" + NL + "idNbr" + NL + "myObj.valueOne" + NL + "primero" + NL + "segundo" + NL, buffer.toString());
	}
	
	@Test
	public void testRanges() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/ranges.biz");
		interpreter.execute(flow, bindings);
		assertEquals("1" + NL + "2" + NL + "3" + NL + "4" + NL + "5" + NL + "6" + NL + "7" + NL + "8" + NL + "9" + NL + "10" + NL + "<1>" + NL, buffer.toString());
	}
	
	@Test
	public void testDates() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/dates.biz");
		interpreter.execute(flow, bindings);
		assertEquals("1" + NL + "2" + NL + "3" + NL, buffer.toString());
	}
	
	@Test
	public void testSwitch() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/switch.biz");
		interpreter.execute(flow, bindings);
		assertEquals("1" + NL + "2" + NL + "3" + NL + "4" + NL, buffer.toString());
	}
	
	/* *******************************
	 * Backup functions and classes  *
	 *********************************/
	private ExecutionFlow getExecutionFlow(String filepath) throws Exception{
		InputStream input = new FileInputStream(filepath);
		return interpreter.interpret(input);
	}

	private class TestingClass {
		private int valueOne;
		private Map<String, String> valueTwo;
		private Collection<String> valueThree;
		private String[] valueFour;
		private Date valueFive;
		
		public TestingClass(int one, String two) {
			valueTwo = new HashMap<String, String>();
			valueOne = one;
			valueTwo.put("entero", two);
			valueThree = new ArrayList<String>();
			valueThree.add("primero");
			valueThree.add("segundo");
			valueFour = new String[]{"a", "b", "c"};
			valueFive = new Date();
		}
		
		@SuppressWarnings("unused")
		public int getValueOne() {
			return valueOne;
		}
		@SuppressWarnings("unused")
		public Map<String, String> getValueTwo() {
			return valueTwo;
		}
		
		@Override
		public String toString() {
			return "TestingClass [valueOne=" + valueOne + ", valueTwo=" + valueTwo + "]";
		}

		@SuppressWarnings("unused")
		public Collection<String> getValueThree() {
			return valueThree;
		}

		@SuppressWarnings("unused")
		public String[] getValueFour() {
			return valueFour;
		}

		@SuppressWarnings("unused")
		public Date getValueFive() {
			return valueFive;
		}
	}
}


