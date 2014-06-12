
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
		public String val;
		public classElement(int i) {
			node = "classElement";
			switch(lex.curTerminal().get()) {
			case "EQUAL": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _1 = null;
				_1 = new expression();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = " = " + _1.val + ";\n";}
				}
				break;
			case "LEFTROUND": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				arguments _1 = null;
				_1 = new arguments();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				functionBody _4 = null;
				_4 = new functionBody(i+1);
				Tree _5 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_5 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = "(" + _1.val + ") {\n" + _4.val + tab + "}\n";
					}
				}
				break;
			case "SEMICOLON": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = ";\n";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class expression extends Tree {
		public String val;
		public expression() {
			node = "expression";
			switch(lex.curTerminal().get()) {
			case "NUMBER": {
				value _0 = null;
				_0 = new value();
				rightPartOfExpr _1 = null;
				_1 = new rightPartOfExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "TRUE": {
				value _0 = null;
				_0 = new value();
				rightPartOfExpr _1 = null;
				_1 = new rightPartOfExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "FALSE": {
				value _0 = null;
				_0 = new value();
				rightPartOfExpr _1 = null;
				_1 = new rightPartOfExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NAME": {
				value _0 = null;
				_0 = new value();
				rightPartOfExpr _1 = null;
				_1 = new rightPartOfExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NEW": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NEW")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NEW expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				newOper _3 = null;
				_3 = new newOper();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				{val = "new " + _1.text + "(" + _3.val;}
				}
				break;
			case "LEFTROUND": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _1 = null;
				_1 = new expression();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				rightPartOfExpr _3 = null;
				_3 = new rightPartOfExpr();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				{val = "(" + _1.val + ")" + _3.val;}
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
				_0 = new classDeclaration(0);
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EOF expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{System.out.println(_0.val);}
				}
				break;
			case "PRIVATE": {
				classDeclaration _0 = null;
				_0 = new classDeclaration(0);
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EOF")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EOF expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{System.out.println(_0.val);}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class declaration extends Tree {
		public String val;
		public declaration(int i) {
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
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + _1.val + " " + _2.text;
					}
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
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + _1.val + " " + _2.text;
					}
				}
				break;
			case "BOOLEAN": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text;
					}
				}
				break;
			case "LONG": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text;
					}
				}
				break;
			case "NAME": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text;
					}
				}
				break;
			case "INT": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text;
					}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class newOper extends Tree {
		public String val;
		public newOper() {
			node = "newOper";
			switch(lex.curTerminal().get()) {
			case "LEFTROUND": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "NUMBER": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "TRUE": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "FALSE": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "NEW": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "NAME": {
				argumentsExpr _0 = null;
				_0 = new argumentsExpr();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + ")";}
				}
				break;
			case "RIGHTROUND": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = ")";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class bodyDeclaration extends Tree {
		public String val;
		public bodyDeclaration(int i) {
			node = "bodyDeclaration";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "PUBLIC": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "LONG": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "PRIVATE": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "NAME": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "INT": {
				declaration _0 = null;
				_0 = new declaration(i);
				classElement _1 = null;
				_1 = new classElement(i);
				bodyDeclaration _2 = null;
				_2 = new bodyDeclaration(i);
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = _0.val + _1.val + _2.val;}
				}
				break;
			case "RIGHT": {
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

	public class functionBody extends Tree {
		public String val;
		public functionBody(int i) {
			node = "functionBody";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "LONG": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "WHILE": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "IF": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NAME": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "RETURN": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "INT": {
				functionElement _0 = null;
				_0 = new functionElement(i);
				functionBody _1 = null;
				_1 = new functionBody(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "RIGHT": {
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

	public class arguments extends Tree {
		public String val;
		public arguments() {
			node = "arguments";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				argumentWithoutComma _0 = null;
				_0 = new argumentWithoutComma();
				argumentss _1 = null;
				_1 = new argumentss();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "LONG": {
				argumentWithoutComma _0 = null;
				_0 = new argumentWithoutComma();
				argumentss _1 = null;
				_1 = new argumentss();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NAME": {
				argumentWithoutComma _0 = null;
				_0 = new argumentWithoutComma();
				argumentss _1 = null;
				_1 = new argumentss();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "INT": {
				argumentWithoutComma _0 = null;
				_0 = new argumentWithoutComma();
				argumentss _1 = null;
				_1 = new argumentss();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "RIGHTROUND": {
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

	public class oper extends Tree {
		public String val;
		public oper() {
			node = "oper";
			switch(lex.curTerminal().get()) {
			case "PLUS": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PLUS")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("PLUS expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "+";}
				}
				break;
			case "MUL": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("MUL")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("MUL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "*";}
				}
				break;
			case "DIV": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("DIV")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("DIV expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "/";}
				}
				break;
			case "AND": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("AND")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("AND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "&&";}
				}
				break;
			case "OR": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("OR")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("OR expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "||";}
				}
				break;
			case "EQUAL": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = "==";}
				}
				break;
			case "LESS": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LESS")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LESS expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = "<";}
				}
				break;
			case "GREAT": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("GREAT")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("GREAT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = ">";}
				}
				break;
			case "NOT": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NOT")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NOT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = "!=";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class ifBlock extends Tree {
		public String val;
		public ifBlock(int i) {
			node = "ifBlock";
			switch(lex.curTerminal().get()) {
			case "IF": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("IF")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("IF expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _2 = null;
				_2 = new expression();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				functionBody _5 = null;
				_5 = new functionBody(i+1);
				Tree _6 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_6 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				children.add(_6);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + "if (" + _2.val + ") {\n" + _5.val + tab + "}";
					}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentss extends Tree {
		public String val;
		public argumentss() {
			node = "argumentss";
			switch(lex.curTerminal().get()) {
			case "COMMA": {
				argumentWithComma _0 = null;
				_0 = new argumentWithComma();
				argumentss _1 = null;
				_1 = new argumentss();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "RIGHTROUND": {
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

	public class whileBlock extends Tree {
		public String val;
		public whileBlock(int i) {
			node = "whileBlock";
			switch(lex.curTerminal().get()) {
			case "WHILE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("WHILE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("WHILE expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("LEFTROUND")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _2 = null;
				_2 = new expression();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("RIGHTROUND")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHTROUND expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				functionBody _5 = null;
				_5 = new functionBody(i+1);
				Tree _6 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_6 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				children.add(_6);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + "while (" + _2.val + ") {\n" + _5.val + tab + "}\n";
					}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class rightPartOfExpr extends Tree {
		public String val;
		public rightPartOfExpr() {
			node = "rightPartOfExpr";
			switch(lex.curTerminal().get()) {
			case "DIV": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "EQUAL": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "MUL": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "OR": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "GREAT": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "NOT": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "AND": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "LESS": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "PLUS": {
				oper _0 = null;
				_0 = new oper();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = " " + _0.val + " " + _1.val;}
				}
				break;
			case "COMMA": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "";}
				}
				break;
			case "SEMICOLON": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "";}
				}
				break;
			case "RIGHTROUND": {
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

	public class modifier extends Tree {
		public String val;
		public modifier() {
			node = "modifier";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PUBLIC")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("PUBLIC expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text + " ";}
				}
				break;
			case "PRIVATE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("PRIVATE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("PRIVATE expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text + " ";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class elseBlock extends Tree {
		public String val;
		public elseBlock(int i) {
			node = "elseBlock";
			switch(lex.curTerminal().get()) {
			case "ELSE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("ELSE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("ELSE expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				functionBody _2 = null;
				_2 = new functionBody(i+1);
				Tree _3 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = " else {\n" + _2.val + tab + "}\n";
					}
				}
				break;
			case "BOOLEAN": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "LONG": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "WHILE": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "IF": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "NAME": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "RETURN": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "RIGHT": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			case "INT": {
				Tree _0 = null;
				_0 = new TerminalTree("EPS", "");
				children.add(_0);
				{val = "\n";}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentWithoutCommaExpr extends Tree {
		public String val;
		public argumentWithoutCommaExpr() {
			node = "argumentWithoutCommaExpr";
			switch(lex.curTerminal().get()) {
			case "LEFTROUND": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "NUMBER": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "TRUE": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "FALSE": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "NEW": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "NAME": {
				expression _0 = null;
				_0 = new expression();
				children.add(_0);
				{val = _0.val;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentWithCommaExpr extends Tree {
		public String val;
		public argumentWithCommaExpr() {
			node = "argumentWithCommaExpr";
			switch(lex.curTerminal().get()) {
			case "COMMA": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("COMMA")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("COMMA expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _1 = null;
				_1 = new expression();
				children.add(_0);
				children.add(_1);
				{val = ", " + _1.val;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class classDeclaration extends Tree {
		public String val;
		public classDeclaration(int i) {
			node = "classDeclaration";
			switch(lex.curTerminal().get()) {
			case "PUBLIC": {
				modifier _0 = null;
				_0 = new modifier();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("CLASS")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("CLASS expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				bodyDeclaration _4 = null;
				_4 = new bodyDeclaration(i+1);
				Tree _5 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_5 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				{	
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + "class " + _2.text + " {\n" + _4.val + tab + "}\n";
					}
				}
				break;
			case "PRIVATE": {
				modifier _0 = null;
				_0 = new modifier();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("CLASS")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("CLASS expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _3 = null;
				if (lex.curTerminal().get().equals("LEFT")) {
					_3 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LEFT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				bodyDeclaration _4 = null;
				_4 = new bodyDeclaration(i+1);
				Tree _5 = null;
				if (lex.curTerminal().get().equals("RIGHT")) {
					_5 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RIGHT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				children.add(_5);
				{	
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + "class " + _2.text + " {\n" + _4.val + tab + "}\n";
					}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class type extends Tree {
		public String val;
		public type() {
			node = "type";
			switch(lex.curTerminal().get()) {
			case "INT": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("INT")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("INT expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "LONG": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("LONG")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("LONG expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "BOOLEAN": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("BOOLEAN")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("BOOLEAN expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "NAME": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentsExpr extends Tree {
		public String val;
		public argumentsExpr() {
			node = "argumentsExpr";
			switch(lex.curTerminal().get()) {
			case "LEFTROUND": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NUMBER": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "TRUE": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "FALSE": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NEW": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "NAME": {
				argumentWithoutCommaExpr _0 = null;
				_0 = new argumentWithoutCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class functionElement extends Tree {
		public String val;
		public functionElement(int i) {
			node = "functionElement";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _3 = null;
				_3 = new expression();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text + " = " + _3.val + ";\n";
					}
				}
				break;
			case "LONG": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _3 = null;
				_3 = new expression();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text + " = " + _3.val + ";\n";
					}
				}
				break;
			case "NAME": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _3 = null;
				_3 = new expression();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text + " = " + _3.val + ";\n";
					}
				}
				break;
			case "INT": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("EQUAL")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _3 = null;
				_3 = new expression();
				Tree _4 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_4 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				children.add(_3);
				children.add(_4);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.val + " " + _1.text + " = " + _3.val + ";\n";
					}
				}
				break;
			case "IF": {
				ifBlock _0 = null;
				_0 = new ifBlock(i);
				elseBlock _1 = null;
				_1 = new elseBlock(i);
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "WHILE": {
				whileBlock _0 = null;
				_0 = new whileBlock(i);
				children.add(_0);
				{val = _0.val;}
				}
				break;
			case "RETURN": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("RETURN")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("RETURN expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				expression _1 = null;
				_1 = new expression();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("SEMICOLON")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("SEMICOLON expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{
						String tab = "";
						for (int j = 0; j < i; j++) tab += "\t";
						val = tab + _0.text + " " + _1.val + ";\n";
					}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentWithoutComma extends Tree {
		public String val;
		public argumentWithoutComma() {
			node = "argumentWithoutComma";
			switch(lex.curTerminal().get()) {
			case "BOOLEAN": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + " " + _1.text;}
				}
				break;
			case "LONG": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + " " + _1.text;}
				}
				break;
			case "NAME": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + " " + _1.text;}
				}
				break;
			case "INT": {
				type _0 = null;
				_0 = new type();
				Tree _1 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_1 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				{val = _0.val + " " + _1.text;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class value extends Tree {
		public String val;
		public value() {
			node = "value";
			switch(lex.curTerminal().get()) {
			case "NUMBER": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NUMBER")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NUMBER expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "TRUE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("TRUE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("TRUE expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "FALSE": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("FALSE")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("FALSE expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			case "NAME": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				{val = _0.text;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

	public class argumentssExpr extends Tree {
		public String val;
		public argumentssExpr() {
			node = "argumentssExpr";
			switch(lex.curTerminal().get()) {
			case "COMMA": {
				argumentWithCommaExpr _0 = null;
				_0 = new argumentWithCommaExpr();
				argumentssExpr _1 = null;
				_1 = new argumentssExpr();
				children.add(_0);
				children.add(_1);
				{val = _0.val + _1.val;}
				}
				break;
			case "RIGHTROUND": {
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

	public class argumentWithComma extends Tree {
		public String val;
		public argumentWithComma() {
			node = "argumentWithComma";
			switch(lex.curTerminal().get()) {
			case "COMMA": {
				Tree _0 = null;
				if (lex.curTerminal().get().equals("COMMA")) {
					_0 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("COMMA expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				type _1 = null;
				_1 = new type();
				Tree _2 = null;
				if (lex.curTerminal().get().equals("NAME")) {
					_2 = new TerminalTree(lex.curTerminal().get(), lex.curToken());
				} else {
					throw new AssertionError("NAME expected, instead of " + lex.curToken());
				}
				lex.nextToken();
				children.add(_0);
				children.add(_1);
				children.add(_2);
				{val = ", " + _1.val + " " + _2.text;}
				}
				break;
			default:
				throw new AssertionError();
			}
					}
	}

}
