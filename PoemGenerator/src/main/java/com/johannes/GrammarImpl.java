package com.johannes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.johannes.grammar.GrammarRule;

public class GrammarImpl implements Grammar {
	
	private LinkedHashMap<String, GrammarRule> rules = new LinkedHashMap<String, GrammarRule>();
	
	private GrammarImpl() {
		
	}
	
	private static class GrammarHelper {
		private static final Grammar INSTANCE = new GrammarImpl();
	}

	public int countRules() {
		return rules.size();
	}

	public void addRule(GrammarRule rule) {
		rules.put(rule.getName(), rule);
	}

	public void addRules(List<? extends GrammarRule> rules) {
		for (GrammarRule grammarRule : rules) {
			this.rules.put(grammarRule.getName(), grammarRule);
		}
		
	}

	public String generateText(String ruleName) {
		// TODO Auto-generated method stub
		return rules.get(ruleName).processRule();
	}
	
	public static Grammar getInstance() {
		return GrammarHelper.INSTANCE;
	}
	
}