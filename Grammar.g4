grammar Grammar;

@header {
	package com.samborskiy.antlr;
	import java.util.*; 
	import com.samborskiy.elements.*;
}

@parser::members {
	public Set<Terminal> terminals = new HashSet<>();
	public Map<Nonterminal, List<Rule>> grammaRules = new HashMap<>();
	
	private Map<Nonterminal, List<List<String>>> rules = new HashMap<>();
	private boolean hasEpsTerm = false;
	
	private Terminal findTerm(String str) {
		for (Terminal term : terminals) {
			if (term.get().equals(str)) {
				if (term.get().equals("EPS")) hasEpsTerm = true;
				return term;
			}
		}
		return null;
	}
}

gram
	: (rules SPACE?)* EOF
	{
		terminals.add(new Terminal("EPS", ""));
		for (Nonterminal nonterm : rules.keySet()) {
			List<Rule> newRules = new ArrayList<>();
			for (List<String> list : rules.get(nonterm)) {
				Element[] elements = new Element[list.size()];
				for (int i = 0; i < list.size(); i++) {
					Terminal term = findTerm(list.get(i));
					if (term == null) {
						elements[i] = new Nonterminal(list.get(i));
					} else {
						elements[i] = term;
					}
				}
				newRules.add(new Rule(elements));
			}
			grammaRules.put(nonterm, newRules);
		}
		if (!hasEpsTerm) terminals.remove(new Terminal("EPS", ""));
	}
	;
	
rules 
	: term
	| nonterm
	;
	
term
	: TERMINAL SPACE? ':' termrightpart ';'
	{terminals.add(new Terminal($TERMINAL.text, $termrightpart.val));}
	;
	
termrightpart returns [String val]
	@init {String res = "";}
	: SPACE? '\'' (SYMBOL{res += $SYMBOL.text;})* '\'' SPACE?
	{$val = res;}
	| SPACE? '[' (SYMBOL{res += $SYMBOL.text;})* ']' SPACE?
	{$val = "[" + res + "]";}
	;

nonterm
	@init {List<List<String>> ruleList = new ArrayList<>();}
	: NONTERMINAL SPACE? ':' nontermrightpart{ruleList.add($nontermrightpart.val);} ('|' nontermrightpart{ruleList.add($nontermrightpart.val);})* ';'
	{rules.put(new Nonterminal($NONTERMINAL.text), ruleList);}
	;
	
nontermrightpart returns [List<String> val]
	@init {List<String> ruleElements = new ArrayList<>();}
	: SPACE? ((NONTERMINAL{ruleElements.add($NONTERMINAL.text);} | TERMINAL{ruleElements.add($TERMINAL.text);}) SPACE)*
	{$val = ruleElements;}
	;
	
SPACE 		: [ \t\r\n]+;
NONTERMINAL	: [a-z]+[a-zA-Z]*;
TERMINAL	: [A-Z]+;
SYMBOL		: [0-9a-zA-Z+\-*\\];
