package com.cultomebizlang.language.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

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
import com.cultome.bizlang.language.parser.BizlangBaseListener;
import com.cultome.bizlang.language.parser.BizlangLexer;
import com.cultome.bizlang.language.parser.BizlangParser.ArrayContext;
import com.cultome.bizlang.language.parser.BizlangParser.AssignationContext;
import com.cultome.bizlang.language.parser.BizlangParser.BlockContext;
import com.cultome.bizlang.language.parser.BizlangParser.CaseBlockContext;
import com.cultome.bizlang.language.parser.BizlangParser.ConditionalContext;
import com.cultome.bizlang.language.parser.BizlangParser.CstmLogOpContext;
import com.cultome.bizlang.language.parser.BizlangParser.DefRuleContext;
import com.cultome.bizlang.language.parser.BizlangParser.ElseBlkContext;
import com.cultome.bizlang.language.parser.BizlangParser.FnctCallContext;
import com.cultome.bizlang.language.parser.BizlangParser.LogicOpContext;
import com.cultome.bizlang.language.parser.BizlangParser.MathExprContext;
import com.cultome.bizlang.language.parser.BizlangParser.ParamLstContext;
import com.cultome.bizlang.language.parser.BizlangParser.RangeContext;
import com.cultome.bizlang.language.parser.BizlangParser.RepetitionContext;
import com.cultome.bizlang.language.parser.BizlangParser.SwtchContext;
import com.cultome.bizlang.language.parser.BizlangParser.ValueContext;

