package com.johannes.grammar;

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
	
	public String getValue() {
		if(this.isRuleReference()) {
			int endIndex = value.indexOf(">");
			return value.substring(1, endIndex);
		} else { 
			return value;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}

}
