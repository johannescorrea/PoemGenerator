package com.johannes.grammar;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.johannes.grammar.GrammarRule;
import com.johannes.grammar.exceptions.IllegalWordDefinition;
import com.johannes.grammar.exceptions.InvalidGrammarRuleDefinition;

public class PoemGrammarParserTest {

	String ruleDefinition = "RULE: word1|word2|word3|word4 <RULE>|<RULE>|$KEYWORD";
	private PoemGrammarParser parser;
	
	@Before
	public void setUp() throws Exception {
		parser = new PoemGrammarParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ruleShouldHaveName() {
		GrammarRule rule = parser.parseRule("RULE: word1|word2|word3|word4");
		assertEquals("RULE", rule.getName());
	}
	
	@Test(expected = InvalidGrammarRuleDefinition.class)
	public void shouldFailIfRuleHasNoName() {
		GrammarRule rule = parser.parseRule(": word1|word2|word3|word4");
		assertEquals("RULE", rule.getName());
	}
	
	@Test
	public void ruleShouldHaveOneStep() {
		GrammarRule rule = parser.parseRule("RULE: word1|word2|word3|word4");
		assertEquals(1, rule.getStepsCount());
	}
	
	@Test
	public void ruleShouldHaveFiveSteps() {
		GrammarRule rule = parser.parseRule("POEM: <LINE> <LINE> <LINE> <LINE> <LINE>");
		assertEquals(5, rule.getStepsCount());
	}
	
	@Test
	public void ruleShouldHaveTwoSteps() {
		GrammarRule rule = parser.parseRule(ruleDefinition);
		assertEquals(2, rule.getStepsCount());
	}
	
	@Test(expected=IllegalWordDefinition.class)
	public void shouldNotAllowMalformedReferences() {
		parser.parseRule("RULE: word1|word2|word3|word4 <RULE>|<RULE1|$END" );
	}
	
	@Test(expected=InvalidGrammarRuleDefinition.class)
	public void shouldNotAllowPlainWordsInKeywordSection() {
		parser.parseRule("RULE: word1|word2|word3|word4 <RULE>|<RULE1>|END" );
	}
	
	@Test(expected=InvalidGrammarRuleDefinition.class)
	public void ruleParsingShouldFailIfNoSteps() {
		parser.parseRule("RULE: ");
		
	}

	@Test
	public void grammarShouldContainSevenRules() {
		Grammar grammar = parser.parseGrammar(ClassLoader.getSystemResourceAsStream("testGRammar.txt"));
		assertEquals(7, grammar.countRules());
	}
	
	@Test
	public void textShouldContainFiveLines() {
		Grammar grammar = parser.parseGrammar(ClassLoader.getSystemResourceAsStream("emptyLinesGrammar.txt"));
		String text = grammar.generateText("POEM");
		assertEquals(5, StringUtils.countMatches(text, System.lineSeparator()));
	}
	
}
