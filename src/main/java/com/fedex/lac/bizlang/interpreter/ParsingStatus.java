package com.fedex.lac.bizlang.interpreter;

/* 
 * ParsingStatus.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public enum ParsingStatus {
	PARSING_FNCT, WAITING, ASSIGNING_VAL, PARSING_MATH_EXPR, GETTING_VALUE
}