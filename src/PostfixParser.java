
import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;
import com.samborskiy.elements.TerminalTree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = new s();
	}
	
	public Tree getTree() {
		return root;
	}

	public class a extends Tree {
		public a() {
			node = "a";
			switch(lex.curTerminal().get()) {
			case "N": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("N")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("N expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				a _1 = null;
				_1 = new a();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("SIGN")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SIGN expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				a _3 = null;
				_3 = new a();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				}
				break;
			case "SIGN": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class s extends Tree {
		public s() {
			node = "s";
			switch(lex.curTerminal().get()) {
			case "N": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("N")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("N expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				a _1 = null;
				_1 = new a();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

}
