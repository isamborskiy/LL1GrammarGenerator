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

	private Tree a() {
		Tree res = null;
		Tree _0 = null, _1 = null, _2 = null, _3 = null;
		switch(lex.curTerminal().get()) {
		case "N":
			if (lex.curTerminal().get().equals("N")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = a();
			if (lex.curTerminal().get().equals("SIGN")) {
				_2 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_3 = a();
			res = new Tree("a", _0, _1, _2, _3);
			break;
		case "SIGN":
			_0 = new Tree("(EPS)");
			res = new Tree("a", _0);
			break;
		case "EOF":
			_0 = new Tree("(EPS)");
			res = new Tree("a", _0);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}

	private Tree s() {
		Tree res = null;
		Tree _0 = null, _1 = null, _2 = null;
		switch(lex.curTerminal().get()) {
		case "N":
			if (lex.curTerminal().get().equals("N")) {
				_0 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_1 = a();
			if (lex.curTerminal().get().equals("EOF")) {
				_2 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _0, _1, _2);
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

}
