import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = s();
	}
	
	public Tree getTree() {
		return root;
	}

	private Tree s() {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = e();
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		case "V":
			_0 = e();
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		case "LEFT":
			_0 = e();
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		case "EOF":
			_0 = new Tree("(EPS)");
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree t() {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = f();
			_1 = ts();
			res = new Tree("t", _0, _1);
			break;
		case "V":
			_0 = f();
			_1 = ts();
			res = new Tree("t", _0, _1);
			break;
		case "LEFT":
			_0 = f();
			_1 = ts();
			res = new Tree("t", _0, _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree e() {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = t();
			_1 = es();
			res = new Tree("e", _0, _1);
			break;
		case "V":
			_0 = t();
			_1 = es();
			res = new Tree("e", _0, _1);
			break;
		case "LEFT":
			_0 = t();
			_1 = es();
			res = new Tree("e", _0, _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree f() {
		Tree res = null;
		Tree _0 = null, _1 = null, _2 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			if (lex.curTerminal().get().equals("NOT")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = f();
			res = new Tree("f", _0, _1);
			break;
		case "V":
			if (lex.curTerminal().get().equals("V")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("f", _0);
			break;
		case "LEFT":
			if (lex.curTerminal().get().equals("LEFT")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = e();
			if (lex.curTerminal().get().equals("RIGHT")) {
				_2 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("f", _0, _1, _2);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree es() {
		Tree res = null;
		Tree _0 = null, _1 = null, _2 = null;
		switch(lex.curTerminal().get()) {
		case "OR":
			if (lex.curTerminal().get().equals("OR")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = t();
			_2 = es();
			res = new Tree("es", _0, _1, _2);
			break;
		case "XOR":
			if (lex.curTerminal().get().equals("XOR")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = t();
			_2 = es();
			res = new Tree("es", _0, _1, _2);
			break;
		case "EOF":
			_0 = new Tree("(EPS)");
			res = new Tree("es", _0);
			break;
		case "RIGHT":
			_0 = new Tree("(EPS)");
			res = new Tree("es", _0);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree ts() {
		Tree res = null;
		Tree _0 = null, _1 = null, _2 = null;
		switch(lex.curTerminal().get()) {
		case "AND":
			if (lex.curTerminal().get().equals("AND")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = f();
			_2 = ts();
			res = new Tree("ts", _0, _1, _2);
			break;
		case "OR":
			_0 = new Tree("(EPS)");
			res = new Tree("ts", _0);
			break;
		case "EOF":
			_0 = new Tree("(EPS)");
			res = new Tree("ts", _0);
			break;
		case "XOR":
			_0 = new Tree("(EPS)");
			res = new Tree("ts", _0);
			break;
		case "RIGHT":
			_0 = new Tree("(EPS)");
			res = new Tree("ts", _0);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

}
