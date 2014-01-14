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

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class BizlangLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__9 = 1, T__8 = 2, T__7 = 3, T__6 = 4, T__5 = 5, T__4 = 6, T__3 = 7, T__2 = 8, T__1 = 9, T__0 = 10, SING_LN_CMM = 11, MULT_LN_CMM = 12, LOGICOPRT = 13, MATHOPTR = 14,
			CONDOPRT = 15, NBR = 16, STR = 17, ID = 18, OBJPROP = 19, NEWLINE = 20, WS = 21;
	public static String[] modeNames = { "DEFAULT_MODE" };

	public static final String[] tokenNames = { "<INVALID>", "'do'", "'sum'", "')'", "'getFromDb'", "','", "'('", "'print'", "'else'", "'='", "'end'", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT",
			"MATHOPTR", "CONDOPRT", "NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS" };
	public static final String[] ruleNames = { "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "SING_LN_CMM", "MULT_LN_CMM", "LOGICOPRT", "MATHOPTR", "CONDOPRT",
			"NBR", "STR", "ID", "OBJPROP", "NEWLINE", "WS" };

	public BizlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "Bizlang.g4";
	}

	@Override
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10:
			SING_LN_CMM_action((RuleContext) _localctx, actionIndex);
			break;

		case 11:
			MULT_LN_CMM_action((RuleContext) _localctx, actionIndex);
			break;

		case 20:
			WS_action((RuleContext) _localctx, actionIndex);
			break;
		}
	}

	private void MULT_LN_CMM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			skip();
			break;
		}
	}

	private void SING_LN_CMM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN = "\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\27\u00b4\b\1\4\2" + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"
			+ "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3"
			+ "\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3" + "\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13"
			+ "\3\f\3\f\6\fX\n\f\r\f\16\fY\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\re\n" + "\r\f\r\16\rh\13\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"
			+ "\16\3\16\3\16\5\16x\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20" + "\3\20\5\20\u0084\n\20\3\21\6\21\u0087\n\21\r\21\16\21\u0088\3\22\3\22"
			+ "\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\22\7\22\u0095\n\22" + "\f\22\16\22\u0098\13\22\3\22\5\22\u009b\n\22\3\23\3\23\6\23\u009f\n\23"
			+ "\r\23\16\23\u00a0\3\24\3\24\3\24\3\24\3\25\5\25\u00a8\n\25\3\25\3\25\5" + "\25\u00ac\n\25\3\26\6\26\u00af\n\26\r\26\16\26\u00b0\3\26\3\26\6Yf\u008e"
			+ "\u0096\27\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25" + "\f\1\27\r\2\31\16\3\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)"
			+ "\26\1+\27\4\3\2\n\4\2>>@@\6\2,-//\61\61^^\3\2\62;\3\2$$\3\2))\4\2C\\c" + "|\6\2\62;C\\aac|\4\2\13\13\"\"\u00c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"
			+ "\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23" + "\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"
			+ "\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2" + "\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\13@"
			+ "\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21J\3\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27" + "U\3\2\2\2\31_\3\2\2\2\33w\3\2\2\2\35y\3\2\2\2\37\u0083\3\2\2\2!\u0086"
			+ "\3\2\2\2#\u009a\3\2\2\2%\u009c\3\2\2\2\'\u00a2\3\2\2\2)\u00ab\3\2\2\2" + "+\u00ae\3\2\2\2-.\7f\2\2./\7q\2\2/\4\3\2\2\2\60\61\7u\2\2\61\62\7w\2\2"
			+ "\62\63\7o\2\2\63\6\3\2\2\2\64\65\7+\2\2\65\b\3\2\2\2\66\67\7i\2\2\678" + "\7g\2\289\7v\2\29:\7H\2\2:;\7t\2\2;<\7q\2\2<=\7o\2\2=>\7F\2\2>?\7d\2\2"
			+ "?\n\3\2\2\2@A\7.\2\2A\f\3\2\2\2BC\7*\2\2C\16\3\2\2\2DE\7r\2\2EF\7t\2\2" + "FG\7k\2\2GH\7p\2\2HI\7v\2\2I\20\3\2\2\2JK\7g\2\2KL\7n\2\2LM\7u\2\2MN\7"
			+ "g\2\2N\22\3\2\2\2OP\7?\2\2P\24\3\2\2\2QR\7g\2\2RS\7p\2\2ST\7f\2\2T\26" + "\3\2\2\2UW\7%\2\2VX\13\2\2\2WV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2YW\3\2\2\2Z"
			+ "[\3\2\2\2[\\\5)\25\2\\]\3\2\2\2]^\b\f\2\2^\30\3\2\2\2_`\7\61\2\2`a\7," + "\2\2af\3\2\2\2be\13\2\2\2ce\5)\25\2db\3\2\2\2dc\3\2\2\2eh\3\2\2\2fg\3"
			+ "\2\2\2fd\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7,\2\2jk\7\61\2\2kl\3\2\2\2lm\b" + "\r\3\2m\32\3\2\2\2no\7>\2\2ox\7?\2\2pq\7@\2\2qx\7?\2\2rx\t\2\2\2st\7?"
			+ "\2\2tx\7?\2\2uv\7#\2\2vx\7?\2\2wn\3\2\2\2wp\3\2\2\2wr\3\2\2\2ws\3\2\2" + "\2wu\3\2\2\2x\34\3\2\2\2yz\t\3\2\2z\36\3\2\2\2{|\7k\2\2|\u0084\7h\2\2"
			+ "}~\7w\2\2~\177\7p\2\2\177\u0080\7n\2\2\u0080\u0081\7g\2\2\u0081\u0082" + "\7u\2\2\u0082\u0084\7u\2\2\u0083{\3\2\2\2\u0083}\3\2\2\2\u0084 \3\2\2"
			+ "\2\u0085\u0087\t\4\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086" + "\3\2\2\2\u0088\u0089\3\2\2\2\u0089\"\3\2\2\2\u008a\u008e\7$\2\2\u008b"
			+ "\u008d\n\5\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f\3\2" + "\2\2\u008e\u008c\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"
			+ "\u009b\7$\2\2\u0092\u0096\7)\2\2\u0093\u0095\n\6\2\2\u0094\u0093\3\2\2" + "\2\u0095\u0098\3\2\2\2\u0096\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099"
			+ "\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\7)\2\2\u009a\u008a\3\2\2\2\u009a" + "\u0092\3\2\2\2\u009b$\3\2\2\2\u009c\u009e\t\7\2\2\u009d\u009f\t\b\2\2"
			+ "\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1" + "\3\2\2\2\u00a1&\3\2\2\2\u00a2\u00a3\5%\23\2\u00a3\u00a4\7\60\2\2\u00a4"
			+ "\u00a5\5%\23\2\u00a5(\3\2\2\2\u00a6\u00a8\7\17\2\2\u00a7\u00a6\3\2\2\2" + "\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\7\f\2\2\u00aa\u00ac"
			+ "\7\2\2\3\u00ab\u00a7\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac*\3\2\2\2\u00ad" + "\u00af\t\t\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2"
			+ "\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\26\4\2\u00b3" + ",\3\2\2\2\20\2Ydfw\u0083\u0088\u008e\u0096\u009a\u00a0\u00a7\u00ab\u00b0";
	public static final ATN _ATN = ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}