import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = new s().parse();
	}
	
	public Tree getTree() {
		return root;
	}

	private class s {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "NOT":
				_0 = new e().parse();
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("s", "", _0, _1);
				break;
			case "V":
				_0 = new e().parse();
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("s", "", _0, _1);
				break;
			case "LEFT":
				_0 = new e().parse();
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("s", "", _0, _1);
				break;
			case "EOF":
				_0 = new Tree("EPS", "");
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("s", "", _0, _1);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class t {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "NOT":
				_0 = new f().parse();
				_1 = new ts().parse();
				res = new Tree("t", "", _0, _1);
				break;
			case "V":
				_0 = new f().parse();
				_1 = new ts().parse();
				res = new Tree("t", "", _0, _1);
				break;
			case "LEFT":
				_0 = new f().parse();
				_1 = new ts().parse();
				res = new Tree("t", "", _0, _1);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class e {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "NOT":
				_0 = new t().parse();
				_1 = new es().parse();
				res = new Tree("e", "", _0, _1);
				break;
			case "V":
				_0 = new t().parse();
				_1 = new es().parse();
				res = new Tree("e", "", _0, _1);
				break;
			case "LEFT":
				_0 = new t().parse();
				_1 = new es().parse();
				res = new Tree("e", "", _0, _1);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class f {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null, _2 = null;
			switch(lex.curTerminal().get()) {
			case "NOT":
				if (lex.curTerminal().get().equals("NOT")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new f().parse();
				res = new Tree("f", "", _0, _1);
				break;
			case "V":
				if (lex.curTerminal().get().equals("V")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("f", "", _0);
				break;
			case "LEFT":
				if (lex.curTerminal().get().equals("LEFT")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new e().parse();
				if (lex.curTerminal().get().equals("RIGHT")) {
					_2 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("f", "", _0, _1, _2);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class es {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null, _2 = null;
			switch(lex.curTerminal().get()) {
			case "OR":
				if (lex.curTerminal().get().equals("OR")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new t().parse();
				_2 = new es().parse();
				res = new Tree("es", "", _0, _1, _2);
				break;
			case "XOR":
				if (lex.curTerminal().get().equals("XOR")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new t().parse();
				_2 = new es().parse();
				res = new Tree("es", "", _0, _1, _2);
				break;
			case "EOF":
				_0 = new Tree("EPS", "");
				res = new Tree("es", "", _0);
				break;
			case "RIGHT":
				_0 = new Tree("EPS", "");
				res = new Tree("es", "", _0);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class ts {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null, _2 = null;
			switch(lex.curTerminal().get()) {
			case "AND":
				if (lex.curTerminal().get().equals("AND")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new f().parse();
				_2 = new ts().parse();
				res = new Tree("ts", "", _0, _1, _2);
				break;
			case "OR":
				_0 = new Tree("EPS", "");
				res = new Tree("ts", "", _0);
				break;
			case "EOF":
				_0 = new Tree("EPS", "");
				res = new Tree("ts", "", _0);
				break;
			case "XOR":
				_0 = new Tree("EPS", "");
				res = new Tree("ts", "", _0);
				break;
			case "RIGHT":
				_0 = new Tree("EPS", "");
				res = new Tree("ts", "", _0);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

}
