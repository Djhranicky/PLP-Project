echo off
set arg1=%1
antlr4 grammar/delphi.g4 -o ./srcs
javac srcs/*.java
java -cp srcs Main
::grun.bat delphi program %arg1% -gui &