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
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		SING_LN_CMM=17, MULT_LN_CMM=18, CSTMOPRT=19, LOGICOPRT=20, MATHOPTR=21, 
		CONDOPRT=22, FNCTNAME=23, NBR=24, STR=25, DATE=26, ID=27, OBJPROP=28, 
		NEWLINE=29, WS=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "'...'", "')'", "'default'", "'in'", "','", "'['", "'('", 
		"'then'", "'for'", "'else'", "'='", "'when'", "'end'", "'case'", "SING_LN_CMM", 
		"MULT_LN_CMM", "'><'", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", 
		"NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "SING_LN_CMM", 
		"MULT_LN_CMM", "CSTMOPRT", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", 
		"NBR", "STR", "DATE", "ID", "OBJPROP", "NEWLINE", "WS"
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
		case 16: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 17: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 29: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2 \u0115\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\6\22|\n\22\r\22\16\22}\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u0089\n\23\f\23\16\23"+
		"\u008c\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u009f\n\25\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00ab\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00be\n\30"+
		"\3\31\5\31\u00c1\n\31\3\31\6\31\u00c4\n\31\r\31\16\31\u00c5\3\31\3\31"+
		"\6\31\u00ca\n\31\r\31\16\31\u00cb\5\31\u00ce\n\31\3\32\3\32\7\32\u00d2"+
		"\n\32\f\32\16\32\u00d5\13\32\3\32\3\32\3\32\7\32\u00da\n\32\f\32\16\32"+
		"\u00dd\13\32\3\32\5\32\u00e0\n\32\3\33\6\33\u00e3\n\33\r\33\16\33\u00e4"+
		"\3\33\3\33\6\33\u00e9\n\33\r\33\16\33\u00ea\3\33\3\33\6\33\u00ef\n\33"+
		"\r\33\16\33\u00f0\3\34\3\34\6\34\u00f5\n\34\r\34\16\34\u00f6\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0106\n\35"+
		"\3\36\5\36\u0109\n\36\3\36\3\36\5\36\u010d\n\36\3\37\6\37\u0110\n\37\r"+
		"\37\16\37\u0111\3\37\3\37\6}\u008a\u00d3\u00db \3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\1#\23\2%\24\3\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1"+
		"\63\33\1\65\34\1\67\35\19\36\1;\37\1= \4\3\2\13\4\2>>@@\6\2,-//\61\61"+
		"^^\5\2--//^^\3\2\62;\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\""+
		"\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5B\3\2\2\2\7D\3\2\2\2\tH\3\2\2\2\13"+
		"J\3\2\2\2\rR\3\2\2\2\17U\3\2\2\2\21W\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27"+
		"`\3\2\2\2\31d\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37p\3\2\2\2!t\3\2\2\2#y"+
		"\3\2\2\2%\u0083\3\2\2\2\'\u0092\3\2\2\2)\u009e\3\2\2\2+\u00a0\3\2\2\2"+
		"-\u00aa\3\2\2\2/\u00bd\3\2\2\2\61\u00c0\3\2\2\2\63\u00df\3\2\2\2\65\u00e2"+
		"\3\2\2\2\67\u00f2\3\2\2\29\u0105\3\2\2\2;\u010c\3\2\2\2=\u010f\3\2\2\2"+
		"?@\7f\2\2@A\7q\2\2A\4\3\2\2\2BC\7_\2\2C\6\3\2\2\2DE\7\60\2\2EF\7\60\2"+
		"\2FG\7\60\2\2G\b\3\2\2\2HI\7+\2\2I\n\3\2\2\2JK\7f\2\2KL\7g\2\2LM\7h\2"+
		"\2MN\7c\2\2NO\7w\2\2OP\7n\2\2PQ\7v\2\2Q\f\3\2\2\2RS\7k\2\2ST\7p\2\2T\16"+
		"\3\2\2\2UV\7.\2\2V\20\3\2\2\2WX\7]\2\2X\22\3\2\2\2YZ\7*\2\2Z\24\3\2\2"+
		"\2[\\\7v\2\2\\]\7j\2\2]^\7g\2\2^_\7p\2\2_\26\3\2\2\2`a\7h\2\2ab\7q\2\2"+
		"bc\7t\2\2c\30\3\2\2\2de\7g\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\32\3\2\2\2"+
		"ij\7?\2\2j\34\3\2\2\2kl\7y\2\2lm\7j\2\2mn\7g\2\2no\7p\2\2o\36\3\2\2\2"+
		"pq\7g\2\2qr\7p\2\2rs\7f\2\2s \3\2\2\2tu\7e\2\2uv\7c\2\2vw\7u\2\2wx\7g"+
		"\2\2x\"\3\2\2\2y{\7%\2\2z|\13\2\2\2{z\3\2\2\2|}\3\2\2\2}~\3\2\2\2}{\3"+
		"\2\2\2~\177\3\2\2\2\177\u0080\5;\36\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\b\22\2\2\u0082$\3\2\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7,\2\2\u0085"+
		"\u008a\3\2\2\2\u0086\u0089\13\2\2\2\u0087\u0089\5;\36\2\u0088\u0086\3"+
		"\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7,"+
		"\2\2\u008e\u008f\7\61\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\23\3\2\u0091"+
		"&\3\2\2\2\u0092\u0093\7@\2\2\u0093\u0094\7>\2\2\u0094(\3\2\2\2\u0095\u0096"+
		"\7>\2\2\u0096\u009f\7?\2\2\u0097\u0098\7@\2\2\u0098\u009f\7?\2\2\u0099"+
		"\u009f\t\2\2\2\u009a\u009b\7?\2\2\u009b\u009f\7?\2\2\u009c\u009d\7#\2"+
		"\2\u009d\u009f\7?\2\2\u009e\u0095\3\2\2\2\u009e\u0097\3\2\2\2\u009e\u0099"+
		"\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f*\3\2\2\2\u00a0"+
		"\u00a1\t\3\2\2\u00a1,\3\2\2\2\u00a2\u00a3\7k\2\2\u00a3\u00ab\7h\2\2\u00a4"+
		"\u00a5\7w\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7g\2\2"+
		"\u00a8\u00a9\7u\2\2\u00a9\u00ab\7u\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00a4"+
		"\3\2\2\2\u00ab.\3\2\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af"+
		"\7k\2\2\u00af\u00b0\7p\2\2\u00b0\u00be\7v\2\2\u00b1\u00b2\7u\2\2\u00b2"+
		"\u00b3\7w\2\2\u00b3\u00be\7o\2\2\u00b4\u00b5\7i\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\u00b7\7v\2\2\u00b7\u00b8\7H\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba"+
		"\7q\2\2\u00ba\u00bb\7o\2\2\u00bb\u00bc\7F\2\2\u00bc\u00be\7d\2\2\u00bd"+
		"\u00ac\3\2\2\2\u00bd\u00b1\3\2\2\2\u00bd\u00b4\3\2\2\2\u00be\60\3\2\2"+
		"\2\u00bf\u00c1\t\4\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3"+
		"\3\2\2\2\u00c2\u00c4\t\5\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00cd\3\2\2\2\u00c7\u00c9\7\60"+
		"\2\2\u00c8\u00ca\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c7\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\62\3\2\2\2\u00cf\u00d3\7$\2\2\u00d0\u00d2"+
		"\n\6\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00e0\7$"+
		"\2\2\u00d7\u00db\7)\2\2\u00d8\u00da\n\7\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\3\2"+
		"\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7)\2\2\u00df\u00cf\3\2\2\2\u00df"+
		"\u00d7\3\2\2\2\u00e0\64\3\2\2\2\u00e1\u00e3\t\5\2\2\u00e2\u00e1\3\2\2"+
		"\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e8\7\61\2\2\u00e7\u00e9\t\5\2\2\u00e8\u00e7\3\2\2\2"+
		"\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\7\61\2\2\u00ed\u00ef\t\5\2\2\u00ee\u00ed\3\2\2\2"+
		"\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\66"+
		"\3\2\2\2\u00f2\u00f4\t\b\2\2\u00f3\u00f5\t\t\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f78\3\2\2\2"+
		"\u00f8\u00f9\5\67\34\2\u00f9\u00fa\7\60\2\2\u00fa\u00fb\5\67\34\2\u00fb"+
		"\u0106\3\2\2\2\u00fc\u00fd\5\67\34\2\u00fd\u00fe\7\60\2\2\u00fe\u00ff"+
		"\59\35\2\u00ff\u0106\3\2\2\2\u0100\u0101\5\67\34\2\u0101\u0102\7]\2\2"+
		"\u0102\u0103\5\61\31\2\u0103\u0104\7_\2\2\u0104\u0106\3\2\2\2\u0105\u00f8"+
		"\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u0100\3\2\2\2\u0106:\3\2\2\2\u0107"+
		"\u0109\7\17\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3"+
		"\2\2\2\u010a\u010d\7\f\2\2\u010b\u010d\7\2\2\3\u010c\u0108\3\2\2\2\u010c"+
		"\u010b\3\2\2\2\u010d<\3\2\2\2\u010e\u0110\t\n\2\2\u010f\u010e\3\2\2\2"+
		"\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\b\37\4\2\u0114>\3\2\2\2\30\2}\u0088\u008a\u009e\u00aa"+
		"\u00bd\u00c0\u00c5\u00cb\u00cd\u00d3\u00db\u00df\u00e4\u00ea\u00f0\u00f6"+
		"\u0105\u0108\u010c\u0111";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}