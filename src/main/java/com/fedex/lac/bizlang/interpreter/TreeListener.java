package com.fedex.lac.bizlang.interpreter;

import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.fedex.lac.bizlang.language.BizlangAssignation;
import com.fedex.lac.bizlang.language.BizlangBlock;
import com.fedex.lac.bizlang.language.BizlangConditionalExpression;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangFunction;
import com.fedex.lac.bizlang.language.BizlangLogicOperation;
import com.fedex.lac.bizlang.language.BizlangMathOperation;
import com.fedex.lac.bizlang.language.BizlangRepetition;
import com.fedex.lac.bizlang.language.BizlangValue;
import com.fedex.lac.bizlang.parser.BizlangBaseListener;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.parser.BizlangParser.AssignationContext;
import com.fedex.lac.bizlang.parser.BizlangParser.BlockContext;
import com.fedex.lac.bizlang.parser.BizlangParser.CommentContext;
import com.fedex.lac.bizlang.parser.BizlangParser.ConditionalContext;
import com.fedex.lac.bizlang.parser.BizlangParser.ElseBlkContext;
import com.fedex.lac.bizlang.parser.BizlangParser.FnctCallContext;
import com.fedex.lac.bizlang.parser.BizlangParser.LogicOpContext;
import com.fedex.lac.bizlang.parser.BizlangParser.MathExprContext;
import com.fedex.lac.bizlang.parser.BizlangParser.RepetitionContext;
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
	public void enterComment(CommentContext ctx) {
		super.enterComment(ctx);
	}
	
	@Override
	public void enterFnctCall(FnctCallContext ctx) {
		BizlangFunction fnct = new BizlangFunction(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		buffer.push(fnct);
		parsingStatus.push(ParsingStatus.PARSING_FNCT);
	}

	@Override
	public void enterAssignation(AssignationContext ctx) {
		BizlangAssignation assign = new BizlangAssignation(ctx.ID().getText(), ctx.getStart().getLine());
		buffer.push(assign);
		parsingStatus.push(ParsingStatus.ASSIGNING_VAL);
	}

	@Override
	public void enterMathExpr(MathExprContext ctx) {
		BizlangMathOperation mathOperation = new BizlangMathOperation(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		buffer.push(mathOperation);
		parsingStatus.push(ParsingStatus.PARSING_MATH_EXPR);
	}
	
	@Override
	public void enterConditional(ConditionalContext ctx) {
		BizlangConditionalExpression condExpr = new BizlangConditionalExpression(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		buffer.push(condExpr);
		parsingStatus.push(ParsingStatus.PARSING_CONDITION);
	}
	
	@Override
	public void enterLogicOp(LogicOpContext ctx) {
		BizlangLogicOperation condExpr = new BizlangLogicOperation(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		buffer.push(condExpr);
		parsingStatus.push(ParsingStatus.PARSING_LOGIC_COMP);
	}
	
	@Override
	public void enterBlock(BlockContext ctx) {
		BizlangBlock block = new BizlangBlock("_block_", ctx.getStart().getLine());
		buffer.push(block);
		parsingStatus.push(ParsingStatus.PARSING_BLOCK);
	}
	
	@Override
	public void enterElseBlk(ElseBlkContext ctx) {
		BizlangBlock block = new BizlangBlock("_else_block_", ctx.getStart().getLine());
		buffer.push(block);
		parsingStatus.push(ParsingStatus.PARSING_ELSE_BLOCK);
	}
	
	@Override
	public void enterRepetition(RepetitionContext ctx) {
		BizlangRepetition repetition = new BizlangRepetition(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		repetition.setRepetitionVarName(ctx.getChild(TerminalNode.class, 1).getText());
		repetition.setCollection(ctx.getChild(TerminalNode.class, 3).getText());
		buffer.push(repetition);
		parsingStatus.push(ParsingStatus.PARSING_REPETITION);
	}
	
	@Override
	public void enterValue(ValueContext ctx) {
		BizlangValue value = getValue(ctx);
		buffer.push(value);
		parsingStatus.push(ParsingStatus.GETTING_VALUE);
	}
	
	@Override
	public void exitRepetition(RepetitionContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitBlock(BlockContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitElseBlk(ElseBlkContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitLogicOp(LogicOpContext ctx) {
		exitExpression();
	}

	@Override
	public void exitConditional(ConditionalContext ctx) {
		exitExpression();
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
		ParsingStatus prevStatus = parsingStatus.pop();
		BizlangExpression r = buffer.pop();
		if(parsingStatus.isEmpty()){
			flow.addToFlow(r);
		} else {
			switch(parsingStatus.peek()){
			// T__8 = 1, T__7 = 2, T__6 = 3, T__5 = 4, T__4 = 5, T__3 = 6, T__2 = 7, T__1 = 8, T__0 = 9, 
			// FNCTNAME = 10, ID = 11, STR = 12, NBR = 13, OBJPROP = 14, MATHOPTR = 15, NEWLINE = 16, WS = 17;
			case PARSING_MATH_EXPR:
				((BizlangMathOperation) buffer.peek()).addParam(r);
				break;
			case PARSING_FNCT:
				((BizlangFunction) buffer.peek()).addParam(r);
				break;
			case ASSIGNING_VAL:
				((BizlangAssignation) buffer.peek()).addLValue(r);
				break;
			case PARSING_CONDITION:
				if(prevStatus.equals(ParsingStatus.PARSING_LOGIC_COMP)){
					((BizlangConditionalExpression) buffer.peek()).addCondition((BizlangLogicOperation) r);
				} else if(prevStatus.equals(ParsingStatus.PARSING_BLOCK)){
					((BizlangConditionalExpression) buffer.peek()).addBlock((BizlangBlock) r);
				}
				break;
			case PARSING_LOGIC_COMP:
				((BizlangLogicOperation) buffer.peek()).addParam((BizlangValue) r);
				break;
			case PARSING_BLOCK:
			case PARSING_ELSE_BLOCK:
				if(prevStatus.equals(ParsingStatus.PARSING_ELSE_BLOCK)){
					((BizlangConditionalExpression) buffer.elementAt(buffer.size() - 2)).addElseBlock((BizlangBlock) r);
				} else {
					((BizlangBlock) buffer.peek()).addExpression((BizlangExpression) r);
				}
				break;
			case PARSING_REPETITION:
				if(prevStatus.equals(ParsingStatus.PARSING_BLOCK)){
					((BizlangRepetition) buffer.peek()).addBlock((BizlangBlock) r);
				}
				break;
			case WAITING:
			case GETTING_VALUE:
				break;
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
			case BizlangLexer.OBJPROP:
				return new BizlangValue(BizlangLexer.OBJPROP, ctx.OBJPROP().getText(), ctx.getStart().getLine());
			default:
				throw new RuntimeException("Symbol type uknown. [" + valueNode.getSymbol().getType() + "]");
		}
	}
}
