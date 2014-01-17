// Generated from Bizlang.g4 by ANTLR 4.1
package com.fedex.lac.bizlang.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BizlangLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, SING_LN_CMM=13, MULT_LN_CMM=14, CSTMOPRT=15, 
		LOGICOPRT=16, MATHOPTR=17, CONDOPRT=18, FNCTNAME=19, NBR=20, STR=21, ID=22, 
		OBJPROP=23, NEWLINE=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "'...'", "')'", "'in'", "','", "'['", "'('", "'for'", "'else'", 
		"'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "'><'", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "SING_LN_CMM", "MULT_LN_CMM", "CSTMOPRT", "LOGICOPRT", 
		"MATHOPTR", "CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", 
		"WS"
	};


	public BizlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Bizlang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 12: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 13: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 24: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void MULT_LN_CMM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void SING_LN_CMM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\33\u00e0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\6\16[\n\16\r\16\16\16\\\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\7\17h\n\17\f\17\16\17k\13\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21~\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u008a\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u009d\n\24\3\25\6\25\u00a0\n\25\r\25\16"+
		"\25\u00a1\3\25\3\25\6\25\u00a6\n\25\r\25\16\25\u00a7\5\25\u00aa\n\25\3"+
		"\26\3\26\7\26\u00ae\n\26\f\26\16\26\u00b1\13\26\3\26\3\26\3\26\7\26\u00b6"+
		"\n\26\f\26\16\26\u00b9\13\26\3\26\5\26\u00bc\n\26\3\27\3\27\6\27\u00c0"+
		"\n\27\r\27\16\27\u00c1\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u00d1\n\30\3\31\5\31\u00d4\n\31\3\31\3\31\5\31"+
		"\u00d8\n\31\3\32\6\32\u00db\n\32\r\32\16\32\u00dc\3\32\3\32\6\\i\u00af"+
		"\u00b7\33\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\2\35\20\3\37\21\1!\22\1#\23\1%\24\1\'\25\1)"+
		"\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\4\3\2\n\4\2>>@@\6\2,-//\61\61^^"+
		"\3\2\62;\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\"\u00f5\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\58\3\2\2\2\7:\3\2\2\2\t>\3\2\2\2\13"+
		"@\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25M\3\2\2\2\27"+
		"R\3\2\2\2\31T\3\2\2\2\33X\3\2\2\2\35b\3\2\2\2\37q\3\2\2\2!}\3\2\2\2#\177"+
		"\3\2\2\2%\u0089\3\2\2\2\'\u009c\3\2\2\2)\u009f\3\2\2\2+\u00bb\3\2\2\2"+
		"-\u00bd\3\2\2\2/\u00d0\3\2\2\2\61\u00d7\3\2\2\2\63\u00da\3\2\2\2\65\66"+
		"\7f\2\2\66\67\7q\2\2\67\4\3\2\2\289\7_\2\29\6\3\2\2\2:;\7\60\2\2;<\7\60"+
		"\2\2<=\7\60\2\2=\b\3\2\2\2>?\7+\2\2?\n\3\2\2\2@A\7k\2\2AB\7p\2\2B\f\3"+
		"\2\2\2CD\7.\2\2D\16\3\2\2\2EF\7]\2\2F\20\3\2\2\2GH\7*\2\2H\22\3\2\2\2"+
		"IJ\7h\2\2JK\7q\2\2KL\7t\2\2L\24\3\2\2\2MN\7g\2\2NO\7n\2\2OP\7u\2\2PQ\7"+
		"g\2\2Q\26\3\2\2\2RS\7?\2\2S\30\3\2\2\2TU\7g\2\2UV\7p\2\2VW\7f\2\2W\32"+
		"\3\2\2\2XZ\7%\2\2Y[\13\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2\\Z\3\2\2"+
		"\2]^\3\2\2\2^_\5\61\31\2_`\3\2\2\2`a\b\16\2\2a\34\3\2\2\2bc\7\61\2\2c"+
		"d\7,\2\2di\3\2\2\2eh\13\2\2\2fh\5\61\31\2ge\3\2\2\2gf\3\2\2\2hk\3\2\2"+
		"\2ij\3\2\2\2ig\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7,\2\2mn\7\61\2\2no\3\2\2"+
		"\2op\b\17\3\2p\36\3\2\2\2qr\7@\2\2rs\7>\2\2s \3\2\2\2tu\7>\2\2u~\7?\2"+
		"\2vw\7@\2\2w~\7?\2\2x~\t\2\2\2yz\7?\2\2z~\7?\2\2{|\7#\2\2|~\7?\2\2}t\3"+
		"\2\2\2}v\3\2\2\2}x\3\2\2\2}y\3\2\2\2}{\3\2\2\2~\"\3\2\2\2\177\u0080\t"+
		"\3\2\2\u0080$\3\2\2\2\u0081\u0082\7k\2\2\u0082\u008a\7h\2\2\u0083\u0084"+
		"\7w\2\2\u0084\u0085\7p\2\2\u0085\u0086\7n\2\2\u0086\u0087\7g\2\2\u0087"+
		"\u0088\7u\2\2\u0088\u008a\7u\2\2\u0089\u0081\3\2\2\2\u0089\u0083\3\2\2"+
		"\2\u008a&\3\2\2\2\u008b\u008c\7r\2\2\u008c\u008d\7t\2\2\u008d\u008e\7"+
		"k\2\2\u008e\u008f\7p\2\2\u008f\u009d\7v\2\2\u0090\u0091\7u\2\2\u0091\u0092"+
		"\7w\2\2\u0092\u009d\7o\2\2\u0093\u0094\7i\2\2\u0094\u0095\7g\2\2\u0095"+
		"\u0096\7v\2\2\u0096\u0097\7H\2\2\u0097\u0098\7t\2\2\u0098\u0099\7q\2\2"+
		"\u0099\u009a\7o\2\2\u009a\u009b\7F\2\2\u009b\u009d\7d\2\2\u009c\u008b"+
		"\3\2\2\2\u009c\u0090\3\2\2\2\u009c\u0093\3\2\2\2\u009d(\3\2\2\2\u009e"+
		"\u00a0\t\4\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a9\3\2\2\2\u00a3\u00a5\7\60\2\2\u00a4"+
		"\u00a6\t\4\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa*\3\2\2\2\u00ab\u00af\7$\2\2\u00ac\u00ae\n\5\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00bc\7$\2\2\u00b3"+
		"\u00b7\7)\2\2\u00b4\u00b6\n\6\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bc\7)\2\2\u00bb\u00ab\3\2\2\2\u00bb\u00b3\3\2"+
		"\2\2\u00bc,\3\2\2\2\u00bd\u00bf\t\7\2\2\u00be\u00c0\t\b\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		".\3\2\2\2\u00c3\u00c4\5-\27\2\u00c4\u00c5\7\60\2\2\u00c5\u00c6\5-\27\2"+
		"\u00c6\u00d1\3\2\2\2\u00c7\u00c8\5-\27\2\u00c8\u00c9\7\60\2\2\u00c9\u00ca"+
		"\5/\30\2\u00ca\u00d1\3\2\2\2\u00cb\u00cc\5-\27\2\u00cc\u00cd\7]\2\2\u00cd"+
		"\u00ce\5)\25\2\u00ce\u00cf\7_\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00c3\3\2"+
		"\2\2\u00d0\u00c7\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\60\3\2\2\2\u00d2\u00d4"+
		"\7\17\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2"+
		"\u00d5\u00d8\7\f\2\2\u00d6\u00d8\7\2\2\3\u00d7\u00d3\3\2\2\2\u00d7\u00d6"+
		"\3\2\2\2\u00d8\62\3\2\2\2\u00d9\u00db\t\t\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00df\b\32\4\2\u00df\64\3\2\2\2\24\2\\gi}\u0089\u009c\u00a1"+
		"\u00a7\u00a9\u00af\u00b7\u00bb\u00c1\u00d0\u00d3\u00d7\u00dc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}