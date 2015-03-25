package com.johannes.grammar;


public interface GrammarRule {

	public String getName();

	public String processRule();

	public int getStepsCount();
	
	public void addStep(GrammarStep step);

}
