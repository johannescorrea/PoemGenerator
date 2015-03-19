package com.johannes;

import java.util.ArrayList;
import java.util.List;

class GrammarRuleImpl implements GrammarRule {
	
	private String name;
	private List<Word> words;
	private List<Word> ruleReferences;
	private List<Word> keywords;
	
	GrammarRuleImpl(String name) {
		this.name = name;
		this.words = new ArrayList<Word>();
		this.keywords = new ArrayList<Word>();
		this.ruleReferences = new ArrayList<Word>();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void addWord(Word word) {
		if(word.isKeyword()) {
			keywords.add(word);
		} else if(word.isRuleReference()) {
			ruleReferences.add(word);
		} else {
			words.add(word);
		}
	}

	public int countWords() {
		// TODO Auto-generated method stub
		return words.size();
	}

	public int countRuleReferences() {
		// TODO Auto-generated method stub
		return ruleReferences.size();
	}

	public int countKeywords() {
		// TODO Auto-generated method stub
		return keywords.size();
	}

}
