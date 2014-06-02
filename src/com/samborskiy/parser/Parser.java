package com.samborskiy.parser;

import java.io.InputStream;
import java.text.ParseException;

import com.samborskiy.elements.Grammar;

public class Parser {
	private LexicalAnalyzer lex;
	private Grammar grammar;

	public Parser(InputStream is, Grammar grammar) throws ParseException {
		this.lex = new LexicalAnalyzer(is, grammar);
		this.grammar = grammar;
	}
}
