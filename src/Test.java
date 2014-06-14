import com.samborskiy.elements.Grammar;

public class Test {
	public static void main(String[] args) throws Exception {
//		new Grammar("JavaGrammar", "prog");
//		JavaGrammarParser parser = new JavaGrammarParser("input");
//		parser.getTree().show();
//		new Grammar("Postfix", "s");
		PostfixParser parser = new PostfixParser("input2");
		parser.getTree().show();
	}
}
