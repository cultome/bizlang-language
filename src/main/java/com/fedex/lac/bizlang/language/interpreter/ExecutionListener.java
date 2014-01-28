package com.fedex.lac.bizlang.language.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.language.BizlangArray;
import com.fedex.lac.bizlang.language.BizlangAssignation;
import com.fedex.lac.bizlang.language.BizlangBlock;
import com.fedex.lac.bizlang.language.BizlangConditionalExpression;
import com.fedex.lac.bizlang.language.BizlangCustomLogicOperation;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangFunction;
import com.fedex.lac.bizlang.language.BizlangLogicOperation;
import com.fedex.lac.bizlang.language.BizlangMathOperation;
import com.fedex.lac.bizlang.language.BizlangRange;
import com.fedex.lac.bizlang.language.BizlangRepetition;
import com.fedex.lac.bizlang.language.BizlangRule;
import com.fedex.lac.bizlang.language.BizlangSwitch;
import com.fedex.lac.bizlang.language.BizlangSwitchBlock;
import com.fedex.lac.bizlang.language.BizlangValue;

public abstract class ExecutionListener {
	
	private static final int ARRAY = 1;
	private static final int ASSIGNATION = 2;
	private static final int BLOCK = 3;
	private static final int CONDITIONAL_EXPRESSION = 4;
	private static final int CUSTOM_LOGIG_OPERATION = 5;
	private static final int FUNCTION = 6;
	private static final int LOGIC_OPERATION = 7;
	private static final int MATH_OPERATION = 8;
	private static final int RANGE = 9;
	private static final int REPETITION = 10;
	private static final int RULE = 11;
	private static final int SWITCH = 12;
	private static final int SWITCH_BLOCK = 13;
	private static final int VALUE = 14;

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
	
	public static final List<ExecutionListener> getExecutionListeners() {
		if(executionListeners == null){
			executionListeners = new ArrayList<ExecutionListener>();
		}
		return executionListeners;
	}
	
	public static final void addExecutionListeners(ExecutionListener listener) {
		getExecutionListeners().add(listener);
	}

	private static void dispatchLeaveByExpressionType(BizlangExpression expression, Object returnValue, ExecutionListener listener) {
		int type = getExpressionType(expression);
		switch(type){
			case ARRAY: 
				listener.leaveArray((BizlangArray) expression, returnValue);
				break;
			case ASSIGNATION:
				listener.leaveAssignation((BizlangAssignation) expression, returnValue);
				break;
			case BLOCK:
				listener.leaveBlock((BizlangBlock) expression, returnValue);
				break;
			case CONDITIONAL_EXPRESSION:
				listener.leaveConditionalExpression((BizlangConditionalExpression) expression, returnValue);
				break;
			case CUSTOM_LOGIG_OPERATION:
				listener.leaveCustomLogicOperation((BizlangCustomLogicOperation) expression, returnValue);
				break;
			case FUNCTION:
				listener.leaveFunction((BizlangFunction) expression, returnValue);
				break;
			case LOGIC_OPERATION:
				listener.leaveOperation((BizlangLogicOperation) expression, returnValue);
				break;
			case MATH_OPERATION:
				listener.leaveMathOperation((BizlangMathOperation) expression, returnValue);
				break;
			case RANGE:
				listener.leaveRange((BizlangRange) expression, returnValue);
				break;
			case REPETITION:
				listener.leaveRepetition((BizlangRepetition) expression, returnValue);
				break;
			case RULE:
				listener.leaveRule((BizlangRule) expression, returnValue);
				break;
			case SWITCH:
				listener.leaveSwitch((BizlangSwitch) expression, returnValue);
				break;
			case SWITCH_BLOCK:
				listener.leaveSwitchBlock((BizlangSwitchBlock) expression, returnValue);
				break;
			case VALUE:
				listener.leaveValue((BizlangValue) expression, returnValue);
				break;
		}
	}

	private static void dispatchEnterByExpressionType(BizlangExpression expression, Bindings bindings, ExecutionListener listener) {
		int type = getExpressionType(expression);
		switch(type){
			case ARRAY: 
				listener.enterArray((BizlangArray) expression, bindings);
				break;
			case ASSIGNATION:
				listener.enterAssignation((BizlangAssignation) expression, bindings);
				break;
			case BLOCK:
				listener.enterBlock((BizlangBlock) expression, bindings);
				break;
			case CONDITIONAL_EXPRESSION:
				listener.enterConditionalExpression((BizlangConditionalExpression) expression, bindings);
				break;
			case CUSTOM_LOGIG_OPERATION:
				listener.enterCustomLogicOperation((BizlangCustomLogicOperation) expression, bindings);
				break;
			case FUNCTION:
				listener.enterFunction((BizlangFunction) expression, bindings);
				break;
			case LOGIC_OPERATION:
				listener.enterOperation((BizlangLogicOperation) expression, bindings);
				break;
			case MATH_OPERATION:
				listener.enterMathOperation((BizlangMathOperation) expression, bindings);
				break;
			case RANGE:
				listener.enterRange((BizlangRange) expression, bindings);
				break;
			case REPETITION:
				listener.enterRepetition((BizlangRepetition) expression, bindings);
				break;
			case RULE:
				listener.enterRule((BizlangRule) expression, bindings);
				break;
			case SWITCH:
				listener.enterSwitch((BizlangSwitch) expression, bindings);
				break;
			case SWITCH_BLOCK:
				listener.enterSwitchBlock((BizlangSwitchBlock) expression, bindings);
				break;
			case VALUE:
				listener.enterValue((BizlangValue) expression, bindings);
				break;
		}
	}

