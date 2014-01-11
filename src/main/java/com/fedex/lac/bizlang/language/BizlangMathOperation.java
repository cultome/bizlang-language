package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;

/* 
 * MathOperation.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangMathOperation extends BizlangFunction {

	private static final int NUMBERS_OP = 1;
	private static final int CONCAT_STR_OP = 2;

	public BizlangMathOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		// evaluamos los parametros de la funcion
		List<Object> values = getFinalValues(bindings);
		// checamos el tipo de parametros para determinar el tipo de operacion
		int opType = checkOperationType(values);

		switch (opType) {
		case NUMBERS_OP:
			return operateNumbers(values);
		case CONCAT_STR_OP:
			return concatenate(values);
		}

		return null;
	}

	private BigDecimal operateNumbers(List<Object> values) {
		BigDecimal result = null;
		BigDecimal nbr;
		for (Object value : values) {
			nbr = new BigDecimal(value.toString());
			if (result == null) {
				result = nbr;
			} else {
				if ("+".equals(name)) {
					result = result.add(nbr);
				} else if ("-".equals(name)) {
					result = result.subtract(nbr);
				} else if ("*".equals(name)) {
					result = result.multiply(nbr);
				} else if ("/".equals(name)) {
					result = result.divide(nbr);
				}
			}
		}

		return result;
	}

	private String concatenate(List<Object> values) {
		StringBuilder b = new StringBuilder();
		for (Object obj : values) {
			b.append(obj.toString());
		}
		return b.toString();
	}

	private boolean areAllOfThisTypes(List<Object> values, String... classNames){
		for (Object obj : values) {
			for (String className : classNames) {
				if(!obj.getClass().getName().endsWith(className)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private int checkOperationType(List<Object> values) {
		if(areAllOfThisTypes(values, "BigDecimal")){
			return NUMBERS_OP;
		}
		
		return CONCAT_STR_OP;
	}
}
