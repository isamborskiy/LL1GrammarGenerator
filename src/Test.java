public class Test {
	public static void main(String[] args) throws Exception {
		Generator.main(new String[] { "Postfix", "decl" });
		PostfixParser parser = new PostfixParser("input");
		parser.getTree().show();
	}
}
