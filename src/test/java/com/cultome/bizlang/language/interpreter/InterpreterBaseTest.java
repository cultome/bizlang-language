package com.cultome.bizlang.language.interpreter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionFlow;
import com.cultomebizlang.language.interpreter.Interpreter;

/* 
 * InterpreterBaseTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	18/02/2014
 */
public abstract class InterpreterBaseTest {
	
	protected Interpreter interpreter;
	protected Bindings bindings;
	
	protected ExecutionFlow getExecutionFlow(String filepath) throws Exception{
		InputStream input = new FileInputStream(filepath);
		return interpreter.parseProgram(input);
	}

	public class TestingClass {
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
		
		public int getValueOne() {
			return valueOne;
		}
		public Map<String, String> getValueTwo() {
			return valueTwo;
		}
		
		@Override
		public String toString() {
			return "TestingClass [valueOne=" + valueOne + ", valueTwo=" + valueTwo + "]";
		}

		public Collection<String> getValueThree() {
			return valueThree;
		}

		public String[] getValueFour() {
			return valueFour;
		}

		public Date getValueFive() {
			return valueFive;
		}
	}
}
