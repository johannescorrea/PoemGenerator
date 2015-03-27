package com.johannes.grammar;

import java.util.StringTokenizer;

import com.johannes.grammar.exceptions.InvalidGrammarRuleDefinition;

public class GrammarRuleBuilder {
	
	public static GrammarRule buildGrammarRule(String ruleDefinition) {
		String[] parts = ruleDefinition.split(":");
		String ruleName = parts[0];
		if(ruleName.isEmpty()) {
			throw new InvalidGrammarRuleDefinition("GrammarRule has have a name");
		}
		String stepsDefinition = parts[1].trim();
		StringTokenizer stepsSections = new StringTokenizer(stepsDefinition, " ");
		if(!(stepsSections.countTokens() > 0)) {
			throw new InvalidGrammarRuleDefinition("Rule " + ruleName + " is not properly defined");
		}
		
		GrammarRule rule = new GrammarRuleImpl(ruleName);
		while (stepsSections.hasMoreTokens()) {
			rule.addStep(AbstractGrammarStep.createGrammarStep(stepsSections.nextToken()));
			
		}
		return rule;
	}

}
 