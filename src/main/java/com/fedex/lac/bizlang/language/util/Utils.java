package com.fedex.lac.bizlang.language.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fedex.lac.bizlang.language.BizlangException;
import com.fedex.lac.bizlang.language.BizlangValue;
import com.fedex.lac.bizlang.language.interpreter.Bindings;

/* 
 * Utils.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	20/01/2014
 */
public class Utils {

	private static final SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
	
	public static Date parseDate(String dateStr) throws BizlangException {
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new BizlangException("Date format invalid: " + dateStr + ". Try dd/mm/yyyy.");
		}
	}
	
	public static String formatDate(Date date) {
		return formatter.format(date);
	}

	public static boolean areEquivalentNumbers(String nbr1, String nbr2) {
		boolean nbr1IsDecimal = nbr1.contains(".");
		boolean nbr2IsDecimal = nbr2.contains(".");
		
		if(nbr1IsDecimal && nbr2IsDecimal){
			// ambos decimales
			int maxPrecision = Math.max(getPrecision(nbr1), getPrecision(nbr2));
			return areEquivalentNumbers(nbr1, nbr2, maxPrecision);
		} else if(!nbr1IsDecimal && !nbr2IsDecimal){
			// ambos enteros
			return nbr1.equals(nbr2);
		} else {
			// uno de los dos es decimal
			if(nbr1IsDecimal){
				return areEquivalentNumbers(nbr1, nbr2, getPrecision(nbr1));
			} else {
				return areEquivalentNumbers(nbr1, nbr2, getPrecision(nbr2));
			}
		}
	}

	public static boolean compareArrays(List<BizlangValue> thisValue, List<BizlangValue> otherValue) {
		return thisValue.equals(otherValue);
	}

	public static boolean containsFinalValue(List<BizlangValue> values, Object thisValue, Bindings bindings) throws BizlangException {
		for (BizlangValue bizlangValue : values) {
			if(bizlangValue.execute(bindings).equals(thisValue)){
				return true;
			}
		}
		return false;
	}
	
	public static int getPrecision(String nbr) {
		return nbr.substring(nbr.lastIndexOf(".")+1).length();
	}
	
	public static int getPrecision(BigDecimal nbr) {
		return nbr.toPlainString().substring(nbr.toPlainString().lastIndexOf(".")+1).length();
	}

	public static boolean areAllOfThisTypes(List<Object> values, String... classNames){
		boolean keepOn = false;
		for (Object obj : values) {
			keepOn = false;
			for (String className : classNames) {
				if(obj.getClass().getName().endsWith(className)){
					keepOn = true;
					break;
				}
			}
			if(!keepOn){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean areAnyOfThisTypes(List<Object> values, String... classNames){
		for (Object obj : values) {
			for (String className : classNames) {
				if(obj.getClass().getName().endsWith(className)){
					return true;
				}
			}
		}
		
		return false;
	}

	public static List<BizlangValue> cloneList(List<BizlangValue> list) {
		List<BizlangValue> newList = new ArrayList<BizlangValue>();
		for (BizlangValue value : list) {
			newList.add(value);
		}
		return newList;
	}

	private static boolean areEquivalentNumbers(String nbr1, String nbr2, int precision) {
		BigDecimal bd1 = new BigDecimal(nbr1).setScale(precision);
		BigDecimal bd2 = new BigDecimal(nbr2).setScale(precision);
		return bd1.equals(bd2);
	}

}
