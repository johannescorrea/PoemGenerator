package com.johannes.grammar.exceptions;

public class UndefinedKeywordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1162038711165992549L;

	public UndefinedKeywordException(String keyword) {
		super("Invalid keyword: " + keyword);
	}
}
