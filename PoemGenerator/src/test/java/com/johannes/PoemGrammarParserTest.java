package com.johannes;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.johannes.grammar.GrammarRule;
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
	
	@Test(expected=InvalidGrammarRuleDefinition.class)
	public void ruleParsingShouldFailIfNoSteps() {
		GrammarRule rule = parser.parseRule("RULE: ");
		
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
	
	@Test
	public void textShouldContainLinesAndWords() {
		Grammar grammar = parser.parseGrammar(ClassLoader.getSystemResourceAsStream("testGRammar.txt"));
		String text = grammar.generateText("POEM");
		System.out.println(text);
		assertEquals(5, StringUtils.countMatches(text, System.lineSeparator()));
		
	}

}
