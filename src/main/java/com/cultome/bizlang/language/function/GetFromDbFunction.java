package com.cultome.bizlang.language.function;

import com.cultome.bizlang.dataaccess.DBReader;
import com.cultome.bizlang.dataaccess.object.QueryDataSet;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

public class GetFromDbFunction implements JavaFunction {

	public static final String ACCESSOR = "accessor";
	
	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		try {
			if(params.length != 2){
				throw new RuntimeException("getFromDb function requires 2 parameters: connectionId and query.");
			}
			
			String dbId = (String) params[0].execute(bindings);
			String query = (String) params[1].execute(bindings);
			DBReader accessor = bindings.getConfig(Bindings.CNFG_NS_DATABASES, ACCESSOR, DBReader.class);
			QueryDataSet result = accessor.query(dbId, query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizlangException(e);
		}
	}

}
