package com.fedex.lac.bizlang.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.language.BizlangExpression;

/* 
 * ExecutionFlow.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	09/01/2014
 */
public class ExecutionFlow {
	
	List<BizlangExpression> flow;

	public List<BizlangExpression> getFlow() {
		if(flow == null){
			flow = new ArrayList<BizlangExpression>();
		}
		return flow;
	}
	
	public void addToFlow(BizlangExpression expression){
		getFlow().add(expression);
	}
}
