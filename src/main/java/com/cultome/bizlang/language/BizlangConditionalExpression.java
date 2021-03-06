package com.cultome.bizlang.language;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangConditionalExpression extends BizlangExpression {
	
	private BizlangLogicOperation condition;
	private BizlangBlock mainBlock;
	private BizlangBlock alternativeBlock;

	public BizlangConditionalExpression(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Boolean r = (Boolean) condition.execute(bindings);
		if("if".equals(getName())){
			if(r.booleanValue()){
				return mainBlock.execute(bindings);
			} else if(alternativeBlock != null){
				return alternativeBlock.execute(bindings);
			}
		} else if("unless".equals(getName())){
			if(!r.booleanValue()){
				return mainBlock.execute(bindings);
			} else if(alternativeBlock != null){
				return alternativeBlock.execute(bindings);
			}
		}
		
		return null;
	}

	public void addCondition(BizlangLogicOperation condition) {
		this.condition = condition;
	}

	public BizlangLogicOperation getCondition() {
		return condition;
	}

	public void addBlock(BizlangBlock mainBlock) {
		this.mainBlock = mainBlock;
		
	}

	public void addElseBlock(BizlangBlock alternativeBlock) {
		this.alternativeBlock = alternativeBlock;
	}

}
