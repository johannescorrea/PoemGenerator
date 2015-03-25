package com.johannes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.johannes.grammar.GrammarRule;

public class RulesProcessingTest {

	private PoemGrammarParser parser;
	private String ruleDef = "ADJECTIVE: black|white|dark|light|bright|murky|muddy|clear $LINEBREAK";
	GrammarRule rule;

	@Before
	public void setUp() throws Exception {
		parser = new PoemGrammarParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldEndWithLineBreak() {
		rule = parser.parseRule(ruleDef);
		String text = rule.processRule();
		assertTrue(text.endsWith(System.lineSeparator()));
	}
	
	@Test
	public void shouldHaveAWord() {
		rule = parser.parseRule(ruleDef);
		String text = rule.processRule();
		assertTrue(ruleDef.contains(text.trim()));
	}

}
