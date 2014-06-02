// Generated from Grammar.g4 by ANTLR 4.2

	package com.samborskiy.antlr;
	import java.util.*; 
	import com.samborskiy.elements.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, SPACE=7, NONTERMINAL=8, 
		TERMINAL=9, SYMBOL=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'''", "':'", "'['", "';'", "'|'", "']'", "SPACE", "NONTERMINAL", 
		"TERMINAL", "SYMBOL"
	};
	public static final int
		RULE_gram = 0, RULE_rules = 1, RULE_term = 2, RULE_termrightpart = 3, 
		RULE_nonterm = 4, RULE_nontermrightpart = 5;
	public static final String[] ruleNames = {
		"gram", "rules", "term", "termrightpart", "nonterm", "nontermrightpart"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		public Set<Terminal> terminals = new HashSet<>();
		public Map<Nonterminal, List<Rule>> rules = new HashMap<>();

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GramContext extends ParserRuleContext {
		public RulesContext rules(int i) {
			return getRuleContext(RulesContext.class,i);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public TerminalNode SPACE(int i) {
			return getToken(GrammarParser.SPACE, i);
		}
		public List<RulesContext> rules() {
			return getRuleContexts(RulesContext.class);
		}
		public List<TerminalNode> SPACE() { return getTokens(GrammarParser.SPACE); }
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGram(this);
		}
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL || _la==TERMINAL) {
				{
				{
				setState(12); rules();
				setState(14);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(13); match(SPACE);
					}
				}

				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RulesContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NontermContext nonterm() {
			return getRuleContext(NontermContext.class,0);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRules(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rules);
		try {
			setState(25);
			switch (_input.LA(1)) {
			case TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(23); term();
				}
				break;
			case NONTERMINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(24); nonterm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Token TERMINAL;
		public TermrightpartContext termrightpart;
		public TerminalNode SPACE(int i) {
			return getToken(GrammarParser.SPACE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(GrammarParser.SPACE); }
		public TerminalNode TERMINAL() { return getToken(GrammarParser.TERMINAL, 0); }
		public TermrightpartContext termrightpart() {
			return getRuleContext(TermrightpartContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); ((TermContext)_localctx).TERMINAL = match(TERMINAL);
			setState(29);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(28); match(SPACE);
				}
			}

			setState(31); match(2);
			setState(33);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(32); match(SPACE);
				}
				break;
			}
			setState(35); ((TermContext)_localctx).termrightpart = termrightpart();
			setState(37);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(36); match(SPACE);
				}
			}

			setState(39); match(4);
			terminals.add(new Terminal((((TermContext)_localctx).TERMINAL!=null?((TermContext)_localctx).TERMINAL.getText():null), ((TermContext)_localctx).termrightpart.val));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermrightpartContext extends ParserRuleContext {
		public String val;
		public Token SYMBOL;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public TerminalNode SPACE(int i) {
			return getToken(GrammarParser.SPACE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(GrammarParser.SPACE); }
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
		public TermrightpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termrightpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermrightpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermrightpart(this);
		}
	}

	public final TermrightpartContext termrightpart() throws RecognitionException {
		TermrightpartContext _localctx = new TermrightpartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_termrightpart);
		String res = "";
		int _la;
		try {
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(42); match(SPACE);
					}
				}

				setState(45); match(1);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(46); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53); match(1);
				setState(55);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(54); match(SPACE);
					}
					break;
				}
				((TermrightpartContext)_localctx).val =  "\'" + res + "\'";
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(58); match(SPACE);
					}
				}

				setState(61); match(3);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(62); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69); match(6);
				setState(71);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(70); match(SPACE);
					}
					break;
				}
				((TermrightpartContext)_localctx).val =  "[" + res + "]";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NontermContext extends ParserRuleContext {
		public TerminalNode NONTERMINAL() { return getToken(GrammarParser.NONTERMINAL, 0); }
		public List<NontermrightpartContext> nontermrightpart() {
			return getRuleContexts(NontermrightpartContext.class);
		}
		public TerminalNode SPACE() { return getToken(GrammarParser.SPACE, 0); }
		public NontermrightpartContext nontermrightpart(int i) {
			return getRuleContext(NontermrightpartContext.class,i);
		}
		public NontermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonterm(this);
		}
	}

	public final NontermContext nonterm() throws RecognitionException {
		NontermContext _localctx = new NontermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nonterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(NONTERMINAL);
			setState(78);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(77); match(SPACE);
				}
			}

			setState(80); match(2);
			setState(81); nontermrightpart();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(82); match(5);
				setState(83); nontermrightpart();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NontermrightpartContext extends ParserRuleContext {
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public List<TerminalNode> NONTERMINAL() { return getTokens(GrammarParser.NONTERMINAL); }
		public TerminalNode SPACE(int i) {
			return getToken(GrammarParser.SPACE, i);
		}
		public TerminalNode NONTERMINAL(int i) {
			return getToken(GrammarParser.NONTERMINAL, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(GrammarParser.SPACE); }
		public List<TerminalNode> TERMINAL() { return getTokens(GrammarParser.TERMINAL); }
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
		public TerminalNode TERMINAL(int i) {
			return getToken(GrammarParser.TERMINAL, i);
		}
		public NontermrightpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nontermrightpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNontermrightpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNontermrightpart(this);
		}
	}

	public final NontermrightpartContext nontermrightpart() throws RecognitionException {
		NontermrightpartContext _localctx = new NontermrightpartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nontermrightpart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(91); match(SPACE);
				}
			}

			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << NONTERMINAL) | (1L << TERMINAL))) != 0)) {
				{
				{
				setState(104);
				switch (_input.LA(1)) {
				case NONTERMINAL:
					{
					setState(94); match(NONTERMINAL);
					}
					break;
				case TERMINAL:
					{
					setState(95); match(TERMINAL);
					}
					break;
				case 1:
					{
					{
					setState(96); match(1);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SYMBOL) {
						{
						{
						setState(97); match(SYMBOL);
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(103); match(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(106); match(SPACE);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fs\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\7\2\23\n\2\f\2\16"+
		"\2\26\13\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\4\3\4\5\4 \n\4\3\4\3\4\5\4$\n"+
		"\4\3\4\3\4\5\4(\n\4\3\4\3\4\3\4\3\5\5\5.\n\5\3\5\3\5\3\5\7\5\63\n\5\f"+
		"\5\16\5\66\13\5\3\5\3\5\5\5:\n\5\3\5\3\5\5\5>\n\5\3\5\3\5\3\5\7\5C\n\5"+
		"\f\5\16\5F\13\5\3\5\3\5\5\5J\n\5\3\5\5\5M\n\5\3\6\3\6\5\6Q\n\6\3\6\3\6"+
		"\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\3\7\5\7_\n\7\3\7\3\7\3\7\3\7"+
		"\7\7e\n\7\f\7\16\7h\13\7\3\7\5\7k\n\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7"+
		"\2\2\b\2\4\6\b\n\f\2\2\u0080\2\24\3\2\2\2\4\33\3\2\2\2\6\35\3\2\2\2\b"+
		"L\3\2\2\2\nN\3\2\2\2\f^\3\2\2\2\16\20\5\4\3\2\17\21\7\t\2\2\20\17\3\2"+
		"\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\16\3\2\2\2\23\26\3\2\2\2\24\22\3\2"+
		"\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3\2\2\2\27\30\7\2\2\3\30\3\3\2"+
		"\2\2\31\34\5\6\4\2\32\34\5\n\6\2\33\31\3\2\2\2\33\32\3\2\2\2\34\5\3\2"+
		"\2\2\35\37\7\13\2\2\36 \7\t\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#"+
		"\7\4\2\2\"$\7\t\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%\'\5\b\5\2&(\7\t\2"+
		"\2\'&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\6\2\2*+\b\4\1\2+\7\3\2\2\2,.\7"+
		"\t\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\64\7\3\2\2\60\61\7\f\2\2\61\63\b"+
		"\5\1\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3"+
		"\2\2\2\66\64\3\2\2\2\679\7\3\2\28:\7\t\2\298\3\2\2\29:\3\2\2\2:;\3\2\2"+
		"\2;M\b\5\1\2<>\7\t\2\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?D\7\5\2\2@A\7\f\2"+
		"\2AC\b\5\1\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2"+
		"\2GI\7\b\2\2HJ\7\t\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KM\b\5\1\2L-\3\2\2"+
		"\2L=\3\2\2\2M\t\3\2\2\2NP\7\n\2\2OQ\7\t\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2"+
		"\2\2RS\7\4\2\2SX\5\f\7\2TU\7\7\2\2UW\5\f\7\2VT\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\6\2\2\\\13\3\2\2\2]_\7\t\2\2^"+
		"]\3\2\2\2^_\3\2\2\2_o\3\2\2\2`k\7\n\2\2ak\7\13\2\2bf\7\3\2\2ce\7\f\2\2"+
		"dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ik\7\3\2\2"+
		"j`\3\2\2\2ja\3\2\2\2jb\3\2\2\2kl\3\2\2\2ln\7\t\2\2mj\3\2\2\2nq\3\2\2\2"+
		"om\3\2\2\2op\3\2\2\2p\r\3\2\2\2qo\3\2\2\2\25\20\24\33\37#\'-\649=DILP"+
		"X^fjo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}