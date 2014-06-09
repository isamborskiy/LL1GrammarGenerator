
public class Test {
	public static void main(String[] args) throws Exception {
//		Generator.main(new String[] { "Expression", "e" });
		ExpressionParser parser = new ExpressionParser("input");
		parser.getTree().show();
	}
}
