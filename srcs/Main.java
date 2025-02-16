import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String args[]) throws IOException {
        CharStream inputStream = CharStreams.fromFileName("test-pascal.pas");

        delphiLexer delphiLexer = new delphiLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(delphiLexer);
        delphiParser delphiParser = new delphiParser(tokens);
        ParseTree tree = delphiParser.program();
        DelphiInterpreter listener = new DelphiInterpreter();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }
}
