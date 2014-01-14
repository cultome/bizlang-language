package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangConditionalExpression.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
public class BizlangConditionalExpression extends BizlangExpression {
	
	private BizlangLogicOperation condition;
	private BizlangBlock mainBlock;
	private BizlangBlock alternativeBlock;

	public BizlangConditionalExpression(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Boolean r = (Boolean) condition.execute(bindings);
		if(r.booleanValue()){
			return mainBlock.execute(bindings);
		} else if(alternativeBlock != null){
			return alternativeBlock.execute(bindings);
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
