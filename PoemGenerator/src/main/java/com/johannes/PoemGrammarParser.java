package com.johannes;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import com.johannes.grammar.GrammarRule;
import com.johannes.grammar.GrammarRuleBuilder;

public class PoemGrammarParser {

	public GrammarRule parseRule(String ruleDefinition) {
		return GrammarRuleBuilder.buildGrammarRule(ruleDefinition);
	}

	public Grammar parseGrammar(InputStream inputStream) {
		try {
			Grammar grammar = GrammarImpl.getInstance();
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(inputStream));
			String ruleLine = reader.readLine();
			while (ruleLine!=null) {
				GrammarRule rule = parseRule(ruleLine);
				grammar.addRule(rule);
				ruleLine = reader.readLine();
			}
			return grammar;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error parsing grammar", e);
		}
	}

}
