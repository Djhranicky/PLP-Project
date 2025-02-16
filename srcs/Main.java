import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String args[]) throws IOException {
        CharStream inputStream = CharStreams.fromFileName("test-pascal.pas");

        DelphiLexer delphiLexer = new DelphiLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(delphiLexer);
        DelphiParser delphiParser = new DelphiParser(tokens);
        ParseTree tree = delphiParser.program();
        DelphiInterpreter listener = new DelphiInterpreter();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }
}
