package com.samborskiy.elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Grammar {

	private class Rule {
		private Nonterminal from;
		private Element[] to;

		public Rule(Nonterminal from, Element... to) {
			assert (to.length > 0);
			this.from = from;
			this.to = to;
		}

		public Nonterminal getFrom() {
			return from;
		}

		public Element getTo(int index) {
			return to[index];
		}

		public int size() {
			return to.length;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(from.toString() + " ->");
			for (Element elem : to) {
				sb.append(" " + elem.get());
			}
			return sb.toString();
		}
	}

	private Map<Nonterminal, List<Rule>> rules = new HashMap<>();
	private Set<Nonterminal> nonterminals = new HashSet<>();
	private Set<Terminal> terminals = new HashSet<>();
	private Nonterminal start;

	public Grammar(File file) {
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			while (st.hasMoreTokens()) {
				nonterminals.add(new Nonterminal(st.nextToken()));
			}
			st = new StringTokenizer(bf.readLine(), " ");
			while (st.hasMoreTokens()) {
				terminals.add(new Terminal(st.nextToken()));
			}
			start = new Nonterminal(bf.readLine().replaceAll(" ", ""));

			String str = "";
			while ((str = bf.readLine()) != null) {
				st = new StringTokenizer(str, " ");
				Nonterminal from = new Nonterminal(st.nextToken());
				st.nextToken(); // skip ->
				List<Element> to = new ArrayList<>();
				while (st.hasMoreTokens()) {
					String value = st.nextToken();
					if (nonterminals.contains(new Nonterminal(value))) {
						to.add(new Nonterminal(value));
					} else {
						to.add(new Terminal(value));
					}
				}

				if (!rules.containsKey(from)) {
					rules.put(from, new ArrayList<>());
				}
				rules.get(from).add(
						new Rule(from, (Element[]) to.toArray(new Element[to
								.size()])));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// removeEpsRules();
		// removeLeftRecursive();
	}

	// private void removeLeftRecursive() {
	// Map<Nonterminal, List<Rule>> newRules = new HashMap<>();
	// for (Nonterminal nonterm : nonterminals) {
	// newRules.put(nonterm, new ArrayList<>());
	// List<Rule> ruleList = newRules.get(nonterm);
	//
	// List<Rule> recRules = new ArrayList<>();
	// List<Rule> otherRules = new ArrayList<>();
	// for (Rule rule : rules.get(nonterm)) {
	// if (rule.getTo(0).equals(nonterm)) {
	// recRules.add(rule);
	// } else {
	// otherRules.add(rule);
	// }
	// }
	// if (recRules.isEmpty()) {
	// Nonterminal newNonterm = new Nonterminal(nonterm.get() + "\'");
	// int n = otherRules.size();
	// } else {
	// ruleList.addAll(otherRules);
	// }
	//
	// }
	// }

	// private void removeEpsRules() {
	// Set<Nonterminal> epsNonterm = new HashSet<>();
	// for (Nonterminal nonterm : nonterminals) {
	// for (Rule rule : rules.get(nonterm)) {
	// if (rule.size() == 1 && rule.getTo(0).equals(Terminal.EPS)) {
	// epsNonterm.add(nonterm);
	// }
	// }
	// }
	//
	// int size = 0;
	// while (size != epsNonterm.size()) {
	// size = epsNonterm.size();
	// for (Nonterminal nonterm : nonterminals) {
	// if (epsNonterm.contains(nonterm)) {
	// continue;
	// }
	// for (Rule rule : rules.get(nonterm)) {
	// boolean isEpsNonterm = true;
	// for (int i = 0; i < rule.size(); i++) {
	// if (!epsNonterm.contains(rule.getTo(i))) {
	// isEpsNonterm = false;
	// break;
	// }
	// }
	// if (isEpsNonterm) {
	// epsNonterm.add(nonterm);
	// }
	// }
	// }
	// }
	//
	// Map<Nonterminal, List<Rule>> newRules = new HashMap<>();
	// for (Nonterminal nonterm : nonterminals) {
	// newRules.put(nonterm, new ArrayList<>());
	// List<Rule> ruleList = newRules.get(nonterm);
	// for (Rule rule : rules.get(nonterm)) {
	// if (rule.getTo(0).equals(Terminal.EPS) && rule.size() == 1) {
	// continue;
	// } else {
	// removeEpsNonterminal(ruleList, epsNonterm, rule, 0);
	// }
	// }
	// }
	//
	// if (epsNonterm.contains(start)) {
	// Nonterminal newStart = new Nonterminal(start.get() + "\'");
	// List<Rule> to = new ArrayList<>();
	// to.add(new Rule(newStart, Terminal.EPS));
	// to.add(new Rule(newStart, start));
	// newRules.put(newStart, to);
	// this.start = newStart;
	// this.rules = newRules;
	// nonterminals.add(newStart);
	// }
	// }
	//
	// private void removeEpsNonterminal(List<Rule> ruleList,
	// Set<Nonterminal> epsNonterm, Rule rule, int index) {
	// ruleList.add(rule);
	// Set<Integer> removedNonterm = new HashSet<>();
	// int size = -1;
	// while (size != removedNonterm.size()) {
	// size = removedNonterm.size();
	// List<Element> to = new ArrayList<>();
	// for (int i = 0; i < index; i++) {
	// to.add(rule.getTo(i));
	// }
	// boolean isFind = false;
	// int j = 0;
	// for (int i = index; i < rule.size(); i++) {
	// if (!isFind && !removedNonterm.contains(i)
	// && epsNonterm.contains(rule.getTo(i))) {
	// removedNonterm.add(i);
	// j = i;
	// isFind = true;
	// } else {
	// to.add(rule.getTo(i));
	// }
	// }
	// Rule newRule = new Rule(rule.getFrom(),
	// (Element[]) to.toArray(new Element[to.size()]));
	// if (to.size() != rule.size() && to.size() != 0) {
	// removeEpsNonterminal(ruleList, epsNonterm, newRule, j);
	// }
	// }
	// }

	public boolean contains(Terminal term) {
		return terminals.contains(term);
	}

	private Map<Nonterminal, Set<Terminal>> first = null;

	public Map<Nonterminal, Set<Terminal>> getFirst() {
		if (first == null) {
			first = new HashMap<>();
			for (Nonterminal nonterm : nonterminals) {
				first.put(nonterm, new HashSet<Terminal>());
			}
			boolean isChange = true;
			while (isChange) {
				isChange = false;
				for (Nonterminal nonterm : nonterminals) {
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
		for (Nonterminal nonterm : nonterminals) {
			follow.put(nonterm, new HashSet<Terminal>());
		}
		getFirst();
		follow.get(start).add(Terminal.END);
		boolean isChange = true;
		while (isChange) {
			isChange = false;
			for (Nonterminal nonterm : nonterminals) {
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
