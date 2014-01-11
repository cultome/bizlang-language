package com.fedex.lac.bizlang.interpreter;

import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.parser.BizlangParser;
import com.fedex.lac.bizlang.parser.BizlangParser.ScriptContext;

/* 
 * Interpreter.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class Interpreter {

	public ExecutionFlow interpret(InputStream script) throws Exception{
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
		for(BizlangExpression exp : flow.getFlow()){
			exp.execute(bindings);
		}
	}
}
