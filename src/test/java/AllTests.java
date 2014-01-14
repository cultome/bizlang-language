import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fedex.lac.bizlang.interpreter.InterpreterTest;
import com.fedex.lac.bizlang.language.BizlangMathOperationTest;


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
	InterpreterTest.class,
	BizlangMathOperationTest.class
	})
public class AllTests {

}
