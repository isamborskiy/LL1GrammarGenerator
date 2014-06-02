package com.samborskiy.elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;

import com.samborskiy.antlr.GrammarLexer;
import com.samborskiy.antlr.GrammarParser;

public class Grammar {

	private Map<Nonterminal, List<Rule>> rules = new HashMap<>();
	private Set<Nonterminal> nonterminals = new HashSet<>();
	private Set<Terminal> terminals = new HashSet<>();
	private Nonterminal start;

	public Grammar(String fileName) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream(fileName);
		GrammarLexer lexer = new GrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		RuleContext tree = parser.gram();
		tree.inspect(parser);

		for (Terminal term : parser.terminals) {
			System.out.println(term.get() + "---" + term.match());
		}
		System.out.println("---------");
		for (Nonterminal nonterm : parser.grammaRules.keySet()) {
			for (Rule rule : parser.grammaRules.get(nonterm)) {
				System.out.println(nonterm.get() + "---" + rule.toString());
			}
		}

		// try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
		// StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		// while (st.hasMoreTokens()) {
		// nonterminals.add(new Nonterminal(st.nextToken()));
		// }
		// st = new StringTokenizer(bf.readLine(), " ");
		// while (st.hasMoreTokens()) {
		// terminals.add(new Terminal(st.nextToken()));
		// }
		// start = new Nonterminal(bf.readLine().replaceAll(" ", ""));
		//
		// String str = "";
		// while ((str = bf.readLine()) != null) {
		// st = new StringTokenizer(str, " ");
		// Nonterminal from = new Nonterminal(st.nextToken());
		// st.nextToken(); // skip ->
		// List<Element> to = new ArrayList<>();
		// while (st.hasMoreTokens()) {
		// String value = st.nextToken();
		// if (nonterminals.contains(new Nonterminal(value))) {
		// to.add(new Nonterminal(value));
		// } else {
		// to.add(new Terminal(value));
		// }
		// }
		//
		// if (!rules.containsKey(from)) {
		// rules.put(from, new ArrayList<>());
		// }
		// rules.get(from).add(
		// new Rule(from, (Element[]) to.toArray(new Element[to
		// .size()])));
		// }
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	// public boolean contains(Terminal term) {
	// return terminals.contains(term);
	// }
	//
	// private Map<Nonterminal, Set<Terminal>> first = null;
	//
	// public Map<Nonterminal, Set<Terminal>> getFirst() {
	// if (first == null) {
	// first = new HashMap<>();
	// for (Nonterminal nonterm : nonterminals) {
	// first.put(nonterm, new HashSet<Terminal>());
	// }
	// boolean isChange = true;
	// while (isChange) {
	// isChange = false;
	// for (Nonterminal nonterm : nonterminals) {
	// int size = first.get(nonterm).size();
	// for (Rule rule : rules.get(nonterm)) {
	// if (rule.getTo(0).isTerm()) {
	// first.get(nonterm).add((Terminal) rule.getTo(0));
	// } else {
	// first.get(nonterm).addAll(genFirst(rule, 0));
	// }
	// }
	// if (first.get(nonterm).size() != size) {
	// isChange = true;
	// }
	// }
	// }
	// }
	// return first;
	// }
	//
	// private Set<Terminal> genFirst(Rule rule, int index) {
	// Set<Terminal> res = new HashSet<>();
	// if (rule.size() == index) {
	// return res;
	// }
	//
	// if (!rule.getTo(index).isTerm()) {
	// res.addAll(first.get(rule.getTo(index)));
	// if (res.contains(Terminal.EPS)) {
	// res.addAll(genFirst(rule, index + 1));
	// }
	// } else {
	// res.add((Terminal) rule.getTo(index));
	// }
	//
	// return res;
	// }
	//
	// private Map<Nonterminal, Set<Terminal>> follow = null;
	//
	// public Map<Nonterminal, Set<Terminal>> getFollow() {
	// follow = new HashMap<>();
	// for (Nonterminal nonterm : nonterminals) {
	// follow.put(nonterm, new HashSet<Terminal>());
	// }
	// getFirst();
	// follow.get(start).add(Terminal.END);
	// boolean isChange = true;
	// while (isChange) {
	// isChange = false;
	// for (Nonterminal nonterm : nonterminals) {
	// for (Rule rule : rules.get(nonterm)) {
	// for (int i = 0; i < rule.size(); i++) {
	// if (!rule.getTo(i).isTerm()) {
	// Nonterminal b = (Nonterminal) rule.getTo(i);
	// Set<Terminal> gammaFirst = genFirst(rule, i + 1);
	// boolean isContainsEps = gammaFirst
	// .remove(Terminal.EPS);
	// int size = follow.get(b).size();
	// follow.get(b).addAll(gammaFirst);
	// if (isContainsEps || i + 1 == rule.size()) {
	// follow.get(b).addAll(follow.get(nonterm));
	// }
	// if (size != follow.get(b).size()) {
	// isChange = true;
	// }
	// }
	// }
	// }
	// }
	// }
	// return follow;
	// }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Nonterminals:");
		for (Nonterminal nonterm : nonterminals) {
			sb.append(" " + nonterm.get());
		}
		sb.append("\nTerminals:");
		for (Terminal term : terminals) {
			sb.append(" " + term.get());
		}
		sb.append("\nStart: " + start.toString() + "\n");
		for (Nonterminal nonterm : nonterminals) {
			for (Rule rule : rules.get(nonterm)) {
				sb.append(rule.toString() + "\n");
			}
		}

		return sb.toString();
	}
}
