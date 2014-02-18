import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cultome.bizlang.language.BizlangCustomLogicOperationTest;
import com.cultome.bizlang.language.BizlangLogicOperationTest;
import com.cultome.bizlang.language.BizlangMathOperationTest;
import com.cultome.bizlang.language.BizlangRangeTest;
import com.cultome.bizlang.language.BizlangValueTest;
import com.cultome.bizlang.language.interpreter.InterpreterTest;
import com.cultome.bizlang.language.util.UtilsTest;

@RunWith(Suite.class)
@SuiteClasses({
	/* Interpreter */
	InterpreterTest.class,
	/* Language */
	BizlangCustomLogicOperationTest.class,
	BizlangLogicOperationTest.class,
	BizlangMathOperationTest.class,
	BizlangRangeTest.class,
	BizlangValueTest.class,
	/* Utils */
	UtilsTest.class
	})
public class AllTests {

}
