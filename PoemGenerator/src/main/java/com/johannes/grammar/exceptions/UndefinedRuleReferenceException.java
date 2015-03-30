package com.johannes.grammar.exceptions;

public class UndefinedRuleReferenceException extends GrammarException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -116647576060880328L;

	public UndefinedRuleReferenceException(String ruleName) {
		super("Rule <" + ruleName + "> is not defined in grammar");
		// TODO Auto-generated constructor stub
	}

}
