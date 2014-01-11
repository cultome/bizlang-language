grammar Bizlang;
options{
    language = Java;
}

script		: expressions ;
expressions	: expression
			| expression NEWLINE expressions
			;
expression  : fnctCall 
			| assignation
			| mathExpr
			| value
			;
mathExpr	: value MATHOPTR value
			| value MATHOPTR mathExpr
			;
fnctCall    : fnct expression
			| fnct '(' paramLst ')'
			| fnct paramLst
			;
fnct        : 'print'
			| 'sum'
			| 'getFromDb'
			;
assignation	: ID '=' expression ;
paramLst   : value
			| value ',' paramLst
			;
value		: NBR
			| STR
			| ID
			| OBJPROP
			;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
STR         : '"' [a-zA-Z0-9 ]+ '"'
			| '\'' [a-zA-Z0-9 ]+ '\''
			;
NBR			: [0-9]+ ;
OBJPROP	: ID'.'ID ;
MATHOPTR		: [\+\-\*/] ;
NEWLINE		: '\r'? '\n' ;
WS          : [ \t]+ -> skip ;