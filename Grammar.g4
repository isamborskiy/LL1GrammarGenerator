grammar Grammar;

@header {
	package com.samborskiy.antlr;
	import java.util.*; 
	import java.io.*; 
	import com.samborskiy.elements.*;
}

@parser::members {
	public Set<Terminal> terminals = new HashSet<>();
	public Map<Nonterminal, List<Rule>> rules = new HashMap<>();
	public String grammarName = "";
	public Terminal skipTerminal = null;
	public boolean hasError = false;
	public String errorMessage = "";
	
	private Terminal findTerm(String str) {
		for (Terminal term : terminals) {
			if (term.get().equals(str)) {
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
		
		try {
			PrintWriter pw = new PrintWriter(grammarName + ".tokens");
			for (Terminal term : terminals) {
				if (!term.equals(Terminal.EPS) && !term.equals(Terminal.EOF)) {
					pw.println(term.get() + ":" + term.match());
				}
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
			terminals.add(new Terminal($name.val, $termrightpart.val, false));
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
		if (res.contains("(") && res.contains(")")) {
			int start = res.indexOf("(");
			int end = res.lastIndexOf(")");
			$val = res.substring(start + 1, end);
			if ($val.equals("[]") || $val.isEmpty()) {
				errorMessage = "Incorrect grammar file: use EPS terminal";
				hasError = true;
			}
		} else {
			errorMessage = "Incorrect grammar file: terminal recording.";
			hasError = true;
		}
	}
	;

nonterm
	@init {List<Rule> ruleList = new ArrayList<>();}
	: name ('|' nontermrightpart{ruleList.add($nontermrightpart.val);})+ ';'
	{
		String inher = "";
		String synth = "";
		String nameStr = $name.val;
		if (nameStr.contains("[")) {
			String[] arr = nameStr.split("returns");
			if (arr[0].contains("[")) {
				inher = nameStr.substring(nameStr.indexOf("[") + 1, nameStr.indexOf("]"));
			}
			if (arr.length > 1) {
				synth = arr[1].substring(arr[1].indexOf("[") + 1, arr[1].indexOf("]"));
			}
			nameStr = $name.val.substring(0, $name.val.indexOf("[")).replaceAll("\\s+", "");
		}
		if (nameStr.charAt(0) >= 'a' && nameStr.charAt(0) <= 'z') {
			Nonterminal nonterm = new Nonterminal(nameStr);
			if (!inher.isEmpty()) {
				nonterm.setInher(inher);
			}
			if (!synth.isEmpty()) {
				nonterm.setSynth(synth);
			}
			rules.put(nonterm, ruleList);
		} else {
			errorMessage = "Incorrect grammar file: nonterminal name \'" + $name.val + "\'." ;
			hasError = true;
		}		
	}
	;
	
nontermrightpart returns [Rule val]
	@init{String res = "";}
	: (SYMBOL{res += $SYMBOL.text;})+
	{
		List<Element> list = new ArrayList<>();
		String[] arr = res.split("\\s+");
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			String inher = "";
			if (!str.isEmpty()) {
				if (str.contains("[")) {
					inher = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
					str = str.substring(0, str.indexOf("["));
				}
				
				if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
					Nonterminal nonterm = new Nonterminal(str);
					nonterm.setInher(inher);
					list.add(nonterm);
				} else {
					list.add(new Terminal(str, "", false));
				}
			}
		}
		$val = new Rule(list.toArray(new Element[list.size()]));
	}
	;
	
skip
	: name ':' termrightpart? '->' SYMBOL+? 'skip' SYMBOL* ';'
	{
		if ($termrightpart.val != null && $name.val.equals($name.val.toUpperCase()) && !$name.val.isEmpty() && $termrightpart.val.contains("[") && $termrightpart.val.contains("]")) {
			skipTerminal = new Terminal($name.val, $termrightpart.val, false);
		} else {
			errorMessage = "Incorrect grammar file: skip rule.";
			hasError = true;
		}
	}
	;
	
name returns [String val]
	@init{String res = "";}
	: (SYMBOL{res += $SYMBOL.text;})+
	{
		if (!res.contains("[")) {
			$val = res.replaceAll("\\s+", "");
		} else {
			int k = 0;
			while(new String("" + res.charAt(k)).matches("\\s")) {
				k++;
			}
			res = res.substring(k);
			k = res.length() - 1;
			while(new String("" + res.charAt(k)).matches("\\s")) {
				k--;
			}
			$val = res.substring(0, k + 1);
		}
	}
	;
	
SYMBOL	: ~[|:;];