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
		T__2=10, T__1=11, T__0=12, SING_LN_CMM=13, MULT_LN_CMM=14, LOGICOPRT=15, 
		MATHOPTR=16, CONDOPRT=17, FNCTNAME=18, NBR=19, STR=20, ID=21, OBJPROP=22, 
		NEWLINE=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "'...'", "')'", "'in'", "','", "'['", "'('", "'for'", "'else'", 
		"'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
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

		case 23: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\32\u00db\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\6\16Y\n\16\r\16\16\16Z\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\7\17f\n\17\f\17\16\17i\13\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20y\n\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0085\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0098\n\23\3\24\6\24\u009b\n\24\r\24\16\24\u009c\3\24\3\24\6\24"+
		"\u00a1\n\24\r\24\16\24\u00a2\5\24\u00a5\n\24\3\25\3\25\7\25\u00a9\n\25"+
		"\f\25\16\25\u00ac\13\25\3\25\3\25\3\25\7\25\u00b1\n\25\f\25\16\25\u00b4"+
		"\13\25\3\25\5\25\u00b7\n\25\3\26\3\26\6\26\u00bb\n\26\r\26\16\26\u00bc"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00cc\n\27\3\30\5\30\u00cf\n\30\3\30\3\30\5\30\u00d3\n\30\3\31\6\31\u00d6"+
		"\n\31\r\31\16\31\u00d7\3\31\3\31\6Zg\u00aa\u00b2\32\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\2\35\20\3\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\4\3\2\n\4\2>>@@\6\2,-//\61\61^^\3\2\62;\3\2$$\3\2))\4\2C\\c|\6\2\62"+
		";C\\aac|\4\2\13\13\"\"\u00f0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\66\3\2\2\2\7"+
		"8\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23"+
		"G\3\2\2\2\25K\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33V\3\2\2\2\35`\3\2\2\2"+
		"\37x\3\2\2\2!z\3\2\2\2#\u0084\3\2\2\2%\u0097\3\2\2\2\'\u009a\3\2\2\2)"+
		"\u00b6\3\2\2\2+\u00b8\3\2\2\2-\u00cb\3\2\2\2/\u00d2\3\2\2\2\61\u00d5\3"+
		"\2\2\2\63\64\7f\2\2\64\65\7q\2\2\65\4\3\2\2\2\66\67\7_\2\2\67\6\3\2\2"+
		"\289\7\60\2\29:\7\60\2\2:;\7\60\2\2;\b\3\2\2\2<=\7+\2\2=\n\3\2\2\2>?\7"+
		"k\2\2?@\7p\2\2@\f\3\2\2\2AB\7.\2\2B\16\3\2\2\2CD\7]\2\2D\20\3\2\2\2EF"+
		"\7*\2\2F\22\3\2\2\2GH\7h\2\2HI\7q\2\2IJ\7t\2\2J\24\3\2\2\2KL\7g\2\2LM"+
		"\7n\2\2MN\7u\2\2NO\7g\2\2O\26\3\2\2\2PQ\7?\2\2Q\30\3\2\2\2RS\7g\2\2ST"+
		"\7p\2\2TU\7f\2\2U\32\3\2\2\2VX\7%\2\2WY\13\2\2\2XW\3\2\2\2YZ\3\2\2\2Z"+
		"[\3\2\2\2ZX\3\2\2\2[\\\3\2\2\2\\]\5/\30\2]^\3\2\2\2^_\b\16\2\2_\34\3\2"+
		"\2\2`a\7\61\2\2ab\7,\2\2bg\3\2\2\2cf\13\2\2\2df\5/\30\2ec\3\2\2\2ed\3"+
		"\2\2\2fi\3\2\2\2gh\3\2\2\2ge\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7,\2\2kl\7"+
		"\61\2\2lm\3\2\2\2mn\b\17\3\2n\36\3\2\2\2op\7>\2\2py\7?\2\2qr\7@\2\2ry"+
		"\7?\2\2sy\t\2\2\2tu\7?\2\2uy\7?\2\2vw\7#\2\2wy\7?\2\2xo\3\2\2\2xq\3\2"+
		"\2\2xs\3\2\2\2xt\3\2\2\2xv\3\2\2\2y \3\2\2\2z{\t\3\2\2{\"\3\2\2\2|}\7"+
		"k\2\2}\u0085\7h\2\2~\177\7w\2\2\177\u0080\7p\2\2\u0080\u0081\7n\2\2\u0081"+
		"\u0082\7g\2\2\u0082\u0083\7u\2\2\u0083\u0085\7u\2\2\u0084|\3\2\2\2\u0084"+
		"~\3\2\2\2\u0085$\3\2\2\2\u0086\u0087\7r\2\2\u0087\u0088\7t\2\2\u0088\u0089"+
		"\7k\2\2\u0089\u008a\7p\2\2\u008a\u0098\7v\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u0098\7o\2\2\u008e\u008f\7i\2\2\u008f\u0090\7g\2\2"+
		"\u0090\u0091\7v\2\2\u0091\u0092\7H\2\2\u0092\u0093\7t\2\2\u0093\u0094"+
		"\7q\2\2\u0094\u0095\7o\2\2\u0095\u0096\7F\2\2\u0096\u0098\7d\2\2\u0097"+
		"\u0086\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u008e\3\2\2\2\u0098&\3\2\2\2"+
		"\u0099\u009b\t\4\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a4\3\2\2\2\u009e\u00a0\7\60\2\2"+
		"\u009f\u00a1\t\4\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5(\3\2\2\2\u00a6\u00aa\7$\2\2\u00a7\u00a9\n\5\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b7\7$\2\2\u00ae"+
		"\u00b2\7)\2\2\u00af\u00b1\n\6\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00b7\7)\2\2\u00b6\u00a6\3\2\2\2\u00b6\u00ae\3\2"+
		"\2\2\u00b7*\3\2\2\2\u00b8\u00ba\t\7\2\2\u00b9\u00bb\t\b\2\2\u00ba\u00b9"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		",\3\2\2\2\u00be\u00bf\5+\26\2\u00bf\u00c0\7\60\2\2\u00c0\u00c1\5+\26\2"+
		"\u00c1\u00cc\3\2\2\2\u00c2\u00c3\5+\26\2\u00c3\u00c4\7\60\2\2\u00c4\u00c5"+
		"\5-\27\2\u00c5\u00cc\3\2\2\2\u00c6\u00c7\5+\26\2\u00c7\u00c8\7]\2\2\u00c8"+
		"\u00c9\5\'\24\2\u00c9\u00ca\7_\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00be\3\2"+
		"\2\2\u00cb\u00c2\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cc.\3\2\2\2\u00cd\u00cf"+
		"\7\17\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2"+
		"\u00d0\u00d3\7\f\2\2\u00d1\u00d3\7\2\2\3\u00d2\u00ce\3\2\2\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\60\3\2\2\2\u00d4\u00d6\t\t\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00da\b\31\4\2\u00da\62\3\2\2\2\24\2Zegx\u0084\u0097\u009c"+
		"\u00a2\u00a4\u00aa\u00b2\u00b6\u00bc\u00cb\u00ce\u00d2\u00d7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}