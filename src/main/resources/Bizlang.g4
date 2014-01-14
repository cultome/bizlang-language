grammar Bizlang;
options{
    language = Java;
}

script		: expression+ EOF ;
expression  : fnctCall
			| mathExpr
			| conditional
			| assignation
			| value
			| comment
			| NEWLINE
			;
fnctCall    : fnct expression
			| fnct '(' paramLst ')'
			| fnct paramLst
			;
assignation	: ID '=' expression ;
mathExpr	: value MATHOPTR value
			| value MATHOPTR mathExpr
			;
conditional	: CONDOPRT logicOp block;
value		: NBR
			| STR
			| ID
			| OBJPROP
			;
comment		: SING_LN_CMM
			| MULT_LN_CMM
			;
logicOp		: value LOGICOPRT value ;
fnct        : 'print'
			| 'sum'
			| 'getFromDb'
			;
paramLst	: value
			| value ',' paramLst
			;
block		: 'do' expression+ 'end'
			| 'do' expression+ elseBlk 'end'
			;
elseBlk		: 'else' expression+ ;
SING_LN_CMM	: '#' .+? NEWLINE -> skip ;
MULT_LN_CMM	: '/*' (.|NEWLINE)*? '*/' -> skip ;
LOGICOPRT	: '<=' | '>=' | '<' | '>' | '==' | '!=' ;
MATHOPTR	: [\+\-\*/] ;
CONDOPRT	: 'if'
			| 'unless'
			; 

NBR			: [0-9]+ ;
STR         : '"' (~["])*? '"'
			| '\'' (~['])*? '\''
			;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
OBJPROP		: ID'.'ID ;

NEWLINE		: '\r'? '\n'
			| EOF
			;
WS          : [ \t]+ -> skip ;