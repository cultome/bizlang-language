package com.fedex.lac.bizlang.language;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fedex.lac.bizlang.language.interpreter.Bindings;
import com.fedex.lac.bizlang.language.util.Utils;

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
	private static final int DATE_OP = 3;
	private static final int RANGE_OP = 4;

	public BizlangMathOperation(String fnctName, int srcLineDefinedAt) {
		super(fnctName, srcLineDefinedAt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getValue(Bindings bindings) throws BizlangException {
		// evaluamos los parametros de la funcion
		List<Object> values = getFinalValues(bindings);
		// checamos el tipo de parametros para determinar el tipo de operacion
		int opType = guessOperationType(values);
		// buscamos una operacion alterna
		if(opType == CONCAT_STR_OP){
			List<Object> altValues = flatten(values);
			int opType2 = guessOperationType(altValues);
			if(opType2 != CONCAT_STR_OP){
				opType = opType2;
				values = altValues;
			}
		}

		switch (opType) {
		case NUMBERS_OP:
			return operateNumbers(values);
		case CONCAT_STR_OP:
			return concatenate(values);
		case DATE_OP:
			return dateOperation(values);
		case RANGE_OP:
			return rangeOperation((List<BizlangValue>) values.get(0), (BizlangValue) getParamList().get(1));
		}

		return null;
	}

	private List<Object> flatten(List<Object> values) {
		List<Object> returnValue = new ArrayList<Object>();
		for (Object obj : values) {
			if(obj instanceof List<?>){
				List<?> lst = (List<?>) obj;
				if(lst.size() == 1){
					returnValue.add(lst.get(0));
				} else {
					returnValue.add(lst);
				}
			} else {
				returnValue.add(obj);
			}
		}
		return returnValue;
	}

	private BizlangArray rangeOperation(List<BizlangValue> list, BizlangValue object) {
		List<BizlangValue> newList = Utils.cloneList(list);
		
		if ("+".equals(name)) {
			newList.add(object);
		} else if ("-".equals(name)) {
			newList.remove(object);
		}
		return new BizlangArray(newList);
	}

	private Object dateOperation(List<Object> values) {
		Date dt;
		BigDecimal nbr;
		
		if(values.get(0) instanceof Date){
			dt = (Date) values.get(0);
			nbr = (BigDecimal) values.get(1);
		} else {
			dt = (Date) values.get(1);
			nbr = (BigDecimal) values.get(0);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int offset = nbr.toBigInteger().intValue();
		cal.add(Calendar.DAY_OF_YEAR, offset);
		return cal.getTime();
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
	
	private int guessOperationType(List<Object> values) {
		if(Utils.areAllOfThisTypes(values, "BigDecimal", "Integer")){
			return NUMBERS_OP;
		} else if(Utils.areAllOfThisTypes(values, "Date", "BigDecimal", "Integer") && values.size() == 2){
			return DATE_OP;
		} else if(Utils.areAllOfThisTypes(values.subList(0, 1), "List")){
			return RANGE_OP;
		}
		
		return CONCAT_STR_OP;
	}
}
