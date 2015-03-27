package com.johannes.grammar;

import java.util.Collections;

class WordsListStep extends AbstractGrammarStep {
	
	private String previousWord;

	WordsListStep(String stepDefinition) {
		super(stepDefinition);
		// TODO Auto-generated constructor stub
	}

	public String processStep() {
		// TODO Auto-generated method stub
		Collections.shuffle(getWords());
		String selectedWord = getWords().get(0).toString();
		if(selectedWord.equals(previousWord)) {
			return processStep();
		} else {
			previousWord = selectedWord;
			return selectedWord;
		}
	}
	
}
