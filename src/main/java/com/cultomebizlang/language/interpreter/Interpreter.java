package com.cultomebizlang.language.interpreter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.BizlangRule;
import com.cultome.bizlang.language.parser.BizlangLexer;
import com.cultome.bizlang.language.parser.BizlangParser;
import com.cultome.bizlang.language.parser.BizlangParser.ScriptContext;

public class Interpreter {

	public ExecutionFlow parseProgram(InputStream script) throws IOException {
		CharStream input = new ANTLRInputStream(script);
		BizlangLexer lexer = new BizlangLexer(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		BizlangParser parser = new BizlangParser(tokenStream);
		ScriptContext scriptCtx = parser.script();
		
		TreeListener listener = new TreeListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, scriptCtx);
		return listener.getExecutionFlow();
	}

	public ExecutionFlow parseProgram(String code) throws IOException {
		return parseProgram(new ByteArrayInputStream(code.getBytes()));
	}

	public void execute(ExecutionFlow flow, Bindings bindings) throws BizlangException {
		loadRules(flow, bindings);
		for(BizlangExpression exp : flow.getFlow()){
			exp.execute(bindings);
		}
	}

	public void execute(String code, Bindings bindings) throws IOException, BizlangException {
		ByteArrayInputStream bis = new ByteArrayInputStream(code.getBytes());
		ExecutionFlow ef = parseProgram(bis);
		execute(ef, bindings);
	}

	private void loadRules(ExecutionFlow flow, Bindings bindings) {
		for(Entry<String, BizlangRule> entrySet : flow.getRules().entrySet()){
			bindings.addRule(entrySet.getKey(), entrySet.getValue());
		}
	}
}
