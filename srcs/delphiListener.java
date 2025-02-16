// Generated from delphi.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link delphiParser}.
 */
public interface delphiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link delphiParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(delphiParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(delphiParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeading(delphiParser.ProgramHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeading(delphiParser.ProgramHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(delphiParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(delphiParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(delphiParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(delphiParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(delphiParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(delphiParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#labelDeclPart}.
	 * @param ctx the parse tree
	 */
	void enterLabelDeclPart(delphiParser.LabelDeclPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#labelDeclPart}.
	 * @param ctx the parse tree
	 */
	void exitLabelDeclPart(delphiParser.LabelDeclPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constDefPart}.
	 * @param ctx the parse tree
	 */
	void enterConstDefPart(delphiParser.ConstDefPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constDefPart}.
	 * @param ctx the parse tree
	 */
	void exitConstDefPart(delphiParser.ConstDefPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(delphiParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(delphiParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#typeDefPart}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefPart(delphiParser.TypeDefPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#typeDefPart}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefPart(delphiParser.TypeDefPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void enterTypeDef(delphiParser.TypeDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void exitTypeDef(delphiParser.TypeDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#varDeclSection}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclSection(delphiParser.VarDeclSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#varDeclSection}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclSection(delphiParser.VarDeclSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(delphiParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(delphiParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#procFuncDeclPart}.
	 * @param ctx the parse tree
	 */
	void enterProcFuncDeclPart(delphiParser.ProcFuncDeclPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#procFuncDeclPart}.
	 * @param ctx the parse tree
	 */
	void exitProcFuncDeclPart(delphiParser.ProcFuncDeclPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(delphiParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(delphiParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(delphiParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(delphiParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(delphiParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(delphiParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(delphiParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(delphiParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#memberSections}.
	 * @param ctx the parse tree
	 */
	void enterMemberSections(delphiParser.MemberSectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#memberSections}.
	 * @param ctx the parse tree
	 */
	void exitMemberSections(delphiParser.MemberSectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#memberSection}.
	 * @param ctx the parse tree
	 */
	void enterMemberSection(delphiParser.MemberSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#memberSection}.
	 * @param ctx the parse tree
	 */
	void exitMemberSection(delphiParser.MemberSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#memberList}.
	 * @param ctx the parse tree
	 */
	void enterMemberList(delphiParser.MemberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#memberList}.
	 * @param ctx the parse tree
	 */
	void exitMemberList(delphiParser.MemberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#memberDecl}.
	 * @param ctx the parse tree
	 */
	void enterMemberDecl(delphiParser.MemberDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#memberDecl}.
	 * @param ctx the parse tree
	 */
	void exitMemberDecl(delphiParser.MemberDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(delphiParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(delphiParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDecl(delphiParser.ConstructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDecl(delphiParser.ConstructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#destructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterDestructorDecl(delphiParser.DestructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#destructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitDestructorDecl(delphiParser.DestructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#methodImplementations}.
	 * @param ctx the parse tree
	 */
	void enterMethodImplementations(delphiParser.MethodImplementationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#methodImplementations}.
	 * @param ctx the parse tree
	 */
	void exitMethodImplementations(delphiParser.MethodImplementationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#methodImplementation}.
	 * @param ctx the parse tree
	 */
	void enterMethodImplementation(delphiParser.MethodImplementationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#methodImplementation}.
	 * @param ctx the parse tree
	 */
	void exitMethodImplementation(delphiParser.MethodImplementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#functionImplementation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionImplementation(delphiParser.FunctionImplementationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#functionImplementation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionImplementation(delphiParser.FunctionImplementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#procedureImplementation}.
	 * @param ctx the parse tree
	 */
	void enterProcedureImplementation(delphiParser.ProcedureImplementationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#procedureImplementation}.
	 * @param ctx the parse tree
	 */
	void exitProcedureImplementation(delphiParser.ProcedureImplementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constructorImplementation}.
	 * @param ctx the parse tree
	 */
	void enterConstructorImplementation(delphiParser.ConstructorImplementationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constructorImplementation}.
	 * @param ctx the parse tree
	 */
	void exitConstructorImplementation(delphiParser.ConstructorImplementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#usesUnitsPart}.
	 * @param ctx the parse tree
	 */
	void enterUsesUnitsPart(delphiParser.UsesUnitsPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#usesUnitsPart}.
	 * @param ctx the parse tree
	 */
	void exitUsesUnitsPart(delphiParser.UsesUnitsPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessSpecifier(delphiParser.AccessSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessSpecifier(delphiParser.AccessSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(delphiParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(delphiParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void enterParamDecl(delphiParser.ParamDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void exitParamDecl(delphiParser.ParamDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(delphiParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(delphiParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(delphiParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(delphiParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(delphiParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(delphiParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(delphiParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(delphiParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(delphiParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(delphiParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(delphiParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(delphiParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(delphiParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(delphiParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(delphiParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(delphiParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(delphiParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(delphiParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(delphiParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(delphiParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(delphiParser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(delphiParser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#complexExpr}.
	 * @param ctx the parse tree
	 */
	void enterComplexExpr(delphiParser.ComplexExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#complexExpr}.
	 * @param ctx the parse tree
	 */
	void exitComplexExpr(delphiParser.ComplexExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(delphiParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(delphiParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(delphiParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(delphiParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(delphiParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(delphiParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(delphiParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(delphiParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(delphiParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(delphiParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(delphiParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(delphiParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(delphiParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(delphiParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(delphiParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(delphiParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(delphiParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(delphiParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(delphiParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(delphiParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void enterConstantValue(delphiParser.ConstantValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void exitConstantValue(delphiParser.ConstantValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(delphiParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(delphiParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(delphiParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(delphiParser.TypeIdentifierContext ctx);
}