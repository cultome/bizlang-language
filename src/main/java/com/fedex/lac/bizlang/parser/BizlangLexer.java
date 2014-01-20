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
		LOGICOPRT=16, MATHOPTR=17, CONDOPRT=18, FNCTNAME=19, NBR=20, STR=21, DATE=22, 
		ID=23, OBJPROP=24, NEWLINE=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "'...'", "')'", "'in'", "','", "'['", "'('", "'for'", "'else'", 
		"'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "'><'", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "SING_LN_CMM", "MULT_LN_CMM", "CSTMOPRT", "LOGICOPRT", 
		"MATHOPTR", "CONDOPRT", "FNCTNAME", "NBR", "STR", "DATE", "ID", "OBJPROP", 
		"NEWLINE", "WS"
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

		case 25: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\34\u00f6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\6\16]\n\16\r\16\16\16^\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17j\n\17\f\17\16\17m\13\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0080\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u008c\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u009f\n\24\3\25\5\25\u00a2"+
		"\n\25\3\25\6\25\u00a5\n\25\r\25\16\25\u00a6\3\25\3\25\6\25\u00ab\n\25"+
		"\r\25\16\25\u00ac\5\25\u00af\n\25\3\26\3\26\7\26\u00b3\n\26\f\26\16\26"+
		"\u00b6\13\26\3\26\3\26\3\26\7\26\u00bb\n\26\f\26\16\26\u00be\13\26\3\26"+
		"\5\26\u00c1\n\26\3\27\6\27\u00c4\n\27\r\27\16\27\u00c5\3\27\3\27\6\27"+
		"\u00ca\n\27\r\27\16\27\u00cb\3\27\3\27\6\27\u00d0\n\27\r\27\16\27\u00d1"+
		"\3\30\3\30\6\30\u00d6\n\30\r\30\16\30\u00d7\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00e7\n\31\3\32\5\32\u00ea"+
		"\n\32\3\32\3\32\5\32\u00ee\n\32\3\33\6\33\u00f1\n\33\r\33\16\33\u00f2"+
		"\3\33\3\33\6^k\u00b4\u00bc\34\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\2\35\20\3\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\4"+
		"\3\2\13\4\2>>@@\6\2,-//\61\61^^\5\2--//^^\3\2\62;\3\2$$\3\2))\4\2C\\c"+
		"|\6\2\62;C\\aac|\4\2\13\13\"\"\u010f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\3\67\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2\t@\3\2\2\2\13B\3\2\2\2\rE\3"+
		"\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25O\3\2\2\2\27T\3\2\2\2\31"+
		"V\3\2\2\2\33Z\3\2\2\2\35d\3\2\2\2\37s\3\2\2\2!\177\3\2\2\2#\u0081\3\2"+
		"\2\2%\u008b\3\2\2\2\'\u009e\3\2\2\2)\u00a1\3\2\2\2+\u00c0\3\2\2\2-\u00c3"+
		"\3\2\2\2/\u00d3\3\2\2\2\61\u00e6\3\2\2\2\63\u00ed\3\2\2\2\65\u00f0\3\2"+
		"\2\2\678\7f\2\289\7q\2\29\4\3\2\2\2:;\7_\2\2;\6\3\2\2\2<=\7\60\2\2=>\7"+
		"\60\2\2>?\7\60\2\2?\b\3\2\2\2@A\7+\2\2A\n\3\2\2\2BC\7k\2\2CD\7p\2\2D\f"+
		"\3\2\2\2EF\7.\2\2F\16\3\2\2\2GH\7]\2\2H\20\3\2\2\2IJ\7*\2\2J\22\3\2\2"+
		"\2KL\7h\2\2LM\7q\2\2MN\7t\2\2N\24\3\2\2\2OP\7g\2\2PQ\7n\2\2QR\7u\2\2R"+
		"S\7g\2\2S\26\3\2\2\2TU\7?\2\2U\30\3\2\2\2VW\7g\2\2WX\7p\2\2XY\7f\2\2Y"+
		"\32\3\2\2\2Z\\\7%\2\2[]\13\2\2\2\\[\3\2\2\2]^\3\2\2\2^_\3\2\2\2^\\\3\2"+
		"\2\2_`\3\2\2\2`a\5\63\32\2ab\3\2\2\2bc\b\16\2\2c\34\3\2\2\2de\7\61\2\2"+
		"ef\7,\2\2fk\3\2\2\2gj\13\2\2\2hj\5\63\32\2ig\3\2\2\2ih\3\2\2\2jm\3\2\2"+
		"\2kl\3\2\2\2ki\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7,\2\2op\7\61\2\2pq\3\2\2"+
		"\2qr\b\17\3\2r\36\3\2\2\2st\7@\2\2tu\7>\2\2u \3\2\2\2vw\7>\2\2w\u0080"+
		"\7?\2\2xy\7@\2\2y\u0080\7?\2\2z\u0080\t\2\2\2{|\7?\2\2|\u0080\7?\2\2}"+
		"~\7#\2\2~\u0080\7?\2\2\177v\3\2\2\2\177x\3\2\2\2\177z\3\2\2\2\177{\3\2"+
		"\2\2\177}\3\2\2\2\u0080\"\3\2\2\2\u0081\u0082\t\3\2\2\u0082$\3\2\2\2\u0083"+
		"\u0084\7k\2\2\u0084\u008c\7h\2\2\u0085\u0086\7w\2\2\u0086\u0087\7p\2\2"+
		"\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089\u008a\7u\2\2\u008a\u008c"+
		"\7u\2\2\u008b\u0083\3\2\2\2\u008b\u0085\3\2\2\2\u008c&\3\2\2\2\u008d\u008e"+
		"\7r\2\2\u008e\u008f\7t\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u009f\7v\2\2\u0092\u0093\7u\2\2\u0093\u0094\7w\2\2\u0094\u009f\7o\2\2"+
		"\u0095\u0096\7i\2\2\u0096\u0097\7g\2\2\u0097\u0098\7v\2\2\u0098\u0099"+
		"\7H\2\2\u0099\u009a\7t\2\2\u009a\u009b\7q\2\2\u009b\u009c\7o\2\2\u009c"+
		"\u009d\7F\2\2\u009d\u009f\7d\2\2\u009e\u008d\3\2\2\2\u009e\u0092\3\2\2"+
		"\2\u009e\u0095\3\2\2\2\u009f(\3\2\2\2\u00a0\u00a2\t\4\2\2\u00a1\u00a0"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5\t\5\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00ae\3\2\2\2\u00a8\u00aa\7\60\2\2\u00a9\u00ab\t\5\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"*\3\2\2\2\u00b0\u00b4\7$\2\2\u00b1\u00b3\n\6\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\3\2"+
		"\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00c1\7$\2\2\u00b8\u00bc\7)\2\2\u00b9\u00bb"+
		"\n\7\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\7)"+
		"\2\2\u00c0\u00b0\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c1,\3\2\2\2\u00c2\u00c4"+
		"\t\5\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\7\61\2\2\u00c8\u00ca\t"+
		"\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\7\61\2\2\u00ce\u00d0\t"+
		"\5\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2.\3\2\2\2\u00d3\u00d5\t\b\2\2\u00d4\u00d6\t\t\2\2"+
		"\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\60\3\2\2\2\u00d9\u00da\5/\30\2\u00da\u00db\7\60\2\2\u00db"+
		"\u00dc\5/\30\2\u00dc\u00e7\3\2\2\2\u00dd\u00de\5/\30\2\u00de\u00df\7\60"+
		"\2\2\u00df\u00e0\5\61\31\2\u00e0\u00e7\3\2\2\2\u00e1\u00e2\5/\30\2\u00e2"+
		"\u00e3\7]\2\2\u00e3\u00e4\5)\25\2\u00e4\u00e5\7_\2\2\u00e5\u00e7\3\2\2"+
		"\2\u00e6\u00d9\3\2\2\2\u00e6\u00dd\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e7\62"+
		"\3\2\2\2\u00e8\u00ea\7\17\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00ee\7\f\2\2\u00ec\u00ee\7\2\2\3\u00ed\u00e9"+
		"\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\64\3\2\2\2\u00ef\u00f1\t\n\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\33\4\2\u00f5\66\3\2\2\2\30\2^i"+
		"k\177\u008b\u009e\u00a1\u00a6\u00ac\u00ae\u00b4\u00bc\u00c0\u00c5\u00cb"+
		"\u00d1\u00d7\u00e6\u00e9\u00ed\u00f2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}