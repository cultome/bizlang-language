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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, ID=8, STR=9, NBR=10, 
		OBJ_PROP=11, MATH_OP=12, NEWLINE=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "'sum'", "')'", "'getFromDb'", "','", "'('", "'print'", "'='", 
		"ID", "STR", "NBR", "OBJ_PROP", "MATH_OP", "NEWLINE", "WS"
	};
	public static final int
		RULE_script = 0, RULE_expressions = 1, RULE_expression = 2, RULE_math_expr = 3, 
		RULE_fnct_call = 4, RULE_fnct = 5, RULE_assignation = 6, RULE_param_lst = 7, 
		RULE_value = 8;
	public static final String[] ruleNames = {
		"script", "expressions", "expression", "math_expr", "fnct_call", "fnct", 
		"assignation", "param_lst", "value"
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
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); expressions();
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

	public static class ExpressionsContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(BizlangParser.NEWLINE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expressions);
		try {
			setState(25);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21); expression();
				setState(22); match(NEWLINE);
				setState(23); expressions();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public Fnct_callContext fnct_call() {
			return getRuleContext(Fnct_callContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
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
		enterRule(_localctx, 4, RULE_expression);
		try {
			setState(31);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); fnct_call();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); assignation();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29); math_expr();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(30); value();
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

	public static class Math_exprContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode MATH_OP() { return getToken(BizlangParser.MATH_OP, 0); }
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public Math_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterMath_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitMath_expr(this);
		}
	}

	public final Math_exprContext math_expr() throws RecognitionException {
		Math_exprContext _localctx = new Math_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_math_expr);
		try {
			setState(41);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33); value();
				setState(34); match(MATH_OP);
				setState(35); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); value();
				setState(38); match(MATH_OP);
				setState(39); math_expr();
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

	public static class Fnct_callContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Param_lstContext param_lst() {
			return getRuleContext(Param_lstContext.class,0);
		}
		public FnctContext fnct() {
			return getRuleContext(FnctContext.class,0);
		}
		public Fnct_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnct_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterFnct_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitFnct_call(this);
		}
	}

	public final Fnct_callContext fnct_call() throws RecognitionException {
		Fnct_callContext _localctx = new Fnct_callContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fnct_call);
		try {
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); fnct();
				setState(44); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46); fnct();
				setState(47); match(5);
				setState(48); param_lst();
				setState(49); match(2);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51); fnct();
				setState(52); param_lst();
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

	public static class FnctContext extends ParserRuleContext {
		public FnctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterFnct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitFnct(this);
		}
	}

	public final FnctContext fnct() throws RecognitionException {
		FnctContext _localctx = new FnctContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6))) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(ID);
			setState(59); match(7);
			setState(60); expression();
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

	public static class Param_lstContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Param_lstContext param_lst() {
			return getRuleContext(Param_lstContext.class,0);
		}
		public Param_lstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_lst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).enterParam_lst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BizlangListener ) ((BizlangListener)listener).exitParam_lst(this);
		}
	}

	public final Param_lstContext param_lst() throws RecognitionException {
		Param_lstContext _localctx = new Param_lstContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param_lst);
		try {
			setState(67);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); value();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); value();
				setState(64); match(4);
				setState(65); param_lst();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode OBJ_PROP() { return getToken(BizlangParser.OBJ_PROP, 0); }
		public TerminalNode ID() { return getToken(BizlangParser.ID, 0); }
		public TerminalNode STR() { return getToken(BizlangParser.STR, 0); }
		public TerminalNode NBR() { return getToken(BizlangParser.NBR, 0); }
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
		enterRule(_localctx, 16, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << STR) | (1L << NBR) | (1L << OBJ_PROP))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\20J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\5\4\"\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\69\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tF\n\t\3\n\3\n"+
		"\3\n\2\13\2\4\6\b\n\f\16\20\22\2\4\5\2\3\3\5\5\b\b\3\2\n\rH\2\24\3\2\2"+
		"\2\4\33\3\2\2\2\6!\3\2\2\2\b+\3\2\2\2\n8\3\2\2\2\f:\3\2\2\2\16<\3\2\2"+
		"\2\20E\3\2\2\2\22G\3\2\2\2\24\25\5\4\3\2\25\3\3\2\2\2\26\34\5\6\4\2\27"+
		"\30\5\6\4\2\30\31\7\17\2\2\31\32\5\4\3\2\32\34\3\2\2\2\33\26\3\2\2\2\33"+
		"\27\3\2\2\2\34\5\3\2\2\2\35\"\5\n\6\2\36\"\5\16\b\2\37\"\5\b\5\2 \"\5"+
		"\22\n\2!\35\3\2\2\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\7\3\2\2\2#$\5"+
		"\22\n\2$%\7\16\2\2%&\5\22\n\2&,\3\2\2\2\'(\5\22\n\2()\7\16\2\2)*\5\b\5"+
		"\2*,\3\2\2\2+#\3\2\2\2+\'\3\2\2\2,\t\3\2\2\2-.\5\f\7\2./\5\6\4\2/9\3\2"+
		"\2\2\60\61\5\f\7\2\61\62\7\7\2\2\62\63\5\20\t\2\63\64\7\4\2\2\649\3\2"+
		"\2\2\65\66\5\f\7\2\66\67\5\20\t\2\679\3\2\2\28-\3\2\2\28\60\3\2\2\28\65"+
		"\3\2\2\29\13\3\2\2\2:;\t\2\2\2;\r\3\2\2\2<=\7\n\2\2=>\7\t\2\2>?\5\6\4"+
		"\2?\17\3\2\2\2@F\5\22\n\2AB\5\22\n\2BC\7\6\2\2CD\5\20\t\2DF\3\2\2\2E@"+
		"\3\2\2\2EA\3\2\2\2F\21\3\2\2\2GH\t\3\2\2H\23\3\2\2\2\7\33!+8E";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}