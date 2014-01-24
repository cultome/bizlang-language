import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fedex.lac.bizlang.interpreter.InterpreterTest;
import com.fedex.lac.bizlang.language.BizlangCustomLogicOperationTest;
import com.fedex.lac.bizlang.language.BizlangLogicOperationTest;
import com.fedex.lac.bizlang.language.BizlangMathOperationTest;
import com.fedex.lac.bizlang.language.BizlangValueTest;
import com.fedex.lac.bizlang.util.UtilsTest;


/* 
 * AllTests.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
@RunWith(Suite.class)
@SuiteClasses({
	/* Interpreter */
	InterpreterTest.class,
	/* Language */
	BizlangCustomLogicOperationTest.class,
	BizlangLogicOperationTest.class,
	BizlangMathOperationTest.class,
	BizlangValueTest.class,
	/* Utils */
	UtilsTest.class
	})
public class AllTests {

}
