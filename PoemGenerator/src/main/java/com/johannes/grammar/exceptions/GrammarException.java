package com.johannes.grammar.exceptions;

public abstract class GrammarException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3027129012926718923L;
	
	public GrammarException(String message) {
		super(message);
	}

}
