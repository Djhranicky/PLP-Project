# PLP-Project 1

Authored by David Hranicky and Paraman Galipalli

## Executing Programs

So far, I am not familiar with exactly how ANTLR works. I have the ANTLR tools downloaded, and can create the parse trees (cli or gui). Still not sure how generating the java code and running test cases works yet

Followed [this](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md) documentation to get ANTLR running locally.

Following [this](https://www.youtube.com/watch?v=cWUbZ0fCZB4&list=PL5dxAmCmjv_4FGYtGzcvBeoS-BobRTJLq&index=2) youtube video to understand how to actually run test-cases.

Was finally able to get something working. Not a big fan of it and not sure if it's the intended way, but I can actually run against test cases it seems.

Had to set up a grun.bat file in a directory in my PATH variable.

Can run with the following steps:

* `antlr4 delphi.g4`
* `javac delphi*.java`
* `grun.bat delphi program [input test file] -gui &`
