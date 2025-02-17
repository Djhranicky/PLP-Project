
import java.util.ArrayList;
import java.util.List;


public class AST {

    public static abstract class Node {}

    public static class ProgramNode extends Node {
        public String name;              // from programHeading
        public List<DeclarationNode> declarations = new ArrayList<>();
        public CompoundStmtNode mainBlock; // from block: compoundStatement

        public ProgramNode(String name) {
            this.name = name;
        }
    }

    public static abstract class DeclarationNode extends Node {}

    // ex. var x, y: integer
    public static class VarDeclarationNode extends DeclarationNode {
        public List<String> varNames = new ArrayList<>();
        public String typeName;
    }

    // Classes
    public static class ClassDeclarationNode extends DeclarationNode {
        public String className;
        public String parentName; // for EXTENDS
        public List<MemberSectionNode> sections = new ArrayList<>();
        public List<MethodImplementationNode> methodImplementations = new ArrayList<>();
    }

    public static class MemberSectionNode extends Node {
        public String accessSpecifier; // PUBLIC, PRIVATE, PROTECTED
        public List<MemberDeclNode> members = new ArrayList<>();
    }

    public static abstract class MemberDeclNode extends Node {}

    // Fields inside a class
    public static class FieldDeclNode extends MemberDeclNode {
        public List<String> fields = new ArrayList<>();
        public String typeName;
    }

    // A method declaration
    public static class MethodDeclNode extends MemberDeclNode {
        public String name;
        public String returnType; // null or empty if procedure
        public List<ParamDeclNode> params = new ArrayList<>();
    }

    // Constructors & destructors
    public static class ConstructorDeclNode extends MemberDeclNode {
        public String name;
        public List<ParamDeclNode> params = new ArrayList<>();
    }

    public static class DestructorDeclNode extends MemberDeclNode {
        public String name;
    }

    // Parameter
    public static class ParamDeclNode extends Node {
        public List<String> paramNames = new ArrayList<>();
        public String typeName;
    }

    // For the methodImplementation parts (functionImplementation, procedureImplementation, etc.)
    public static class MethodImplementationNode extends Node {
        public boolean isFunction;
        public boolean isConstructor;
        public boolean isDestructor;
        public String name;
        public String returnType;  // if function
        public CompoundStmtNode body; // from block
        public List<ParamDeclNode> params = new ArrayList<>();
    }

    // === Procedures/Functions at the top level (non-class) ===
    public static class ProcedureDeclNode extends DeclarationNode {
        public String name;
        public List<ParamDeclNode> params = new ArrayList<>();
        public CompoundStmtNode body;
    }

    public static class FunctionDeclNode extends DeclarationNode {
        public String name;
        public String returnType;
        public List<ParamDeclNode> params = new ArrayList<>();
        public CompoundStmtNode body;
    }

    public static abstract class StmtNode extends Node {}

    public static class CompoundStmtNode extends StmtNode {
        public List<StmtNode> statements = new ArrayList<>();
    }

    public static class AssignStmtNode extends StmtNode {
        public String varName;
        public ExprNode expr;
    }

    public static class IfStmtNode extends StmtNode {
        public ExprNode condition;
        public StmtNode thenStmt;
        public StmtNode elseStmt;
    }

    public static class WhileStmtNode extends StmtNode {
        public ExprNode condition;
        public StmtNode body;
    }

    public static class ForStmtNode extends StmtNode {
        public String varName;
        public ExprNode startExpr;
        public ExprNode endExpr;
        public StmtNode body;
    }

    public static class ProcCallStmtNode extends StmtNode {
        public String procName;      // e.g. "Echo", or last identifier in "obj.Method"
        public List<String> dotChain = new ArrayList<>(); // e.g. ["obj", "Method"] or ["ClassName","Create"]
        public List<ExprNode> args = new ArrayList<>();
        public boolean dottedCall = false; // if there's a "DOT" chain
    }

    // === Expressions ===
    public static abstract class ExprNode extends Node {}

    public static class VarExprNode extends ExprNode {
        public String varName; // e.g. "x"
    }

    public static class LiteralExprNode extends ExprNode {
        public enum LitType { INT, REAL, STRING }
        public LitType litType;
        public String textValue; // stored as string
    }

    public static class BinaryExprNode extends ExprNode {
        public ExprNode left;
        public ExprNode right;
        public String op; // "+", "-", "*", "/", "=", "<", etc.
    }

    public static class UnaryExprNode extends ExprNode {
        public String op; // "+", "-", "not"
        public ExprNode expr;
    }

    public static class ParenExprNode extends ExprNode {
        public ExprNode sub;
    }
    public static class LabelDeclarationNode extends DeclarationNode {
    public List<String> labels = new ArrayList<>();  // Can be identifiers or integers
    }
    
    public static class ConstDeclarationNode extends DeclarationNode {
        public String name;
        public LiteralExprNode value;
    }
    
    public static class TypeDeclarationNode extends DeclarationNode {
        public String name;
        public String type;
    }
    
    public static class UsesNode extends DeclarationNode {
        public List<String> units = new ArrayList<>();
    }
    
    public static class MemberAccessExprNode extends ExprNode {
        public List<String> chain = new ArrayList<>();  // For obj.field.method etc.
    }
    
    public static class MethodCallExprNode extends ExprNode {
        public List<String> chain = new ArrayList<>();  // For obj.method() or method()
        public List<ExprNode> arguments = new ArrayList<>();
    }
    
    public static class EmptyStmtNode extends StmtNode {
        // Represents empty statements allowed by the grammar
    }
    
    public static class UnitNode extends Node {
        public String name;
        public List<DeclarationNode> interfaceSection = new ArrayList<>();
        public List<DeclarationNode> implementationSection = new ArrayList<>();
    }
}
