package com.cultome.bizlang.language.listener;

import com.cultome.bizlang.language.BizlangArray;
import com.cultome.bizlang.language.BizlangAssignation;
import com.cultome.bizlang.language.BizlangBlock;
import com.cultome.bizlang.language.BizlangConditionalExpression;
import com.cultome.bizlang.language.BizlangCustomLogicOperation;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.BizlangFunction;
import com.cultome.bizlang.language.BizlangLogicOperation;
import com.cultome.bizlang.language.BizlangMathOperation;
import com.cultome.bizlang.language.BizlangRange;
import com.cultome.bizlang.language.BizlangRepetition;
import com.cultome.bizlang.language.BizlangRule;
import com.cultome.bizlang.language.BizlangSwitch;
import com.cultome.bizlang.language.BizlangSwitchBlock;
import com.cultome.bizlang.language.BizlangValue;
import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionListener;

public class CodeExtractorListener extends ExecutionListener {

	private static final String NL = "\n";
	private int indentLevel;
	private StringBuilder code;
	
	public CodeExtractorListener() {
		code = new StringBuilder();
		indentLevel = 0;
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

	public void enterFunction(BizlangFunction expression, Bindings bindings) {
		code.append(getIndent() + expression.getName() + "(");
		boolean firstArg = true;
		String name;
		for(BizlangExpression exp : expression.getParamList()){
			name = exp.getName();
			
			if(exp instanceof BizlangValue){
				name = exp.toString();
			}
			
			if(firstArg) {
				code.append(name);
				firstArg = false;
			} else {
				code.append(", " + name);
			}
		}
		code.append(")" + NL);
	}

	public void enterCustomLogicOperation(BizlangCustomLogicOperation expression, Bindings bindings) {}

	public void enterConditionalExpression(BizlangConditionalExpression expression, Bindings bindings) {
		BizlangLogicOperation cond = expression.getCondition();
		code.append(getIndent() + expression.getName() + " " + cond.getLeftValue() + " " + cond.getName() + " " + cond.getRightValue() + " do" + NL);
		indentLevel++;
	}

	public void enterBlock(BizlangBlock expression, Bindings bindings) {}

	public void enterAssignation(BizlangAssignation expression, Bindings bindings) {
		code.append(getIndent() + expression.getLValue() + " = " + expression.getRValue() + NL);
	}

	public void enterArray(BizlangArray expression, Bindings bindings) {}
	
	/*
	 * LEAVE
	 */

	public void leaveValue(BizlangValue expression, Object returnValue) {}

	public void leaveSwitchBlock(BizlangSwitchBlock expression, Object returnValue) {}

	public void leaveSwitch(BizlangSwitch expression, Object returnValue) {}

	public void leaveRule(BizlangRule expression, Object returnValue) {}

	public void leaveRepetition(BizlangRepetition expression, Object returnValue) {}

	public void leaveRange(BizlangRange expression, Object returnValue) {}

	public void leaveMathOperation(BizlangMathOperation expression, Object returnValue) {}

	public void leaveOperation(BizlangLogicOperation expression, Object returnValue) {}

	public void leaveCustomLogicOperation(BizlangCustomLogicOperation expression, Object returnValue) {}

	public void leaveConditionalExpression(BizlangConditionalExpression expression, Object returnValue) {
		indentLevel--;
		code.append(getIndent() + "end" + NL);
	}

	public void leaveBlock(BizlangBlock expression, Object returnValue) {}

	public void leaveArray(BizlangArray expression, Object returnValue) {}

	public String getCode() {
		if(code == null){
			code = new StringBuilder();
		}
		return code.toString();
	}
	
	private String getIndent(){
		String indent = "";
		for(int i = 0; i < indentLevel; i++){
			indent += "  ";
		}
		return indent;
	}
}
