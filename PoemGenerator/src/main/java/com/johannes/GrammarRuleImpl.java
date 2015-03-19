package com.johannes;

import java.util.ArrayList;
import java.util.List;

class GrammarRuleImpl implements GrammarRule {
	
	private String name;
	private List<? extends Word> words;
	private List<? extends Word> ruleReference;
	private List<? extends Word> keywords;
	
	GrammarRuleImpl(String name) {
		this.name = name;
		this.words = new ArrayList<Word>();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public List<? extends Word> getWords() {
		// TODO Auto-generated method stub
		return words;
	}
	
	public void addWord(Word word) {
		
	}

}
