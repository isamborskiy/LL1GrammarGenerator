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
		public Map<Nonterminal, List<Rule>> grammaRules = new HashMap<>();
		
		private Map<Nonterminal, List<List<String>>> rules = new HashMap<>();
		private boolean hasEpsTerm = false;
		
		private Terminal findTerm(String str) {
			for (Terminal term : terminals) {
				if (term.get().equals(str)) {
					if (term.get().equals("EPS")) hasEpsTerm = true;
					return term;
				}
			}
			return null;
		}

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

					terminals.add(Terminal.EPS);
					for (Nonterminal nonterm : rules.keySet()) {
						List<Rule> newRules = new ArrayList<>();
						for (List<String> list : rules.get(nonterm)) {
							Element[] elements = new Element[list.size()];
							for (int i = 0; i < list.size(); i++) {
								Terminal term = findTerm(list.get(i));
								if (term == null) {
									elements[i] = new Nonterminal(list.get(i));
								} else {
									elements[i] = term;
								}
							}
							newRules.add(new Rule(elements));
						}
						grammaRules.put(nonterm, newRules);
					}
					if (!hasEpsTerm) terminals.remove(Terminal.EPS);
				
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
			setState(26);
			switch (_input.LA(1)) {
			case TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); term();
				}
				break;
			case NONTERMINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); nonterm();
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
		public TerminalNode SPACE() { return getToken(GrammarParser.SPACE, 0); }
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
			setState(28); ((TermContext)_localctx).TERMINAL = match(TERMINAL);
			setState(30);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(29); match(SPACE);
				}
			}

			setState(32); match(2);
			setState(33); ((TermContext)_localctx).termrightpart = termrightpart();
			setState(34); match(4);
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
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(37); match(SPACE);
					}
				}

				setState(40); match(1);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(41); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48); match(1);
				setState(50);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(49); match(SPACE);
					}
				}

				((TermrightpartContext)_localctx).val =  res;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(53); match(SPACE);
					}
				}

				setState(56); match(3);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(57); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64); match(6);
				setState(66);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(65); match(SPACE);
					}
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
		public Token NONTERMINAL;
		public NontermrightpartContext nontermrightpart;
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
		List<List<String>> ruleList = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); ((NontermContext)_localctx).NONTERMINAL = match(NONTERMINAL);
			setState(73);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(72); match(SPACE);
				}
			}

			setState(75); match(2);
			setState(76); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
			ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(78); match(5);
				setState(79); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
				ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87); match(4);
			rules.put(new Nonterminal((((NontermContext)_localctx).NONTERMINAL!=null?((NontermContext)_localctx).NONTERMINAL.getText():null)), ruleList);
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
		public List<String> val;
		public Token NONTERMINAL;
		public Token TERMINAL;
		public List<TerminalNode> NONTERMINAL() { return getTokens(GrammarParser.NONTERMINAL); }
		public TerminalNode SPACE(int i) {
			return getToken(GrammarParser.SPACE, i);
		}
		public TerminalNode NONTERMINAL(int i) {
			return getToken(GrammarParser.NONTERMINAL, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(GrammarParser.SPACE); }
		public List<TerminalNode> TERMINAL() { return getTokens(GrammarParser.TERMINAL); }
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
		List<String> ruleElements = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(90); match(SPACE);
				}
			}

			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL || _la==TERMINAL) {
				{
				{
				setState(97);
				switch (_input.LA(1)) {
				case NONTERMINAL:
					{
					setState(93); ((NontermrightpartContext)_localctx).NONTERMINAL = match(NONTERMINAL);
					ruleElements.add((((NontermrightpartContext)_localctx).NONTERMINAL!=null?((NontermrightpartContext)_localctx).NONTERMINAL.getText():null));
					}
					break;
				case TERMINAL:
					{
					setState(95); ((NontermrightpartContext)_localctx).TERMINAL = match(TERMINAL);
					ruleElements.add((((NontermrightpartContext)_localctx).TERMINAL!=null?((NontermrightpartContext)_localctx).TERMINAL.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(99); match(SPACE);
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((NontermrightpartContext)_localctx).val =  ruleElements;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fn\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\7\2\23\n\2\f\2\16"+
		"\2\26\13\2\3\2\3\2\3\2\3\3\3\3\5\3\35\n\3\3\4\3\4\5\4!\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\5\5)\n\5\3\5\3\5\3\5\7\5.\n\5\f\5\16\5\61\13\5\3\5\3\5\5"+
		"\5\65\n\5\3\5\3\5\5\59\n\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\5\3\5"+
		"\5\5E\n\5\3\5\5\5H\n\5\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6U\n\6\f\6\16\6X\13\6\3\6\3\6\3\6\3\7\5\7^\n\7\3\7\3\7\3\7\3\7\5\7d\n"+
		"\7\3\7\7\7g\n\7\f\7\16\7j\13\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2w\2\24"+
		"\3\2\2\2\4\34\3\2\2\2\6\36\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\f]\3\2\2\2\16"+
		"\20\5\4\3\2\17\21\7\t\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22"+
		"\16\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26"+
		"\24\3\2\2\2\27\30\7\2\2\3\30\31\b\2\1\2\31\3\3\2\2\2\32\35\5\6\4\2\33"+
		"\35\5\n\6\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36 \7\13\2\2\37!"+
		"\7\t\2\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\4\2\2#$\5\b\5\2$%\7\6\2"+
		"\2%&\b\4\1\2&\7\3\2\2\2\')\7\t\2\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*/\7"+
		"\3\2\2+,\7\f\2\2,.\b\5\1\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2"+
		"\60\62\3\2\2\2\61/\3\2\2\2\62\64\7\3\2\2\63\65\7\t\2\2\64\63\3\2\2\2\64"+
		"\65\3\2\2\2\65\66\3\2\2\2\66H\b\5\1\2\679\7\t\2\28\67\3\2\2\289\3\2\2"+
		"\29:\3\2\2\2:?\7\5\2\2;<\7\f\2\2<>\b\5\1\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BD\7\b\2\2CE\7\t\2\2DC\3\2\2\2DE\3\2\2"+
		"\2EF\3\2\2\2FH\b\5\1\2G(\3\2\2\2G8\3\2\2\2H\t\3\2\2\2IK\7\n\2\2JL\7\t"+
		"\2\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\4\2\2NO\5\f\7\2OV\b\6\1\2PQ\7\7"+
		"\2\2QR\5\f\7\2RS\b\6\1\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\6\2\2Z[\b\6\1\2[\13\3\2\2\2\\^\7\t\2\2]\\"+
		"\3\2\2\2]^\3\2\2\2^h\3\2\2\2_`\7\n\2\2`d\b\7\1\2ab\7\13\2\2bd\b\7\1\2"+
		"c_\3\2\2\2ca\3\2\2\2de\3\2\2\2eg\7\t\2\2fc\3\2\2\2gj\3\2\2\2hf\3\2\2\2"+
		"hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\b\7\1\2l\r\3\2\2\2\22\20\24\34 (/\64"+
		"8?DGKV]ch";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}