package com.cultome.bizlang.language;

/* 
 * BizlangException.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public class BizlangException extends Exception {

	private static final long serialVersionUID = -2870185477347867661L;

	public BizlangException(String message) {
		super(message);
	}

	public BizlangException(Exception exception) {
		super(exception);
	}
}
