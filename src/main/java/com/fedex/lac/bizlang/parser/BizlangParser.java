// Generated from Bizlang.g4 by ANTLR 4.1
package com.fedex.lac.bizlang.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BizlangParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, SING_LN_CMM=13, MULT_LN_CMM=14, CSTMOPRT=15, 
		LOGICOPRT=16, MATHOPTR=17, CONDOPRT=18, FNCTNAME=19, NBR=20, STR=21, ID=22, 
		OBJPROP=23, NEWLINE=24, WS=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'do'", "']'", "'...'", "')'", "'in'", "','", "'['", "'('", 
		"'for'", "'else'", "'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "'><'", 
		"LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", 
		"NEWLINE", "WS"
	};
	public static final int
		RULE_script = 0, RULE_expression = 1, RULE_fnctCall = 2, RULE_assignation = 3, 
		RULE_mathExpr = 4, RULE_conditional = 5, RULE_repetition = 6, RULE_paramLst = 7, 
		RULE_range = 8, RULE_array = 9, RULE_value = 10, RULE_comment = 11, RULE_logicOp = 12, 
		RULE_cstmLogOp = 13, RULE_block = 14, RULE_elseBlk = 15;
	public static final String[] ruleNames = {
		"script", "expression", "fnctCall", "assignation", "mathExpr", "conditional", 
		"repetition", "paramLst", "range", "array", "value", "comment", "logicOp", 
		"cstmLogOp", "block", "elseBlk"
	};

	@Override
	public String getGrammarFileName() { return "Bizlang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BizlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BizlangParser.EOF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32); expression();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
			setState(37); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(BizlangParser.NEWLINE, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public RepetitionContext repetition() {
			return getRuleContext(RepetitionContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public FnctCallContext fnctCall() {
			return getRuleContext(FnctCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); fnctCall();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); mathExpr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41); conditional();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(42); repetition();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(43); assignation();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(44); value();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(45); comment();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(46); match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnctCallContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParamLstContext paramLst() {
			return getRuleContext(ParamLstContext.class,0);
		}
		public TerminalNode FNCTNAME() { return getToken(BizlangParser.FNCTNAME, 0); }
		public FnctCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnctCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterFnctCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitFnctCall(this);
		}
	}

	public final FnctCallContext fnctCall() throws RecognitionException {
		FnctCallContext _localctx = new FnctCallContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fnctCall);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); match(FNCTNAME);
				setState(50); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); match(FNCTNAME);
				setState(52); match(8);
				setState(53); paramLst();
				setState(54); match(4);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56); match(FNCTNAME);
				setState(57); paramLst();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BizlangParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); match(ID);
			setState(61); match(11);
			setState(62); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathExprContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode MATHOPTR() { return getToken(BizlangParser.MATHOPTR, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public MathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterMathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitMathExpr(this);
		}
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mathExpr);
		try {
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); value();
				setState(65); match(MATHOPTR);
				setState(66); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); value();
				setState(69); match(MATHOPTR);
				setState(70); mathExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CONDOPRT() { return getToken(BizlangParser.CONDOPRT, 0); }
		public CstmLogOpContext cstmLogOp() {
			return getRuleContext(CstmLogOpContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional);
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(CONDOPRT);
				setState(75); logicOp();
				setState(76); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); match(CONDOPRT);
				setState(79); cstmLogOp();
				setState(80); block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepetitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BizlangParser.ID); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode OBJPROP() { return getToken(BizlangParser.OBJPROP, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(BizlangParser.ID, i);
		}
		public RepetitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterRepetition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitRepetition(this);
		}
	}

	public final RepetitionContext repetition() throws RecognitionException {
		RepetitionContext _localctx = new RepetitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_repetition);
		try {
			setState(106);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); match(9);
				setState(85); match(ID);
				setState(86); match(5);
				setState(87); match(OBJPROP);
				setState(88); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); match(9);
				setState(90); match(ID);
				setState(91); match(5);
				setState(92); match(ID);
				setState(93); block();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94); match(9);
				setState(95); match(ID);
				setState(96); match(5);
				setState(97); array();
				setState(98); block();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); match(9);
				setState(101); match(ID);
				setState(102); match(5);
				setState(103); range();
				setState(104); block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamLstContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParamLstContext paramLst() {
			return getRuleContext(ParamLstContext.class,0);
		}
		public ParamLstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramLst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterParamLst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitParamLst(this);
		}
	}

	public final ParamLstContext paramLst() throws RecognitionException {
		ParamLstContext _localctx = new ParamLstContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramLst);
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); value();
				setState(110); match(6);
				setState(111); paramLst();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public List<TerminalNode> NBR() { return getTokens(BizlangParser.NBR); }
		public TerminalNode NBR(int i) {
			return getToken(BizlangParser.NBR, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(7);
			setState(116); match(NBR);
			setState(117); match(3);
			setState(118); match(NBR);
			setState(119); match(2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ParamLstContext paramLst() {
			return getRuleContext(ParamLstContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(7);
			setState(122); paramLst();
			setState(123); match(2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BizlangParser.ID, 0); }
		public TerminalNode STR() { return getToken(BizlangParser.STR, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode NBR() { return getToken(BizlangParser.NBR, 0); }
		public TerminalNode OBJPROP() { return getToken(BizlangParser.OBJPROP, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		try {
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); match(NBR);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); match(STR);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127); match(ID);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128); match(OBJPROP);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(129); array();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(130); range();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode MULT_LN_CMM() { return getToken(BizlangParser.MULT_LN_CMM, 0); }
		public TerminalNode SING_LN_CMM() { return getToken(BizlangParser.SING_LN_CMM, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==SING_LN_CMM || _la==MULT_LN_CMM) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicOpContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode LOGICOPRT() { return getToken(BizlangParser.LOGICOPRT, 0); }
		public LogicOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitLogicOp(this);
		}
	}

	public final LogicOpContext logicOp() throws RecognitionException {
		LogicOpContext _localctx = new LogicOpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logicOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); value();
			setState(136); match(LOGICOPRT);
			setState(137); value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CstmLogOpContext extends ParserRuleContext {
		public TerminalNode CSTMOPRT() { return getToken(BizlangParser.CSTMOPRT, 0); }
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public CstmLogOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cstmLogOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterCstmLogOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitCstmLogOp(this);
		}
	}

	public final CstmLogOpContext cstmLogOp() throws RecognitionException {
		CstmLogOpContext _localctx = new CstmLogOpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cstmLogOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); value();
			setState(140); match(CSTMOPRT);
			setState(141); value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ElseBlkContext elseBlk() {
			return getRuleContext(ElseBlkContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); match(1);
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(144); expression();
					}
					}
					setState(147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				setState(149); match(12);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151); match(1);
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(152); expression();
					}
					}
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				setState(157); elseBlk();
				setState(158); match(12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseBlkContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ElseBlkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterElseBlk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitElseBlk(this);
		}
	}

	public final ElseBlkContext elseBlk() throws RecognitionException {
		ElseBlkContext _localctx = new ElseBlkContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseBlk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(10);
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163); expression();
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\33\u00ab\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2"+
		"$\n\2\r\2\16\2%\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7U\n\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\3\t\3\t\3\t\5\tt\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0086\n\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\6\20\u0094\n"+
		"\20\r\20\16\20\u0095\3\20\3\20\3\20\3\20\6\20\u009c\n\20\r\20\16\20\u009d"+
		"\3\20\3\20\3\20\5\20\u00a3\n\20\3\21\3\21\6\21\u00a7\n\21\r\21\16\21\u00a8"+
		"\3\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\17\20\u00b3"+
		"\2#\3\2\2\2\4\61\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nJ\3\2\2\2\fT\3\2\2\2\16"+
		"l\3\2\2\2\20s\3\2\2\2\22u\3\2\2\2\24{\3\2\2\2\26\u0085\3\2\2\2\30\u0087"+
		"\3\2\2\2\32\u0089\3\2\2\2\34\u008d\3\2\2\2\36\u00a2\3\2\2\2 \u00a4\3\2"+
		"\2\2\"$\5\4\3\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'"+
		"(\7\2\2\3(\3\3\2\2\2)\62\5\6\4\2*\62\5\n\6\2+\62\5\f\7\2,\62\5\16\b\2"+
		"-\62\5\b\5\2.\62\5\26\f\2/\62\5\30\r\2\60\62\7\32\2\2\61)\3\2\2\2\61*"+
		"\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61"+
		"\60\3\2\2\2\62\5\3\2\2\2\63\64\7\25\2\2\64=\5\4\3\2\65\66\7\25\2\2\66"+
		"\67\7\n\2\2\678\5\20\t\289\7\6\2\29=\3\2\2\2:;\7\25\2\2;=\5\20\t\2<\63"+
		"\3\2\2\2<\65\3\2\2\2<:\3\2\2\2=\7\3\2\2\2>?\7\30\2\2?@\7\r\2\2@A\5\4\3"+
		"\2A\t\3\2\2\2BC\5\26\f\2CD\7\23\2\2DE\5\26\f\2EK\3\2\2\2FG\5\26\f\2GH"+
		"\7\23\2\2HI\5\n\6\2IK\3\2\2\2JB\3\2\2\2JF\3\2\2\2K\13\3\2\2\2LM\7\24\2"+
		"\2MN\5\32\16\2NO\5\36\20\2OU\3\2\2\2PQ\7\24\2\2QR\5\34\17\2RS\5\36\20"+
		"\2SU\3\2\2\2TL\3\2\2\2TP\3\2\2\2U\r\3\2\2\2VW\7\13\2\2WX\7\30\2\2XY\7"+
		"\7\2\2YZ\7\31\2\2Zm\5\36\20\2[\\\7\13\2\2\\]\7\30\2\2]^\7\7\2\2^_\7\30"+
		"\2\2_m\5\36\20\2`a\7\13\2\2ab\7\30\2\2bc\7\7\2\2cd\5\24\13\2de\5\36\20"+
		"\2em\3\2\2\2fg\7\13\2\2gh\7\30\2\2hi\7\7\2\2ij\5\22\n\2jk\5\36\20\2km"+
		"\3\2\2\2lV\3\2\2\2l[\3\2\2\2l`\3\2\2\2lf\3\2\2\2m\17\3\2\2\2nt\5\26\f"+
		"\2op\5\26\f\2pq\7\b\2\2qr\5\20\t\2rt\3\2\2\2sn\3\2\2\2so\3\2\2\2t\21\3"+
		"\2\2\2uv\7\t\2\2vw\7\26\2\2wx\7\5\2\2xy\7\26\2\2yz\7\4\2\2z\23\3\2\2\2"+
		"{|\7\t\2\2|}\5\20\t\2}~\7\4\2\2~\25\3\2\2\2\177\u0086\7\26\2\2\u0080\u0086"+
		"\7\27\2\2\u0081\u0086\7\30\2\2\u0082\u0086\7\31\2\2\u0083\u0086\5\24\13"+
		"\2\u0084\u0086\5\22\n\2\u0085\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085\u0081"+
		"\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\27\3\2\2\2\u0087\u0088\t\2\2\2\u0088\31\3\2\2\2\u0089\u008a\5\26\f\2"+
		"\u008a\u008b\7\22\2\2\u008b\u008c\5\26\f\2\u008c\33\3\2\2\2\u008d\u008e"+
		"\5\26\f\2\u008e\u008f\7\21\2\2\u008f\u0090\5\26\f\2\u0090\35\3\2\2\2\u0091"+
		"\u0093\7\3\2\2\u0092\u0094\5\4\3\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\7\16\2\2\u0098\u00a3\3\2\2\2\u0099\u009b\7\3\2\2\u009a\u009c\5"+
		"\4\3\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\5 \21\2\u00a0\u00a1\7\16"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0099\3\2\2\2\u00a3"+
		"\37\3\2\2\2\u00a4\u00a6\7\f\2\2\u00a5\u00a7\5\4\3\2\u00a6\u00a5\3\2\2"+
		"\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9!"+
		"\3\2\2\2\16%\61<JTls\u0085\u0095\u009d\u00a2\u00a8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}