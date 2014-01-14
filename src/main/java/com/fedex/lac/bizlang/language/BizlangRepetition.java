package com.fedex.lac.bizlang.language;

import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangRepetition.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	14/01/2014
 */
public class BizlangRepetition extends BizlangExpression {
	
	private BizlangBlock block;
	private String varName;
	private String collectionName;

	public BizlangRepetition(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Object collection = bindings.getBinding(collectionName);
		if(collection.getClass().getName().endsWith("List")){
			for(Object obj : (List<?>) collection){
				executeBlock(obj, bindings);
			}
		} else if(collection.getClass().getName().startsWith("[L")){
			Object[] array = (Object[]) collection;
			for(int i = 0; i < array.length; i++){
				executeBlock(array[i], bindings);
			}
		}
		return null;
	}

	private void executeBlock(Object obj, Bindings bindings) throws BizlangException {
		bindings.addBinding(varName, obj);
		block.execute(bindings);
	}

	public void addBlock(BizlangBlock block) {
		this.block = block;
	}

	public void setRepetitionVarName(String varName) {
		this.varName = varName;
	}

	public void setCollection(String collectionName) {
		this.collectionName = collectionName;
	}

}