/* 
 * TreeListener.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class TreeListener extends BizlangBaseListener {

	public static final int COMPLEX_TYPE_ARRAY = 100;
	public static final int COMPLEX_TYPE_RANGE = 101;

	private Stack<ParsingStatus> parsingStatus;
	private Stack<BizlangExpression> buffer;
	private ExecutionFlow flow;
	
	@Override
	public String toString() {
		return parsingStatus.toString() + "\n";
	}

	public TreeListener() {
		flow = new ExecutionFlow();
		parsingStatus = new Stack<ParsingStatus>();
		buffer = new Stack<BizlangExpression>();
	}

	public ExecutionFlow getExecutionFlow() {
		return flow;
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
		BizlangBlock block = new BizlangBlock("__block__", ctx.getStart().getLine());
		buffer.push(block);
		parsingStatus.push(ParsingStatus.PARSING_BLOCK);
	}
	
	@Override
	public void enterElseBlk(ElseBlkContext ctx) {
		BizlangBlock block = new BizlangBlock("__else_block__", ctx.getStart().getLine());
		buffer.push(block);
		parsingStatus.push(ParsingStatus.PARSING_ELSE_BLOCK);
	}
	
	@Override
	public void enterRepetition(RepetitionContext ctx) {
		BizlangRepetition repetition = new BizlangRepetition(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine());
		repetition.setRepetitionVarName(ctx.getChild(TerminalNode.class, 1).getText());
		TerminalNode collRefNameNode = ctx.getChild(TerminalNode.class, 3);
		String collRefName = null;
		if(collRefNameNode != null){
			// el array NO esta inline
			collRefName = collRefNameNode.getText();
		}
		
		repetition.setCollectionName(collRefName);
		buffer.push(repetition);
		parsingStatus.push(ParsingStatus.PARSING_REPETITION);
	}

	@Override
	public void enterArray(ArrayContext ctx) {
		BizlangArray array = new BizlangArray(ctx.getStart().getLine()); 
		buffer.push(array);
		parsingStatus.push(ParsingStatus.PARSING_ARRAY);
	}

	@Override
	public void enterRange(RangeContext ctx) {
		BizlangRange range;
		if(!parsingStatus.peek().equals(ParsingStatus.GETTING_VALUE)){
			range = getRange(ctx);
		} else {
			range = new BizlangRange(ctx.getStart().getLine()); 
		}
		buffer.push(range);
		parsingStatus.push(ParsingStatus.PARSING_RANGE);
	}
	
	@Override
	public void enterValue(ValueContext ctx) {
		BizlangValue value = getValue(ctx);
		buffer.push(value);
		parsingStatus.push(ParsingStatus.GETTING_VALUE);
	}
	
	@Override
	public void enterCstmLogOp(CstmLogOpContext ctx) {
		BizlangCustomLogicOperation cstmLogOp = new BizlangCustomLogicOperation(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine()); 
		buffer.push(cstmLogOp);
		parsingStatus.push(ParsingStatus.PARSING_CSTM_LOG_OP);
	}
	
	@Override
	public void enterSwtch(SwtchContext ctx) {
		BizlangSwitch swtch = new BizlangSwitch(ctx.getStart().getLine());
		buffer.push(swtch);
		parsingStatus.push(ParsingStatus.PARSING_SWITCH);
	}
	
	@Override
	public void enterCaseBlock(CaseBlockContext ctx) {
		BizlangSwitchBlock cstmLogOp = new BizlangSwitchBlock(ctx.getChild(TerminalNode.class, 0).getText(), ctx.getStart().getLine()); 
		buffer.push(cstmLogOp);
		parsingStatus.push(ParsingStatus.PARSING_CASE_BLOCK);
	}
	
	@Override
	public void enterDefRule(DefRuleContext ctx) {
		String fnctNameColons = ctx.getChild(TerminalNode.class, 1).getText();
		BizlangRule rule = new BizlangRule(fnctNameColons.replaceAll("\"", ""), ctx.getStart().getLine()); 
		buffer.push(rule);
		parsingStatus.push(ParsingStatus.PARSING_RULE);
	}
	
	@Override
	public void exitDefRule(DefRuleContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitCaseBlock(CaseBlockContext ctx) {
		exitExpression();
	}

	@Override
	public void exitSwtch(SwtchContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitCstmLogOp(CstmLogOpContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitRange(RangeContext ctx) {
		exitExpression();
	}
	
	@Override
	public void exitArray(ArrayContext ctx) {
		exitExpression();
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
		
		if(prevStatus.equals(ParsingStatus.PARSING_RULE)){
			flow.addRule((BizlangRule) r);
		}
		
		if(parsingStatus.isEmpty()){
			flow.addToFlow(r);
		} else {
			switch(parsingStatus.peek()){
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
				} else if(prevStatus.equals(ParsingStatus.PARSING_CSTM_LOG_OP)){
					((BizlangConditionalExpression) buffer.peek()).addCondition((BizlangCustomLogicOperation) r);
				} else if(prevStatus.equals(ParsingStatus.PARSING_BLOCK)){
					((BizlangConditionalExpression) buffer.peek()).addBlock((BizlangBlock) r);
				}
				break;
			case PARSING_LOGIC_COMP:
				((BizlangLogicOperation) buffer.peek()).addParam((BizlangValue) r);
				break;
			case PARSING_CSTM_LOG_OP:
				if(prevStatus.equals(ParsingStatus.PARSING_BLOCK)){
					((BizlangConditionalExpression) buffer.elementAt(buffer.size() - 2)).addBlock((BizlangBlock) r);
				} else {
					((BizlangCustomLogicOperation) buffer.peek()).addParam((BizlangValue) r);
				}
				break;
			case PARSING_BLOCK:
			case PARSING_ELSE_BLOCK:
				if(prevStatus.equals(ParsingStatus.PARSING_ELSE_BLOCK)){
					BizlangExpression elementAt = buffer.elementAt(buffer.size() - 2);
					if(elementAt instanceof BizlangConditionalExpression){
						((BizlangConditionalExpression) elementAt).addElseBlock((BizlangBlock) r);
					} else {
						((BizlangConditionalExpression) buffer.elementAt(buffer.size() - 3)).addElseBlock((BizlangBlock) r);
					}
				} else {
					((BizlangBlock) buffer.peek()).addExpression((BizlangExpression) r);
				}
				break;
			case PARSING_REPETITION:
				if(prevStatus.equals(ParsingStatus.PARSING_BLOCK)){
					((BizlangRepetition) buffer.peek()).addBlock((BizlangBlock) r);
				} else if(prevStatus.equals(ParsingStatus.PARSING_ARRAY)){
					((BizlangRepetition) buffer.peek()).setCollection((BizlangArray) r);
				} else if(prevStatus.equals(ParsingStatus.PARSING_RANGE)){
					((BizlangRepetition) buffer.peek()).setCollection((BizlangRange) r);
				}
				break;
			case PARSING_ARRAY:
				((BizlangArray) buffer.peek()).addElement((BizlangValue) r);
				break;
			case PARSING_RANGE:
				((BizlangRange) buffer.peek()).addLimit((BizlangValue) r);
				break;
			case PARSING_SWITCH:
				if(prevStatus.equals(ParsingStatus.GETTING_VALUE)){
					((BizlangSwitch) buffer.peek()).addReference((BizlangValue) r);
				} else if(prevStatus.equals(ParsingStatus.PARSING_CASE_BLOCK)){
					((BizlangSwitch) buffer.peek()).addCase((BizlangSwitchBlock) r);
				}
				break;
			case PARSING_CASE_BLOCK:
				BizlangSwitchBlock bizlangSwitchBlock = (BizlangSwitchBlock) buffer.peek();
				if(prevStatus.equals(ParsingStatus.GETTING_VALUE)){
					if(bizlangSwitchBlock.getCondition() == null){
						bizlangSwitchBlock.addCondition((BizlangValue) r);
					} else {
						bizlangSwitchBlock.addExpression((BizlangExpression) r);
					}
				} else { 
					bizlangSwitchBlock.addExpression((BizlangExpression) r);
				}
				break;
			case PARSING_RULE:
				((BizlangRule) buffer.peek()).addExpression((BizlangExpression) r);
			case WAITING:
			case GETTING_VALUE:
				break;
			}
		}
	}
	
	private BizlangValue getValue(ValueContext ctx) {
		TerminalNode valueNode = ctx.getChild(TerminalNode.class, 0);
		if(valueNode != null){
			return getPrimitiveValue(valueNode, ctx.getStart().getLine());
		} else {
			// es un tipo complejo
			if(ctx.getChild(0) instanceof ArrayContext){
				List<BizlangValue> values = extractValuesFromParamList((ParamLstContext) ctx.getChild(0).getChild(1));
				return new BizlangArray(ctx.getChild(0).getText(), ctx.getStart().getLine(), values);
			} else if(ctx.getChild(0)instanceof RangeContext){
				return getRange((RangeContext) ctx.getChild(0));
			}
		}
		throw new RuntimeException("Uknown type. [" + ctx.getText() + "]");
	}

	private BizlangRange getRange(RangeContext ctx) {
		BizlangValue lowLimit = getPrimitiveValue((TerminalNode) ctx.getChild(1), ctx.getStart().getLine());
		BizlangValue highLimit = getPrimitiveValue((TerminalNode) ctx.getChild(3), ctx.getStart().getLine());
		return new BizlangRange("_range_", ctx.getStart().getLine(), lowLimit, highLimit);
	}

	private BizlangValue getPrimitiveValue(TerminalNode valueNode, int srcLineDefinedAt) {
		// es un tipo simple
		switch (valueNode.getSymbol().getType()) {
		case BizlangLexer.STR:
			return new BizlangValue(BizlangLexer.STR, valueNode.getText(), srcLineDefinedAt);
		case BizlangLexer.ID:
			return new BizlangValue(BizlangLexer.ID, valueNode.getText(), srcLineDefinedAt);
		case BizlangLexer.NBR:
			return new BizlangValue(BizlangLexer.NBR, valueNode.getText(), srcLineDefinedAt);
		case BizlangLexer.OBJPROP:
			return new BizlangValue(BizlangLexer.OBJPROP, valueNode.getText(), srcLineDefinedAt);
		case BizlangLexer.DATE:
			return new BizlangValue(BizlangLexer.DATE, valueNode.getText(), srcLineDefinedAt);
		default:
			throw new RuntimeException("Symbol type uknown in line " + srcLineDefinedAt + ". [" + valueNode.getSymbol().getType() + "]");
		}
	}

	private List<BizlangValue> extractValuesFromParamList(ParamLstContext values) {
		ArrayList<BizlangValue> arrayValues = new ArrayList<BizlangValue>();
		for(int i = 0; i < values.getChildCount(); i++){
			ParseTree child = values.getChild(i);
			if(child instanceof ValueContext){
				arrayValues.add(getValue((ValueContext) child));
			} else if(child instanceof ParamLstContext){
				arrayValues.addAll(extractValuesFromParamList((ParamLstContext) child));
			} else if(child instanceof TerminalNode){
				// ignore the colons
			} else {
				throw new RuntimeException("Unknown type in inner arrau value. [" + child.getClass().getName() + "]");
			}
		}
		return arrayValues;
	}
}
