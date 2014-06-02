package com.samborskiy.parser;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import com.samborskiy.elements.Grammar;
import com.samborskiy.elements.Terminal;

public class LexicalAnalyzer {
	private InputStream is;
	private int curChar;
	private int curPos;
	private String curToken;
	private Grammar grammar;

	public LexicalAnalyzer(InputStream is, Grammar grammar)
			throws ParseException {
		this.is = is;
		this.grammar = grammar;
		curPos = 0;
		nextChar();
	}

	private boolean isBlank(int c) {
		return c == ' ' || c == '\r' || c == '\n' || c == '\t';
	}

	private void nextChar() throws ParseException {
		curPos++;
		try {
			curChar = is.read();
		} catch (IOException e) {
			throw new ParseException(e.getMessage(), curPos);
		}
	}

	public void nextToken() throws ParseException {
		while (isBlank(curChar)) {
			nextChar();
		}

		if (grammar.contains(Terminal.NUM)) {
			curToken = "";
			while (String.valueOf((char) curChar).matches("[0-9]")) {
				curToken += (char) curChar;
				nextChar();
			}
			if (!curToken.isEmpty()) {
				return;
			}
		}

		if (grammar.contains(new Terminal(String.valueOf((char) curChar)))) {
			nextChar();
			curToken = String.valueOf((char) curChar);
			return;
		}

		if (curChar == -1) {
			curToken = Terminal.END.get();
		} else {
			throw new ParseException("Illegal character " + (char) curChar,
					curPos);
		}
	}

	public String curToken() {
		return curToken;
	}

	public int curPos() {
		return curPos;
	}
}
