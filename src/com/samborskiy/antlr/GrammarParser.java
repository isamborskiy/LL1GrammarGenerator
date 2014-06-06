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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, SYMBOL=7;
	public static final String[] tokenNames = {
		"<INVALID>", "'->'", "':'", "';'", "'skip'", "'|'", "'grammar'", "SYMBOL"
	};
	public static final int
		RULE_gram = 0, RULE_rules = 1, RULE_term = 2, RULE_termrightpart = 3, 
		RULE_nonterm = 4, RULE_nontermrightpart = 5, RULE_skip = 6, RULE_name = 7;
	public static final String[] ruleNames = {
		"gram", "rules", "term", "termrightpart", "nonterm", "nontermrightpart", 
		"skip", "name"
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
		public String grammarName = "";
		public Terminal skipTerminal = null;
		public boolean hasError = false;
		public String errorMessage = "";
		
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
		public Token SYMBOL;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public RulesContext rules(int i) {
			return getRuleContext(RulesContext.class,i);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<RulesContext> rules() {
			return getRuleContexts(RulesContext.class);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
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
		String name = "";
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(6);
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17); ((GramContext)_localctx).SYMBOL = match(SYMBOL);
				name += (((GramContext)_localctx).SYMBOL!=null?((GramContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );
			setState(23); match(3);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(24); rules();
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(30); ((GramContext)_localctx).SYMBOL = match(SYMBOL);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36); match(EOF);

					grammarName = name.replaceAll("\\s+", "");
					if (terminals.contains(Terminal.EPS) || terminals.contains(Terminal.END)) {
						errorMessage = "EPS and END are reserved names.";
						hasError = true;
					}
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
		public SkipContext skip() {
			return getRuleContext(SkipContext.class,0);
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
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); term();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); nonterm();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41); skip();
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

	public static class TermContext extends ParserRuleContext {
		public NameContext name;
		public TermrightpartContext termrightpart;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); ((TermContext)_localctx).name = name();
			setState(45); match(2);
			setState(46); ((TermContext)_localctx).termrightpart = termrightpart();
			setState(47); match(3);

					if (((TermContext)_localctx).name.val.equals(((TermContext)_localctx).name.val.toUpperCase()) && !((TermContext)_localctx).name.val.isEmpty() && findTerm(((TermContext)_localctx).name.val) == null) {
						terminals.add(new Terminal(((TermContext)_localctx).name.val, ((TermContext)_localctx).termrightpart.val));
					} else {
						errorMessage = "Incorrect grammar file: terminal name \'" + ((TermContext)_localctx).name.val + "\'.";
						hasError = true;
					}
					if (errorMessage.equals("Incorrect grammar file: use EPS terminal")) {
						errorMessage += " instead of " + ((TermContext)_localctx).name.val + ".";
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

	public static class TermrightpartContext extends ParserRuleContext {
		public String val;
		public Token SYMBOL;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );

					if (res.contains("[") && res.contains("]")) {
						int start = res.indexOf("[");
						int end = res.lastIndexOf("]");
						((TermrightpartContext)_localctx).val =  res.substring(start, end + 1);
					} else if (res.contains("'")) {
						int start = res.indexOf("'");
						int end = res.lastIndexOf("'");
						((TermrightpartContext)_localctx).val =  res.substring(start + 1, end);
					} else {
						errorMessage = "Incorrect grammar file: terminal recording.";
						hasError = true;
					}
					if (_localctx.val.equals("[]") || _localctx.val.isEmpty()) {
						errorMessage = "Incorrect grammar file: use EPS terminal";
						hasError = true;
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

	public static class NontermContext extends ParserRuleContext {
		public NameContext name;
		public NontermrightpartContext nontermrightpart;
		public List<NontermrightpartContext> nontermrightpart() {
			return getRuleContexts(NontermrightpartContext.class);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
			setState(58); ((NontermContext)_localctx).name = name();
			setState(59); match(2);
			setState(60); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
			ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(62); match(5);
				setState(63); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
				ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); match(3);

					if (((NontermContext)_localctx).name.val.charAt(0) >= 'a' && ((NontermContext)_localctx).name.val.charAt(0) <= 'z') {
						rules.put(new Nonterminal(((NontermContext)_localctx).name.val), ruleList);
					} else {
						errorMessage = "Incorrect grammar file: nonterminal name \'" + ((NontermContext)_localctx).name.val + "\'." ;
						hasError = true;
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

	public static class NontermrightpartContext extends ParserRuleContext {
		public List<String> val;
		public Token SYMBOL;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
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
		String res = "";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74); ((NontermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((NontermrightpartContext)_localctx).SYMBOL!=null?((NontermrightpartContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );

					((NontermrightpartContext)_localctx).val =  new ArrayList<>();
					String[] arr = res.split("\\s+");
					for (String str : arr) {
						if (!str.isEmpty()) {
							_localctx.val.add(str);
						}
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

	public static class SkipContext extends ParserRuleContext {
		public NameContext name;
		public TermrightpartContext termrightpart;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
		public TermrightpartContext termrightpart() {
			return getRuleContext(TermrightpartContext.class,0);
		}
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSkip(this);
		}
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skip);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82); ((SkipContext)_localctx).name = name();
			setState(83); match(2);
			setState(85);
			_la = _input.LA(1);
			if (_la==SYMBOL) {
				{
				setState(84); ((SkipContext)_localctx).termrightpart = termrightpart();
				}
			}

			setState(87); match(1);
			setState(89); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(88); match(SYMBOL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(91); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=1 && _alt!=-1 );
			setState(93); match(4);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(94); match(SYMBOL);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100); match(3);

					if (((SkipContext)_localctx).termrightpart.val != null && ((SkipContext)_localctx).name.val.equals(((SkipContext)_localctx).name.val.toUpperCase()) && !((SkipContext)_localctx).name.val.isEmpty() && ((SkipContext)_localctx).termrightpart.val.contains("[") && ((SkipContext)_localctx).termrightpart.val.contains("]")) {
						skipTerminal = new Terminal(((SkipContext)_localctx).name.val, ((SkipContext)_localctx).termrightpart.val);
					} else {
						errorMessage = "Incorrect grammar file: skip rule.";
						hasError = true;
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

	public static class NameContext extends ParserRuleContext {
		public String val;
		public Token SYMBOL;
		public TerminalNode SYMBOL(int i) {
			return getToken(GrammarParser.SYMBOL, i);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(GrammarParser.SYMBOL); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_name);
		String res = "";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103); ((NameContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((NameContext)_localctx).SYMBOL!=null?((NameContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );
			((NameContext)_localctx).val =  res.replaceAll("\\s+", "");
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\tr\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\7\2\"\n\2\f\2"+
		"\16\2%\13\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\6\5\67\n\5\r\5\16\58\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6E\n\6\f\6\16\6H\13\6\3\6\3\6\3\6\3\7\3\7\6\7O\n\7\r\7\16\7P\3\7\3\7"+
		"\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\6\b\\\n\b\r\b\16\b]\3\b\3\b\7\bb\n\b\f\b"+
		"\16\be\13\b\3\b\3\b\3\b\3\t\3\t\6\tl\n\t\r\t\16\tm\3\t\3\t\3\t\3]\2\n"+
		"\2\4\6\b\n\f\16\20\2\2u\2\22\3\2\2\2\4,\3\2\2\2\6.\3\2\2\2\b\66\3\2\2"+
		"\2\n<\3\2\2\2\fN\3\2\2\2\16T\3\2\2\2\20k\3\2\2\2\22\25\7\b\2\2\23\24\7"+
		"\t\2\2\24\26\b\2\1\2\25\23\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3"+
		"\2\2\2\30\31\3\2\2\2\31\35\7\5\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3"+
		"\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36#\3\2\2\2\37\35\3\2\2\2 \"\7\t\2"+
		"\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2"+
		"\2\3\'(\b\2\1\2(\3\3\2\2\2)-\5\6\4\2*-\5\n\6\2+-\5\16\b\2,)\3\2\2\2,*"+
		"\3\2\2\2,+\3\2\2\2-\5\3\2\2\2./\5\20\t\2/\60\7\4\2\2\60\61\5\b\5\2\61"+
		"\62\7\5\2\2\62\63\b\4\1\2\63\7\3\2\2\2\64\65\7\t\2\2\65\67\b\5\1\2\66"+
		"\64\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\5\1\2;\t\3"+
		"\2\2\2<=\5\20\t\2=>\7\4\2\2>?\5\f\7\2?F\b\6\1\2@A\7\7\2\2AB\5\f\7\2BC"+
		"\b\6\1\2CE\3\2\2\2D@\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2H"+
		"F\3\2\2\2IJ\7\5\2\2JK\b\6\1\2K\13\3\2\2\2LM\7\t\2\2MO\b\7\1\2NL\3\2\2"+
		"\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\b\7\1\2S\r\3\2\2\2TU\5\20"+
		"\t\2UW\7\4\2\2VX\5\b\5\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\7\3\2\2Z\\\7"+
		"\t\2\2[Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2][\3\2\2\2^_\3\2\2\2_c\7\6\2\2`b"+
		"\7\t\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2f"+
		"g\7\5\2\2gh\b\b\1\2h\17\3\2\2\2ij\7\t\2\2jl\b\t\1\2ki\3\2\2\2lm\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\t\1\2p\21\3\2\2\2\r\27\35#,8FPW]"+
		"cm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}