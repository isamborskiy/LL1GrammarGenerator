import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;


public class Parser {
	private Lexer lex;
	private Tree root;
	
	public Parser(String grammarName, String inputFile) throws IOException, ParseException {
		lex = new Lexer(inputFile);
		root = parse();
	}
	
	private Tree parse() {
		return s();
	}
	
	private Tree s() {
		return null;
	}
}
