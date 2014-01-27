package com.fedex.lac.bizlang.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangFunction;

public abstract class ExecutionListener {

	private static List<ExecutionListener> executionListeners;

	public static final void enterExpression(BizlangExpression bizlangExpression, Bindings bindings) {
		for(ExecutionListener listener : getExecutionListeners()){
			dispatchEnterByExpressionType(bizlangExpression, bindings, listener);
		}
	}

	public static final void leaveExpression(BizlangExpression bizlangExpression, Object returnValue) {
		for(ExecutionListener listener : getExecutionListeners()){
			dispatchLeaveByExpressionType(bizlangExpression, returnValue, listener);
		}
	}

	private static void dispatchLeaveByExpressionType(BizlangExpression bizlangExpression, Object returnValue, ExecutionListener listener) {
		if("BizlangFunction".equals(bizlangExpression.getClass().getSimpleName())){
			listener.leaverFunction((BizlangFunction) bizlangExpression, returnValue);
		}
	}


	private static void dispatchEnterByExpressionType(BizlangExpression bizlangExpression, Bindings bindings, ExecutionListener listener) {
		if("BizlangFunction".equals(bizlangExpression.getClass().getSimpleName())){
			listener.enterFunction((BizlangFunction) bizlangExpression, bindings);
		}
	}
	
	public static final List<ExecutionListener> getExecutionListeners() {
		if(executionListeners == null){
			executionListeners = new ArrayList<ExecutionListener>();
		}
		return executionListeners;
	}
	
	public static final void addExecutionListeners(ExecutionListener listener) {
		getExecutionListeners().add(listener);
	}
	
	public abstract void enterFunction(BizlangFunction bizlangExpression, Bindings bindings);
	
	public abstract void leaverFunction(BizlangFunction bizlangExpression, Object returnValue);
}
