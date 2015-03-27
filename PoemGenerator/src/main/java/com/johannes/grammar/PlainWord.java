package com.johannes.grammar;

public class PlainWord extends Word {

	protected PlainWord(String value) {
		super(value);
	}

	@Override
	public boolean isRuleReference() {
		return false;
	}

	@Override
	public boolean isKeyword() {
		return false;
	}

	@Override
	public String getValue() {
		return value;
	}

}
