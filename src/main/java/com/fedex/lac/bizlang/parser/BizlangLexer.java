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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, ID=8, STR=9, NBR=10, 
		OBJPROP=11, MATHOPTR=12, NEWLINE=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'sum'", "')'", "'getFromDb'", "','", "'('", "'print'", "'='", "ID", "STR", 
		"NBR", "OBJPROP", "MATHOPTR", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", "STR", "NBR", 
		"OBJPROP", "MATHOPTR", "NEWLINE", "WS"
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
		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\20h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\6\t>\n\t\r\t\16\t?\3\n\3\n\6\nD\n\n\r\n\16\nE\3\n"+
		"\3\n\3\n\6\nK\n\n\r\n\16\nL\3\n\5\nP\n\n\3\13\6\13S\n\13\r\13\16\13T\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\5\16^\n\16\3\16\3\16\3\17\6\17c\n\17\r\17"+
		"\16\17d\3\17\3\17\2\20\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\2\3\2\b\4\2C\\c|\6\2"+
		"\62;C\\aac|\6\2\"\"\62;C\\c|\3\2\62;\6\2,-//\61\61^^\4\2\13\13\"\"n\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5#\3\2\2\2\7%\3\2\2"+
		"\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23O\3"+
		"\2\2\2\25R\3\2\2\2\27V\3\2\2\2\31Z\3\2\2\2\33]\3\2\2\2\35b\3\2\2\2\37"+
		" \7u\2\2 !\7w\2\2!\"\7o\2\2\"\4\3\2\2\2#$\7+\2\2$\6\3\2\2\2%&\7i\2\2&"+
		"\'\7g\2\2\'(\7v\2\2()\7H\2\2)*\7t\2\2*+\7q\2\2+,\7o\2\2,-\7F\2\2-.\7d"+
		"\2\2.\b\3\2\2\2/\60\7.\2\2\60\n\3\2\2\2\61\62\7*\2\2\62\f\3\2\2\2\63\64"+
		"\7r\2\2\64\65\7t\2\2\65\66\7k\2\2\66\67\7p\2\2\678\7v\2\28\16\3\2\2\2"+
		"9:\7?\2\2:\20\3\2\2\2;=\t\2\2\2<>\t\3\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@\22\3\2\2\2AC\7$\2\2BD\t\4\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2FG\3\2\2\2GP\7$\2\2HJ\7)\2\2IK\t\4\2\2JI\3\2\2\2KL\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NP\7)\2\2OA\3\2\2\2OH\3\2\2\2P\24\3\2"+
		"\2\2QS\t\5\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\26\3\2\2\2VW\5"+
		"\21\t\2WX\7\60\2\2XY\5\21\t\2Y\30\3\2\2\2Z[\t\6\2\2[\32\3\2\2\2\\^\7\17"+
		"\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\f\2\2`\34\3\2\2\2ac\t\7\2\2ba"+
		"\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\17\2\2g\36\3\2\2"+
		"\2\n\2?ELOT]d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}