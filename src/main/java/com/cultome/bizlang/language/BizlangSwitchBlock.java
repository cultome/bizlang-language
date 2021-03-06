package com.cultome.bizlang.language;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangSwitchBlock extends BizlangBlock {
	
	private BizlangValue condition;

	public BizlangSwitchBlock(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	public void addCondition(BizlangValue condition) {
		this.condition = condition;
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		return super.getValue(bindings);
	}

	public BizlangValue getCondition() {
		return condition;
	}
	
	@Override
	public String toString() {
		return condition.toString();
	}
}
