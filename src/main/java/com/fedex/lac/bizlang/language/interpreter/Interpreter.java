package com.fedex.lac.bizlang.language.interpreter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangRule;
import com.fedex.lac.bizlang.language.parser.BizlangLexer;
import com.fedex.lac.bizlang.language.parser.BizlangParser;
import com.fedex.lac.bizlang.language.parser.BizlangParser.ScriptContext;

/* 
 * Interpreter.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
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
