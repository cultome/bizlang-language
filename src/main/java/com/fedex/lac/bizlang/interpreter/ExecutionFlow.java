package com.fedex.lac.bizlang.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangRule;

/* 
 * ExecutionFlow.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class ExecutionFlow {
	
	private Map<String, BizlangRule> rules;	
	private List<BizlangExpression> flow;

	public List<BizlangExpression> getFlow() {
		if(flow == null){
			flow = new ArrayList<BizlangExpression>();
		}
		return flow;
	}
	
	public void addToFlow(BizlangExpression expression){
		getFlow().add(expression);
	}

	public Map<String, BizlangRule> getRules() {
		if(rules == null){
			rules = new HashMap<String, BizlangRule>();
		}
		return rules;
	}

	public void addRule(BizlangRule rule) {
		getRules().put(rule.getName(), rule);
	}
}
