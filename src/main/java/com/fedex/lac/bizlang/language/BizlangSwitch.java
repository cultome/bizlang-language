package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * BizlangSwitch.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	20/01/2014
 */
public class BizlangSwitch extends BizlangExpression {
	
	private List<BizlangSwitchBlock> blocks;
	private BizlangValue reference;

	public BizlangSwitch(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		Object refValue = reference.execute(bindings);
		Object condValue;
		
		for(BizlangSwitchBlock block : getBlocks()){
			condValue = block.getCondition().execute(bindings);
			
			if(refValue.equals(condValue)){
				return block.execute(bindings);
			}
		}
		return null;
	}

	public void addReference(BizlangValue reference) {
		this.reference = reference;
	}

	public void addCase(BizlangSwitchBlock block) {
		getBlocks().add(block);
	}

	public List<BizlangSwitchBlock> getBlocks() {
		if(blocks == null){
			blocks = new ArrayList<BizlangSwitchBlock>();
		}
		return blocks;
	}
}
