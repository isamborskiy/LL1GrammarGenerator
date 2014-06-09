// Generated from Grammar.g4 by ANTLR 4.2

	package com.samborskiy.antlr;
	import java.util.*; 
	import java.io.*; 
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, SYMBOL=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'@header'", "'->'", "'#'", "'$'", "':'", "'skip'", "'grammar'", 
		"SYMBOL"
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
		public Map<Nonterminal, List<Rule>> rules = new HashMap<>();
		public String grammarName = "";
		public Terminal skipTerminal = null;
		public String headerCode = "";
		public boolean hasError = false;
		public String errorMessage = "";
		
		private Terminal findTerm(String str) {
			for (Terminal term : terminals) {
				if (term.get().equals(str)) {
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
		public NameContext name;
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		String header = "";
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(7);
			setState(17); ((GramContext)_localctx).name = name();
			setState(18); match(4);
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(20); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(19); ((GramContext)_localctx).SYMBOL = match(SYMBOL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(22); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=1 && _alt!=-1 );
				setState(24); match(1);
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(25); ((GramContext)_localctx).SYMBOL = match(SYMBOL);
					header += (((GramContext)_localctx).SYMBOL!=null?((GramContext)_localctx).SYMBOL.getText():null);
					}
					}
					setState(29); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SYMBOL );
				setState(31); match(4);
				}
				break;
			}
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(34); rules();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(40); ((GramContext)_localctx).SYMBOL = match(SYMBOL);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46); match(EOF);

					if (header.contains("{") && header.contains("}")) {
						headerCode = header.substring(header.indexOf("{") + 1, header.lastIndexOf("}"));
					}
					grammarName = ((GramContext)_localctx).name.val;
					if (terminals.contains(Terminal.EPS) || terminals.contains(Terminal.EOF)) {
						errorMessage = "EPS and EOF are reserved names.";
						hasError = true;
					}
					
					try {
						PrintWriter pw = new PrintWriter(grammarName + ".tokens");
						for (Terminal term : terminals) {
							if (!term.equals(Terminal.EPS) && !term.equals(Terminal.EOF)) {
								pw.println(term.get() + ":" + term.match());
							}
						}
						if (skipTerminal != null) {
							pw.println();
							pw.println(skipTerminal.get() + ":" + skipTerminal.match());
						}
						pw.close();
					} catch(IOException e) {
						e.printStackTrace();
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
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); term();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); nonterm();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51); skip();
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
			setState(54); ((TermContext)_localctx).name = name();
			setState(55); match(5);
			setState(56); ((TermContext)_localctx).termrightpart = termrightpart();
			setState(57); match(4);

					if (((TermContext)_localctx).name.val.equals(((TermContext)_localctx).name.val.toUpperCase()) && !((TermContext)_localctx).name.val.isEmpty() && findTerm(((TermContext)_localctx).name.val) == null) {
						terminals.add(new Terminal(((TermContext)_localctx).name.val, ((TermContext)_localctx).termrightpart.val, false));
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
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60); ((TermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((TermrightpartContext)_localctx).SYMBOL!=null?((TermrightpartContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );

					if (res.contains("(") && res.contains(")")) {
						int start = res.indexOf("(");
						int end = res.lastIndexOf(")");
						((TermrightpartContext)_localctx).val =  res.substring(start + 1, end);
						if (_localctx.val.equals("[]") || _localctx.val.isEmpty()) {
							errorMessage = "Incorrect grammar file: use EPS terminal";
							hasError = true;
						}
					} else {
						errorMessage = "Incorrect grammar file: terminal recording.";
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
		List<Rule> ruleList = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); ((NontermContext)_localctx).name = name();
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69); match(3);
				setState(70); ((NontermContext)_localctx).nontermrightpart = nontermrightpart();
				ruleList.add(((NontermContext)_localctx).nontermrightpart.val);
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 );
			setState(77); match(4);

					String inher = "";
					String synth = "";
					String nameStr = ((NontermContext)_localctx).name.val;
					if (nameStr.contains("[")) {
						String[] arr = nameStr.split("returns");
						if (arr[0].contains("[")) {
							inher = arr[0].substring(arr[0].indexOf("[") + 1, arr[0].indexOf("]"));
						}
						if (arr.length > 1) {
							synth = arr[1].substring(arr[1].indexOf("[") + 1, arr[1].indexOf("]"));
							nameStr = arr[0];
						}
						nameStr = nameStr.substring(0, nameStr.indexOf("[") == -1 ? nameStr.length() : nameStr.indexOf("[")).replaceAll("\\s+", "");
					}
					if (nameStr.charAt(0) >= 'a' && nameStr.charAt(0) <= 'z') {
						Nonterminal nonterm = new Nonterminal(nameStr);
						if (!inher.isEmpty()) {
							nonterm.setInher(inher);
						}
						if (!synth.isEmpty()) {
							nonterm.setSynth(synth);
						}
						rules.put(nonterm, ruleList);
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
		public Rule val;
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
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80); ((NontermrightpartContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((NontermrightpartContext)_localctx).SYMBOL!=null?((NontermrightpartContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );

					List<Element> list = new ArrayList<>();
					String trans = "";
					if (res.contains("{") && res.contains("}")) {
						trans = res.substring(res.indexOf("{"), res.lastIndexOf("}") + 1);
						res = res.substring(0, res.indexOf("{"));
					}
					String[] arr = res.split("\\s+");
					for (int i = 0; i < arr.length; i++) {
						String str = arr[i];
						String inher = "";
						if (!str.isEmpty()) {
							if (str.contains("[")) {
								inher = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
								str = str.substring(0, str.indexOf("["));
							}
							
							if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
								Nonterminal nonterm = new Nonterminal(str);
								nonterm.setInher(inher);
								list.add(nonterm);
							} else {
								list.add(new Terminal(str, "", false));
							}
						}
					}
					((NontermrightpartContext)_localctx).val =  new Rule(list.toArray(new Element[list.size()]));
					_localctx.val.setTrans(trans);
				
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
			setState(88); ((SkipContext)_localctx).name = name();
			setState(89); match(5);
			setState(91);
			_la = _input.LA(1);
			if (_la==SYMBOL) {
				{
				setState(90); ((SkipContext)_localctx).termrightpart = termrightpart();
				}
			}

			setState(93); match(2);
			setState(95); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(94); match(SYMBOL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(97); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=1 && _alt!=-1 );
			setState(99); match(6);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(100); match(SYMBOL);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106); match(4);

					if (((SkipContext)_localctx).termrightpart.val != null && ((SkipContext)_localctx).name.val.equals(((SkipContext)_localctx).name.val.toUpperCase()) && !((SkipContext)_localctx).name.val.isEmpty() && ((SkipContext)_localctx).termrightpart.val.contains("[") && ((SkipContext)_localctx).termrightpart.val.contains("]")) {
						skipTerminal = new Terminal(((SkipContext)_localctx).name.val, ((SkipContext)_localctx).termrightpart.val, false);
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
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109); ((NameContext)_localctx).SYMBOL = match(SYMBOL);
				res += (((NameContext)_localctx).SYMBOL!=null?((NameContext)_localctx).SYMBOL.getText():null);
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );

					if (!res.contains("[")) {
						((NameContext)_localctx).val =  res.replaceAll("\\s+", "");
					} else {
						int k = 0;
						while(new String("" + res.charAt(k)).matches("\\s")) {
							k++;
						}
						res = res.substring(k);
						k = res.length() - 1;
						while(new String("" + res.charAt(k)).matches("\\s")) {
							k--;
						}
						((NameContext)_localctx).val =  res.substring(0, k + 1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\nx\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\6\2"+
		"\27\n\2\r\2\16\2\30\3\2\3\2\3\2\6\2\36\n\2\r\2\16\2\37\3\2\5\2#\n\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\6\5A\n\5\r\5\16\5"+
		"B\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6\6L\n\6\r\6\16\6M\3\6\3\6\3\6\3\7\3\7\6"+
		"\7U\n\7\r\7\16\7V\3\7\3\7\3\b\3\b\3\b\5\b^\n\b\3\b\3\b\6\bb\n\b\r\b\16"+
		"\bc\3\b\3\b\7\bh\n\b\f\b\16\bk\13\b\3\b\3\b\3\b\3\t\3\t\6\tr\n\t\r\t\16"+
		"\ts\3\t\3\t\3\t\4\30c\2\n\2\4\6\b\n\f\16\20\2\2}\2\22\3\2\2\2\4\66\3\2"+
		"\2\2\68\3\2\2\2\b@\3\2\2\2\nF\3\2\2\2\fT\3\2\2\2\16Z\3\2\2\2\20q\3\2\2"+
		"\2\22\23\7\t\2\2\23\24\5\20\t\2\24\"\7\6\2\2\25\27\7\n\2\2\26\25\3\2\2"+
		"\2\27\30\3\2\2\2\30\31\3\2\2\2\30\26\3\2\2\2\31\32\3\2\2\2\32\35\7\3\2"+
		"\2\33\34\7\n\2\2\34\36\b\2\1\2\35\33\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2"+
		"\2\37 \3\2\2\2 !\3\2\2\2!#\7\6\2\2\"\26\3\2\2\2\"#\3\2\2\2#\'\3\2\2\2"+
		"$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(-\3\2\2\2)\'\3\2"+
		"\2\2*,\7\n\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3"+
		"\2\2\2\60\61\7\2\2\3\61\62\b\2\1\2\62\3\3\2\2\2\63\67\5\6\4\2\64\67\5"+
		"\n\6\2\65\67\5\16\b\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\5\3"+
		"\2\2\289\5\20\t\29:\7\7\2\2:;\5\b\5\2;<\7\6\2\2<=\b\4\1\2=\7\3\2\2\2>"+
		"?\7\n\2\2?A\b\5\1\2@>\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2"+
		"DE\b\5\1\2E\t\3\2\2\2FK\5\20\t\2GH\7\5\2\2HI\5\f\7\2IJ\b\6\1\2JL\3\2\2"+
		"\2KG\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\6\2\2PQ\b\6\1"+
		"\2Q\13\3\2\2\2RS\7\n\2\2SU\b\7\1\2TR\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2WX\3\2\2\2XY\b\7\1\2Y\r\3\2\2\2Z[\5\20\t\2[]\7\7\2\2\\^\5\b\5\2]\\"+
		"\3\2\2\2]^\3\2\2\2^_\3\2\2\2_a\7\4\2\2`b\7\n\2\2a`\3\2\2\2bc\3\2\2\2c"+
		"d\3\2\2\2ca\3\2\2\2de\3\2\2\2ei\7\b\2\2fh\7\n\2\2gf\3\2\2\2hk\3\2\2\2"+
		"ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7\6\2\2mn\b\b\1\2n\17\3\2\2"+
		"\2op\7\n\2\2pr\b\t\1\2qo\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2"+
		"\2uv\b\t\1\2v\21\3\2\2\2\17\30\37\"\'-\66BMV]cis";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}