package com.cultome.bizlang.language;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangRule extends BizlangBlock {

	public BizlangRule(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}
	
	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		return null;
	}
	
	public Object call(Bindings bindings) throws BizlangException{
		Object returnValue = super.getValue(bindings);
		bindings.addBinding(getName(), returnValue);
		return returnValue;
	}
	
	@Override
	public String toString() {
		return "rule: " + getName();
	}
}
