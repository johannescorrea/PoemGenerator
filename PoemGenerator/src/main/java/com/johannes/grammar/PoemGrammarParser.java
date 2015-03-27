package com.johannes.grammar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class PoemGrammarParser {

	GrammarRule parseRule(String ruleDefinition) {
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
	
	public Grammar parseGrammar(String fileName) {
		try {
			return parseGrammar(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
