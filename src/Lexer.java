import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.samborskiy.elements.Terminal;

public class Lexer {
	private static final String TOKENS_FILE = "Postfix.tokens";
	
	private StringBuilder input = new StringBuilder();
	private int curTokenNumber = 0;
	private List<String> tokens = new ArrayList<>();
	private List<Terminal> tokenToTerm = new ArrayList<>();
	private List<Terminal> terminals = new ArrayList<>();
	private Terminal skipTerminal;

	public Lexer(String fileName) throws IOException, ParseException {
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
					terminals.add(new Terminal(line.substring(0, tmp), line.substring(tmp + 1)));
				} else {
					skipTerminal = new Terminal(line.substring(0, tmp), line.substring(tmp + 1));
				}
			}
		}
		bf.close();
		
		if (skipTerminal != null) {
			StringTokenizer st = new StringTokenizer(input.toString(), skipTerminal.match());
			while (st.hasMoreTokens()) {
				parse(st.nextToken());
			}
		} else {
			parse(input.toString());
		}
		
		tokens.add("");
		tokenToTerm.add(Terminal.EOF);
	}

	private void parse(String str) throws ParseException {
		Terminal curTerm = null;
		String cur = "";
		for (int i = 0; i < str.length(); i++) {
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
					if (cur.matches(term.match())) {
						curTerm = term;
						break;
					}
				}
			}
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
		return tokens.get(curTokenNumber);
	}
	
	public Terminal curTerminal() {
		return tokenToTerm.get(curTokenNumber);
	}
	
	public boolean hasNextToken() {
		return curTokenNumber < tokens.size();
	}
}
