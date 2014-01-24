package com.fedex.lac.bizlang.language;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fedex.lac.bizlang.interpreter.Bindings;
import com.fedex.lac.bizlang.parser.BizlangLexer;
import com.fedex.lac.bizlang.util.Utils;

/* 
 * BizlangRange.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	17/01/2014
 */
public class BizlangRange extends BizlangValue {
	
	private BizlangValue lowerLimit;
	private BizlangValue upperLimit;
	
	public static final int INTEGER_RANGE = 1;
	public static final int DECIMAL_RANGE = 2;
	public static final int DATE_RANGE = 3;

	public BizlangRange(String fnctName, int srcLineDefinedAt) {
		super(COMPLEX_TYPE_RANGE, fnctName, srcLineDefinedAt);
	}
	
	public BizlangRange(String fnctName, int srcLineDefinedAt, BizlangValue lowerLimit, BizlangValue upperLimit) {
		this(fnctName, srcLineDefinedAt);
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	@Override
	public Object execute(Bindings bindings) throws BizlangException {
		int rangeType = checkRangeType();
		switch(rangeType){
		case INTEGER_RANGE:
			int low = Integer.parseInt(lowerLimit.getValue());
			int high = Integer.parseInt(upperLimit.getValue());
			return getIntegerRange(low, high);
			
		case DATE_RANGE:
			Date lowDt = Utils.parseDate(lowerLimit.getValue());
			Date uppDt = Utils.parseDate(upperLimit.getValue());
			return getDateRange(lowDt, uppDt);
			
		case DECIMAL_RANGE:
			break;
		}
		return null;
	}

	private List<BizlangValue> getDateRange(Date lowDt, Date uppDt) {
		List<BizlangValue> dateRange = new ArrayList<BizlangValue>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(lowDt);
		Date currentDt;
		int increment = 1;
		
		if(lowDt.compareTo(uppDt) > 0){
			increment = -1;
		}
		
		do {
			cal.add(Calendar.DAY_OF_YEAR, increment);
			currentDt = cal.getTime();
			dateRange.add(new BizlangValue(BizlangLexer.DATE, Utils.formatDate(currentDt), -1));
		} while(currentDt.compareTo(uppDt) != 0);
		
		return dateRange;
	}

	private List<BizlangValue> getIntegerRange(int low, int high) {
		List<BizlangValue> range = new ArrayList<BizlangValue>();
		if(low < high){
			for(int i = low; i <= high; i++){
				range.add(new BizlangValue(BizlangLexer.NBR, String.valueOf(i), -1));
			}
		} else {
			for(int i = low; i >= high; i--){
				range.add(new BizlangValue(BizlangLexer.NBR, String.valueOf(i), -1));
			}
		}
		return range;
	}

	private int checkRangeType() {
		switch(lowerLimit.getType()){
		case BizlangLexer.NBR:
			if(lowerLimit.getValue().matches("^[\\d]+$")){
				return INTEGER_RANGE;
			} else if(lowerLimit.getValue().matches("^[\\d]+.[\\d]+$")){
				return DECIMAL_RANGE;
			}
			break;
		case BizlangLexer.DATE:
			return DATE_RANGE;
		}
		
		throw new RuntimeException("Unknown rage type [" + lowerLimit.getType() + ", " + upperLimit.getType() + "]");
	}
	
	public void setUpperLimit(BizlangValue limit) {
		upperLimit = limit;
	}

	public void setLowerLimit(BizlangValue limit) {
		lowerLimit = limit;
	}
	
	public void addLimit(BizlangValue limit) {
		if(lowerLimit == null){
			lowerLimit = limit;
		} else {
			upperLimit = limit;
		}
	}

	public BizlangValue getLowerLimit() {
		return lowerLimit;
	}

	public BizlangValue getUpperLimit() {
		return upperLimit;
	}

}
