package com.johannes;

import java.util.List;

public interface GrammarRule {

	String getName();

	List<? extends Word> getWords();

}
