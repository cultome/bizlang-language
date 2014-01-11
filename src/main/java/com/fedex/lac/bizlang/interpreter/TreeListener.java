package com.fedex.lac.bizlang.interpreter;

import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.fedex.lac.bizlang.language.BizlangAssignation;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangFunction;
import com.fedex.lac.bizlang.language.BizlangMathOperation;
import com.fedex.lac.bizlang.language.BizlangValue;
import com.fedex.lac.bizlang.parser.BizlangBaseListener;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.parser.BizlangParser.AssignationContext;
import com.fedex.lac.bizlang.parser.BizlangParser.FnctCallContext;
import com.fedex.lac.bizlang.parser.BizlangParser.FnctContext;
import com.fedex.lac.bizlang.parser.BizlangParser.MathExprContext;
import com.fedex.lac.bizlang.parser.BizlangParser.ValueContext;

/* 
 * TreeListener.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class TreeListener extends BizlangBaseListener {

	private Stack<ParsingStatus> parsingStatus;
	private Stack<BizlangExpression> buffer;
	private ExecutionFlow flow;

	public TreeListener() {
		flow = new ExecutionFlow();
		parsingStatus = new Stack<ParsingStatus>();
		buffer = new Stack<BizlangExpression>();
	}

	public ExecutionFlow getExecutionFlow() {
		return flow;
	}

	@Override
	public void enterFnct(FnctContext ctx) {
		BizlangFunction fnct = flow.addFnct(ctx.getText(), ctx.getStart().getLine());
		buffer.push(fnct);
		parsingStatus.push(ParsingStatus.PARSING_FNCT);
	}

	@Override
	public void enterAssignation(AssignationContext ctx) {
		BizlangAssignation assign = flow.addAssignation(ctx.ID().getText(), ctx.getStart().getLine());
		buffer.push(assign);
		parsingStatus.push(ParsingStatus.ASSIGNING_VAL);
	}

	@Override
	public void enterMathExpr(MathExprContext ctx) {
		String operator = ctx.getChild(TerminalNode.class, 0).getText();
		BizlangMathOperation mathOperation = new BizlangMathOperation(operator, ctx.getStart().getLine());
		buffer.push(mathOperation);
		parsingStatus.push(ParsingStatus.PARSING_MATH_EXPR);
	}

	@Override
	public void enterValue(ValueContext ctx) {
		BizlangValue value = getValue(ctx);
		buffer.push(value);
		parsingStatus.push(ParsingStatus.GETTING_VALUE);
	}
	
	@Override
	public void exitFnctCall(FnctCallContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitAssignation(AssignationContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitMathExpr(MathExprContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitValue(ValueContext ctx) {
		exitExpression();
	}

	private void exitExpression(){
		parsingStatus.pop();
		BizlangExpression r = buffer.pop();
		if(!parsingStatus.isEmpty()){
			// T__6 = 1, T__5 = 2, T__4 = 3, T__3 = 4, T__2 = 5, T__1 = 6, T__0 = 7,
			// ID = 8, STR = 9, NBR = 10, OBJ_PROP = 11, MATH_OP = 12, NEWLINE = 13, WS = 14;
			if (parsingStatus.peek().equals(ParsingStatus.PARSING_MATH_EXPR)) {
				((BizlangMathOperation) buffer.peek()).addParam(r);
				
			} else if (parsingStatus.peek().equals(ParsingStatus.PARSING_FNCT)) {
				((BizlangFunction) buffer.peek()).addParam(r);
				
			} else if (parsingStatus.peek().equals(ParsingStatus.ASSIGNING_VAL)) {
				((BizlangAssignation) buffer.peek()).addLValue(r);
				
			}
		}
	}
	
	private BizlangValue getValue(ValueContext ctx) {
		TerminalNode valueNode = ctx.getChild(TerminalNode.class, 0);
		switch (valueNode.getSymbol().getType()) {
			case BizlangLexer.STR:
				return new BizlangValue(BizlangLexer.STR, ctx.STR().getText(), ctx.getStart().getLine());
			case BizlangLexer.ID:
				return new BizlangValue(BizlangLexer.ID, ctx.ID().getText(), ctx.getStart().getLine());
			case BizlangLexer.NBR:
				return new BizlangValue(BizlangLexer.NBR, ctx.NBR().getText(), ctx.getStart().getLine());
			default:
				throw new RuntimeException("Symbol type uknown. [" + valueNode.getSymbol().getType() + "]");
		}
	}
}
