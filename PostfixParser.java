
import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile, int i) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = new decl().parse(i);
	}
	
	public Tree getTree() {
		return root;
	}

	private class next {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "SEMICOLON":
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("next", "", _0);
				break;
			case "COMMA":
				if (lex.curTerminal().get().equals("COMMA")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new var().parse();
				res = new Tree("next", "", _0, _1);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class amp {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null;
			switch(lex.curTerminal().get()) {
			case "STAR":
				_0 = new Tree("EPS", "");
				res = new Tree("amp", "", _0);
				break;
			case "NAME":
				_0 = new Tree("EPS", "");
				res = new Tree("amp", "", _0);
				break;
			case "AND":
				if (lex.curTerminal().get().equals("AND")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("amp", "", _0);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class decl {
		public Tree parse(int i) {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "EOF":
				_0 = new Tree("EPS", "");
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("decl", "", _0, _1);
				break;
			case "BOOL":
				_0 = new block().parse();
				_1 = new decl().parse(i);
				res = new Tree("decl", "", _0, _1);
				{
						System.out.println("BLABLABLA " + i);
					}
				break;
			case "LONG":
				_0 = new block().parse();
				_1 = new decl().parse(i);
				res = new Tree("decl", "", _0, _1);
				{
						System.out.println("BLABLABLA " + i);
					}
				break;
			case "CHAR":
				_0 = new block().parse();
				_1 = new decl().parse(i);
				res = new Tree("decl", "", _0, _1);
				{
						System.out.println("BLABLABLA " + i);
					}
				break;
			case "INT":
				_0 = new block().parse();
				_1 = new decl().parse(i);
				res = new Tree("decl", "", _0, _1);
				{
						System.out.println("BLABLABLA " + i);
					}
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class var {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null;
			switch(lex.curTerminal().get()) {
			case "STAR":
				if (lex.curTerminal().get().equals("STAR")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new var().parse();
				res = new Tree("var", "", _0, _1);
				break;
			case "NAME":
				if (lex.curTerminal().get().equals("NAME")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				_1 = new next().parse();
				res = new Tree("var", "", _0, _1);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class block {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null, _1 = null, _2 = null;
			switch(lex.curTerminal().get()) {
			case "BOOL":
				_0 = new type().parse();
				_1 = new amp().parse();
				_2 = new var().parse();
				res = new Tree("block", "", _0, _1, _2);
				break;
			case "LONG":
				_0 = new type().parse();
				_1 = new amp().parse();
				_2 = new var().parse();
				res = new Tree("block", "", _0, _1, _2);
				break;
			case "CHAR":
				_0 = new type().parse();
				_1 = new amp().parse();
				_2 = new var().parse();
				res = new Tree("block", "", _0, _1, _2);
				break;
			case "INT":
				_0 = new type().parse();
				_1 = new amp().parse();
				_2 = new var().parse();
				res = new Tree("block", "", _0, _1, _2);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

	private class type {
		public Tree parse() {
			Tree res = null;
			Tree _0 = null;
			switch(lex.curTerminal().get()) {
			case "BOOL":
				if (lex.curTerminal().get().equals("BOOL")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("type", "", _0);
				break;
			case "INT":
				if (lex.curTerminal().get().equals("INT")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("type", "", _0);
				break;
			case "LONG":
				if (lex.curTerminal().get().equals("LONG")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("type", "", _0);
				break;
			case "CHAR":
				if (lex.curTerminal().get().equals("CHAR")) {
					_0 = new Tree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				res = new Tree("type", "", _0);
				break;
			default:
				throw new AssertionError();
			}
			return res;
		}
	}

}
