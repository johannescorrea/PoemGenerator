package com.johannes;

import java.util.StringTokenizer;

public class PoemGrammarParser {

	public GrammarRule parseRule(String ruleDefinition) {
		// TODO Auto-generated method stub
		String[] parts = ruleDefinition.split(":");

		GrammarRule rule = new GrammarRuleImpl(parts[0]);

		StringTokenizer wordsSections = new StringTokenizer(parts[1], " ");
		while (wordsSections.hasMoreTokens()) {
			String wordsListStr = wordsSections.nextToken();
			StringTokenizer wordsTokens = new StringTokenizer(wordsListStr,"|");
			while (wordsTokens.hasMoreTokens()) {
				rule.addWord(new Word(wordsTokens.nextToken()));
			}
		}

		return rule;
	}

}
