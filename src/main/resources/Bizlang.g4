grammar Bizlang;
options{
    language = Java;
}

script		: expression+ EOF ;
expression  : fnctCall
			| mathExpr
			| conditional
			| repetition
			| assignation
			| value
			| comment
			| NEWLINE
			;
fnctCall    : FNCTNAME expression
			| FNCTNAME '(' paramLst ')'
			| FNCTNAME paramLst
			;
assignation	: ID '=' expression ;
mathExpr	: value MATHOPTR value
			| value MATHOPTR mathExpr
			;
conditional	: CONDOPRT logicOp block;
repetition	: 'for' ID 'in' OBJPROP block;
value		: NBR
			| STR
			| ID
			| OBJPROP
			;
comment		: SING_LN_CMM
			| MULT_LN_CMM
			;
logicOp		: value LOGICOPRT value ;
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
FNCTNAME	: 'print'
			| 'sum'
			| 'getFromDb'
			;
NBR			: [0-9]+('.'[0-9]+)? ;
STR         : '"' (~["])*? '"'
			| '\'' (~['])*? '\''
			;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
OBJPROP		: ID'.'ID
			| ID'.'OBJPROP
			| ID '[' NBR ']'
			;
NEWLINE		: '\r'? '\n'
			| EOF
			;
WS          : [ \t]+ -> skip ;