import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cultome.bizlang.language.BizlangCustomLogicOperationTest;
import com.cultome.bizlang.language.BizlangLogicOperationTest;
import com.cultome.bizlang.language.BizlangMathOperationTest;
import com.cultome.bizlang.language.BizlangRangeTest;
import com.cultome.bizlang.language.BizlangValueTest;
import com.cultome.bizlang.language.function.GetFromDbFunctionTest;
import com.cultome.bizlang.language.function.GetFromWsFunctionTest;
import com.cultome.bizlang.language.interpreter.InterpreterTest;
import com.cultome.bizlang.language.interpreter.RealExamplesTest;
import com.cultome.bizlang.language.listener.CodeExtractorListenerTest;
import com.cultome.bizlang.language.util.UtilsTest;

@RunWith(Suite.class)
@SuiteClasses({
	/* Language */
	BizlangCustomLogicOperationTest.class,
	BizlangLogicOperationTest.class,
	BizlangMathOperationTest.class,
	BizlangRangeTest.class,
	BizlangValueTest.class,
	/* Function */
	GetFromDbFunctionTest.class,
	GetFromWsFunctionTest.class,
	/* Interpreter */
	InterpreterTest.class,
	RealExamplesTest.class,
	/* Listener */
	CodeExtractorListenerTest.class,
	/* Utils */
	UtilsTest.class,
	})
public class AllTests {

}
