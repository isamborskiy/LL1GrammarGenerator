grammar Grammar;

@header {
	package com.samborskiy.antlr;
	import java.util.*; 
	import java.io.*; 
	import com.samborskiy.elements.*;
}

@parser::members {
	public Set<Terminal> terminals = new HashSet<>();
	public Map<Nonterminal, List<Rule>> grammaRules = new HashMap<>();
	public String grammarName = "";
	public Terminal skipTerminal = null;
	public boolean hasError = false;
	public String errorMessage = "";
	
	private Map<Nonterminal, List<List<String>>> rules = new HashMap<>();
	private boolean hasEpsTerm = false;
	private boolean hasEofTerm = false;
	
	private Terminal findTerm(String str) {
		for (Terminal term : terminals) {
			if (term.get().equals(str)) {
				if (term.get().equals("EPS")) hasEpsTerm = true;
				if (term.get().equals("EOF")) hasEofTerm = true;
				return term;
			}
		}
		return null;
	}
}

gram
	: 'grammar' name ';' (rules)* SYMBOL* EOF
	{
		grammarName = $name.val;
		if (terminals.contains(Terminal.EPS) || terminals.contains(Terminal.EOF)) {
			errorMessage = "EPS and EOF are reserved names.";
			hasError = true;
		}
		terminals.add(Terminal.EPS);
		terminals.add(Terminal.EOF);
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
		if (!hasEpsTerm) terminals.remove(Terminal.EPS);
		if (!hasEofTerm) {
			errorMessage = "EOF not found in grammar rules.";
			hasError = true;
		}
		try {
			PrintWriter pw = new PrintWriter(grammarName + ".tokens");
			for (Terminal term : terminals) {
				pw.println(term.get() + ":" + term.match());
			}
			if (skipTerminal != null) {
				pw.println();
				pw.println(skipTerminal.get() + ":" + skipTerminal.match());
			}
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	;
	
rules 
	: term
	| nonterm
	| skip
	;
	
term
	: name ':' termrightpart ';'
	{
		if ($name.val.equals($name.val.toUpperCase()) && !$name.val.isEmpty() && findTerm($name.val) == null) {
			terminals.add(new Terminal($name.val, $termrightpart.val));
		} else {
			errorMessage = "Incorrect grammar file: terminal name \'" + $name.val + "\'.";
			hasError = true;
		}
		if (errorMessage.equals("Incorrect grammar file: use EPS terminal")) {
			errorMessage += " instead of " + $name.val + ".";
		}
	}
	;
	
termrightpart returns [String val]
	@init{String res = "";}
	: (SYMBOL{res += $SYMBOL.text;})+
	{
		if (res.contains("[") && res.contains("]")) {
			int start = res.indexOf("[");
			int end = res.lastIndexOf("]");
			$val = res.substring(start, end + 1);
		} else if (res.contains("'")) {
			int start = res.indexOf("'");
			int end = res.lastIndexOf("'");
			$val = res.substring(start + 1, end);
		} else {
			errorMessage = "Incorrect grammar file: terminal recording.";
			hasError = true;
		}
		if ($val.equals("[]") || $val.isEmpty()) {
			errorMessage = "Incorrect grammar file: use EPS terminal";
			hasError = true;
		}
	}
	;

nonterm
	@init {List<List<String>> ruleList = new ArrayList<>();}
	: name ':' nontermrightpart{ruleList.add($nontermrightpart.val);} ('|' nontermrightpart{ruleList.add($nontermrightpart.val);})* ';'
	{
		if ($name.val.charAt(0) >= 'a' && $name.val.charAt(0) <= 'z') {
			rules.put(new Nonterminal($name.val), ruleList);
		} else {
			errorMessage = "Incorrect grammar file: nonterminal name \'" + $name.val + "\'." ;
			hasError = true;
		}		
	}
	;
	
nontermrightpart returns [List<String> val]
	@init{String res = "";}
	: (SYMBOL{res += $SYMBOL.text;})+
	{
		$val = new ArrayList<>();
		String[] arr = res.split("\\s+");
		for (String str : arr) {
			if (!str.isEmpty()) {
				$val.add(str);
			}
		}
	}
	;
	
skip
	: name ':' termrightpart? '->' SYMBOL+? 'skip' SYMBOL* ';'
	{
		if ($termrightpart.val != null && $name.val.equals($name.val.toUpperCase()) && !$name.val.isEmpty() && $termrightpart.val.contains("[") && $termrightpart.val.contains("]")) {
			skipTerminal = new Terminal($name.val, $termrightpart.val);
		} else {
			errorMessage = "Incorrect grammar file: skip rule.";
			hasError = true;
		}
	}
	;
	
name returns [String val]
	@init{String res = "";}
	: (SYMBOL{res += $SYMBOL.text;})+
	{$val = res.replaceAll("\\s+", "");}
	;
	
SYMBOL	: ~[|:;];