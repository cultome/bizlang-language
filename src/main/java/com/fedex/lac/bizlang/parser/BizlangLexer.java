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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		SING_LN_CMM=10, MULT_LN_CMM=11, LOGICOPRT=12, MATHOPTR=13, CONDOPRT=14, 
		FNCTNAME=15, NBR=16, STR=17, ID=18, OBJPROP=19, NEWLINE=20, WS=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "')'", "'in'", "','", "'('", "'for'", "'else'", "'='", "'end'", 
		"SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", 
		"NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", 
		"NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
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
		case 9: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 10: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 20: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\27\u00cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\6\13K\n\13\r\13\16\13L\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\7\fX\n\f\f\f\16\f[\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rk\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17w\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008a\n\20\3\21\6\21"+
		"\u008d\n\21\r\21\16\21\u008e\3\21\3\21\6\21\u0093\n\21\r\21\16\21\u0094"+
		"\5\21\u0097\n\21\3\22\3\22\7\22\u009b\n\22\f\22\16\22\u009e\13\22\3\22"+
		"\3\22\3\22\7\22\u00a3\n\22\f\22\16\22\u00a6\13\22\3\22\5\22\u00a9\n\22"+
		"\3\23\3\23\6\23\u00ad\n\23\r\23\16\23\u00ae\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00be\n\24\3\25\5\25\u00c1"+
		"\n\25\3\25\3\25\5\25\u00c5\n\25\3\26\6\26\u00c8\n\26\r\26\16\26\u00c9"+
		"\3\26\3\26\6LY\u009c\u00a4\27\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\2\27\r\3\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\1)\26\1+\27\4\3\2\n\4\2>>@@\6\2,-//\61\61^^\3\2\62"+
		";\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\"\u00e2\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2\7\62\3\2"+
		"\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17=\3\2\2\2\21B\3\2\2\2\23"+
		"D\3\2\2\2\25H\3\2\2\2\27R\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35v\3\2\2\2"+
		"\37\u0089\3\2\2\2!\u008c\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00bd"+
		"\3\2\2\2)\u00c4\3\2\2\2+\u00c7\3\2\2\2-.\7f\2\2./\7q\2\2/\4\3\2\2\2\60"+
		"\61\7+\2\2\61\6\3\2\2\2\62\63\7k\2\2\63\64\7p\2\2\64\b\3\2\2\2\65\66\7"+
		".\2\2\66\n\3\2\2\2\678\7*\2\28\f\3\2\2\29:\7h\2\2:;\7q\2\2;<\7t\2\2<\16"+
		"\3\2\2\2=>\7g\2\2>?\7n\2\2?@\7u\2\2@A\7g\2\2A\20\3\2\2\2BC\7?\2\2C\22"+
		"\3\2\2\2DE\7g\2\2EF\7p\2\2FG\7f\2\2G\24\3\2\2\2HJ\7%\2\2IK\13\2\2\2JI"+
		"\3\2\2\2KL\3\2\2\2LM\3\2\2\2LJ\3\2\2\2MN\3\2\2\2NO\5)\25\2OP\3\2\2\2P"+
		"Q\b\13\2\2Q\26\3\2\2\2RS\7\61\2\2ST\7,\2\2TY\3\2\2\2UX\13\2\2\2VX\5)\25"+
		"\2WU\3\2\2\2WV\3\2\2\2X[\3\2\2\2YZ\3\2\2\2YW\3\2\2\2Z\\\3\2\2\2[Y\3\2"+
		"\2\2\\]\7,\2\2]^\7\61\2\2^_\3\2\2\2_`\b\f\3\2`\30\3\2\2\2ab\7>\2\2bk\7"+
		"?\2\2cd\7@\2\2dk\7?\2\2ek\t\2\2\2fg\7?\2\2gk\7?\2\2hi\7#\2\2ik\7?\2\2"+
		"ja\3\2\2\2jc\3\2\2\2je\3\2\2\2jf\3\2\2\2jh\3\2\2\2k\32\3\2\2\2lm\t\3\2"+
		"\2m\34\3\2\2\2no\7k\2\2ow\7h\2\2pq\7w\2\2qr\7p\2\2rs\7n\2\2st\7g\2\2t"+
		"u\7u\2\2uw\7u\2\2vn\3\2\2\2vp\3\2\2\2w\36\3\2\2\2xy\7r\2\2yz\7t\2\2z{"+
		"\7k\2\2{|\7p\2\2|\u008a\7v\2\2}~\7u\2\2~\177\7w\2\2\177\u008a\7o\2\2\u0080"+
		"\u0081\7i\2\2\u0081\u0082\7g\2\2\u0082\u0083\7v\2\2\u0083\u0084\7H\2\2"+
		"\u0084\u0085\7t\2\2\u0085\u0086\7q\2\2\u0086\u0087\7o\2\2\u0087\u0088"+
		"\7F\2\2\u0088\u008a\7d\2\2\u0089x\3\2\2\2\u0089}\3\2\2\2\u0089\u0080\3"+
		"\2\2\2\u008a \3\2\2\2\u008b\u008d\t\4\2\2\u008c\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0096\3\2\2\2\u0090"+
		"\u0092\7\60\2\2\u0091\u0093\t\4\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0090\3\2\2\2\u0096\u0097\3\2\2\2\u0097\"\3\2\2\2\u0098\u009c\7$\2\2"+
		"\u0099\u009b\n\5\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a9\7$\2\2\u00a0\u00a4\7)\2\2\u00a1\u00a3\n\6\2\2\u00a2\u00a1\3\2\2"+
		"\2\u00a3\u00a6\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\7)\2\2\u00a8\u0098\3\2\2\2\u00a8"+
		"\u00a0\3\2\2\2\u00a9$\3\2\2\2\u00aa\u00ac\t\7\2\2\u00ab\u00ad\t\b\2\2"+
		"\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af&\3\2\2\2\u00b0\u00b1\5%\23\2\u00b1\u00b2\7\60\2\2\u00b2"+
		"\u00b3\5%\23\2\u00b3\u00be\3\2\2\2\u00b4\u00b5\5%\23\2\u00b5\u00b6\7\60"+
		"\2\2\u00b6\u00b7\5\'\24\2\u00b7\u00be\3\2\2\2\u00b8\u00b9\5%\23\2\u00b9"+
		"\u00ba\7]\2\2\u00ba\u00bb\5!\21\2\u00bb\u00bc\7_\2\2\u00bc\u00be\3\2\2"+
		"\2\u00bd\u00b0\3\2\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be("+
		"\3\2\2\2\u00bf\u00c1\7\17\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2\u00c5\7\f\2\2\u00c3\u00c5\7\2\2\3\u00c4\u00c0"+
		"\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5*\3\2\2\2\u00c6\u00c8\t\t\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\26\4\2\u00cc,\3\2\2\2\24\2LWYj"+
		"v\u0089\u008e\u0094\u0096\u009c\u00a4\u00a8\u00ae\u00bd\u00c0\u00c4\u00c9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}