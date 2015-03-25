package com.johannes.grammar;

import java.util.Collections;

public class WordsListStep extends AbstractGrammarStep {

	protected WordsListStep(String stepDefinition) {
		super(stepDefinition);
		// TODO Auto-generated constructor stub
	}

	public String processStep() {
		// TODO Auto-generated method stub
		Collections.shuffle(getWords());
		return getWords().get(0).toString();
	}
	
}
