package com.fedex.lac.bizlang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fedex.lac.bizlang.language.BizlangException;

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

}
