# PLP-Project 1

Authored by David Hranicky and Paraman Galipalli

## Executing Programs

Followed [this](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md) documentation to get ANTLR running locally.

Had to set up a grun.bat file in a directory in my PATH variable.

Can compile and run the Main.java project just by navigating to the base directory and running the `run.bat` file. This will generate all of the required antlr files, and cross compiles those with the included `DelphiInterpreter.java` file and run the `Main.java` file to parse the `test-pascal.pas` file with the grammar.

Once compiled, the parse tree can also be visualized with a gui by running the `test.bat` file.
