// Generated from Bizlang.g4 by ANTLR 4.1
package com.fedex.lac.bizlang.language.parser;
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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, SING_LN_CMM=18, MULT_LN_CMM=19, CSTMOPRT=20, LOGICOPRT=21, MATHOPTR=22, 
		CONDOPRT=23, FNCTNAME=24, NBR=25, STR=26, DATE=27, ID=28, OBJPROP=29, 
		NEWLINE=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "'in'", "'default'", "')'", "','", "'['", "'for'", "'('", 
		"'='", "'...'", "'then'", "'else'", "'when'", "'rule'", "'end'", "'case'", 
		"SING_LN_CMM", "MULT_LN_CMM", "'><'", "LOGICOPRT", "MATHOPTR", "CONDOPRT", 
		"FNCTNAME", "NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"SING_LN_CMM", "MULT_LN_CMM", "CSTMOPRT", "LOGICOPRT", "MATHOPTR", "CONDOPRT", 
		"FNCTNAME", "NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", "WS"
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
		case 17: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 18: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 30: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u0132\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\6\23\u0083\n\23\r\23\16\23\u0084\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\7\24\u0090\n\24\f\24\16\24\u0093\13\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u00a6\n\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u00b2\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u00db\n\31\3\32\5\32\u00de\n\32\3\32\6\32\u00e1\n\32\r\32\16\32\u00e2"+
		"\3\32\3\32\6\32\u00e7\n\32\r\32\16\32\u00e8\5\32\u00eb\n\32\3\33\3\33"+
		"\7\33\u00ef\n\33\f\33\16\33\u00f2\13\33\3\33\3\33\3\33\7\33\u00f7\n\33"+
		"\f\33\16\33\u00fa\13\33\3\33\5\33\u00fd\n\33\3\34\6\34\u0100\n\34\r\34"+
		"\16\34\u0101\3\34\3\34\6\34\u0106\n\34\r\34\16\34\u0107\3\34\3\34\6\34"+
		"\u010c\n\34\r\34\16\34\u010d\3\35\3\35\6\35\u0112\n\35\r\35\16\35\u0113"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0123\n\36\3\37\5\37\u0126\n\37\3\37\3\37\5\37\u012a\n\37\3 \6 \u012d"+
		"\n \r \16 \u012e\3 \3 \6\u0084\u0091\u00f0\u00f8!\3\3\1\5\4\1\7\5\1\t"+
		"\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1"+
		"\35\20\1\37\21\1!\22\1#\23\1%\24\2\'\25\3)\26\1+\27\1-\30\1/\31\1\61\32"+
		"\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\4\3\2\13\4\2>>@@\6\2,-//"+
		"\61\61^^\5\2--//^^\3\2\62;\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13"+
		"\13\"\"\u014e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5D\3\2\2\2\7F\3\2\2"+
		"\2\tI\3\2\2\2\13Q\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21W\3\2\2\2\23[\3\2\2"+
		"\2\25]\3\2\2\2\27_\3\2\2\2\31c\3\2\2\2\33h\3\2\2\2\35m\3\2\2\2\37r\3\2"+
		"\2\2!w\3\2\2\2#{\3\2\2\2%\u0080\3\2\2\2\'\u008a\3\2\2\2)\u0099\3\2\2\2"+
		"+\u00a5\3\2\2\2-\u00a7\3\2\2\2/\u00b1\3\2\2\2\61\u00da\3\2\2\2\63\u00dd"+
		"\3\2\2\2\65\u00fc\3\2\2\2\67\u00ff\3\2\2\29\u010f\3\2\2\2;\u0122\3\2\2"+
		"\2=\u0129\3\2\2\2?\u012c\3\2\2\2AB\7f\2\2BC\7q\2\2C\4\3\2\2\2DE\7_\2\2"+
		"E\6\3\2\2\2FG\7k\2\2GH\7p\2\2H\b\3\2\2\2IJ\7f\2\2JK\7g\2\2KL\7h\2\2LM"+
		"\7c\2\2MN\7w\2\2NO\7n\2\2OP\7v\2\2P\n\3\2\2\2QR\7+\2\2R\f\3\2\2\2ST\7"+
		".\2\2T\16\3\2\2\2UV\7]\2\2V\20\3\2\2\2WX\7h\2\2XY\7q\2\2YZ\7t\2\2Z\22"+
		"\3\2\2\2[\\\7*\2\2\\\24\3\2\2\2]^\7?\2\2^\26\3\2\2\2_`\7\60\2\2`a\7\60"+
		"\2\2ab\7\60\2\2b\30\3\2\2\2cd\7v\2\2de\7j\2\2ef\7g\2\2fg\7p\2\2g\32\3"+
		"\2\2\2hi\7g\2\2ij\7n\2\2jk\7u\2\2kl\7g\2\2l\34\3\2\2\2mn\7y\2\2no\7j\2"+
		"\2op\7g\2\2pq\7p\2\2q\36\3\2\2\2rs\7t\2\2st\7w\2\2tu\7n\2\2uv\7g\2\2v"+
		" \3\2\2\2wx\7g\2\2xy\7p\2\2yz\7f\2\2z\"\3\2\2\2{|\7e\2\2|}\7c\2\2}~\7"+
		"u\2\2~\177\7g\2\2\177$\3\2\2\2\u0080\u0082\7%\2\2\u0081\u0083\13\2\2\2"+
		"\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\5=\37\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\b\23\2\2\u0089&\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7,\2\2"+
		"\u008c\u0091\3\2\2\2\u008d\u0090\13\2\2\2\u008e\u0090\5=\37\2\u008f\u008d"+
		"\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7,"+
		"\2\2\u0095\u0096\7\61\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\24\3\2\u0098"+
		"(\3\2\2\2\u0099\u009a\7@\2\2\u009a\u009b\7>\2\2\u009b*\3\2\2\2\u009c\u009d"+
		"\7>\2\2\u009d\u00a6\7?\2\2\u009e\u009f\7@\2\2\u009f\u00a6\7?\2\2\u00a0"+
		"\u00a6\t\2\2\2\u00a1\u00a2\7?\2\2\u00a2\u00a6\7?\2\2\u00a3\u00a4\7#\2"+
		"\2\u00a4\u00a6\7?\2\2\u00a5\u009c\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u00a0"+
		"\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6,\3\2\2\2\u00a7"+
		"\u00a8\t\3\2\2\u00a8.\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00b2\7h\2\2\u00ab"+
		"\u00ac\7w\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7g\2\2"+
		"\u00af\u00b0\7u\2\2\u00b0\u00b2\7u\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00ab"+
		"\3\2\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7r\2\2\u00b4\u00b5\7t\2\2\u00b5"+
		"\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7\u00db\7v\2\2\u00b8\u00b9\7u\2\2"+
		"\u00b9\u00ba\7w\2\2\u00ba\u00db\7o\2\2\u00bb\u00bc\7i\2\2\u00bc\u00bd"+
		"\7g\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7H\2\2\u00bf\u00c0\7t\2\2\u00c0"+
		"\u00c1\7q\2\2\u00c1\u00c2\7o\2\2\u00c2\u00c3\7F\2\2\u00c3\u00db\7d\2\2"+
		"\u00c4\u00c5\7i\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8"+
		"\7H\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7o\2\2\u00cb"+
		"\u00cc\7Y\2\2\u00cc\u00db\7u\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7c\2\2"+
		"\u00cf\u00d0\7n\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7T\2\2\u00d2\u00d3"+
		"\7w\2\2\u00d3\u00d4\7n\2\2\u00d4\u00db\7g\2\2\u00d5\u00d6\7e\2\2\u00d6"+
		"\u00d7\7q\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7p\2\2\u00d9\u00db\7v\2\2"+
		"\u00da\u00b3\3\2\2\2\u00da\u00b8\3\2\2\2\u00da\u00bb\3\2\2\2\u00da\u00c4"+
		"\3\2\2\2\u00da\u00cd\3\2\2\2\u00da\u00d5\3\2\2\2\u00db\62\3\2\2\2\u00dc"+
		"\u00de\t\4\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2"+
		"\2\2\u00df\u00e1\t\5\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ea\3\2\2\2\u00e4\u00e6\7\60"+
		"\2\2\u00e5\u00e7\t\5\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e4\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\64\3\2\2\2\u00ec\u00f0\7$\2\2\u00ed\u00ef"+
		"\n\6\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00fd\7$"+
		"\2\2\u00f4\u00f8\7)\2\2\u00f5\u00f7\n\7\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00fa\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\7)\2\2\u00fc\u00ec\3\2\2\2\u00fc"+
		"\u00f4\3\2\2\2\u00fd\66\3\2\2\2\u00fe\u0100\t\5\2\2\u00ff\u00fe\3\2\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0105\7\61\2\2\u0104\u0106\t\5\2\2\u0105\u0104\3\2\2\2"+
		"\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010b\7\61\2\2\u010a\u010c\t\5\2\2\u010b\u010a\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e8\3"+
		"\2\2\2\u010f\u0111\t\b\2\2\u0110\u0112\t\t\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114:\3\2\2\2"+
		"\u0115\u0116\59\35\2\u0116\u0117\7\60\2\2\u0117\u0118\59\35\2\u0118\u0123"+
		"\3\2\2\2\u0119\u011a\59\35\2\u011a\u011b\7\60\2\2\u011b\u011c\5;\36\2"+
		"\u011c\u0123\3\2\2\2\u011d\u011e\59\35\2\u011e\u011f\7]\2\2\u011f\u0120"+
		"\5\63\32\2\u0120\u0121\7_\2\2\u0121\u0123\3\2\2\2\u0122\u0115\3\2\2\2"+
		"\u0122\u0119\3\2\2\2\u0122\u011d\3\2\2\2\u0123<\3\2\2\2\u0124\u0126\7"+
		"\17\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u012a\7\f\2\2\u0128\u012a\7\2\2\3\u0129\u0125\3\2\2\2\u0129\u0128\3\2"+
		"\2\2\u012a>\3\2\2\2\u012b\u012d\t\n\2\2\u012c\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\b \4\2\u0131@\3\2\2\2\30\2\u0084\u008f\u0091\u00a5\u00b1\u00da"+
		"\u00dd\u00e2\u00e8\u00ea\u00f0\u00f8\u00fc\u0101\u0107\u010d\u0113\u0122"+
		"\u0125\u0129\u012e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}