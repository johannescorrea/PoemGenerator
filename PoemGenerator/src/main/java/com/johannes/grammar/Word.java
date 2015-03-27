package com.johannes.grammar;

public abstract class Word {
	
	
	protected String value;
	
	protected Word(String value) {
		this.value = value;
		
	}
	
	public abstract boolean isRuleReference();
	
	public abstract boolean isKeyword();
	
	public abstract String getValue();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public static Word createWord(String value) {
		if(value.contains("<") || value.contains("$")) {
			return new Keyword(value);
		} else {
			return new PlainWord(value);
		}
	}

}
