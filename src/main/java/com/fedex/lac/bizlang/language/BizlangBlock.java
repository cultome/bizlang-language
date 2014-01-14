package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangBlock.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	13/01/2014
 */
public class BizlangBlock extends BizlangExpression {
	
	private List<BizlangExpression> expressions;

	public BizlangBlock(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
		expressions = new ArrayList<BizlangExpression>();
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		for (BizlangExpression expr : expressions) {
			expr.execute(bindings);
		}
		return null;
	}

	public void addExpression(BizlangExpression r) {
		expressions.add(r);
	}

}
