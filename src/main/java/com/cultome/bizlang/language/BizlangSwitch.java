package com.cultome.bizlang.language;

import java.util.ArrayList;
import java.util.List;

import com.cultomebizlang.language.interpreter.Bindings;

public class BizlangSwitch extends BizlangExpression {
	
	private List<BizlangSwitchBlock> blocks;
	private BizlangValue reference;

	public BizlangSwitch(int srcLineDefinedAt) {
		super("__switch__", srcLineDefinedAt);
	}

	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		for(BizlangSwitchBlock block : getBlocks()){
			if(reference.equals(block.getCondition(), bindings)){
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
