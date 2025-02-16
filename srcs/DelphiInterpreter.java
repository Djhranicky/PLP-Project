import java.util.*;

public class DelphiInterpreter extends delphiBaseListener {
    public static class Value {
        public enum ValueType {INTEGER, REAL, STRING, NIL};

        private ValueType type;
        private int integerValue;
        private double realValue;
        private String stringValue;

        public Value(int i) {
            type = ValueType.INTEGER;
            integerValue = i;
        }
        public Value(double r) {
            type = ValueType.REAL;
            realValue = r;
        }
        public Value(String s) {
            type = ValueType.STRING;
            stringValue = s;
        }
        public Value() {
            type = ValueType.NIL;
        }
    }

    private Map<String, Value> variables = new HashMap<>();


    @Override
    public void enterProgramHeading(delphiParser.ProgramHeadingContext ctx) {
        System.out.println("Running program: " + ctx.identifier().getText());
    }

    @Override
    public void enterClassDecl(delphiParser.ClassDeclContext ctx) {
        System.out.println("Declaring class: " + ctx.identifier(0).getText());
    }

    @Override
    public void enterMemberSection(delphiParser.MemberSectionContext ctx) {
        String accessType = ctx.getChild(0).getText();
        List<delphiParser.MemberDeclContext> memberDeclList = ctx.memberList().memberDecl();

        for(delphiParser.MemberDeclContext memberDecl : memberDeclList ) {
            String className = memberDecl.getChild(0).getClass().getSimpleName();
            String type = "";

            switch(className) {
                case "VarDeclContext":
                    // List<delphiParser.IdentifierContext> identifiers = memberDecl.varDecl().identifierList().getText();
                    String variables = memberDecl.varDecl().identifierList().getText().replaceAll(",", ", ");
                    type = memberDecl.varDecl().typeIdentifier().getText();
                    System.out.println("Declaring " + accessType.toLowerCase() + " variable(s) \"" + variables + "\" of type " + type);
                    break;
                case "ConstructorDeclContext":
                    String constructorId = memberDecl.constructorDecl().identifier().getText();
                    String paramString = "";
                    delphiParser.ParamListContext paramList = memberDecl.constructorDecl().paramList();
                    List<delphiParser.ParamDeclContext> params = null;
                    if (paramList != null) {
                        params = paramList.paramDecl();
                        for(delphiParser.ParamDeclContext param : params) {
                            String ids = param.identifierList().getText().replaceAll(",", ", ");
                            type = param.typeIdentifier().getText();
                            paramString += ", " + ids + " of type " + type;
                        }
                    }
                    paramString = paramString.length() > 0 ? " with parameters " + paramString.substring(1) : "";
                    System.out.println("Declaring " + accessType.toLowerCase() + " constructor " + constructorId +  paramString);
                    break;
                case "MethodDeclContext":
                    String methodID = memberDecl.methodDecl().identifier().getText();
                    type = memberDecl.methodDecl().typeIdentifier().getText();
                    System.out.println("Declaring " + accessType.toLowerCase() + " function " + methodID + " with return type " + type);
                    break;
                case "DestructorDeclContext":
                    String destID = memberDecl.destructorDecl().identifier().getText();
                    System.out.println("Declaring " + accessType.toLowerCase() + " destructor " + destID);
                    break;
            }
        }
        // System.out.println("Declaring " + accessType.toLowerCase() + "");
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
