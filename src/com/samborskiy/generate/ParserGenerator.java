package com.samborskiy.generate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.samborskiy.elements.Element;
import com.samborskiy.elements.Nonterminal;
import com.samborskiy.elements.Rule;
import com.samborskiy.elements.Terminal;

public class ParserGenerator {

	private static final String TAP2 = "\t\t";
	private static final String TAP3 = "\t\t\t";
	private static final String TAP4 = "\t\t\t\t";

	private static final String TERMINAL = TAP3
			+ "if (lex.curTerminal().get().equals(\"%s\")) {\n"
			+ TAP4
			+ "_%s = new Tree(lex.curToken() + \"(\" + lex.curTerminal().get() + \")\");\n"
			+ TAP3 + "} else {\n" + TAP4 + "throw new AssertionError();\n"
			+ TAP3 + "}\n" + TAP3 + "lex.nextToken();\n";
	private static final String NONTERMINAL = TAP3 + "_%s = %s();\n";
	private static final String EPS_TERMINAL = TAP3
			+ "_%s = new Tree(\"(EPS)\");\n";

	public static void generate(String grammarName, String start,
			Map<Nonterminal, List<Rule>> rules,
			Map<Nonterminal, Set<Terminal>> first,
			Map<Nonterminal, Set<Terminal>> follow) throws IOException {
		StringBuilder out = new StringBuilder();
		out.append("import java.io.IOException;\n"
				+ "import java.text.ParseException;\n"
				+ "\n"
				+ "import com.samborskiy.elements.Tree;\n"
				+ "\n"
				+ "public class "
				+ grammarName
				+ "Parser {\n"
				+ "\tprivate "
				+ grammarName
				+ "Lexer lex;\n"
				+ "\tprivate Tree root;\n"
				+ "\t\n"
				+ "\tpublic "
				+ grammarName
				+ "Parser(String inputFile) throws IOException, ParseException {\n"
				+ "\t\tlex = new " + grammarName + "Lexer(inputFile);\n"
				+ "\t\troot = " + start + "();\n" + "\t}\n" + "\t\n"
				+ "\tpublic Tree getTree() {\n" + "\t\treturn root;\n"
				+ "\t}\n\n");

		for (Nonterminal nonterm : rules.keySet()) {
			StringBuilder function = new StringBuilder("\tprivate Tree "
					+ nonterm.get() + "() {\n");
			function.append(TAP2 + "Tree res = null;\n");
			int max = -1;
			for (Rule rule : rules.get(nonterm)) {
				if (rule.size() > max) {
					max = rule.size();
				}
			}
			function.append(TAP2 + "Tree ");
			for (int i = 0; i < max; i++) {
				function.append("_" + i + " = null"
						+ (i + 1 < max ? ", " : ";\n"));
			}
			function.append(TAP2 + "switch(lex.curTerminal().get()) {\n");

			List<Terminal> cases = new ArrayList<>();
			List<Rule> caseRules = new ArrayList<>();
			Rule epsRule = null;
			for (Terminal term : first.get(nonterm)) {
				cases.add(term);
				if (!term.equals(Terminal.EPS)) {
					for (Rule rule : rules.get(nonterm)) {
						if (rule.get(0).equals(term)) {
							caseRules.add(rule);
							break;
						}
					}
				} else {
					for (Rule rule : rules.get(nonterm)) {
						if (rule.get(0).equals(term)) {
							epsRule = rule;
							break;
						}
					}
				}
			}
			if (cases.remove(Terminal.EPS)) {
				for (Terminal term : follow.get(nonterm)) {
					cases.add(term);
					caseRules.add(epsRule);
				}
			}

			for (int i = 0; i < cases.size(); i++) {
				function.append(generateCase(nonterm, cases.get(i),
						caseRules.get(i)));
			}

			function.append(TAP2 + "default:\n" + TAP3
					+ "throw new AssertionError();\n" + TAP2 + "}\n" + TAP2
					+ "return res;\n" + "\t}\n\n");
			out.append(function);
		}
		out.append("}\n");
		PrintWriter pw = new PrintWriter(grammarName + "Parser.java");
		pw.print(out);
		pw.close();
	}

	private static final StringBuilder generateCase(Nonterminal nonterm,
			Terminal term, Rule rule) {
		StringBuilder c = new StringBuilder(String.format(TAP2
				+ "case \"%s\":\n", term.get()));
		for (int i = 0; i < rule.size(); i++) {
			Element elem = rule.get(i);
			if (elem.isTerm()) {
				if (elem.equals(Terminal.EPS)) {
					c.append(String.format(EPS_TERMINAL, String.valueOf(i)));
				} else {
					c.append(String.format(TERMINAL, elem.get(),
							String.valueOf(i)));
				}
			} else {
				c.append(String.format(NONTERMINAL, String.valueOf(i),
						elem.get()));
			}
		}
		c.append(String.format(TAP3 + "res = new Tree(\"%s\"", nonterm.get()));
		for (int i = 0; i < rule.size(); i++) {
			c.append(String.format(", _%s", String.valueOf(i)));
		}
		return c.append(");\n" + TAP3 + "break;\n");
	}
}
