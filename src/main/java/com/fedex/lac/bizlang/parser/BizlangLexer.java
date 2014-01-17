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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, SING_LN_CMM=12, MULT_LN_CMM=13, LOGICOPRT=14, MATHOPTR=15, 
		CONDOPRT=16, FNCTNAME=17, NBR=18, STR=19, ID=20, OBJPROP=21, NEWLINE=22, 
		WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "']'", "')'", "'in'", "','", "'['", "'('", "'for'", "'else'", 
		"'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", 
		"CONDOPRT", "FNCTNAME", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", 
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
		case 11: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 12: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 22: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\31\u00d5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\6\rS\n\r"+
		"\r\r\16\rT\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16`\n\16\f\16\16"+
		"\16c\13\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17s\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\177\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0092\n\22\3\23\6\23\u0095\n\23\r"+
		"\23\16\23\u0096\3\23\3\23\6\23\u009b\n\23\r\23\16\23\u009c\5\23\u009f"+
		"\n\23\3\24\3\24\7\24\u00a3\n\24\f\24\16\24\u00a6\13\24\3\24\3\24\3\24"+
		"\7\24\u00ab\n\24\f\24\16\24\u00ae\13\24\3\24\5\24\u00b1\n\24\3\25\3\25"+
		"\6\25\u00b5\n\25\r\25\16\25\u00b6\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\5\26\u00c6\n\26\3\27\5\27\u00c9\n\27\3\27"+
		"\3\27\5\27\u00cd\n\27\3\30\6\30\u00d0\n\30\r\30\16\30\u00d1\3\30\3\30"+
		"\6Ta\u00a4\u00ac\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\1\31\16\2\33\17\3\35\20\1\37\21\1!\22\1#\23\1%\24"+
		"\1\'\25\1)\26\1+\27\1-\30\1/\31\4\3\2\n\4\2>>@@\6\2,-//\61\61^^\3\2\62"+
		";\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\"\u00ea\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2"+
		"\2\5\64\3\2\2\2\7\66\3\2\2\2\t8\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2"+
		"\2\2\21A\3\2\2\2\23E\3\2\2\2\25J\3\2\2\2\27L\3\2\2\2\31P\3\2\2\2\33Z\3"+
		"\2\2\2\35r\3\2\2\2\37t\3\2\2\2!~\3\2\2\2#\u0091\3\2\2\2%\u0094\3\2\2\2"+
		"\'\u00b0\3\2\2\2)\u00b2\3\2\2\2+\u00c5\3\2\2\2-\u00cc\3\2\2\2/\u00cf\3"+
		"\2\2\2\61\62\7f\2\2\62\63\7q\2\2\63\4\3\2\2\2\64\65\7_\2\2\65\6\3\2\2"+
		"\2\66\67\7+\2\2\67\b\3\2\2\289\7k\2\29:\7p\2\2:\n\3\2\2\2;<\7.\2\2<\f"+
		"\3\2\2\2=>\7]\2\2>\16\3\2\2\2?@\7*\2\2@\20\3\2\2\2AB\7h\2\2BC\7q\2\2C"+
		"D\7t\2\2D\22\3\2\2\2EF\7g\2\2FG\7n\2\2GH\7u\2\2HI\7g\2\2I\24\3\2\2\2J"+
		"K\7?\2\2K\26\3\2\2\2LM\7g\2\2MN\7p\2\2NO\7f\2\2O\30\3\2\2\2PR\7%\2\2Q"+
		"S\13\2\2\2RQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2TR\3\2\2\2UV\3\2\2\2VW\5-\27\2"+
		"WX\3\2\2\2XY\b\r\2\2Y\32\3\2\2\2Z[\7\61\2\2[\\\7,\2\2\\a\3\2\2\2]`\13"+
		"\2\2\2^`\5-\27\2_]\3\2\2\2_^\3\2\2\2`c\3\2\2\2ab\3\2\2\2a_\3\2\2\2bd\3"+
		"\2\2\2ca\3\2\2\2de\7,\2\2ef\7\61\2\2fg\3\2\2\2gh\b\16\3\2h\34\3\2\2\2"+
		"ij\7>\2\2js\7?\2\2kl\7@\2\2ls\7?\2\2ms\t\2\2\2no\7?\2\2os\7?\2\2pq\7#"+
		"\2\2qs\7?\2\2ri\3\2\2\2rk\3\2\2\2rm\3\2\2\2rn\3\2\2\2rp\3\2\2\2s\36\3"+
		"\2\2\2tu\t\3\2\2u \3\2\2\2vw\7k\2\2w\177\7h\2\2xy\7w\2\2yz\7p\2\2z{\7"+
		"n\2\2{|\7g\2\2|}\7u\2\2}\177\7u\2\2~v\3\2\2\2~x\3\2\2\2\177\"\3\2\2\2"+
		"\u0080\u0081\7r\2\2\u0081\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083\u0084"+
		"\7p\2\2\u0084\u0092\7v\2\2\u0085\u0086\7u\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u0092\7o\2\2\u0088\u0089\7i\2\2\u0089\u008a\7g\2\2\u008a\u008b\7v\2\2"+
		"\u008b\u008c\7H\2\2\u008c\u008d\7t\2\2\u008d\u008e\7q\2\2\u008e\u008f"+
		"\7o\2\2\u008f\u0090\7F\2\2\u0090\u0092\7d\2\2\u0091\u0080\3\2\2\2\u0091"+
		"\u0085\3\2\2\2\u0091\u0088\3\2\2\2\u0092$\3\2\2\2\u0093\u0095\t\4\2\2"+
		"\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u009e\3\2\2\2\u0098\u009a\7\60\2\2\u0099\u009b\t\4\2\2"+
		"\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"&\3\2\2\2\u00a0\u00a4\7$\2\2\u00a1\u00a3\n\5\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00b1\7$\2\2\u00a8\u00ac\7)\2\2\u00a9\u00ab"+
		"\n\6\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\7)"+
		"\2\2\u00b0\u00a0\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b1(\3\2\2\2\u00b2\u00b4"+
		"\t\7\2\2\u00b3\u00b5\t\b\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7*\3\2\2\2\u00b8\u00b9\5)\25\2"+
		"\u00b9\u00ba\7\60\2\2\u00ba\u00bb\5)\25\2\u00bb\u00c6\3\2\2\2\u00bc\u00bd"+
		"\5)\25\2\u00bd\u00be\7\60\2\2\u00be\u00bf\5+\26\2\u00bf\u00c6\3\2\2\2"+
		"\u00c0\u00c1\5)\25\2\u00c1\u00c2\7]\2\2\u00c2\u00c3\5%\23\2\u00c3\u00c4"+
		"\7_\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00b8\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c5"+
		"\u00c0\3\2\2\2\u00c6,\3\2\2\2\u00c7\u00c9\7\17\2\2\u00c8\u00c7\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\7\f\2\2\u00cb\u00cd"+
		"\7\2\2\3\u00cc\u00c8\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd.\3\2\2\2\u00ce"+
		"\u00d0\t\t\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\30\4\2\u00d4"+
		"\60\3\2\2\2\24\2T_ar~\u0091\u0096\u009c\u009e\u00a4\u00ac\u00b0\u00b6"+
		"\u00c5\u00c8\u00cc\u00d1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}