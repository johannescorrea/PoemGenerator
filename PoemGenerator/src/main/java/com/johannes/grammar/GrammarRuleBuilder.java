package com.johannes.grammar;

import java.util.StringTokenizer;

import com.johannes.grammar.exceptions.InvalidGrammarRuleDefinition;

public class GrammarRuleBuilder {
	
	public static GrammarRule buildGrammarRule(String ruleDefinition) {
		String[] parts = ruleDefinition.split(":");
		StringTokenizer stepsSections = new StringTokenizer(parts[1], " ");
		if(!(stepsSections.countTokens() > 0)) {
			throw new InvalidGrammarRuleDefinition(parts[0]);
		}
		
		GrammarRule rule = new GrammarRuleImpl(parts[0]);
		while (stepsSections.hasMoreTokens()) {
			rule.addStep(AbstractGrammarStep.createGrammarStep(stepsSections.nextToken()));
			
		}
		return rule;
	}

}
