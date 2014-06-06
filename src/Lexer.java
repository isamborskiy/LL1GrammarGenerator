import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.samborskiy.elements.Grammar;
import com.samborskiy.elements.Terminal;

public class Lexer {
	private StringBuilder input;
	private int curPos = 0;
	private List<String> tokens = new ArrayList<>();
	private Set<Terminal> terminals;

	public Lexer(String fileName, Grammar grammar) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line = "";
		while ((line = bf.readLine()) != null) {
			input.append(line);
		}
		terminals = grammar.getTerminals();
	}
	
	private void parse() {
		
	}

	public String nextToken() {
		return tokens.get(curPos++);
	}
}
