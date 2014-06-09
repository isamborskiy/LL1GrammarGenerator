import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.samborskiy.elements.Terminal;

public class JavaGrammarLexer {
	private static final String TOKENS_FILE = "JavaGrammar.tokens";
	
	private StringBuilder input = new StringBuilder();
	private int curTokenNumber = 0;
	private List<String> tokens = new ArrayList<>();
	private List<Terminal> tokenToTerm = new ArrayList<>();
	private List<Terminal> terminals = new ArrayList<>();
	private Terminal skipTerminal;

	public JavaGrammarLexer(String fileName) throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line = "";
		while ((line = bf.readLine()) != null) {
			input.append(line);
		}
		bf.close();
		bf = new BufferedReader(new FileReader(TOKENS_FILE));
		boolean isSkip = false;
		while ((line = bf.readLine()) != null) {
			if (line.isEmpty()) {
				isSkip = true;
			} else {
				int tmp = line.indexOf(":");
				if (!isSkip) {
				if (!isSkip) {
					if (line.substring(tmp + 1).charAt(0) == '$' && line.charAt(line.length() - 1) == '$') {
						terminals.add(new Terminal(line.substring(0, tmp), line.substring(tmp + 2, line.length() - 1), false));
					} else {
						terminals.add(new Terminal(line.substring(0, tmp), line.substring(tmp + 1), true));
					}
				} else {
					skipTerminal = new Terminal(line.substring(0, tmp), line.substring(tmp + 1), false);
				}				} else {
					skipTerminal = new Terminal(line.substring(0, tmp), line.substring(tmp + 1), false);
				}
			}
		}
		bf.close();
		
		if (skipTerminal != null) {
			StringTokenizer st = new StringTokenizer(input.toString(), "[ \t\r\n]");
			while (st.hasMoreTokens()) {
				parse(st.nextToken());
			}
		} else {
			parse(input.toString());
		}
		
	}

	private void parse(String str) throws ParseException {
		Terminal curTerm = null;
		String cur = "";
		for (int i = 0; i < str.length(); i++) {
			if (cur.isEmpty()) {
				boolean find = false;
				for (Terminal term : terminals) {
					if (term.isConst()) {
						if (str.substring(i).startsWith(term.match())) {
							find = true;
							i += term.match().length() - 1;
							tokens.add(term.match());
							tokenToTerm.add(term);
							break;
						}
					}
				}
				if (find) {
					continue;
				}
			}
			cur += str.charAt(i);
			if (curTerm != null) {
				if (!cur.matches(curTerm.match())) {
					tokens.add(cur.substring(0, cur.length() - 1));
					tokenToTerm.add(curTerm);
					cur = "" + str.charAt(i);
					curTerm = null;
				}
			}
			if (curTerm == null) {
				for (Terminal term : terminals) {
					if (term.isConst() && cur.equals(term.match())) {
						tokens.add(cur);
						tokenToTerm.add(term);
						cur = "";
						break;
					}
					if (!term.isConst() && cur.matches(term.match())) {
						curTerm = term;
						break;
					}
				}
			}		}
		if (cur.isEmpty()) {
			return;
		}
		if (curTerm != null) {
			tokens.add(cur);
			tokenToTerm.add(curTerm);
		} else {
			throw new ParseException("Can not match string \"" + cur + "\"", input.length());
		}
	}

	public void nextToken() {
		curTokenNumber++;
	}
	
	public String curToken() {
		if (curTokenNumber >= tokens.size()) return "";
		return tokens.get(curTokenNumber);
	}
	
	public Terminal curTerminal() {
		if (curTokenNumber >= tokens.size()) return Terminal.EOF;
		return tokenToTerm.get(curTokenNumber);
	}
	
	public boolean hasNextToken() {
		return curTokenNumber < tokens.size();
	}
}
