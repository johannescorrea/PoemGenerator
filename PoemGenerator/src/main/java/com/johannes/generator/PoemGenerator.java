package com.johannes.generator;

import java.io.FileWriter;
import java.io.IOException;

import com.johannes.grammar.Grammar;
import com.johannes.grammar.PoemGrammarParser;
import com.johannes.grammar.exceptions.GrammarException;

public class PoemGenerator {

	private static final String DEFAULT_OUTPUT = System.getProperty("user.dir")+"/poemOut.txt";
	private static final String DEFAULT_GRAMMAR = System.getProperty("user.dir")+"/poemGrammar.txt";
	private String grammarPath;
	private String poemPath;

	public PoemGenerator() {
		this(null, null, false);
	}

	public PoemGenerator(String grammarPath) {
		this(grammarPath, DEFAULT_OUTPUT, false);
	}

	public PoemGenerator(String grammarPath, String poemPath) {
		this(grammarPath, poemPath, false);
	}

	public PoemGenerator(String grammarPath, String poemPath,
			boolean includeTrace) {
		
		this.grammarPath = grammarPath!=null?grammarPath:DEFAULT_GRAMMAR;
		this.poemPath = poemPath!=null?poemPath:DEFAULT_OUTPUT;
		System.setProperty("includeGrammarTrace",
				Boolean.toString(includeTrace));
	}

	public void generatePoem() {
		PoemGrammarParser parser = new PoemGrammarParser();
		Grammar grammar = parser.parseGrammar(grammarPath);

		FileWriter writer = null;

		try {
			String poem = grammar.generateText("POEM");
			if (poemPath == null) {
				System.out.println(poem);
			} else {
				writer = new FileWriter(poemPath);
				writer.write(poem);
				writer.flush();
			}
		} catch (IOException e) {
			throw new PoemGeneratorException(e);
		} catch (GrammarException e) {
			throw e;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		if (args.length == 1 && args[0].equals("/?")) {
			System.out
					.println("PoemGenerator usage: PoemGenerator [-p] [pathToGrammar] [pathToPoem]");
			System.out
					.println("\t [-p] \t\t\tOptional indicator to print out rule traces applied during grammar processing. False by default");
			System.out
					.println("\t [pathToGrammar] \tPath to file with grammar definition");
			System.out
					.println("\t [pathToPoem] \t\tPath to output file where poem will be printerd. If ommited, poem will be printed to console");
			System.exit(1);
		}

		
		
		
		String grammarPath = null;
		String poemPath = null;
		boolean trace = false;
		try {
			if (args.length>0 && args[0].equals("-p")) {
				trace = true;
				try {
					grammarPath = args[1];
					poemPath = args[2];
				} catch (IndexOutOfBoundsException iobe) {
				}
				
			} else {
				
				try {
					grammarPath = args[0];
					poemPath = args[1];
				} catch (IndexOutOfBoundsException iobe) {
				}
			}
			PoemGenerator generator = new PoemGenerator(grammarPath, poemPath, trace);
			generator.generatePoem();

			System.exit(0);
		} catch (Throwable e) {
			e.printStackTrace(System.out);
			System.exit(1);
		}

	}

}
