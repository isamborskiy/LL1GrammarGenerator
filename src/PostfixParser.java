
import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;
import com.samborskiy.elements.TerminalTree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile, int i) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = new s(i);
	}
	
	public Tree getTree() {
		return root;
	}

	public class a extends Tree {
		public String val;
		public a() {
			node = "a";
			switch(lex.curTerminal().get()) {
			case "N": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("N")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				a _1 = null;
				_1 = new a();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("SIGN")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				a _3 = null;
				_3 = new a();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				{val = _0.text + _1.val + _2.text + _3.val;}
				}
				break;
			case "SIGN": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "";}
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class s extends Tree {
		public s(int i) {
			node = "s";
			switch(lex.curTerminal().get()) {
			case "N": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("N")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				a _1 = null;
				_1 = new a();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{System.out.println(_0.text + _1.val);}
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{System.out.println("EMPTY INPUT");}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

}
