public class Test {
	public static void main(String[] args) throws Exception {
		Generator.main(new String[] { "Postfix", "s" });
		PostfixParser parser = new PostfixParser("input", 1);
		parser.getTree().show();
	}
}
