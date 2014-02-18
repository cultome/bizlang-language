package com.cultome.bizlang.language.function;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cultome.bizlang.dataaccess.DBReader;
import com.cultome.bizlang.dataaccess.object.QueryDataSet;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangValue;
import com.cultome.bizlang.language.function.GetFromDbFunction;
import com.cultome.bizlang.language.parser.BizlangLexer;
import com.cultomebizlang.language.interpreter.Bindings;

public class GetFromDbFunctionTest {

	@Test
	public void testExecute() throws BizlangException {
		DBReader.getInstance().addConnection("sqlite3", "jdbc:sqlite:C:\\workspace\\bizlang-language\\src\\test\\resources\\db.dat", "", "");
		
		Bindings bindings = new Bindings();
		bindings.addConfig(Bindings.CNFG_NS_DATABASES, GetFromDbFunction.ACCESSOR, DBReader.getInstance());
		BizlangValue id = new BizlangValue(BizlangLexer.STR, "sqlite3", 1);
		BizlangValue query = new BizlangValue(BizlangLexer.STR, "select * from resources", 1);
		
		GetFromDbFunction fnct = new GetFromDbFunction();
		QueryDataSet r = (QueryDataSet) fnct.execute(bindings, id, query);
		assertNotNull(r);
		assertFalse(r.isEmpty());
	}

}
