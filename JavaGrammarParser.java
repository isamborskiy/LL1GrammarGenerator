
import java.io.IOException;
import java.text.ParseException;

import com.samborskiy.elements.Tree;
import com.samborskiy.elements.TerminalTree;

public class JavaGrammarParser {
	private JavaGrammarLexer lex;
	private Tree root;
	
	public JavaGrammarParser(String inputFile) throws IOException, ParseException {
		lex = new JavaGrammarLexer(inputFile);
		root = new prog();
	}
	
	public Tree getTree() {
		return root;
	}

	public class classElement extends Tree {
		public classElement() {
			node = "classElement";
			switch(lex.curTerminal().get()) {
			case "EQUAL": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				expression _1 = null;
				_1 = new expression();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
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
			case "LEFTROUND": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class modifier extends Tree {
		public modifier() {
			node = "modifier";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PUBLIC")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "PRIVATE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PRIVATE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class bodyDeclaration extends Tree {
		public bodyDeclaration() {
			node = "bodyDeclaration";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				declaration _0 = null;
				_0 = new declaration();
				classElement _1 = null;
				_1 = new classElement();
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "PUBLIC": {
				declaration _0 = null;
				_0 = new declaration();
				classElement _1 = null;
				_1 = new classElement();
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "LONG": {
				declaration _0 = null;
				_0 = new declaration();
				classElement _1 = null;
				_1 = new classElement();
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "PRIVATE": {
				declaration _0 = null;
				_0 = new declaration();
				classElement _1 = null;
				_1 = new classElement();
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				}
				break;
			case "INT": {
				declaration _0 = null;
				_0 = new declaration();
				classElement _1 = null;
				_1 = new classElement();
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration();
				children.add(_0);
				children.add(_1);
				children.add(_2);
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

	public class classDeclaration extends Tree {
		public classDeclaration() {
			node = "classDeclaration";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				modifier _0 = null;
				_0 = new modifier();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("CLASS")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				bodyDeclaration _4 = null;
				_4 = new bodyDeclaration();
				Tree _5 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_5 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				}
				break;
			case "PRIVATE": {
				modifier _0 = null;
				_0 = new modifier();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("CLASS")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				bodyDeclaration _4 = null;
				_4 = new bodyDeclaration();
				Tree _5 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_5 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class expression extends Tree {
		public expression() {
			node = "expression";
			switch(lex.curTerminal().get()) {
			case "NUMBER": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NUMBER")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "TRUE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("TRUE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "FALSE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("FALSE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class prog extends Tree {
		public prog() {
			node = "prog";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				classDeclaration _0 = null;
				_0 = new classDeclaration();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "PRIVATE": {
				classDeclaration _0 = null;
				_0 = new classDeclaration();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class declaration extends Tree {
		public declaration() {
			node = "declaration";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				modifier _0 = null;
				_0 = new modifier();
				type _1 = null;
				_1 = new type();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
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
			case "PRIVATE": {
				modifier _0 = null;
				_0 = new modifier();
				type _1 = null;
				_1 = new type();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
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
			case "BOOLEAN": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "LONG": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				}
				break;
			case "INT": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class type extends Tree {
		public type() {
			node = "type";
			switch(lex.curTerminal().get()) {
			case "INT": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("INT")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "LONG": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LONG")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			case "BOOLEAN": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("BOOLEAN")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError();
				}
				lex.nextToken();
				children.add(_0);
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

}