package com.cultome.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.cultomebizlang.language.interpreter.Bindings;

/* 
 * BizlangArray.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangArray extends BizlangValue {
	
	private List<BizlangValue> elements;

	public BizlangArray(int srcLineDefinedAt) {
		this("__array__", srcLineDefinedAt, new ArrayList<BizlangValue>());
	}
	
	public BizlangArray(String fnctName, int srcLineDefinedAt, List<BizlangValue> elements) {
		super(COMPLEX_TYPE_ARRAY, fnctName, srcLineDefinedAt);
		this.elements = elements;
	}

	public BizlangArray(List<BizlangValue> list) {
		this(-1);
		elements = list;
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		return elements;
	}

	public void addElement(BizlangValue element) {
		elements.add(element);
	}

	public List<BizlangValue> getElements() {
		if(elements == null){
			elements = new ArrayList<BizlangValue>();
		}
		return elements;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[");
		for(BizlangValue val : getElements()){
			b.append(val.toString() + ", ");
		}
		
		if(b.length() > 1){
			b.delete(b.length()-2, b.length());
		}
		b.append("]");
		
		return b.toString();
	}

	public boolean isEmpty() {
		return getElements().isEmpty();
	}

	public int size() {
		return getElements().size();
	}
}
