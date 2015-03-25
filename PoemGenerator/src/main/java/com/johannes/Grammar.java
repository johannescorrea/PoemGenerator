package com.johannes;

import java.util.List;

import com.johannes.grammar.GrammarRule;

public interface Grammar {

	int countRules();

	void addRule(GrammarRule rule);
	
	void addRules(List<? extends GrammarRule> rules);
	
	public String generateText(String ruleName);

}
