package com.johannes;

public class Word {
	
	private String value;
	
	Word(String value) {
		this.value = value;
	}
	
	public boolean isRuleReference() {
		return (value.startsWith("<") && value.endsWith(">"));
	}
	
	public boolean isKeyword() {
		return value.startsWith("$");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}

}
