grammar Bizlang;
options{
    language = Java;
}

script		: expression+ NEWLINE ;
expression  : fnctCall 
			| assignation
			| mathExpr
			| value
			| comment
			| NEWLINE
			;
comment		: SING_LN_CMM
			| MULT_LN_CMM
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
SING_LN_CMM	: '#' .+? NEWLINE -> skip ;
MULT_LN_CMM	: '/*' (.|NEWLINE)*? '*/' -> skip ;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
STR         : '"' [a-zA-Z0-9 ]+ '"'
			| '\'' [a-zA-Z0-9 ]+ '\''
			;
NBR			: [0-9]+ ;
OBJPROP	: ID'.'ID ;
MATHOPTR		: [\+\-\*/] ;
NEWLINE		: '\r'? '\n' | EOF ;
WS          : [ \t]+ -> skip ;