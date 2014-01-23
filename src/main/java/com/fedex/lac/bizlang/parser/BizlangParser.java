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
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		SING_LN_CMM=17, MULT_LN_CMM=18, CSTMOPRT=19, LOGICOPRT=20, MATHOPTR=21, 
		CONDOPRT=22, FNCTNAME=23, NBR=24, STR=25, DATE=26, ID=27, OBJPROP=28, 
		NEWLINE=29, WS=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'do'", "']'", "'in'", "'default'", "')'", "','", "'['", 
		"'for'", "'('", "'='", "'...'", "'then'", "'else'", "'when'", "'end'", 
		"'case'", "SING_LN_CMM", "MULT_LN_CMM", "'><'", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", 
		"WS"
	};
	public static final int
		RULE_script = 0, RULE_expression = 1, RULE_fnctCall = 2, RULE_assignation = 3, 
		RULE_mathExpr = 4, RULE_conditional = 5, RULE_swtch = 6, RULE_caseBlock = 7, 
		RULE_repetition = 8, RULE_paramLst = 9, RULE_range = 10, RULE_array = 11, 
		RULE_value = 12, RULE_comment = 13, RULE_logicOp = 14, RULE_cstmLogOp = 15, 
		RULE_block = 16, RULE_elseBlk = 17;
	public static final String[] ruleNames = {
		"script", "expression", "fnctCall", "assignation", "mathExpr", "conditional", 
		"swtch", "caseBlock", "repetition", "paramLst", "range", "array", "value", 
		"comment", "logicOp", "cstmLogOp", "block", "elseBlk"
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
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36); expression();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
			setState(41); match(EOF);
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
		public SwtchContext swtch() {
			return getRuleContext(SwtchContext.class,0);
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
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); fnctCall();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); mathExpr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45); conditional();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46); swtch();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47); repetition();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(48); assignation();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49); value();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50); comment();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(51); match(NEWLINE);
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
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); match(FNCTNAME);
				setState(55); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(FNCTNAME);
				setState(57); match(9);
				setState(58); paramLst();
				setState(59); match(5);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); match(FNCTNAME);
				setState(62); paramLst();
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
			setState(65); match(ID);
			setState(66); match(10);
			setState(67); expression();
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
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); value();
				setState(70); match(MATHOPTR);
				setState(71); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); value();
				setState(74); match(MATHOPTR);
				setState(75); mathExpr();
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
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79); match(CONDOPRT);
				setState(80); logicOp();
				setState(81); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); match(CONDOPRT);
				setState(84); cstmLogOp();
				setState(85); block();
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

	public static class SwtchContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(BizlangParser.NEWLINE, 0); }
		public TerminalNode ID() { return getToken(BizlangParser.ID, 0); }
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public SwtchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_swtch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterSwtch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitSwtch(this);
		}
	}

	public final SwtchContext swtch() throws RecognitionException {
		SwtchContext _localctx = new SwtchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_swtch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(16);
			setState(90); match(ID);
			setState(91); match(NEWLINE);
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92); caseBlock();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 || _la==14 );
			setState(97); match(15);
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

	public static class CaseBlockContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterCaseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitCaseBlock(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_caseBlock);
		int _la;
		try {
			setState(113);
			switch (_input.LA(1)) {
			case 14:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); match(14);
				setState(100); value();
				setState(101); match(12);
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(102); expression();
					}
					}
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); match(4);
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(108); expression();
					}
					}
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 16, RULE_repetition);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115); match(8);
				setState(116); match(ID);
				setState(117); match(3);
				setState(118); match(OBJPROP);
				setState(119); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); match(8);
				setState(121); match(ID);
				setState(122); match(3);
				setState(123); match(ID);
				setState(124); block();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125); match(8);
				setState(126); match(ID);
				setState(127); match(3);
				setState(128); array();
				setState(129); block();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131); match(8);
				setState(132); match(ID);
				setState(133); match(3);
				setState(134); range();
				setState(135); block();
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
		enterRule(_localctx, 18, RULE_paramLst);
		try {
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); value();
				setState(141); match(6);
				setState(142); paramLst();
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
		public List<TerminalNode> DATE() { return getTokens(BizlangParser.DATE); }
		public List<TerminalNode> NBR() { return getTokens(BizlangParser.NBR); }
		public TerminalNode NBR(int i) {
			return getToken(BizlangParser.NBR, i);
		}
		public TerminalNode DATE(int i) {
			return getToken(BizlangParser.DATE, i);
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
		enterRule(_localctx, 20, RULE_range);
		try {
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146); match(7);
				setState(147); match(NBR);
				setState(148); match(11);
				setState(149); match(NBR);
				setState(150); match(2);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151); match(7);
				setState(152); match(DATE);
				setState(153); match(11);
				setState(154); match(DATE);
				setState(155); match(2);
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
		enterRule(_localctx, 22, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(7);
			setState(159); paramLst();
			setState(160); match(2);
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
		public TerminalNode DATE() { return getToken(BizlangParser.DATE, 0); }
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
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(NBR);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(STR);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164); match(ID);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165); match(OBJPROP);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166); match(DATE);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167); array();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(168); range();
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
		enterRule(_localctx, 26, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
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
		enterRule(_localctx, 28, RULE_logicOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); value();
			setState(174); match(LOGICOPRT);
			setState(175); value();
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
		enterRule(_localctx, 30, RULE_cstmLogOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); value();
			setState(178); match(CSTMOPRT);
			setState(179); value();
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
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181); match(1);
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182); expression();
					}
					}
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				setState(187); match(15);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189); match(1);
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190); expression();
					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
				setState(195); elseBlk();
				setState(196); match(15);
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
		enterRule(_localctx, 34, RULE_elseBlk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(13);
			setState(202); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(201); expression();
				}
				}
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 16) | (1L << SING_LN_CMM) | (1L << MULT_LN_CMM) | (1L << CONDOPRT) | (1L << FNCTNAME) | (1L << NBR) | (1L << STR) | (1L << DATE) | (1L << ID) | (1L << OBJPROP) | (1L << NEWLINE))) != 0) );
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3 \u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\6\b`\n\b\r\b\16\ba\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\6\tj\n\t\r\t\16\tk\3\t\3\t\6\tp\n\t\r\t\16\tq\5\tt\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u0093\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009f\n\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ac\n\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\6\22\u00ba\n\22\r\22\16\22\u00bb"+
		"\3\22\3\22\3\22\3\22\6\22\u00c2\n\22\r\22\16\22\u00c3\3\22\3\22\3\22\5"+
		"\22\u00c9\n\22\3\23\3\23\6\23\u00cd\n\23\r\23\16\23\u00ce\3\23\2\24\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\23\24\u00de\2\'\3\2"+
		"\2\2\4\66\3\2\2\2\6A\3\2\2\2\bC\3\2\2\2\nO\3\2\2\2\fY\3\2\2\2\16[\3\2"+
		"\2\2\20s\3\2\2\2\22\u008b\3\2\2\2\24\u0092\3\2\2\2\26\u009e\3\2\2\2\30"+
		"\u00a0\3\2\2\2\32\u00ab\3\2\2\2\34\u00ad\3\2\2\2\36\u00af\3\2\2\2 \u00b3"+
		"\3\2\2\2\"\u00c8\3\2\2\2$\u00ca\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2"+
		")\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-\67\5\6\4\2.\67\5"+
		"\n\6\2/\67\5\f\7\2\60\67\5\16\b\2\61\67\5\22\n\2\62\67\5\b\5\2\63\67\5"+
		"\32\16\2\64\67\5\34\17\2\65\67\7\37\2\2\66-\3\2\2\2\66.\3\2\2\2\66/\3"+
		"\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3"+
		"\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\7\31\2\29B\5\4\3\2:;\7\31\2\2;<\7"+
		"\13\2\2<=\5\24\13\2=>\7\7\2\2>B\3\2\2\2?@\7\31\2\2@B\5\24\13\2A8\3\2\2"+
		"\2A:\3\2\2\2A?\3\2\2\2B\7\3\2\2\2CD\7\35\2\2DE\7\f\2\2EF\5\4\3\2F\t\3"+
		"\2\2\2GH\5\32\16\2HI\7\27\2\2IJ\5\32\16\2JP\3\2\2\2KL\5\32\16\2LM\7\27"+
		"\2\2MN\5\n\6\2NP\3\2\2\2OG\3\2\2\2OK\3\2\2\2P\13\3\2\2\2QR\7\30\2\2RS"+
		"\5\36\20\2ST\5\"\22\2TZ\3\2\2\2UV\7\30\2\2VW\5 \21\2WX\5\"\22\2XZ\3\2"+
		"\2\2YQ\3\2\2\2YU\3\2\2\2Z\r\3\2\2\2[\\\7\22\2\2\\]\7\35\2\2]_\7\37\2\2"+
		"^`\5\20\t\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\21\2"+
		"\2d\17\3\2\2\2ef\7\20\2\2fg\5\32\16\2gi\7\16\2\2hj\5\4\3\2ih\3\2\2\2j"+
		"k\3\2\2\2ki\3\2\2\2kl\3\2\2\2lt\3\2\2\2mo\7\6\2\2np\5\4\3\2on\3\2\2\2"+
		"pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2se\3\2\2\2sm\3\2\2\2t\21\3\2\2"+
		"\2uv\7\n\2\2vw\7\35\2\2wx\7\5\2\2xy\7\36\2\2y\u008c\5\"\22\2z{\7\n\2\2"+
		"{|\7\35\2\2|}\7\5\2\2}~\7\35\2\2~\u008c\5\"\22\2\177\u0080\7\n\2\2\u0080"+
		"\u0081\7\35\2\2\u0081\u0082\7\5\2\2\u0082\u0083\5\30\r\2\u0083\u0084\5"+
		"\"\22\2\u0084\u008c\3\2\2\2\u0085\u0086\7\n\2\2\u0086\u0087\7\35\2\2\u0087"+
		"\u0088\7\5\2\2\u0088\u0089\5\26\f\2\u0089\u008a\5\"\22\2\u008a\u008c\3"+
		"\2\2\2\u008bu\3\2\2\2\u008bz\3\2\2\2\u008b\177\3\2\2\2\u008b\u0085\3\2"+
		"\2\2\u008c\23\3\2\2\2\u008d\u0093\5\32\16\2\u008e\u008f\5\32\16\2\u008f"+
		"\u0090\7\b\2\2\u0090\u0091\5\24\13\2\u0091\u0093\3\2\2\2\u0092\u008d\3"+
		"\2\2\2\u0092\u008e\3\2\2\2\u0093\25\3\2\2\2\u0094\u0095\7\t\2\2\u0095"+
		"\u0096\7\32\2\2\u0096\u0097\7\r\2\2\u0097\u0098\7\32\2\2\u0098\u009f\7"+
		"\4\2\2\u0099\u009a\7\t\2\2\u009a\u009b\7\34\2\2\u009b\u009c\7\r\2\2\u009c"+
		"\u009d\7\34\2\2\u009d\u009f\7\4\2\2\u009e\u0094\3\2\2\2\u009e\u0099\3"+
		"\2\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7\t\2\2\u00a1\u00a2\5\24\13\2\u00a2"+
		"\u00a3\7\4\2\2\u00a3\31\3\2\2\2\u00a4\u00ac\7\32\2\2\u00a5\u00ac\7\33"+
		"\2\2\u00a6\u00ac\7\35\2\2\u00a7\u00ac\7\36\2\2\u00a8\u00ac\7\34\2\2\u00a9"+
		"\u00ac\5\30\r\2\u00aa\u00ac\5\26\f\2\u00ab\u00a4\3\2\2\2\u00ab\u00a5\3"+
		"\2\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\t\2\2"+
		"\2\u00ae\35\3\2\2\2\u00af\u00b0\5\32\16\2\u00b0\u00b1\7\26\2\2\u00b1\u00b2"+
		"\5\32\16\2\u00b2\37\3\2\2\2\u00b3\u00b4\5\32\16\2\u00b4\u00b5\7\25\2\2"+
		"\u00b5\u00b6\5\32\16\2\u00b6!\3\2\2\2\u00b7\u00b9\7\3\2\2\u00b8\u00ba"+
		"\5\4\3\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\21\2\2\u00be\u00c9\3"+
		"\2\2\2\u00bf\u00c1\7\3\2\2\u00c0\u00c2\5\4\3\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c6\5$\23\2\u00c6\u00c7\7\21\2\2\u00c7\u00c9\3\2\2\2\u00c8"+
		"\u00b7\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c9#\3\2\2\2\u00ca\u00cc\7\17\2\2"+
		"\u00cb\u00cd\5\4\3\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf%\3\2\2\2\23)\66AOYakqs\u008b\u0092"+
		"\u009e\u00ab\u00bb\u00c3\u00c8\u00ce";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}