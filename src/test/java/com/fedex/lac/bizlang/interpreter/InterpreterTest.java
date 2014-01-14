package com.fedex.lac.bizlang.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
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
	
	private Interpreter interpreter;
	private Bindings bindings;
	
	@Before
	public void setup(){
		interpreter = new Interpreter();
		bindings = new Bindings();
		bindings.addBinding("idNbr", "880475");
		bindings.addBinding("myObj", new TestingClass(3, "5.5"));
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
	}
	
	@Test
	public void testExecuteConditional() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/conditional.biz");
		interpreter.execute(flow, bindings);
	}
	
	@Test
	public void testExecuteWithObject() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/objects.biz");
		interpreter.execute(flow, bindings);
	}
	
	private ExecutionFlow getExecutionFlow(String filepath) throws Exception{
		InputStream input = new FileInputStream(filepath);
		return interpreter.interpret(input);
	}

	private class TestingClass {
		private int valueOne;
		private Map<String, String> valueTwo;
		private Collection<String> valueThree;
		private String[] valueFour;
		
		public TestingClass(int one, String two) {
			valueTwo = new HashMap<String, String>();
			valueOne = one;
			valueTwo.put("entero", two);
			valueThree = new ArrayList<String>();
			valueThree.add("primero");
			valueThree.add("segundo");
			valueFour = new String[]{"a", "b", "c"};
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
	}
}


