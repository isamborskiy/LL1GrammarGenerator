import java.io.File;
import java.io.IOException;

import com.samborskiy.elements.Grammar;

public class Generator {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			throw new IllegalArgumentException(
					"Usage: <gramma file> <start nonterminal> <input file>");
		}
		if (!new File(args[0]).exists()) {
			throw new IOException("File " + args[0] + " does not exist");
		}
		Grammar grammar = new Grammar(args);
		System.out.println(grammar.toString());
		System.out.println(grammar.getFirst());
		System.out.println(grammar.getFollow());
		Lexer le = new Lexer("input");
		while(le.hasNextToken()) {
			System.out.println(le.curToken() + " --- " + le.curTerminal().get());
			le.nextToken();
		}
	}
}
