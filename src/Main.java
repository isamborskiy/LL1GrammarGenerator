import com.samborskiy.elements.Grammar;

public class Main {

	public static void main(String[] args) throws Exception {
		Grammar grammar = new Grammar(args);
//		System.out.print(grammar.toString());
		Lexer le = new  Lexer(args[2], grammar);
	}
}
