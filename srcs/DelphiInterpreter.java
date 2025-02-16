public class DelphiInterpreter extends delphiBaseListener {
    @Override
    public void enterProgramHeading(delphiParser.ProgramHeadingContext ctx) {
        System.out.println("Running program: " + ctx.identifier().getText());
    }

    @Override
    public void enterClassDecl(delphiParser.ClassDeclContext ctx) {
        System.out.println("Declaring class: " + ctx.identifier(0).getText());
    }

    @Override
    public void enterProgram(delphiParser.ProgramContext ctx) {
        // System.out.println("enterProgram: " + ctx.getText());
    }

    @Override
    public void exitProgram(delphiParser.ProgramContext ctx) {
        // System.out.println("exitProgram: " + ctx.getText());
    }

    @Override
    public void enterIdentifierList(delphiParser.IdentifierListContext ctx) {
        // System.out.println("enterIdentifierList: " + ctx.getText());
    }

    @Override
    public void enterIdentifier(delphiParser.IdentifierContext ctx) {
        // System.out.println("enterIdentifier: " + ctx.getText());
    }
}
