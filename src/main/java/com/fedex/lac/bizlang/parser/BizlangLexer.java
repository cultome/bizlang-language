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
		MULT_LN_CMM=9, ID=10, STR=11, NBR=12, OBJPROP=13, MATHOPTR=14, NEWLINE=15, 
		WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'sum'", "')'", "'getFromDb'", "','", "'('", "'print'", "'='", "SING_LN_CMM", 
		"MULT_LN_CMM", "ID", "STR", "NBR", "OBJPROP", "MATHOPTR", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "SING_LN_CMM", 
		"MULT_LN_CMM", "ID", "STR", "NBR", "OBJPROP", "MATHOPTR", "NEWLINE", "WS"
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

		case 15: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\22\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\6\tB\n\t\r\t\16\tC\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\nO\n\n\f\n\16\nR\13\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\6\13[\n\13\r\13\16\13\\\3\f\3\f\6\fa\n\f\r\f\16\fb\3\f"+
		"\3\f\3\f\6\fh\n\f\r\f\16\fi\3\f\5\fm\n\f\3\r\6\rp\n\r\r\r\16\rq\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\20\5\20{\n\20\3\20\3\20\5\20\177\n\20\3\21\6"+
		"\21\u0082\n\21\r\21\16\21\u0083\3\21\3\21\4CP\22\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\2\23\13\3\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\4\3\2\b\4\2C\\c|\6\2\62;C\\aac|\6\2\"\"\62;C\\c|\3\2"+
		"\62;\6\2,-//\61\61^^\4\2\13\13\"\"\u0091\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t\63"+
		"\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23I\3\2\2"+
		"\2\25X\3\2\2\2\27l\3\2\2\2\31o\3\2\2\2\33s\3\2\2\2\35w\3\2\2\2\37~\3\2"+
		"\2\2!\u0081\3\2\2\2#$\7u\2\2$%\7w\2\2%&\7o\2\2&\4\3\2\2\2\'(\7+\2\2(\6"+
		"\3\2\2\2)*\7i\2\2*+\7g\2\2+,\7v\2\2,-\7H\2\2-.\7t\2\2./\7q\2\2/\60\7o"+
		"\2\2\60\61\7F\2\2\61\62\7d\2\2\62\b\3\2\2\2\63\64\7.\2\2\64\n\3\2\2\2"+
		"\65\66\7*\2\2\66\f\3\2\2\2\678\7r\2\289\7t\2\29:\7k\2\2:;\7p\2\2;<\7v"+
		"\2\2<\16\3\2\2\2=>\7?\2\2>\20\3\2\2\2?A\7%\2\2@B\13\2\2\2A@\3\2\2\2BC"+
		"\3\2\2\2CD\3\2\2\2CA\3\2\2\2DE\3\2\2\2EF\5\37\20\2FG\3\2\2\2GH\b\t\2\2"+
		"H\22\3\2\2\2IJ\7\61\2\2JK\7,\2\2KP\3\2\2\2LO\13\2\2\2MO\5\37\20\2NL\3"+
		"\2\2\2NM\3\2\2\2OR\3\2\2\2PQ\3\2\2\2PN\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7"+
		",\2\2TU\7\61\2\2UV\3\2\2\2VW\b\n\3\2W\24\3\2\2\2XZ\t\2\2\2Y[\t\3\2\2Z"+
		"Y\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\26\3\2\2\2^`\7$\2\2_a\t\4"+
		"\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2dm\7$\2\2eg\7)\2"+
		"\2fh\t\4\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2km\7)\2"+
		"\2l^\3\2\2\2le\3\2\2\2m\30\3\2\2\2np\t\5\2\2on\3\2\2\2pq\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2r\32\3\2\2\2st\5\25\13\2tu\7\60\2\2uv\5\25\13\2v\34\3\2"+
		"\2\2wx\t\6\2\2x\36\3\2\2\2y{\7\17\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\177"+
		"\7\f\2\2}\177\7\2\2\3~z\3\2\2\2~}\3\2\2\2\177 \3\2\2\2\u0080\u0082\t\7"+
		"\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\21\4\2\u0086\"\3\2\2"+
		"\2\16\2CNP\\bilqz~\u0083";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}