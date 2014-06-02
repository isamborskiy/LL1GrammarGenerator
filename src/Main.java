
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;

public class Main {

	private static final String FILE_NAME = "grammar";

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream(FILE_NAME);
		GrammarLexer lexer = new GrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		RuleContext tree = parser.gram();
		tree.inspect(parser);
		System.out.println(tree.toStringTree(parser));
	}
}
