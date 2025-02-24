import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.antlr.v4.runtime.tree.*;;;

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

        public int getInt() {
            switch(type) {
                case INTEGER: return integerValue;
                case REAL: return (int) integerValue;
                case STRING: throw new RuntimeException("Cannot convert STRING into int");
                case NIL: return 0;
            }
            return 0;
        }

        public String getString() {
            switch(type) {
                case INTEGER: return "" + integerValue;
                case REAL: return "" + realValue;
                case STRING: return stringValue;
                case NIL: return "";
            }
            return "";
        }

        public double getReal() {
            switch(type) {
                case INTEGER: return (double) integerValue;
                case REAL: return realValue;
                case STRING: throw new RuntimeException("Cannot convert STRING into Real");
                case NIL: return 0.0;
            }
            return 0.0;
        }

        public static Value add(Value left, Value right) {
            if (left.type == ValueType.REAL || right.type == ValueType.REAL) {
                return new Value(left.getReal() + right.getReal());
            } else {
                return new Value(left.getInt() + right.getInt());
            }
        }

        public static Value sub(Value left, Value right) {
            if (left.type == ValueType.REAL || right.type == ValueType.REAL) {
                return new Value(left.getReal() - right.getReal());
            } else {
                return new Value(left.getInt() - right.getInt());
            }
        }

        public static Value mul(Value left, Value right) {
            if (left.type == ValueType.REAL || right.type == ValueType.REAL) {
                return new Value(left.getReal() * right.getReal());
            } else {
                return new Value(left.getInt() * right.getInt());
            }
        }

        public static Value div(Value left, Value right) {
            return new Value(left.getReal() / right.getReal());
        }
    }

    public static class DelphiIdentifier {
        public enum AccessType {PUBLIC, PRIVATE, PROTECTED};
        public enum IdentifierType {CONSTRUCTOR, DESTRUCTOR, FUNCTION, VARIABLE};

        private AccessType access;
        private IdentifierType identifier;
        private String tokenName;

        public DelphiIdentifier(AccessType a, IdentifierType i, String t) {
            access = a;
            identifier = i;
            tokenName = t;
        }

        public String getAccess() {
            switch(access) {
                case PUBLIC: return "PUBLIC";
                case PRIVATE: return "PRIVATE";
                case PROTECTED: return "PROTECTED";
            }
            return "PUBLIC";
        }

        public String getIdentifierType() {
            switch(identifier) {
                case CONSTRUCTOR: return "CONSTRUCTOR";
                case DESTRUCTOR: return "DESTRUCTOR";
                case FUNCTION: return "FUNCTION";
                case VARIABLE: return "VARIABLE";
            }
            return "CONSTRUCTOR";
        }

        public String getTokenName() {
            return tokenName;
        }
    }

    public static class DelphiClass {
        private String className;
        private DelphiIdentifier constructor;
        private DelphiIdentifier destructor;
        private List<DelphiIdentifier> functions;
        private List<DelphiIdentifier> variables;

        public DelphiClass(String c) {
            className = c;
        }

        public void setConstructor(DelphiIdentifier c) {
            if (c.getIdentifierType().equals("CONSTRUCTOR")) {
                constructor = c;
            } else {
                throw new RuntimeException("DelphiClass constructor must be of identifier type CONSTRUCTOR");
            }
        }

        public void setDestructor(DelphiIdentifier d) {
            if (d.getIdentifierType().equals("DESTRUCTOR")) {
                destructor = d;
            } else {
                throw new RuntimeException("DelphiClass destructor must be of identifier type DESTRUCTOR");
            }
        }

        public void addFunction(DelphiIdentifier f) {
            if (f.getIdentifierType().equals("FUNCTION")) {
                if (functions == null) {
                    functions = new ArrayList<DelphiIdentifier>();
                }
                functions.add(f);
            } else {
                throw new RuntimeException("DelphiClass function must be of identifier type FUNCTION");
            }
        }

        public void addVariable(DelphiIdentifier v) {
            if (v.getIdentifierType().equals("VARIABLE")) {
                if (variables == null) {
                    variables = new ArrayList<DelphiIdentifier>();
                }
                variables.add(v);
            } else {
                throw new RuntimeException("DelphiClass variable must be of identifier type VARIABLE");
            }
        }
    }

    private Map<String, Value> variables = new HashMap<>();
    private Deque<Value> valueStack = new ArrayDeque<>();

    private void pushValue(Value v) {
        valueStack.push(v);
    }

    private Value popValue() {
        return valueStack.pop();
    }


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
            if (memberDecl.varDecl() != null) {
                    String variables = memberDecl.varDecl().identifierList().getText().replaceAll(",", ", ");
                String type = memberDecl.varDecl().typeIdentifier().getText();
                System.out.println("Declaring " + accessType.toLowerCase() + " variable(s) \"" + variables + "\" of type " + type);
            }
            else if (memberDecl.constructorDecl() != null) {
                String constructorId = memberDecl.constructorDecl().identifier().getText();
                String paramString = "";
                delphiParser.ParamListContext paramList = memberDecl.constructorDecl().paramList();
                List<delphiParser.ParamDeclContext> params = null;
                if (paramList != null) {
                    params = paramList.paramDecl();
                    for(delphiParser.ParamDeclContext param : params) {
                        String ids = param.identifierList().getText().replaceAll(",", ", ");
                        String type = param.typeIdentifier().getText();
                        paramString += ", " + ids + " of type " + type;
                    }
                }
                paramString = paramString.length() > 0 ? " with parameters" + paramString.substring(1) : "";
                System.out.println("Declaring " + accessType.toLowerCase() + " constructor " + constructorId +  paramString);
            }
            else if (memberDecl.methodDecl() != null) {
                String methodID = memberDecl.methodDecl().identifier().getText();
                String type = memberDecl.methodDecl().typeIdentifier().getText();
                System.out.println("Declaring " + accessType.toLowerCase() + " function " + methodID + " with return type " + type);
            }
            else if (memberDecl.destructorDecl() != null) {
                String destID = memberDecl.destructorDecl().identifier().getText();
                System.out.println("Declaring " + accessType.toLowerCase() + " destructor " + destID);
            }
        }
    }

    @Override
    public void exitSimpleExpr(delphiParser.SimpleExprContext ctx) {
        if(ctx.identifier() != null) {
            String name = ctx.identifier().getText();
            Value val = variables.get(name);
            if (val == null) {
                // For uninitialized variables, default to nil?
                val = new Value();
            }
            pushValue(val);
        } else if (ctx.constantValue() != null) {
            delphiParser.ConstantValueContext constCtx = ctx.constantValue();
            if (constCtx.NUM_INT() != null) {
                int i = Integer.parseInt(constCtx.NUM_INT().getText());
                pushValue(new Value(i));
            } else if (constCtx.NUM_REAL() != null) {
                double d = Double.parseDouble(constCtx.NUM_REAL().getText());
                pushValue(new Value(d));
            } else if (constCtx.STRING() != null) {
                String raw = constCtx.STRING().getText();
                // Strip quotes
                String s = raw.substring(1, raw.length() - 1);
                pushValue(new Value(s));
            }
        }
    }

    @Override
    public void exitMemberAccess(delphiParser.MemberAccessContext ctx) {
        if (ctx.LPAREN() != null && ctx.RPAREN() != null) {
            String firstId = ctx.identifier(0).getText();
            boolean isDotCall = (ctx.identifier().size() > 1);

            if (isDotCall && firstId.equalsIgnoreCase("System") && ctx.identifier(1).getText().equalsIgnoreCase("ReadLn")) {
                try {
                    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter a string: ");
                    String inputString = r.readLine();
                    pushValue(new Value(inputString));
                } catch(IOException ex) {

                }
            }
            if (isDotCall && firstId.equalsIgnoreCase("System") && ctx.identifier(1).getText().equalsIgnoreCase("PrintLn")) {
                Value outValue = variables.get(ctx.argList().getText());
                System.out.println(outValue.getString());
            }
        }
    }

    @Override
    public void exitAdditiveExpr(delphiParser.AdditiveExprContext ctx) {
        int plusCount = ctx.PLUS().size();
        int minusCount = ctx.MINUS().size();
        int opCount = plusCount + minusCount;
        if (opCount == 0) return; // no operation

        List<ParseTree> children = ctx.children;
        int numChildren = children.size();
        Value sum = new Value();
        for (int i = numChildren - 1; i >=2; i = i - 2) {
            Value current = popValue();
            if (children.get(i-1).getText().equals("+")){
                sum = Value.add(sum, current);
            } else {
                sum = Value.sub(sum, current);
            }
        }
        Value left = popValue();
        pushValue(Value.add(left, sum));
    }

    @Override
    public void exitMultiplicativeExpr(delphiParser.MultiplicativeExprContext ctx) {
        // multiplicativeExpr: unaryExpr ((MULTIPLY | DIVIDE) unaryExpr)*
        int mulCount = ctx.MULTIPLY().size();
        int divCount = ctx.DIVIDE().size();
        int opCount = mulCount + divCount;
        if (opCount == 0) return;

        List<ParseTree> children = ctx.children;
        int numChildren = children.size();
        Value sum = new Value(1);
        for (int i = numChildren - 1; i >=2; i = i - 2) {
            Value current = popValue();
            if (children.get(i-1).getText().equals("*")){
                sum = Value.mul(sum, current);
            } else {
                sum = Value.div(sum, current);
            }
        }
        Value left = popValue();
        pushValue(Value.mul(left, sum));
    }

    @Override
    public void exitVarAssign(delphiParser.VarAssignContext ctx) {
        // varAssign: identifier ASSIGN expr
        Value rhs = popValue();  // expression value
        String varName = ctx.identifier().getText();
        variables.put(varName, rhs);
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
