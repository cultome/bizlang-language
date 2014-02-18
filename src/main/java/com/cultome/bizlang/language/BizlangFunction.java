package com.cultome.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.cultome.bizlang.language.function.CallRuleFunction;
import com.cultome.bizlang.language.function.CountFunction;
import com.cultome.bizlang.language.function.GetFromDbFunction;
import com.cultome.bizlang.language.function.JavaFunction;
import com.cultome.bizlang.language.function.PrintJavaFunction;
import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangFunction extends BizlangExpression {
	
	private List<BizlangExpression> paramList;
	
	public BizlangFunction(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		JavaFunction fnct = getJavaImplementation(name, paramList);
		if(fnct == null){
			throw new RuntimeException("Function [" + name + "] not implemented yet.");
		}
		return fnct.execute(bindings, paramList.toArray(new BizlangExpression[]{}));
	}

	protected List<Object> getFinalValues(Bindings bindings) throws BizlangException {
		List<Object> values = new ArrayList<Object>();
		for(BizlangExpression param : getParamList()){
			values.add(param.execute(bindings));
		}
		return values;
	}

	public BizlangExpression addParam(BizlangExpression param) {
		getParamList().add(param);
		return param;
	}

	public List<BizlangExpression> getParamList() {
		if(paramList == null){
			paramList = new ArrayList<BizlangExpression>();
		}
		return paramList;
	}

	private JavaFunction getJavaImplementation(String name, List<BizlangExpression> paramList) {
		if("print".equals(name)){
			return new PrintJavaFunction();
		} else if("callRule".equals(name)){
			return new CallRuleFunction();
		} else if("getFromDb".equals(name)){
			return new GetFromDbFunction();
		} else if("count".equals(name)){
			return new CountFunction();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return getName() + "()";
	}

}
