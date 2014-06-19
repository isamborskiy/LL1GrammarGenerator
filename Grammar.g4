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
	public String headerCode = "";
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
	@init{String header = "";}
	: 'grammar' name '$' (SYMBOL+? '@header' (SYMBOL{header += $SYMBOL.text;})+ '$')? (rules)* SYMBOL* EOF
	{
		if (header.contains("{") && header.contains("}")) {
			headerCode = header.substring(header.indexOf("{") + 1, header.lastIndexOf("}"));
		}
		grammarName = $name.val;
		if (terminals.contains(Terminal.EPS) || terminals.contains(Terminal.EOF) || terminals.contains(Terminal.COLON) || terminals.contains(Terminal.HASH)) {
			errorMessage = "EPS, EOF, COLON and HASH are reserved names of terminals.";
			hasError = true;
		}
		
		for (Nonterminal nonterm : rules.keySet()) {
			for (Rule rule : rules.get(nonterm)) {
				for (int i = 0; i < rule.size(); i++) {
					Element elem = rule.get(i);
					if (elem.isTerm()) {
						if (((Terminal) elem).equals(Terminal.COLON)) {
							terminals.add(Terminal.COLON);
						}
						if (((Terminal) elem).equals(Terminal.HASH)) {
							terminals.add(Terminal.HASH);
						}
					}
				}
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(grammarName + ".tokens");
			for (Terminal term : terminals) {
				if (!term.equals(Terminal.EPS) && !term.equals(Terminal.EOF)) {
					if (term.isConst()) {
						pw.println(term.get() + ":" + term.match());
					} else {
						pw.println(term.get() + ":$" + term.match() + "$");
					}
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
	: name ':' termrightpart '$'
	{
		if ($name.val.equals($name.val.toUpperCase()) && !$name.val.isEmpty() && findTerm($name.val) == null) {
			String match = $termrightpart.val;
			if (match.charAt(0) == '\'') {
				terminals.add(new Terminal($name.val, match.substring(1, match.length() - 1), false));
			} else {
				terminals.add(new Terminal($name.val, match, true));
			}
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
	: name ('#' nontermrightpart{ruleList.add($nontermrightpart.val);})+ '$'
	{
		String inher = "";
		String synth = "";
		String nameStr = $name.val;
		if (nameStr.contains("[")) {
			String[] arr = nameStr.split("returns");
			if (arr[0].contains("[")) {
				inher = arr[0].substring(arr[0].indexOf("[") + 1, arr[0].indexOf("]"));
			}
			if (arr.length > 1) {
				synth = arr[1].substring(arr[1].indexOf("[") + 1, arr[1].indexOf("]"));
				nameStr = arr[0];
			}
			nameStr = nameStr.substring(0, nameStr.indexOf("[") == -1 ? nameStr.length() : nameStr.indexOf("[")).replaceAll("\\s+", "");
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
		String trans = "";
		if (res.contains("{") && res.contains("}")) {
			trans = res.substring(res.indexOf("{"), res.lastIndexOf("}") + 1);
			res = res.substring(0, res.indexOf("{"));
		}
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
		$val.setTrans(trans);
	}
	;
	
skip
	: name ':' termrightpart? '->' SYMBOL+? 'skip' SYMBOL* '$'
	{
		if ($termrightpart.val != null && $name.val.equals($name.val.toUpperCase()) && !$name.val.isEmpty()) {
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
	
SYMBOL	: ~[#:$];
