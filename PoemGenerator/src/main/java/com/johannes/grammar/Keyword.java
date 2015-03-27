package com.johannes.grammar;

import com.johannes.grammar.exceptions.IllegalWordDefinition;

class Keyword extends Word {

	Keyword(String value) {
		super(value);
		
		if(value.startsWith("<") && !value.endsWith(">")) {
			throw new IllegalWordDefinition("Malformed rule reference:" + value);
		} 
				
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
}
