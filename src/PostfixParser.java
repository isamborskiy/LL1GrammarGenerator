import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;

public class PostfixParser {
	private PostfixLexer lex;
	private Tree root;
	
	public PostfixParser(String inputFile, int i) throws IOException, ParseException {
		lex = new PostfixLexer(inputFile);
		root = s(i);
	}
	
	public Tree getTree() {
		return root;
	}

	private Tree s(int i) {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = e(i);
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		case "V":
			_0 = e(i);
			if (lex.curTerminal().get().equals("EOF")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1);
			break;
		case "LEFT":
			_0 = e(i);
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

	private Tree t(int i) {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = f(i);
			_1 = ts(i);
			res = new Tree("t", _0, _1);
			break;
		case "V":
			_0 = f(i);
			_1 = ts(i);
			res = new Tree("t", _0, _1);
			break;
		case "LEFT":
			_0 = f(i);
			_1 = ts(i);
			res = new Tree("t", _0, _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree e(int i) {
		Tree res = null;
		Tree _0 = null, _1 = null;
		switch(lex.curTerminal().get()) {
		case "NOT":
			_0 = t(i);
			_1 = es(i);
			res = new Tree("e", _0, _1);
			break;
		case "V":
			_0 = t(i);
			_1 = es(i);
			res = new Tree("e", _0, _1);
			break;
		case "LEFT":
			_0 = t(i);
			_1 = es(i);
			res = new Tree("e", _0, _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree f(int i) {
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
			_1 = f(i);
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
			_1 = e(i);
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

	private Tree es(int i) {
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
			_1 = t(i);
			_2 = es(i);
			res = new Tree("es", _0, _1, _2);
			break;
		case "XOR":
			if (lex.curTerminal().get().equals("XOR")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = t(i);
			_2 = es(i);
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

	private Tree ts(int i) {
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
			_1 = f(i);
			_2 = ts(i);
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
