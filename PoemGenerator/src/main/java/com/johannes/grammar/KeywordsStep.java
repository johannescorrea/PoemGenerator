package com.johannes.grammar;

import java.util.Collections;

import com.johannes.GrammarImpl;
import com.johannes.grammar.exceptions.UndefinedKeywordException;

public class KeywordsStep extends AbstractGrammarStep {
	
	protected KeywordsStep(String stepDefinition) {
		super(stepDefinition);
		// TODO Auto-generated constructor stub
	}

	private final static String WORD_ENDLINE = "$LINEBREAK";
	private final static String WORD_END = "$END";
	private final static String END_STR = "";
	private final static String ENDLINE_STR = System.lineSeparator();

	public String processStep() {
		// TODO Auto-generated method stub
		Collections.shuffle(getWords());
		Word selectWord = getWords().get(0);
		if(selectWord.isKeyword()) {
			return processKeyword(selectWord);
		} else {
			return processRuleReference(selectWord);
		}
	}
	
	private String processRuleReference(Word selectWord) {
		
		return GrammarImpl.getInstance().generateText(selectWord.getValue());
	}

	private String processKeyword(Word word) {
		if(WORD_END.equals(word.getValue())) {
			return END_STR;
		} else if (WORD_ENDLINE.equals(word.getValue())) {
			return ENDLINE_STR;
		} else {
			throw new UndefinedKeywordException(word.getValue());
		}
 	}

}
