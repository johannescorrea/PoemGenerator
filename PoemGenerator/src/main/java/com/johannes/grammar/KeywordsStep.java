package com.johannes.grammar;

import java.util.Collections;
import java.util.StringTokenizer;

import com.johannes.grammar.exceptions.InvalidGrammarRuleDefinition;
import com.johannes.grammar.exceptions.UndefinedKeywordException;

class KeywordsStep extends AbstractGrammarStep {

	KeywordsStep(String stepDefinition) {
		super(stepDefinition);
	}

	@Override
	protected void processStepDefinition(String stepDefinition) {
		StringTokenizer tokens = new StringTokenizer(stepDefinition, "|");
		while (tokens.hasMoreTokens()) {
			String wordValue = tokens.nextToken();
			Word word = Word.createWord(wordValue);
			if (word.isKeyword() || word.isRuleReference()) {
				addWord(word);
			} else {
				throw new InvalidGrammarRuleDefinition(
						"Plain words not allowed in keywords section");
			}
		}
	}

	private final static String WORD_ENDLINE = "$LINEBREAK";
	private final static String WORD_END = "$END";
	private final static String END_STR = "";
	private final static String ENDLINE_STR = System.lineSeparator();

	public String processStep() {
		Word selectWord = null;
		if (getWordsCount() > 1) {
			Collections.shuffle(getWords());
			// int position = (int)Math.floor(Math.random()*getWords().size());
		}

		selectWord = getWords().get(0);

		if (selectWord.isKeyword()) {
			return processKeyword(selectWord);
		} else {
			return processRuleReference(selectWord);
		}
	}

	private String processRuleReference(Word selectWord) {
		Boolean includeTrace = Boolean.valueOf(System.getProperty(
				"includeGrammarTrace", "FALSE"));
		
		StringBuilder b = new StringBuilder();
		b.append(includeTrace?selectWord.getValue()+":":"");
		b.append(GrammarImpl.getInstance().generateText(selectWord.getValue()));
		return b.toString();
	}

	private String processKeyword(Word word) {
		if (WORD_END.equals(word.getValue())) {
			return END_STR;
		} else if (WORD_ENDLINE.equals(word.getValue())) {
			return ENDLINE_STR;
		} else {
			throw new UndefinedKeywordException(word.getValue());
		}
	}

}
