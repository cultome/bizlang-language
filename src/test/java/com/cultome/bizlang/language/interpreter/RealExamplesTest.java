package com.cultome.bizlang.language.interpreter;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cultome.bizlang.dataaccess.WSReader;
import com.cultome.bizlang.language.function.GetFromWsFunction;
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
	
	private ByteArrayOutputStream buffer;

	@Before
	public void setup(){
		ExecutionListener.addExecutionListeners(new CodeExtractorListener());
		
		interpreter = new Interpreter();
		bindings = new Bindings();
		buffer = new ByteArrayOutputStream();
		PrintStream logger = new PrintStream(buffer);
		bindings.addBinding("STDOUT", logger);
		/*
		 * test18022014_1457
		 */
		// invoiceType = myObj.shipment.invoice.type
		bindings.addBinding("myObj.shipment.invoice.type", "CREDIT");
		// amount = myObj.shipment.invoice.totalAmount
		bindings.addBinding("myObj.shipment.invoice.totalAmount", new BigDecimal(100.00));
		//invoiceDate = myObj.shipment.invoice.invDate
		bindings.addBinding("myObj.shipment.invoice.invDate", "15/01/2014");
		/*
		 * test19022014_1039
		 */

		bindings.addBinding("resourceName", "token");
		bindings.addBinding("token", "mytoken");
		
		Map<String, Object> wsConfig = new HashMap<String, Object>();
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("BIZLANG_TOKEN", "{token}");
		
		wsConfig.put(GetFromWsFunction.ENDPOINT_PROPERTY, "http://localhost:8080/bizlang-ws/{resourceName}s");
		wsConfig.put(GetFromWsFunction.HTTP_METHOD_PROPERTY, "gEt");
//		wsConfig.put(GetFromWsFunction.CONTENT_PROPERTY, null);
		wsConfig.put(GetFromWsFunction.HEADERS_PROPERTY, headers);
		
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, GetFromWsFunction.ACCESSOR, WSReader.getInstance());
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, "tokens", wsConfig);
		
	}

	@Test
	public void test18022014_1457() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/18022014_1457.biz");
		assertNotNull(flow);
		interpreter.execute(flow, bindings);
		System.out.println(bindings.getBinding("calculatePercentageIVAFrontier"));
	}
	
	@Test
	public void test19022014_1039() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/19022014_1039.biz");
		interpreter.execute(flow, bindings);
		System.out.println(new String(buffer.toByteArray()));
	}
}
