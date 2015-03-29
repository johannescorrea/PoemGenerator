package com.johannes.generator;

public class PoemGeneratorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5702904439919589625L;

	public PoemGeneratorException(String message) {
		super(message);
	}
	
	public PoemGeneratorException(Throwable th) {
		super(th);
	}
}
