package com.johannes.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class AbstractGrammarStep implements GrammarStep {

	private List<Word> words;
	
	
	protected AbstractGrammarStep(String stepDefinition) {
		words = new ArrayList<Word>();
		StringTokenizer tokens = new StringTokenizer(stepDefinition, "|");
		while (tokens.hasMoreTokens()) {
			addWord(new Word(tokens.nextToken()));
		}
	}
	
	public void addWord(Word word) {
		this.words.add(word);
	}
	
	protected List<Word> getWords() {
		return words;
	}
	
	public int getWordsCount() {
		return words.size();
	}
	
	public static AbstractGrammarStep createGrammarStep(String stepDefinition) {
		if(stepDefinition.contains("<") || stepDefinition.contains("$")) {
			return new KeywordsStep(stepDefinition);
		} else {
			return new WordsListStep(stepDefinition);
		}
	}
}
