# PoemGenerator

To compile and execute the solution, Gradle 2.3 must be installed to properly manage libraries dependencies. Once Gradle is installed, you can build solution using the following command:
gradle clean fatJar

This command will generate a JAR with all required dependencies at '\build\libs\' directory. To execute, simply open a command line console, go to the directory and use the following line:
	java -jar PoemGenerator-all

MainClass PoemGenerator has three parameters, all of them optional:
1 - [-p] to order to generate poem with a trace of the rules applied. False by default.
2 - grammarPath: path of the grammar wanted to use to generate the poem. By default, PoemGenerator looks for a file named "poemGrammar.txt" located in 'user.dir' directory (which by default is the directory of execution)
3 - poemPath: path of a file to print the generated poem. By default PoemGenerator generates a file named "poemOut.txt" located in 'user.dir' directory.