package com.fedex.lac.bizlang.language.listener;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fedex.lac.bizlang.language.interpreter.Bindings;
import com.fedex.lac.bizlang.language.interpreter.ExecutionFlow;
import com.fedex.lac.bizlang.language.interpreter.ExecutionListener;
import com.fedex.lac.bizlang.language.interpreter.Interpreter;
import com.fedex.lac.bizlang.language.listener.CodeExtractorListener;

/* 
 * CodeExtractorListenerTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	27/01/2014
 */
public class CodeExtractorListenerTest {
	
	private Interpreter interpreter;
	private Bindings bindings;
	private CodeExtractorListener listener;
	
	@Before
	public void setup(){
		interpreter = new Interpreter();
		bindings = new Bindings();
		
		listener = new CodeExtractorListener();
		ExecutionListener.addExecutionListeners(listener);
	}

	@Test
	public void testCodeExtraction() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/code_extraction.biz");
		interpreter.execute(flow, bindings);
		assertNotNull(listener.getCode());
		System.out.println(listener.getCode());
		assertEquals("var = 1\nif var < 2 do\n  print(\"OK!\")\nend\n", listener.getCode());
	}
	
	private ExecutionFlow getExecutionFlow(String filepath) throws Exception{
		InputStream input = new FileInputStream(filepath);
		return interpreter.parseProgram(input);
	}
}
