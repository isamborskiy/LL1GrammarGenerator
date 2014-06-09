
public class Test {
	public static void main(String[] args) throws Exception {
		Generator.main(new String[] { "JavaGrammar", "prog" });
		JavaGrammarParser parser = new JavaGrammarParser("input");
		parser.getTree().show();
	}
}
