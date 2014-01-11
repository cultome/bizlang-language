package com.fedex.lac.bizlang.interpreter;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.*;
import static org.junit.Assert.*;

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
	
	@Before
	public void setup(){
		interpreter = new Interpreter();
	}

	@Test
	public void testInterpret() throws Exception {
		InputStream input = new FileInputStream("src/test/resources/basic.biz");
		ExecutionFlow flow = interpreter.interpret(input);
		assertNotNull(flow);
		assertEquals(1, flow.getFlow().size());
	}
	
	@Test
	public void testExecute() throws Exception {
		InputStream input = new FileInputStream("src/test/resources/basic_exec.biz");
		ExecutionFlow flow = interpreter.interpret(input);
		Bindings bindings = new Bindings();
		bindings.addBinding("idNbr", "880475");
		// no requiere bindings esta ejecucion
		interpreter.execute(flow, bindings);
	}

}
