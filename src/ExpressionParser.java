
import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;
import com.samborskiy.elements.TerminalTree;

public class ExpressionParser {
	private ExpressionLexer lex;
	private Tree root;
	
	public ExpressionParser(String inputFile) throws IOException, ParseException {
		lex = new ExpressionLexer(inputFile);
		root = new e();
	}
	
	public Tree getTree() {
		return root;
	}

	public class t extends Tree {
		public t() {
			node = "t";
			switch(lex.curTerminal().get()) {
			case "LEFT": {
				f _0 = null;
				_0 = new f();
				ts _1 = null;
				_1 = new ts();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "N": {
				f _0 = null;
				_0 = new f();
				ts _1 = null;
				_1 = new ts();
				children.add(_0);
				children.add(_1);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class e extends Tree {
		public e() {
			node = "e";
			switch(lex.curTerminal().get()) {
			case "LEFT": {
				t _0 = null;
				_0 = new t();
				es _1 = null;
				_1 = new es();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "N": {
				t _0 = null;
				_0 = new t();
				es _1 = null;
				_1 = new es();
				children.add(_0);
				children.add(_1);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class f extends Tree {
		public f() {
			node = "f";
			switch(lex.curTerminal().get()) {
			case "N": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("N")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "LEFT": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				e _1 = null;
				_1 = new e();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class es extends Tree {
		public es() {
			node = "es";
			switch(lex.curTerminal().get()) {
			case "PLUS": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PLUS")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				t _1 = null;
				_1 = new t();
				es _2 = null;
				_2 = new es();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			case "RIGHT": {
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

	public class ts extends Tree {
		public ts() {
			node = "ts";
			switch(lex.curTerminal().get()) {
			case "MUL": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("MUL")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				f _1 = null;
				_1 = new f();
				ts _2 = null;
				_2 = new ts();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "EOF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			case "PLUS": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				}
				break;
			case "RIGHT": {
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
