package com.fedex.lac.bizlang.language.function;

import com.fedex.lac.bizlang.dataaccess.DBReader;
import com.fedex.lac.bizlang.dataaccess.object.QueryDataSet;
import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.interpreter.Bindings;

/* 
 * GetFromWsFunction.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	14/02/2014
 */
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
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizlangException(e);
		}
	}

}
