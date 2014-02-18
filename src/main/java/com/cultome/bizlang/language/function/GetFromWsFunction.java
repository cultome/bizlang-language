package com.cultome.bizlang.language.function;

import com.cultome.bizlang.dataaccess.DBReader;
import com.cultome.bizlang.dataaccess.object.QueryDataSet;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultomebizlang.language.interpreter.Bindings;

public class GetFromWsFunction implements JavaFunction {

	@Override
	public Object execute(Bindings bindings, BizlangExpression... params) throws BizlangException {
		try {
			if(params.length < 1){
				throw new RuntimeException("getFromWs function requires at least one parameter: web service id.");
			}
			
			String wsId = (String) params[0].execute(bindings);
//			String query = (String) params[1].execute(bindings);
//			DBReader accessor = bindings.getConfig(Bindings.CNFG_NS_WEBSERVICES, ACCESSOR, DBReader.class);
//			QueryDataSet result = accessor.query(wsId, query);
//			return result;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizlangException(e);
		}
	}

}
