package com.cultomebizlang.language.interpreter;

public enum ParsingStatus {
	PARSING_FNCT, WAITING, ASSIGNING_VAL, PARSING_MATH_EXPR, GETTING_VALUE, 
	PARSING_CONDITION, PARSING_LOGIC_COMP, PARSING_ELSE_BLOCK, PARSING_BLOCK, 
	PARSING_REPETITION, PARSING_ARRAY, PARSING_RANGE, PARSING_CSTM_LOG_OP, 
	PARSING_SWITCH, PARSING_CASE_BLOCK, PARSING_RULE
}
