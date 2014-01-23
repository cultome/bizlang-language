package com.fedex.lac.bizlang.language;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangSwitchBlock.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	20/01/2014
 */
public class BizlangSwitchBlock extends BizlangBlock {
	
	private BizlangValue condition;

	public BizlangSwitchBlock(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	public void addCondition(BizlangValue condition) {
		this.condition = condition;
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		return super.execute(bindings);
	}

	public BizlangValue getCondition() {
		return condition;
	}
}