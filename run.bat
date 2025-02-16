echo off
set arg1=%1
antlr4 delphi.g4
javac delphi*.java
grun.bat delphi program %arg1% -gui &