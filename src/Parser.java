import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;

public class Parser {
	private Lexer lex;
	private Tree root;
	
	public Parser(String inputFile) throws IOException, ParseException {
		lex = new Lexer(inputFile);
		root = s();
	}
	
	public Tree getTree() {
		return root;
	}
	
	private Tree s() {
		Tree res = null;
		Tree _1 = null, _2 = null, _3 = null;
		switch(lex.curTerminal().get()) {
		case "N":
			if (lex.curTerminal().get().equals("N")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_2 = a();
			if (lex.curTerminal().get().equals("EOF")) {
				_3 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _1, _2, _3);
			break;
		case "EOF":
			_1 = new Tree("(EPS)");
			if (lex.curTerminal().get().equals("EOF")) {
				_2 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			res = new Tree("s", _1, _2);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}
	
	private Tree a() {
		Tree res = null;
		Tree _1 = null, _2 = null, _3 = null, _4 = null;
		switch(lex.curTerminal().get()) {
		case "N":
			if (lex.curTerminal().get().equals("N")) {
				_1 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_2 = a();
			if (lex.curTerminal().get().equals("SIGN")) {
				_3 = new Tree(lex.curToken() + "(" + lex.curTerminal().get() + ")");
			} else {
				throw new AssertionError();
			}
			lex.nextToken();
			_4 = a();
			res = new Tree("a", _1, _2, _3, _4);
			break;
		case "EOF":
			_1 = new Tree("(EPS)");
			res = new Tree("a", _1);
			break;
		case "SIGN":
			_1 = new Tree("(EPS)");
			res = new Tree("a", _1);
			break;
		default:
			throw new AssertionError();
		}
		return res;
	}
}
