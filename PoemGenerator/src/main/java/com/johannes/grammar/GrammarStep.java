package com.johannes.grammar;


public interface GrammarStep{

	public void addWord(Word word);
	
	public String processStep();

	public int getWordsCount();
}
