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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, SPACE=8, NONTERMINAL=9, 
		TERMINAL=10, NAME=11, SYMBOL=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'''", "':'", "'['", "';'", "'|'", "'grammar'", "']'", "SPACE", 
		"NONTERMINAL", "TERMINAL", "NAME", "SYMBOL"
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
		public TerminalNode NAME() { return getToken(GrammarParser.NAME, 0); }
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
			setState(12); match(6);
			setState(14);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(13); match(SPACE);
				}
			}

			setState(16); match(NAME);
			setState(18);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(17); match(SPACE);
				}
			}

			setState(20); match(4);
			setState(22);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(21); match(SPACE);
				}
			}

			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL || _la==TERMINAL) {
				{
				{
				setState(24); rules();
				setState(26);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(25); match(SPACE);
					}
				}

				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33); match(EOF);

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
			setState(38);
			switch (_input.LA(1)) {
			case TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); term();
				}
				break;
			case NONTERMINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); nonterm();
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
			setState(40); ((TermContext)_localctx).TERMINAL = match(TERMINAL);
			setState(42);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(41); match(SPACE);
				}
			}

			setState(44); match(2);
			setState(45); ((TermContext)_localctx).termrightpart = termrightpart();
			setState(46); match(4);
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
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(49); match(SPACE);
					}
				}

				setState(52); match(1);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(53); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60); match(1);
				setState(62);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(61); match(SPACE);
					}
				}

				((TermrightpartContext)_localctx).val =  res;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(65); match(SPACE);
					}
				}

				setState(68); match(3);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(69); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
					res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76); match(7);
				setState(78);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(77); match(SPACE);
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
			setState(83); ((NontermContext)_localctx).NONTERMINAL = match(NONTERMINAL);
			setState(85);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(84); match(SPACE);
				}
			}

			setState(87); match(2);
			setState(88); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
			ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(90); match(5);
				setState(91); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
				ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); match(4);
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
			setState(103);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(102); match(SPACE);
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL || _la==TERMINAL) {
				{
				{
				setState(109);
				switch (_input.LA(1)) {
				case NONTERMINAL:
					{
					setState(105); ((NontermrightpartContext)_localctx).NONTERMINAL = match(NONTERMINAL);
					ruleElements.add((((NontermrightpartContext)_localctx).NONTERMINAL!=null?((NontermrightpartContext)_localctx).NONTERMINAL.getText():null));
					}
					break;
				case TERMINAL:
					{
					setState(107); ((NontermrightpartContext)_localctx).TERMINAL = match(TERMINAL);
					ruleElements.add((((NontermrightpartContext)_localctx).TERMINAL!=null?((NontermrightpartContext)_localctx).TERMINAL.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(111); match(SPACE);
				}
				}
				setState(116);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\3\2\3\2\5\2\25\n"+
		"\2\3\2\3\2\5\2\31\n\2\3\2\3\2\5\2\35\n\2\7\2\37\n\2\f\2\16\2\"\13\2\3"+
		"\2\3\2\3\2\3\3\3\3\5\3)\n\3\3\4\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4\3\5\5"+
		"\5\65\n\5\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\5\3\5\5\5A\n\5\3\5\3\5"+
		"\5\5E\n\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\5\5Q\n\5\3\5\5\5"+
		"T\n\5\3\6\3\6\5\6X\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6\16\6d"+
		"\13\6\3\6\3\6\3\6\3\7\5\7j\n\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\7\7\7s\n\7\f"+
		"\7\16\7v\13\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2\u0086\2\16\3\2\2\2\4("+
		"\3\2\2\2\6*\3\2\2\2\bS\3\2\2\2\nU\3\2\2\2\fi\3\2\2\2\16\20\7\b\2\2\17"+
		"\21\7\n\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2\2\22\24\7\r\2\2\23"+
		"\25\7\n\2\2\24\23\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\30\7\6\2\2\27"+
		"\31\7\n\2\2\30\27\3\2\2\2\30\31\3\2\2\2\31 \3\2\2\2\32\34\5\4\3\2\33\35"+
		"\7\n\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\32\3\2\2\2\37\""+
		"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\7\2\2\3$%\b\2\1"+
		"\2%\3\3\2\2\2&)\5\6\4\2\')\5\n\6\2(&\3\2\2\2(\'\3\2\2\2)\5\3\2\2\2*,\7"+
		"\f\2\2+-\7\n\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\4\2\2/\60\5\b\5\2\60"+
		"\61\7\6\2\2\61\62\b\4\1\2\62\7\3\2\2\2\63\65\7\n\2\2\64\63\3\2\2\2\64"+
		"\65\3\2\2\2\65\66\3\2\2\2\66;\7\3\2\2\678\7\16\2\28:\b\5\1\29\67\3\2\2"+
		"\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>@\7\3\2\2?A\7\n\2"+
		"\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BT\b\5\1\2CE\7\n\2\2DC\3\2\2\2DE\3\2\2"+
		"\2EF\3\2\2\2FK\7\5\2\2GH\7\16\2\2HJ\b\5\1\2IG\3\2\2\2JM\3\2\2\2KI\3\2"+
		"\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NP\7\t\2\2OQ\7\n\2\2PO\3\2\2\2PQ\3\2"+
		"\2\2QR\3\2\2\2RT\b\5\1\2S\64\3\2\2\2SD\3\2\2\2T\t\3\2\2\2UW\7\13\2\2V"+
		"X\7\n\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\4\2\2Z[\5\f\7\2[b\b\6\1\2"+
		"\\]\7\7\2\2]^\5\f\7\2^_\b\6\1\2_a\3\2\2\2`\\\3\2\2\2ad\3\2\2\2b`\3\2\2"+
		"\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\6\2\2fg\b\6\1\2g\13\3\2\2\2hj\7\n"+
		"\2\2ih\3\2\2\2ij\3\2\2\2jt\3\2\2\2kl\7\13\2\2lp\b\7\1\2mn\7\f\2\2np\b"+
		"\7\1\2ok\3\2\2\2om\3\2\2\2pq\3\2\2\2qs\7\n\2\2ro\3\2\2\2sv\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\b\7\1\2x\r\3\2\2\2\25\20\24\30"+
		"\34 (,\64;@DKPSWbiot";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}