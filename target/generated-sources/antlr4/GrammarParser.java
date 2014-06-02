// Generated from Grammar.g4 by ANTLR 4.2
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
		public TerminalNode SPACE() { return getToken(GrammarParser.SPACE, 0); }
		public TerminalNode TERMINAL() { return getToken(GrammarParser.TERMINAL, 0); }
		public List<TermrightpartContext> termrightpart() {
			return getRuleContexts(TermrightpartContext.class);
		}
		public TermrightpartContext termrightpart(int i) {
			return getRuleContext(TermrightpartContext.class,i);
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
			setState(27); match(TERMINAL);
			setState(29);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(28); match(SPACE);
				}
			}

			setState(31); match(2);
			setState(32); termrightpart();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(33); match(5);
				setState(34); termrightpart();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40); match(4);
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
		int _la;
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
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
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(46); match(SYMBOL);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(52); match(1);
				setState(54);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(53); match(SPACE);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(56); match(SPACE);
					}
				}

				setState(59); match(3);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL) {
					{
					{
					setState(60); match(SYMBOL);
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66); match(6);
				setState(68);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(67); match(SPACE);
					}
				}

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
			setState(72); match(NONTERMINAL);
			setState(74);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(73); match(SPACE);
				}
			}

			setState(76); match(2);
			setState(77); nontermrightpart();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(78); match(5);
				setState(79); nontermrightpart();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(4);
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
			setState(88);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(87); match(SPACE);
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << NONTERMINAL) | (1L << TERMINAL))) != 0)) {
				{
				{
				setState(100);
				switch (_input.LA(1)) {
				case NONTERMINAL:
					{
					setState(90); match(NONTERMINAL);
					}
					break;
				case TERMINAL:
					{
					setState(91); match(TERMINAL);
					}
					break;
				case 1:
					{
					{
					setState(92); match(1);
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SYMBOL) {
						{
						{
						setState(93); match(SYMBOL);
						}
						}
						setState(98);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(99); match(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(102); match(SPACE);
				}
				}
				setState(107);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fo\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\7\2\23\n\2\f\2\16"+
		"\2\26\13\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\4\3\4\5\4 \n\4\3\4\3\4\3\4\3\4"+
		"\7\4&\n\4\f\4\16\4)\13\4\3\4\3\4\3\5\5\5.\n\5\3\5\3\5\7\5\62\n\5\f\5\16"+
		"\5\65\13\5\3\5\3\5\5\59\n\5\3\5\5\5<\n\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13"+
		"\5\3\5\3\5\5\5G\n\5\5\5I\n\5\3\6\3\6\5\6M\n\6\3\6\3\6\3\6\3\6\7\6S\n\6"+
		"\f\6\16\6V\13\6\3\6\3\6\3\7\5\7[\n\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7"+
		"d\13\7\3\7\5\7g\n\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\2\2\b\2\4\6\b\n\f"+
		"\2\2{\2\24\3\2\2\2\4\33\3\2\2\2\6\35\3\2\2\2\bH\3\2\2\2\nJ\3\2\2\2\fZ"+
		"\3\2\2\2\16\20\5\4\3\2\17\21\7\t\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\23"+
		"\3\2\2\2\22\16\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27"+
		"\3\2\2\2\26\24\3\2\2\2\27\30\7\2\2\3\30\3\3\2\2\2\31\34\5\6\4\2\32\34"+
		"\5\n\6\2\33\31\3\2\2\2\33\32\3\2\2\2\34\5\3\2\2\2\35\37\7\13\2\2\36 \7"+
		"\t\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\4\2\2\"\'\5\b\5\2#$\7"+
		"\7\2\2$&\5\b\5\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)"+
		"\'\3\2\2\2*+\7\6\2\2+\7\3\2\2\2,.\7\t\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2"+
		"\2/\63\7\3\2\2\60\62\7\f\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\668\7\3\2\2\679\7\t\2\28\67"+
		"\3\2\2\289\3\2\2\29I\3\2\2\2:<\7\t\2\2;:\3\2\2\2;<\3\2\2\2<=\3\2\2\2="+
		"A\7\5\2\2>@\7\f\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2"+
		"CA\3\2\2\2DF\7\b\2\2EG\7\t\2\2FE\3\2\2\2FG\3\2\2\2GI\3\2\2\2H-\3\2\2\2"+
		"H;\3\2\2\2I\t\3\2\2\2JL\7\n\2\2KM\7\t\2\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2"+
		"\2NO\7\4\2\2OT\5\f\7\2PQ\7\7\2\2QS\5\f\7\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2"+
		"\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\6\2\2X\13\3\2\2\2Y[\7\t\2\2ZY\3\2"+
		"\2\2Z[\3\2\2\2[k\3\2\2\2\\g\7\n\2\2]g\7\13\2\2^b\7\3\2\2_a\7\f\2\2`_\3"+
		"\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2eg\7\3\2\2f\\"+
		"\3\2\2\2f]\3\2\2\2f^\3\2\2\2gh\3\2\2\2hj\7\t\2\2if\3\2\2\2jm\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2l\r\3\2\2\2mk\3\2\2\2\24\20\24\33\37\'-\638;AFHLTZ"+
		"bfk";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}