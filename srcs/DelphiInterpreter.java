

public class DelphiInterpreter extends DelphiBaseListener {
    @Override
    public void enterProgram(DelphiParser.ProgramContext ctx) {
        System.out.println("enterProgram: " + ctx.getText());
    }

    @Override
    public void exitProgram(DelphiParser.ProgramContext ctx) {
        System.out.println("exitProgram: " + ctx.getText());
    }
}
