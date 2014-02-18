package com.cultome.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangBlock extends BizlangExpression {
	
	private List<BizlangExpression> expressions;

	public BizlangBlock(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
		expressions = new ArrayList<BizlangExpression>();
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		Object lastEvaluated = null;
		for (BizlangExpression expr : expressions) {
			lastEvaluated = expr.execute(bindings);
		}
		return lastEvaluated;
	}

	public void addExpression(BizlangExpression r) {
		expressions.add(r);
	}

}
