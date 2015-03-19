package com.johannes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class PoemGrammarParser {

	public GrammarRule parseRule(String ruleDefinition) {
		// TODO Auto-generated method stub
		String[] parts = ruleDefinition.split(":");
		List<Word> words = new ArrayList<Word>();
		
		StringTokenizer toks = new StringTokenizer(parts[1], "|");
		while(toks.hasMoreTokens()) {
			words.add(new Word(toks.nextToken()));
		}
		
		GrammarRule rule = new GrammarRuleImpl(parts[0], words);
		
		return rule;
	}

	

}
