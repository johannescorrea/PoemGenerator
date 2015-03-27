package com.johannes.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.johannes.grammar.Grammar;
import com.johannes.grammar.PoemGrammarParser;

public class PoemGenerator {

	public static void main(String[] args) {
		
		if(args.length==0 || (args.length==1 && args[0].startsWith("-"))) {
			System.out.println("PoemGenerator usage: PoemGenerator [-p] pathToGrammar [pathToPoem]");
			System.out.println("\t [-p] \tOptional indicator to print out rule traces applied during grammar processing. False by default");
			System.out.println("\t pathToGrammar \tPath to file with grammar definition");
			System.out.println("\t [pathToPoem] \tPath to output file where poem will be printerd. If ommited, poem will be printed to console");
			System.exit(1);
		}
		
		PoemGrammarParser parser = new PoemGrammarParser();
		FileWriter writer = null;
		String grammarPath = null;
		String poemPath = null;
		try {
			if(args[0].equals("-p")) {
				System.setProperty("includeGrammarTrace", Boolean.TRUE.toString());
				grammarPath = args[1];
				if(args.length>2) { 
					poemPath = args[2];
				}
			} else {
				System.setProperty("includeGrammarTrace", Boolean.FALSE.toString());
				grammarPath = args[0];
				if(args.length>1) { 
					poemPath = args[1];
				}
			}
	
			Grammar grammar = parser.parseGrammar(grammarPath);
			String poem = grammar.generateText("POEM");
			if(poemPath==null) {
				System.out.println(poem);
			} else {
				writer = new FileWriter(poemPath);
				writer.write(poem);
				writer.flush();
			}
			System.exit(0);
		} catch(Throwable e) {
			e.printStackTrace(System.out);
			System.exit(1);
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
