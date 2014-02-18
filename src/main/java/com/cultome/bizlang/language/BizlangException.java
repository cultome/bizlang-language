package com.cultome.bizlang.language;

public class BizlangException extends Exception {

	private static final long serialVersionUID = -2870185477347867661L;

	public BizlangException(String message) {
		super(message);
	}

	public BizlangException(Exception exception) {
		super(exception);
	}
}
