package com.johannes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PoemGrammarParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnRuleName() {
		PoemGrammarParser parser = new PoemGrammarParser();
		GrammarRule rule = parser.parseRule("RULE: word1|word2");
		assertEquals("RULE", rule.getName());
	}
	
	@Test
	public void shouldContainsTwoWords() {
		PoemGrammarParser parser = new PoemGrammarParser();
		GrammarRule rule = parser.parseRule("RULE: word1|word2");
		assertEquals(2, rule.getWords().size());
	}

}
