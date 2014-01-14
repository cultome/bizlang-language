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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, SING_LN_CMM=8, 
		MULT_LN_CMM=9, LOGICOPRT=10, MATHOPTR=11, CONDOPRT=12, FNCTNAME=13, NBR=14, 
		STR=15, ID=16, OBJPROP=17, NEWLINE=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'do'", "')'", "','", "'('", "'else'", "'='", "'end'", "SING_LN_CMM", 
		"MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", "NBR", 
		"STR", "ID", "OBJPROP", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "SING_LN_CMM", 
		"MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", "CONDOPRT", "FNCTNAME", "NBR", 
		"STR", "ID", "OBJPROP", "NEWLINE", "WS"
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
		case 7: SING_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 8: MULT_LN_CMM_action((RuleContext)_localctx, actionIndex); break;

		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\25\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\6\t@\n\t\r\t\16\tA\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\nM\n\n\f\n\16\nP\13\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13`\n\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rl\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\177\n\16"+
		"\3\17\6\17\u0082\n\17\r\17\16\17\u0083\3\20\3\20\7\20\u0088\n\20\f\20"+
		"\16\20\u008b\13\20\3\20\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13"+
		"\20\3\20\5\20\u0096\n\20\3\21\3\21\6\21\u009a\n\21\r\21\16\21\u009b\3"+
		"\22\3\22\3\22\3\22\3\23\5\23\u00a3\n\23\3\23\3\23\5\23\u00a7\n\23\3\24"+
		"\6\24\u00aa\n\24\r\24\16\24\u00ab\3\24\3\24\6AN\u0089\u0091\25\3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\2\23\13\3\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\4\3\2\n\4\2>>@@\6\2"+
		",-//\61\61^^\3\2\62;\3\2$$\3\2))\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\""+
		"\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5,\3\2\2\2\7.\3\2\2\2\t"+
		"\60\3\2\2\2\13\62\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21=\3\2\2\2\23G\3\2"+
		"\2\2\25_\3\2\2\2\27a\3\2\2\2\31k\3\2\2\2\33~\3\2\2\2\35\u0081\3\2\2\2"+
		"\37\u0095\3\2\2\2!\u0097\3\2\2\2#\u009d\3\2\2\2%\u00a6\3\2\2\2\'\u00a9"+
		"\3\2\2\2)*\7f\2\2*+\7q\2\2+\4\3\2\2\2,-\7+\2\2-\6\3\2\2\2./\7.\2\2/\b"+
		"\3\2\2\2\60\61\7*\2\2\61\n\3\2\2\2\62\63\7g\2\2\63\64\7n\2\2\64\65\7u"+
		"\2\2\65\66\7g\2\2\66\f\3\2\2\2\678\7?\2\28\16\3\2\2\29:\7g\2\2:;\7p\2"+
		"\2;<\7f\2\2<\20\3\2\2\2=?\7%\2\2>@\13\2\2\2?>\3\2\2\2@A\3\2\2\2AB\3\2"+
		"\2\2A?\3\2\2\2BC\3\2\2\2CD\5%\23\2DE\3\2\2\2EF\b\t\2\2F\22\3\2\2\2GH\7"+
		"\61\2\2HI\7,\2\2IN\3\2\2\2JM\13\2\2\2KM\5%\23\2LJ\3\2\2\2LK\3\2\2\2MP"+
		"\3\2\2\2NO\3\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7,\2\2RS\7\61\2\2S"+
		"T\3\2\2\2TU\b\n\3\2U\24\3\2\2\2VW\7>\2\2W`\7?\2\2XY\7@\2\2Y`\7?\2\2Z`"+
		"\t\2\2\2[\\\7?\2\2\\`\7?\2\2]^\7#\2\2^`\7?\2\2_V\3\2\2\2_X\3\2\2\2_Z\3"+
		"\2\2\2_[\3\2\2\2_]\3\2\2\2`\26\3\2\2\2ab\t\3\2\2b\30\3\2\2\2cd\7k\2\2"+
		"dl\7h\2\2ef\7w\2\2fg\7p\2\2gh\7n\2\2hi\7g\2\2ij\7u\2\2jl\7u\2\2kc\3\2"+
		"\2\2ke\3\2\2\2l\32\3\2\2\2mn\7r\2\2no\7t\2\2op\7k\2\2pq\7p\2\2q\177\7"+
		"v\2\2rs\7u\2\2st\7w\2\2t\177\7o\2\2uv\7i\2\2vw\7g\2\2wx\7v\2\2xy\7H\2"+
		"\2yz\7t\2\2z{\7q\2\2{|\7o\2\2|}\7F\2\2}\177\7d\2\2~m\3\2\2\2~r\3\2\2\2"+
		"~u\3\2\2\2\177\34\3\2\2\2\u0080\u0082\t\4\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\36\3\2\2"+
		"\2\u0085\u0089\7$\2\2\u0086\u0088\n\5\2\2\u0087\u0086\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u0096\7$\2\2\u008d\u0091\7)\2\2\u008e\u0090\n\6\2"+
		"\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\7)\2\2\u0095"+
		"\u0085\3\2\2\2\u0095\u008d\3\2\2\2\u0096 \3\2\2\2\u0097\u0099\t\7\2\2"+
		"\u0098\u009a\t\b\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\"\3\2\2\2\u009d\u009e\5!\21\2\u009e"+
		"\u009f\7\60\2\2\u009f\u00a0\5!\21\2\u00a0$\3\2\2\2\u00a1\u00a3\7\17\2"+
		"\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7"+
		"\7\f\2\2\u00a5\u00a7\7\2\2\3\u00a6\u00a2\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"&\3\2\2\2\u00a8\u00aa\t\t\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\b\24\4\2\u00ae(\3\2\2\2\21\2ALN_k~\u0083\u0089\u0091\u0095\u009b\u00a2"+
		"\u00a6\u00ab";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}