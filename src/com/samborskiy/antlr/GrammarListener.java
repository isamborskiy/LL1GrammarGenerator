// Generated from Grammar.g4 by ANTLR 4.2

	package com.samborskiy.antlr;
	import java.util.*; 
	import com.samborskiy.elements.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#nonterm}.
	 * @param ctx the parse tree
	 */
	void enterNonterm(@NotNull GrammarParser.NontermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nonterm}.
	 * @param ctx the parse tree
	 */
	void exitNonterm(@NotNull GrammarParser.NontermContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#nontermrightpart}.
	 * @param ctx the parse tree
	 */
	void enterNontermrightpart(@NotNull GrammarParser.NontermrightpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nontermrightpart}.
	 * @param ctx the parse tree
	 */
	void exitNontermrightpart(@NotNull GrammarParser.NontermrightpartContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#termrightpart}.
	 * @param ctx the parse tree
	 */
	void enterTermrightpart(@NotNull GrammarParser.TermrightpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termrightpart}.
	 * @param ctx the parse tree
	 */
	void exitTermrightpart(@NotNull GrammarParser.TermrightpartContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void enterGram(@NotNull GrammarParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void exitGram(@NotNull GrammarParser.GramContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(@NotNull GrammarParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(@NotNull GrammarParser.RulesContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull GrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull GrammarParser.TermContext ctx);
}