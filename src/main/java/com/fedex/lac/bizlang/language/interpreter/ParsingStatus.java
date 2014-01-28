package com.fedex.lac.bizlang.language.interpreter;

/* 
 * ParsingStatus.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	10/01/2014
 */
public enum ParsingStatus {
	PARSING_FNCT, WAITING, ASSIGNING_VAL, PARSING_MATH_EXPR, GETTING_VALUE, 
	PARSING_CONDITION, PARSING_LOGIC_COMP, PARSING_ELSE_BLOCK, PARSING_BLOCK, 
	PARSING_REPETITION, PARSING_ARRAY, PARSING_RANGE, PARSING_CSTM_LOG_OP, 
	PARSING_SWITCH, PARSING_CASE_BLOCK, PARSING_RULE
}