	private static int getExpressionType(BizlangExpression bizlangExpression) {
		String simpleClassName = bizlangExpression.getClass().getSimpleName();
		
		if(BizlangArray.class.getSimpleName().equals(simpleClassName)){
			return ARRAY;
		} else if(BizlangAssignation.class.getSimpleName().equals(simpleClassName)){
			return ASSIGNATION;
		} else if(BizlangBlock.class.getSimpleName().equals(simpleClassName)){
			return BLOCK;
		} else if(BizlangConditionalExpression.class.getSimpleName().equals(simpleClassName)){
			return CONDITIONAL_EXPRESSION;
		} else if(BizlangCustomLogicOperation.class.getSimpleName().equals(simpleClassName)){
			return CUSTOM_LOGIG_OPERATION;
		} else if(BizlangFunction.class.getSimpleName().equals(simpleClassName)){
			return FUNCTION;
		} else if(BizlangLogicOperation.class.getSimpleName().equals(simpleClassName)){
			return LOGIC_OPERATION;
		} else if(BizlangMathOperation.class.getSimpleName().equals(simpleClassName)){
			return MATH_OPERATION;
		} else if(BizlangRange.class.getSimpleName().equals(simpleClassName)){
			return RANGE;
		} else if(BizlangRepetition.class.getSimpleName().equals(simpleClassName)){
			return REPETITION;
		} else if(BizlangRule.class.getSimpleName().equals(simpleClassName)){
			return RULE;
		} else if(BizlangSwitch.class.getSimpleName().equals(simpleClassName)){
			return SWITCH;
		} else if(BizlangSwitchBlock.class.getSimpleName().equals(simpleClassName)){
			return SWITCH_BLOCK;
		} else if(BizlangValue.class.getSimpleName().equals(simpleClassName)){
			return VALUE;
		}
		
		return -1;
	}

	/*
	 * ENTER
	 */
	
	public void enterValue(BizlangValue expression, Bindings bindings) {}

	public void enterSwitchBlock(BizlangSwitchBlock expression, Bindings bindings) {}

	public void enterSwitch(BizlangSwitch expression, Bindings bindings) {}

	public void enterRule(BizlangRule expression, Bindings bindings) {}

	public void enterRepetition(BizlangRepetition expression, Bindings bindings) {}

	public void enterRange(BizlangRange expression, Bindings bindings) {}

	public void enterMathOperation(BizlangMathOperation expression, Bindings bindings) {}

	public void enterOperation(BizlangLogicOperation expression, Bindings bindings) {}

	public void enterFunction(BizlangFunction expression, Bindings bindings) {}

	public void enterCustomLogicOperation(BizlangCustomLogicOperation expression, Bindings bindings) {}

	public void enterConditionalExpression(BizlangConditionalExpression expression, Bindings bindings) {}

	public void enterBlock(BizlangBlock expression, Bindings bindings) {}

	public void enterAssignation(BizlangAssignation expression, Bindings bindings) {}

	public void enterArray(BizlangArray expression, Bindings bindings) {}
	
	/*
	 * LEAVE
	 */

	public void leaveFunction(BizlangFunction expression, Object returnValue) {}

	public void leaveValue(BizlangValue expression, Object returnValue) {}

	public void leaveSwitchBlock(BizlangSwitchBlock expression, Object returnValue) {}

	public void leaveSwitch(BizlangSwitch expression, Object returnValue) {}

	public void leaveRule(BizlangRule expression, Object returnValue) {}

	public void leaveRepetition(BizlangRepetition expression, Object returnValue) {}

	public void leaveRange(BizlangRange expression, Object returnValue) {}

	public void leaveMathOperation(BizlangMathOperation expression, Object returnValue) {}

	public void leaveOperation(BizlangLogicOperation expression, Object returnValue) {}

	public void leaveCustomLogicOperation(BizlangCustomLogicOperation expression, Object returnValue) {}

	public void leaveConditionalExpression(BizlangConditionalExpression expression, Object returnValue) {}

	public void leaveBlock(BizlangBlock expression, Object returnValue) {}

	public void leaveAssignation(BizlangAssignation expression, Object returnValue) {}

	public void leaveArray(BizlangArray expression, Object returnValue) {}

}
