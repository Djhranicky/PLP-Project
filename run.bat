echo off
set arg1=%1
antlr4 grammar/Delphi.g4 -o ./src
javac src/Delphi*.java -d ./src