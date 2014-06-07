package com.samborskiy.elements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.samborskiy.antlr.GrammarLexer;
import com.samborskiy.antlr.GrammarParser;
import com.samborskiy.generate.LexerGenerator;

public class Grammar {

	public Map<Nonterminal, List<Rule>> rules = new HashMap<>();
	public Set<Terminal> terminals = new HashSet<>();
	public Nonterminal start;
	public Terminal skipTerminal;
	public String grammarName = "";

	public Grammar(String... args) throws Exception {
		ANTLRFileStream input = new ANTLRFileStream(args[0]);
		GrammarLexer lexer = new GrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		parser.gram();
		// RuleContext tree = parser.gram();
		// tree.inspect(parser);

		if (parser.hasError) {
			throw new Exception(parser.errorMessage);
		}

		rules = parser.grammaRules;
		terminals = parser.terminals;
		grammarName = parser.grammarName;
		skipTerminal = parser.skipTerminal;
		start = new Nonterminal(args[1]);
		if (!rules.keySet().contains(start)) {
			throw new IllegalArgumentException("Nonterminal " + args[1]
					+ " does not exist");
		}

		LexerGenerator.generate(grammarName);
	}

	private Map<Nonterminal, Set<Terminal>> first = null;

	public Map<Nonterminal, Set<Terminal>> getFirst() {
		if (first == null) {
			first = new HashMap<>();
			for (Nonterminal nonterm : rules.keySet()) {
				first.put(nonterm, new HashSet<Terminal>());
			}
			boolean isChange = true;
			while (isChange) {
				isChange = false;
				for (Nonterminal nonterm : rules.keySet()) {
					int size = first.get(nonterm).size();
					for (Rule rule : rules.get(nonterm)) {
						if (rule.getTo(0).isTerm()) {
							first.get(nonterm).add((Terminal) rule.getTo(0));
						} else {
							first.get(nonterm).addAll(genFirst(rule, 0));
						}
					}
					if (first.get(nonterm).size() != size) {
						isChange = true;
					}
				}
			}
		}
		return first;
	}

	private Set<Terminal> genFirst(Rule rule, int index) {
		Set<Terminal> res = new HashSet<>();
		if (rule.size() == index) {
			return res;
		}

		if (!rule.getTo(index).isTerm()) {
			res.addAll(first.get(rule.getTo(index)));
			if (res.contains(Terminal.EPS)) {
				res.addAll(genFirst(rule, index + 1));
			}
		} else {
			res.add((Terminal) rule.getTo(index));
		}

		return res;
	}

	private Map<Nonterminal, Set<Terminal>> follow = null;

	public Map<Nonterminal, Set<Terminal>> getFollow() {
		follow = new HashMap<>();
		for (Nonterminal nonterm : rules.keySet()) {
			follow.put(nonterm, new HashSet<Terminal>());
		}
		getFirst();
		follow.get(start).add(Terminal.END);
		boolean isChange = true;
		while (isChange) {
			isChange = false;
			for (Nonterminal nonterm : rules.keySet()) {
				for (Rule rule : rules.get(nonterm)) {
					for (int i = 0; i < rule.size(); i++) {
						if (!rule.getTo(i).isTerm()) {
							Nonterminal b = (Nonterminal) rule.getTo(i);
							Set<Terminal> gammaFirst = genFirst(rule, i + 1);
							boolean isContainsEps = gammaFirst
									.remove(Terminal.EPS);
							int size = follow.get(b).size();
							follow.get(b).addAll(gammaFirst);
							if (isContainsEps || i + 1 == rule.size()) {
								follow.get(b).addAll(follow.get(nonterm));
							}
							if (size != follow.get(b).size()) {
								isChange = true;
							}
						}
					}
				}
			}
		}
		return follow;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Grammar name: " + grammarName + "\nNonterminals:");
		for (Nonterminal nonterm : rules.keySet()) {
			sb.append(" " + nonterm.get());
		}
		sb.append("\nTerminals:");
		for (Terminal term : terminals) {
			sb.append(" " + term.get());
		}
		sb.append("\nSkip: "
				+ (skipTerminal == null ? "" : skipTerminal.match()));
		sb.append("\nStart: " + start.toString() + "\n");
		for (Nonterminal nonterm : rules.keySet()) {
			for (Rule rule : rules.get(nonterm)) {
				sb.append(nonterm.toString() + " -> " + rule.toString() + "\n");
			}
		}

		return sb.toString();
	}
}
