package com.johannes.grammar;

import java.util.List;

public interface Grammar {

	int countRules();

	void addRule(GrammarRule rule);
	
	void addRules(List<? extends GrammarRule> rules);
	
	public String generateText(String ruleName);

}
