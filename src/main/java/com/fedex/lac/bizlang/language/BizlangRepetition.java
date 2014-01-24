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
	private BizlangExpression collection;

	public BizlangRepetition(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Object lastEvaluated = null;
		if(collectionName == null){
			List<BizlangValue> execute = (List<BizlangValue>) collection.execute(bindings);
			for(BizlangValue obj : execute){
				lastEvaluated = executeBlock(obj, bindings);
			}
		} else {
			Object collection = bindings.getBinding(collectionName);
			if(collection instanceof List){
				for(Object obj : (List<?>) collection){
					lastEvaluated = executeBlock(obj, bindings);
				}
			} else if(collection.getClass().getName().startsWith("[L")){
				Object[] array = (Object[]) collection;
				for(int i = 0; i < array.length; i++){
					lastEvaluated = executeBlock(array[i], bindings);
				}
			}
		}
		return lastEvaluated;
	}

	private Object executeBlock(Object obj, Bindings bindings) throws BizlangException {
		bindings.addBinding(varName, obj);
		return block.execute(bindings);
	}

	public void addBlock(BizlangBlock block) {
		this.block = block;
	}

	public void setRepetitionVarName(String varName) {
		this.varName = varName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setCollection(BizlangValue collection) {
		this.collection = collection;
	}

}
