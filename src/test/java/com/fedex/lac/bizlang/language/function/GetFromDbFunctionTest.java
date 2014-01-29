package com.fedex.lac.bizlang.language.function;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fedex.lac.bizlang.dataaccess.Accessor;
import com.fedex.lac.bizlang.dataaccess.object.QueryDataSet;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangValue;
import com.fedex.lac.bizlang.language.interpreter.Bindings;
import com.fedex.lac.bizlang.language.parser.BizlangLexer;

/* 
 * GetFromDbFunctionTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	29/01/2014
 */
public class GetFromDbFunctionTest {

	@Test
	public void testExecute() throws BizlangException {
		Accessor accessor = new Accessor();
		accessor.addConnection("sqlite3", "jdbc:sqlite:C:\\workspace\\bizlang-language\\src\\test\\resources\\db.dat", "", "");
		
		Bindings bindings = new Bindings();
		bindings.addConfig(Bindings.CNFG_NS_DATABASES, GetFromDbFunction.ACCESSOR, accessor);
		BizlangValue id = new BizlangValue(BizlangLexer.STR, "sqlite3", 1);
		BizlangValue query = new BizlangValue(BizlangLexer.STR, "select * from resources", 1);
		
		GetFromDbFunction fnct = new GetFromDbFunction();
		QueryDataSet r = (QueryDataSet) fnct.execute(bindings, id, query);
		assertNotNull(r);
		assertFalse(r.isEmpty());
	}

}
