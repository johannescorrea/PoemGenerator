package com.johannes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PoemGrammarParserTest {

	String ruleDefinition = "RULE: word1|word2 <RULE>|<RULE>|$KEYWORD";
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
		
		GrammarRule rule = parser.parseRule("RULE: word1|word2");
		assertEquals("RULE", rule.getName());
	}
	
	@Test
	public void ruleShouldContainsTwoWords() {
		GrammarRule rule = parser.parseRule(ruleDefinition);
		assertEquals(2, rule.countWords());
	}
	
	@Test
	public void ruleShouldContainsTwoReferenceRules() {
		GrammarRule rule = parser.parseRule(ruleDefinition);
		assertEquals(2, rule.countRuleReferences());
	}
	
	@Test
	public void ruleShouldContainsOneKeyword() {
		GrammarRule rule = parser.parseRule(ruleDefinition);
		assertEquals(1, rule.countKeywords());
	}
	
	@Ignore
	public void grammarShouldContainSevenRules() {
	}

}
