package com.samborskiy.generate;

import java.io.IOException;
import java.io.PrintWriter;

import com.samborskiy.elements.Terminal;

public class LexerGenerator {
	public static void generate(String grammarName, Terminal skipTerminal)
			throws IOException {
		String out = String
				.format("import java.io.BufferedReader;\n"
						+ "import java.io.FileReader;\n"
						+ "import java.io.IOException;\n"
						+ "import java.text.ParseException;\n"
						+ "import java.util.ArrayList;\n"
						+ "import java.util.List;\n"
						+ "import java.util.StringTokenizer;\n"
						+ "\n"
						+ "import com.samborskiy.elements.Terminal;\n"
						+ "\n"
						+ "public class %sLexer {\n"
						+ "\tprivate static final String TOKENS_FILE = \"%s.tokens\";\n"
						+ "\t\n"
						+ "\tprivate StringBuilder input = new StringBuilder();\n"
						+ "\tprivate int curTokenNumber = 0;\n"
						+ "\tprivate List<String> tokens = new ArrayList<>();\n"
						+ "\tprivate List<Terminal> tokenToTerm = new ArrayList<>();\n"
						+ "\tprivate List<Terminal> terminals = new ArrayList<>();\n"
						+ "\tprivate Terminal skipTerminal;\n"
						+ "\n"
						+ "\tpublic %sLexer(String fileName) throws IOException, ParseException {\n"
						+ "\t\tBufferedReader bf = new BufferedReader(new FileReader(fileName));\n"
						+ "\t\tString line = \"\";\n"
						+ "\t\twhile ((line = bf.readLine()) != null) {\n"
						+ "\t\t\tinput.append(line);\n"
						+ "\t\t}\n"
						+ "\t\tbf.close();\n"
						+ "\t\tbf = new BufferedReader(new FileReader(TOKENS_FILE));\n"
						+ "\t\tboolean isSkip = false;\n"
						+ "\t\twhile ((line = bf.readLine()) != null) {\n"
						+ "\t\t\tif (line.isEmpty()) {\n"
						+ "\t\t\t\tisSkip = true;\n"
						+ "\t\t\t} else {\n"
						+ "\t\t\t\tint tmp = line.indexOf(\":\");\n"
						+ "\t\t\t\tif (!isSkip) {\n"
						+ "\t\t\t\t\tterminals.add(new Terminal(line.substring(0, tmp), line.substring(tmp + 1), line.substring(tmp + 1).charAt(0) != '['));\n"
						+ "\t\t\t\t} else {\n"
						+ "\t\t\t\t\tskipTerminal = new Terminal(line.substring(0, tmp), line.substring(tmp + 1), false);\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t}\n"
						+ "\t\t}\n"
						+ "\t\tbf.close();\n"
						+ "\t\t\n"
						+ "\t\tif (skipTerminal != null) {\n"
						+ "\t\t\tStringTokenizer st = new StringTokenizer(input.toString(), \"[ \\t\\r\\n]\");\n"
						+ "\t\t\twhile (st.hasMoreTokens()) {\n"
						+ "\t\t\t\tparse(st.nextToken());\n"
						+ "\t\t\t}\n"
						+ "\t\t} else {\n"
						+ "\t\t\tparse(input.toString());\n"
						+ "\t\t}\n"
						+ "\t\t\n"
						+ "\t}\n"
						+ "\n"
						+ "\tprivate void parse(String str) throws ParseException {\n"
						+ "\t\tTerminal curTerm = null;\n"
						+ "\t\tString cur = \"\";\n"
						+ "\t\tfor (int i = 0; i < str.length(); i++) {\n"
						+ "\t\t\tif (cur.isEmpty()) {\n"
						+ "\t\t\t\tboolean find = false;\n"
						+ "\t\t\t\tfor (Terminal term : terminals) {\n"
						+ "\t\t\t\t\tif (term.isConst()) {\n"
						+ "\t\t\t\t\t\tif (str.substring(i).startsWith(term.match())) {\n"
						+ "\t\t\t\t\t\t\tfind = true;\n"
						+ "\t\t\t\t\t\t\ti += term.match().length() - 1;\n"
						+ "\t\t\t\t\t\t\ttokens.add(term.match());\n"
						+ "\t\t\t\t\t\t\ttokenToTerm.add(term);\n"
						+ "\t\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t\t}\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t\tif (find) {\n"
						+ "\t\t\t\t\tcontinue;\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t}\n"
						+ "\t\t\tcur += str.charAt(i);\n"
						+ "\t\t\tif (curTerm != null) {\n"
						+ "\t\t\t\tif (!cur.matches(curTerm.match())) {\n"
						+ "\t\t\t\t\ttokens.add(cur.substring(0, cur.length() - 1));\n"
						+ "\t\t\t\t\ttokenToTerm.add(curTerm);\n"
						+ "\t\t\t\t\tcur = \"\" + str.charAt(i);\n"
						+ "\t\t\t\t\tcurTerm = null;\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t}\n"
						+ "\t\t\tif (curTerm == null) {\n"
						+ "\t\t\t\tfor (Terminal term : terminals) {\n"
						+ "\t\t\t\t\tif (term.isConst() && cur.equals(term.match())) {\n"
						+ "\t\t\t\t\t\ttokens.add(cur);\n"
						+ "\t\t\t\t\t\ttokenToTerm.add(term);\n"
						+ "\t\t\t\t\t\tcur = \"\";\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t\tif (!term.isConst() && cur.matches(term.match())) {\n"
						+ "\t\t\t\t\t\tcurTerm = term;\n"
						+ "\t\t\t\t\t\tbreak;\n"
						+ "\t\t\t\t\t}\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t}"
						+ "\t\t}\n"
						+ "\t\tif (cur.isEmpty()) {\n"
						+ "\t\t\treturn;\n"
						+ "\t\t}\n"
						+ "\t\tif (curTerm != null) {\n"
						+ "\t\t\ttokens.add(cur);\n"
						+ "\t\t\ttokenToTerm.add(curTerm);\n"
						+ "\t\t} else {\n"
						+ "\t\t\tthrow new ParseException(\"Can not match string \\\"\" + cur + \"\\\"\", input.length());\n"
						+ "\t\t}\n"
						+ "\t}\n"
						+ "\n"
						+ "\tpublic void nextToken() {\n"
						+ "\t\tcurTokenNumber++;\n"
						+ "\t}\n"
						+ "\t\n"
						+ "\tpublic String curToken() {\n"
						+ "\t\tif (curTokenNumber >= tokens.size()) return \"\";\n"
						+ "\t\treturn tokens.get(curTokenNumber);\n"
						+ "\t}\n"
						+ "\t\n"
						+ "\tpublic Terminal curTerminal() {\n"
						+ "\t\tif (curTokenNumber >= tokens.size()) return Terminal.EOF;\n"
						+ "\t\treturn tokenToTerm.get(curTokenNumber);\n"
						+ "\t}\n" + "\t\n"
						+ "\tpublic boolean hasNextToken() {\n"
						+ "\t\treturn curTokenNumber < tokens.size();\n"
						+ "\t}\n" + "}\n", grammarName, grammarName,
						grammarName);
		PrintWriter pw = new PrintWriter(grammarName + "Lexer.java");
		pw.print(out);
		pw.close();
	}
}
