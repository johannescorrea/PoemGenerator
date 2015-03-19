package com.johannes;


public interface GrammarRule {

	public String getName();

	public void addWord(Word word);
	
	public int countWords();
	
	public int countRuleReferences();
	
	public int countKeywords();

}
