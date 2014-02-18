package com.cultomebizlang.language.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cultome.bizlang.language.BizlangExpression;
import com.cultome.bizlang.language.BizlangRule;

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
