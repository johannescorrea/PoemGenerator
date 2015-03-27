package com.johannes.grammar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.johannes.grammar.exceptions.UndefinedKeywordException;

public class AbstractGrammarStepTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldHaveOneWord() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("word");
		assertEquals(1, step.getWordsCount());
	}
	
	@Test
	public void shouldHaveMoreThanOneWord() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("word1|word2");
		assertTrue(step.getWordsCount()>1);
	}
	
	@Test
	public void shouldHaveOneKeyWord() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("$END");
		assertEquals(1, step.getWordsCount());
	}
	
	@Test
	public void shouldHaveMoreThanOneKeyWord() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("<NOUN>|$END");
		assertTrue(step.getWordsCount()>1);
	}
	
	
	@Test(expected=UndefinedKeywordException.class)
	public void shouldNotProcessInvalidKeywords() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("$ENDFILE");
		step.processStep();
	}
	
	@Test
	public void shouldReturnRandomWords() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("black|white|dark|light|bright|murky|muddy|clear");
		String word1 = step.processStep();
		String word2 = step.processStep();
		assertFalse(word1.equals(word2));
	}
	
	@Test
	public void shouldReturnEmptyString() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("$END");
		assertTrue(step.processStep().isEmpty());
		
	}
	
	@Test
	public void shouldReturnNewLine() {
		GrammarStep step = AbstractGrammarStep.createGrammarStep("$LINEBREAK");
		assertTrue(step.processStep().equals(System.lineSeparator()));
	}

}
