grammar Bizlang;
options{
    language = Java;
}

script		: expressions ;
expressions	: expression
			| expression NEWLINE expressions
			;
expression  : fnct_call 
			| assignation
			| math_expr
			| value
			;
math_expr	: value MATH_OP value
			| value MATH_OP math_expr
			;
fnct_call   : fnct expression
			| fnct '(' param_lst ')'
			| fnct param_lst
			;
fnct        : 'print'
			| 'sum'
			| 'getFromDb'
			;
assignation	: ID '=' expression ;
param_lst   : value
			| value ',' param_lst
			;
value		: NBR
			| STR
			| ID
			| OBJ_PROP
			;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
STR         : '"' [a-zA-Z0-9 ]+ '"'
			| '\'' [a-zA-Z0-9 ]+ '\''
			;
NBR			: [0-9]+ ;
OBJ_PROP	: ID'.'ID ;
MATH_OP		: [\+\-\*/] ;
NEWLINE		: '\r'? '\n' ;
WS          : [ \t]+ -> skip ;