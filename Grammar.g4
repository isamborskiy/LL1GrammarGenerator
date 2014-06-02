grammar Grammar;

gram
	: (rules SPACE?)* EOF
	;
	
rules 
	: term
	| nonterm
	;
	
term
	: TERMINAL SPACE? ':' termrightpart ('|' termrightpart)* ';'
	;
	
termrightpart
	: SPACE? '\'' SYMBOL* '\'' SPACE?
	| SPACE? '[' SYMBOL* ']' SPACE?
	;

nonterm
	: NONTERMINAL SPACE? ':' nontermrightpart ('|' nontermrightpart)* ';'
	;
	
nontermrightpart
	: SPACE? ((NONTERMINAL | TERMINAL | ('\'' SYMBOL* '\'')) SPACE)*
	;
    
SPACE 		: [ \t\r\n]+;
NONTERMINAL	: [a-z]+[a-zA-Z]*;
TERMINAL	: [A-Z]+;
SYMBOL		: [0-9a-zA-Z+\-*\\];