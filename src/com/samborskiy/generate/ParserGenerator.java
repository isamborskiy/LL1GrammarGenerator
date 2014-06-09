package com.samborskiy.generate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.samborskiy.elements.Element;
import com.samborskiy.elements.Nonterminal;
import com.samborskiy.elements.Rule;
import com.samborskiy.elements.Terminal;

public class ParserGenerator {

	private static final String TAP3 = "\t\t\t";
	private static final String TAP4 = "\t\t\t\t";
	private static final String TAP5 = "\t\t\t\t\t";

	private static final String TERMINAL = TAP4
			+ "if (lex.curTerminal().get().equals(\"%s\")) {\n"
			+ TAP5
			+ "_%s = new TerminalTree(lex.curTerminal().get(), lex.curToken());\n"
			+ TAP4 + "} else {\n" + TAP5 + "throw new AssertionError();\n"
			+ TAP4 + "}\n" + TAP4 + "lex.nextToken();\n";
	private static final String NONTERMINAL = TAP4 + "_%s = new %s(%s);\n";
	private static final String EPS_TERMINAL = TAP4
			+ "_%s = new TerminalTree(\"EPS\", \"\");\n";

	public static void generate(String grammarName, Nonterminal start,
			Map<Nonterminal, List<Rule>> rules,
			Map<Nonterminal, Set<Terminal>> first,
			Map<Nonterminal, Set<Terminal>> follow, String headerCode)
			throws IOException {
		StringBuilder out = new StringBuilder();
		out.append(headerCode
				+ "\nimport java.io.IOException;\n"
				+ "import java.text.ParseException;\n"
				+ "\n"
				+ "import com.samborskiy.elements.Tree;\n"
				+ "import com.samborskiy.elements.TerminalTree;\n"
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
				+ "Parser(String inputFile"
				+ (start.getInher().isEmpty() ? "" : ", " + start.getInher())
				+ ") throws IOException, ParseException {\n"
				+ "\t\tlex = new "
				+ grammarName
				+ "Lexer(inputFile);\n"
				+ "\t\troot = new "
				+ start.get()
				+ "("
				+ (start.getInher().isEmpty() ? "" : start.getInher()
						.substring(start.getInher().indexOf(" ") + 1)) + ");\n"
				+ "\t}\n" + "\t\n" + "\tpublic Tree getTree() {\n"
				+ "\t\treturn root;\n" + "\t}\n\n");

		for (Nonterminal nonterm : rules.keySet()) {
			StringBuilder function = new StringBuilder(String.format(
					"\tpublic class %s extends Tree {%s\n\t\tpublic %s(%s) {\n"
							+ TAP3 + "node = \"%s\";\n", nonterm.get(), nonterm
							.getSynth().isEmpty() ? "" : "\n\t\tpublic "
							+ nonterm.getSynth() + ";", nonterm.get(), nonterm
							.getInher(), nonterm.get()));
			function.append(TAP3 + "switch(lex.curTerminal().get()) {\n");

			for (Rule rule : rules.get(nonterm)) {
				Element elem = rule.get(0);
				Set<Terminal> list = new HashSet<>();
				if (elem.isTerm()) {
					list.add((Terminal) elem);
				} else {
					list.addAll(first.get((Nonterminal) elem));
				}
				if (list.remove(Terminal.EPS)) {
					list.addAll(follow.get(nonterm));
				}

				for (Terminal term : list) {
					function.append(generateCase(nonterm, term, rule));
				}
			}

			function.append(TAP3 + "default:\n" + TAP4
					+ "throw new AssertionError();\n" + TAP3 + "}\n" + TAP3
					+ "\t\t}\n\t}\n\n");
			out.append(function);
		}
		out.append("}\n");
		PrintWriter pw = new PrintWriter(grammarName + "Parser.java");
		pw.print(out);
		pw.close();
	}

	private static final StringBuilder generateCase(Nonterminal nonterm,
			Terminal term, Rule rule) {
		StringBuilder c = new StringBuilder(String.format(TAP3
				+ "case \"%s\": {\n", term.get()));

		for (int i = 0; i < rule.size(); i++) {
			Element elem = rule.get(i);
			if (elem.isTerm()) {
				c.append(TAP4 + "Tree _" + i + " = null;\n");
				if (elem.equals(Terminal.EPS)) {
					c.append(String.format(EPS_TERMINAL, String.valueOf(i)));
				} else {
					c.append(String.format(TERMINAL, elem.get(),
							String.valueOf(i)));
				}
			} else {
				c.append(TAP4 + elem.get() + " _" + i + " = null;\n");
				c.append(String.format(NONTERMINAL, String.valueOf(i),
						elem.get(), ((Nonterminal) elem).getInher()));
			}
		}
		for (int i = 0; i < rule.size(); i++) {
			c.append(TAP4 + "children.add(_" + i + ");\n");
		}
		if (!rule.getTrans().isEmpty()) {
			String[] lines = rule.getTrans().split("\n");
			for (String line : lines) {
				c.append(TAP4 + line + "\n");
			}
		}
		return c.append(TAP4 + "}\n" + TAP4 + "break;\n");
	}
}
