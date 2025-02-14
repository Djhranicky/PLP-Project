import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String args[]) {
        CharStream inputStream = CharStreams.fromString("program HelloWorld;\r\n" + //
                        "uses crt;\r\n" + //
                        "\r\n" + //
                        "(* Here the main program block starts *)\r\n" + //
                        "begin\r\n" + //
                        "   writeln('Hello, World!');\r\n" + //
                        "   readkey;\r\n" + //
                        "end.");

        DelphiLexer delphiLexer = new DelphiLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(delphiLexer);
        DelphiParser delphiParser = new DelphiParser(tokens);
        ParseTree tree = delphiParser.program();
        DelphiInterpreter listener = new DelphiInterpreter();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }
}
