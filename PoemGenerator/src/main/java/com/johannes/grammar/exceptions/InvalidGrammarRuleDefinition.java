package com.johannes.grammar.exceptions;

public class InvalidGrammarRuleDefinition extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8641908926220849744L;

	public InvalidGrammarRuleDefinition(String ruleName) {
		super("Rule " + ruleName + "is not properly defined");
	}

}
