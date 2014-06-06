import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.samborskiy.elements.Grammar;
import com.samborskiy.elements.Terminal;

public class Lexer {
	private StringBuilder input = new StringBuilder();
	private int curTokenNumber = 0;
	private List<String> tokens = new ArrayList<>();
	private Grammar grammar;

	public Lexer(String fileName, Grammar grammar) throws IOException,
			ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line = "";
		while ((line = bf.readLine()) != null) {
			input.append(line);
		}
		this.grammar = grammar;

		if (grammar.skipTerminal != null) {
			StringTokenizer st = new StringTokenizer(input.toString(),
					grammar.skipTerminal.match());
			while (st.hasMoreTokens()) {
				parse(st.nextToken());
			}
		} else {
			parse(input.toString());
		}

		for (String token : tokens) {
			System.out.println(token);
		}
	}

	private void parse(String str) throws ParseException {
		Terminal curTerm = null;
		String cur = "";
		for (int i = 0; i < str.length(); i++) {
			cur += str.charAt(i);
			if (curTerm != null) {
				if (!cur.matches(curTerm.match())) {
					tokens.add(cur.substring(0, cur.length() - 1));
					cur = "" + str.charAt(i);
					curTerm = null;
				}
			}
			if (curTerm == null) {
				for (Terminal term : grammar.terminals) {
					if (cur.matches(term.match())) {
						curTerm = term;
						break;
					}
				}
			}
		}
		if (curTerm != null) {
			tokens.add(cur);
		} else {
			throw new ParseException("Can not match string \"" + cur + "\"", input.length());
		}
	}

	public String nextToken() {
		return tokens.get(curTokenNumber++);
	}
}
