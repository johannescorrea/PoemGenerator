package com.johannes.grammar;

import java.util.ArrayList;
import java.util.List;

class GrammarRuleImpl implements GrammarRule {
	
	private String name;
	private List<GrammarStep> steps;
	
	GrammarRuleImpl(String name) {
		this.name = name;
		this.steps = new ArrayList<GrammarStep>();
	}

	public String getName() {
		return name;
	}
	
	public void addStep(GrammarStep step) {
		steps.add(step);
	}

	public String processRule() {
		StringBuilder builder = new StringBuilder();
		for (GrammarStep grammarStep : steps) {
			String stepText = grammarStep.processStep();
			builder.append(stepText);
			if(!stepText.endsWith(System.lineSeparator())) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	public int getStepsCount() {
		return steps.size();
	}

}
