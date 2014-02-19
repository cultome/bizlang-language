package com.cultome.bizlang.language.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cultome.bizlang.dataaccess.DBReader;
import com.cultome.bizlang.language.function.GetFromDbFunction;
import com.cultome.bizlang.language.listener.CodeExtractorListener;
import com.cultome.bizlang.language.util.Utils;
import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionFlow;
import com.cultomebizlang.language.interpreter.ExecutionListener;
import com.cultomebizlang.language.interpreter.Interpreter;

public class InterpreterTest extends InterpreterBaseTest {
	
	private final String NL = "\r\n";
	
	private ByteArrayOutputStream buffer;
	
	@Before
	public void setup(){
		ExecutionListener.addExecutionListeners(new CodeExtractorListener());
		
		interpreter = new Interpreter();
		bindings = new Bindings();
		bindings.addBinding("idNbr", "880475");
		bindings.addBinding("myObj", new TestingClass(3, "5.5"));
		bindings.addBinding("dbId", "sqlite3");
		
		buffer = new ByteArrayOutputStream();
		PrintStream logger = new PrintStream(buffer);
		bindings.addBinding("STDOUT", logger);
	}
	
	@Test
	public void testInterpretSourceCodeFromString() throws Exception {
		ExecutionFlow flow = interpreter.parseProgram("print 1 + 1");
		assertNotNull(flow);
		assertEquals(1, flow.getFlow().size());
	}

	@Test
	public void testInterpretSourceCodeFromFile() throws Exception {
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
	
	@Test
	public void testRule() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/rules.biz");
		interpreter.execute(flow, bindings);
		assertEquals("1" + NL + "2" + NL + "3" + NL, buffer.toString());
		assertEquals("hola mundo", bindings.getBinding("primera ley"));
		assertEquals("1/1/2015", Utils.formatDate((Date) bindings.getBinding("segunda_ley")));
	}
	
	@Test
	public void testExecutionInLine() throws Exception {
		interpreter.execute("range = [3/1/2014...7/1/2014]\narray = range - 5/1/2014\ncntRng = count range\ncntArr = count array\n", bindings);
		assertEquals("[3/1/2014, 4/1/2014, 5/1/2014, 6/1/2014, 7/1/2014]", bindings.getBinding("range").toString());
		assertEquals("5", bindings.getBinding("cntRng").toString());
		assertEquals("[3/1/2014, 4/1/2014, 6/1/2014, 7/1/2014]", bindings.getBinding("array").toString());
		assertEquals("4", bindings.getBinding("cntArr").toString());
	}
	
	@Test
	public void testDatabaseAccess() throws Exception {
		DBReader.getInstance().addConnection("sqlite3", "jdbc:sqlite:C:\\workspace\\bizlang\\bizlang-language\\src\\test\\resources\\db-language.dat", "", "");
		bindings.addConfig(Bindings.CNFG_NS_DATABASES, GetFromDbFunction.ACCESSOR, DBReader.getInstance());
		
		ExecutionFlow flow = getExecutionFlow("src/test/resources/getFromDb.biz");
		interpreter.execute(flow, bindings);
		System.out.println(buffer.toString());
		assertEquals("Carlos Soria" + NL + "Sauana Alvarado" + NL + "Noel Soria" + NL + "64" + NL + "30" + NL + "NO" + NL + "NO" + NL, buffer.toString());
	}
	
}


