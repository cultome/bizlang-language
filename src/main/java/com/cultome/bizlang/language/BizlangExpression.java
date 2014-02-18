package com.cultome.bizlang.language;

import java.util.logging.Logger;

import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionListener;

public abstract class BizlangExpression {
	
	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	protected String name;
	protected int definedAt;

	public BizlangExpression(String fnctName, int srcLineDefinedAt) {
		this.name = fnctName;
		this.definedAt = srcLineDefinedAt;
	}

	public abstract Object getValue(Bindings bindings) throws BizlangException;
	
	public Object execute(Bindings bindings) throws BizlangException {
		LOGGER.info("[ENTER]" + getClass().getSimpleName());
		
		ExecutionListener.enterExpression(this, bindings);
		Object returnValue = getValue(bindings);
		ExecutionListener.leaveExpression(this, returnValue);
		
		LOGGER.info("[EXIT]" + getClass().getSimpleName());
		return returnValue;
	}

	public String getName() {
		return name;
	}

	public int getDefinedAt() {
		return definedAt;
	}
}
