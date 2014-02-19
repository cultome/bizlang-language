package com.cultome.bizlang.language.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.cultome.bizlang.language.listener.CodeExtractorListener;
import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionFlow;
import com.cultomebizlang.language.interpreter.ExecutionListener;
import com.cultomebizlang.language.interpreter.Interpreter;

/* 
 * RealExamplesTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	18/02/2014
 */
public class RealExamplesTest extends InterpreterBaseTest {

	@Before
	public void setup(){
		ExecutionListener.addExecutionListeners(new CodeExtractorListener());
		
		interpreter = new Interpreter();
		bindings = new Bindings();
		// invoiceType = myObj.shipment.invoice.type
		bindings.addBinding("myObj.shipment.invoice.type", "CREDIT");
		// amount = myObj.shipment.invoice.totalAmount
		bindings.addBinding("myObj.shipment.invoice.totalAmount", new BigDecimal(100.00));
		//invoiceDate = myObj.shipment.invoice.invDate
		bindings.addBinding("myObj.shipment.invoice.invDate", "15/01/2014");
	}

	@Test
	public void testInterpretSourceCodeFromFile() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/18022014_1457.biz");
		assertNotNull(flow);
		assertEquals(2, flow.getFlow().size());
		interpreter.execute(flow, bindings);
		System.out.println(bindings.getBinding("calculatePercentageIVAFrontier"));
	}
}
