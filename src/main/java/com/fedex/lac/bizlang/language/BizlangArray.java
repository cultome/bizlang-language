package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangArray.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangArray extends BizlangExpression {
	
	private List<BizlangValue> elements;

	public BizlangArray(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
		elements = new ArrayList<BizlangValue>();
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		return elements;
	}

	public void addElement(BizlangValue r) {
		elements.add(r);
	}

	public List<BizlangValue> getElements() {
		return elements;
	}

}
