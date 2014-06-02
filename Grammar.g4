grammar Grammar;

@header {
	package com.samborskiy.antlr;
	import java.util.*; 
	import com.samborskiy.elements.*;
}

@parser::members {
	public Set<Terminal> terminals = new HashSet<>();
	public Map<Nonterminal, List<Rule>> rules = new HashMap<>();
}

gram
	: (rules SPACE?)* EOF
	;
	
rules 
	: term
	| nonterm
	;
	
term
	: TERMINAL SPACE? ':' SPACE? termrightpart SPACE? ';'
	{terminals.add(new Terminal($TERMINAL.text, $termrightpart.val));}
	;
	
termrightpart returns [String val]
	@init {String res = "";}
	: SPACE? '\'' (SYMBOL{res += $SYMBOL.text;})* '\'' SPACE?
	{$val = "\'" + res + "\'";}
	| SPACE? '[' (SYMBOL{res += $SYMBOL.text;})* ']' SPACE?
	{$val = "[" + res + "]";}
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