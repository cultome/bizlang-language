package com.fedex.lac.bizlang.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.language.BizlangAssignation;
import com.fedex.lac.bizlang.language.BizlangExpression;
import com.fedex.lac.bizlang.language.BizlangFunction;

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

	public BizlangFunction addFnct(String fnctName, int srcLineDefinedAt) {
		BizlangFunction bizlangFunction = new BizlangFunction(fnctName, srcLineDefinedAt);
		getFlow().add(bizlangFunction);
		return bizlangFunction;
	}

	public BizlangFunction getFnct() {
		return null;
	}

	public List<BizlangExpression> getFlow() {
		if(flow == null){
			flow = new ArrayList<BizlangExpression>();
		}
		return flow;
	}

	public BizlangAssignation addAssignation(String lVal, int srcLineDefinedAt) {
		BizlangAssignation bizlangAssign = new BizlangAssignation(lVal, srcLineDefinedAt);
		getFlow().add(bizlangAssign);
		return bizlangAssign;
	}

}
