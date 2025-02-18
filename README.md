# PLP-Project 1

Authored by David Hranicky and Paraman Galipalli

## Executing Programs

Followed [this](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md) documentation to get ANTLR running locally.

Had to set up a grun.bat file in a directory in my PATH variable.

Can compile and run the Main.java project just by navigating to the base directory and running the `run.bat` file. This will generate all of the required antlr files, and cross compiles those with the included `DelphiInterpreter.java` file and run the `Main.java` file to parse the `test-pascal.pas` file with the grammar.

Once compiled, the parse tree can also be visualized with a gui by running the `test.bat` file.

The grammar defined in delphi.g4 is capable of parsing class definitions with multiple access specifiers, encapsulated properties, and constructors, destructors, and functions. It can also parse statements that can be run in the execution block, including regular arithmetic, object creation and method access, and basic control logic (if, while, for).

As a proof of concept, the included interpreter is able to take that parsed information and print out diagnostic information about the class declaration(s). It is also equiped to execute basic variable assigning and arithmetic, and can read and write values to the standard input.

Future goals for the project could include:

* Adding control logic handling
* Instantiating class objects with related code/properties
* Adding inheritance and interface support to the grammar and interpreter
* Abstracting functionality in the DelphiInterpreter.java file into AST.java for ease of use and greater extensibility
