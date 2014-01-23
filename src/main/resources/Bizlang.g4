grammar Bizlang;
options{
    language = Java;
}

script		: expression+ EOF ;
expression  : fnctCall
			| mathExpr
			| conditional
			| swtch
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
conditional	: CONDOPRT logicOp block
			| CONDOPRT cstmLogOp block
			;
swtch		: 'case' ID NEWLINE caseBlock+ 'end' ;
caseBlock	: 'when' value 'then' expression+
			| 'default' expression+
			;
repetition	: 'for' ID 'in' OBJPROP block
			| 'for' ID 'in' ID block
			| 'for' ID 'in' array block
			| 'for' ID 'in' range block
			;
paramLst	: value
			| value ',' paramLst
			;
range		: '[' NBR '...' NBR ']'
			| '[' DATE '...' DATE ']'
			;
array		: '[' paramLst ']' ;
value		: NBR
			| STR
			| ID
			| OBJPROP
			| DATE
			| array
			| range
			;
comment		: SING_LN_CMM
			| MULT_LN_CMM
			;
logicOp		: value LOGICOPRT value ;
cstmLogOp	: value CSTMOPRT value ;
block		: 'do' expression+ 'end'
			| 'do' expression+ elseBlk 'end'
			;
elseBlk		: 'else' expression+ ;




SING_LN_CMM	: '#' .+? NEWLINE -> skip ;
MULT_LN_CMM	: '/*' (.|NEWLINE)*? '*/' -> skip ;
CSTMOPRT	: '><' ;
LOGICOPRT	: '<=' | '>=' | '<' | '>' | '==' | '!=' ;
MATHOPTR	: [\+\-\*/] ;
CONDOPRT	: 'if'
			| 'unless'
			; 
FNCTNAME	: 'print'
			| 'sum'
			| 'getFromDb'
			;
NBR			: [\+\-]?[0-9]+('.'[0-9]+)? ;
STR         : '"' (~["])*? '"'
			| '\'' (~['])*? '\''
			;
DATE		: [0-9]+ '/' [0-9]+ '/' [0-9]+ ;
ID			: [a-zA-Z][a-zA-Z0-9_]+ ;
OBJPROP		: ID'.'ID
			| ID'.'OBJPROP
			| ID '[' NBR ']'
			;
NEWLINE		: '\r'? '\n'
			| EOF
			;
WS          : [ \t]+ -> skip ;