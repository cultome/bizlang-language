package com.cultome.bizlang.language;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangAssignation extends BizlangExpression {
	
	private BizlangExpression rValue;

	public BizlangAssignation(String lVal, int srcLineDefinedAt) {
		super(lVal, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Object result = rValue.execute(bindings);
		bindings.addBinding(name, result);
		return result;
	}

	public BizlangExpression addLValue(BizlangExpression rValue) {
		this.rValue = rValue;
		return rValue;
	}
	
	@Override
	public String toString() {
		return getName() + " = " + rValue;
	}

	public BizlangExpression getRValue() {
		return rValue;
	}
	
	public String getLValue() {
		return getName();
	}
	
}
