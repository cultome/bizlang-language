package com.cultome.bizlang.language;

import java.util.List;

import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionListener;

public class BizlangRule extends BizlangBlock {

	public BizlangRule(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}
	
	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		return null;
	}
	
	public Object call(Bindings bindings) throws BizlangException{
		enterExecution(bindings);
		
		Object returnValue = super.getValue(bindings);
		bindings.addBinding(getName(), returnValue);
		
		returnRule(returnValue);
		return returnValue;
	}

	@Override
	public String toString() {
		return "rule: " + getName();
	}

	private void enterExecution(Bindings bindings) {
		LOGGER.info("[EXEC] " + getClass().getSimpleName());
		List<ExecutionListener> listeners = ExecutionListener.getExecutionListeners();
		for (ExecutionListener listener : listeners) {
			listener.executeRule(this, bindings);
		}
	}
	
	private void returnRule(Object returnValue) {
		List<ExecutionListener> listeners = ExecutionListener.getExecutionListeners();
		for (ExecutionListener listener : listeners) {
			listener.returnRule(this, returnValue);
		}
		LOGGER.info("[TERM] " + getClass().getSimpleName());
	}
}
