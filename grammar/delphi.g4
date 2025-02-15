grammar delphi;
options {
    caseInsensitive = true;
}

// Program Structure
program
    : programHeading (INTF)? block DOT EOF
    ;

programHeading
    : PROGRAM identifier (LPAREN identifierList RPAREN)? SEMI
    | UNIT identifier SEMI
    ;

block
    : declarations
      compoundStatement
    ;

declarations
    : (declaration)*
    ;

declaration
    : labelDeclPart
    | constDefPart
    | typeDefPart
    | varDeclSection
    | procFuncDeclPart
    | classDecl
    | usesUnitsPart
    | IMPL SEMI
    ;

// Labels
labelDeclPart
    : LABEL label (COMMA label)* SEMI
    ;

// Constants
constDefPart
    : CONST (constDef SEMI)+
    ;

constDef
    : identifier EQUAL constantValue
    ;

// Types
typeDefPart
    : TYPE (typeDef SEMI)+
    ;

typeDef
    : identifier EQUAL typeIdentifier
    ;

// Variables
varDeclSection
    : VAR (varDecl SEMI)+
    ;

varDecl
    : identifierList COLON typeIdentifier
    ;

// Procedures and Functions
procFuncDeclPart
    : (procDecl | funcDecl)+
    ;

procDecl
    : PROCEDURE identifier (LPAREN paramList? RPAREN)? SEMI block? SEMI
    ;

funcDecl
    : FUNCTION identifier (LPAREN paramList? RPAREN)? COLON typeIdentifier SEMI block? SEMI
    ;

// Classes
classDecl
    : CLASS identifier (EXTENDS identifier)?
      classBody
      END SEMI
    ;

classBody
    : memberSections?
      methodImplementations?
    ;

memberSections
    : memberSection+
    ;

memberSection
    : accessSpecifier memberList
    ;

memberList
    : (memberDecl SEMI)*
    ;

memberDecl
    : varDecl
    | methodDecl
    | constructorDecl
    | destructorDecl
    ;

methodDecl
    : FUNCTION identifier (LPAREN paramList? RPAREN)? COLON typeIdentifier
    | PROCEDURE identifier (LPAREN paramList? RPAREN)?
    ;

constructorDecl
    : CONSTRUCTOR identifier (LPAREN paramList? RPAREN)?
    ;

destructorDecl
    : DESTRUCTOR identifier
    ;

methodImplementations
    : methodImplementation+
    ;

methodImplementation
    : functionImplementation
    | procedureImplementation
    | constructorImplementation
    ;

functionImplementation
    : FUNCTION identifier (LPAREN paramList? RPAREN)? COLON typeIdentifier SEMI
      block
      SEMI
    ;

procedureImplementation
    : PROCEDURE identifier (LPAREN paramList? RPAREN)? SEMI
      block
      SEMI
    ;

constructorImplementation
    : CONSTRUCTOR identifier (LPAREN paramList? RPAREN)? SEMI
      block
      SEMI
    ;

// Uses
usesUnitsPart
    : USES identifierList SEMI
    ;

// Access Specifiers
accessSpecifier
    : PUBLIC
    | PRIVATE
    | PROTECTED
    ;

// Parameters
paramList
    : paramDecl (SEMI paramDecl)*
    ;

paramDecl
    : identifierList COLON typeIdentifier
    ;

// Compound Statement
compoundStatement
    : BEGIN stmtList END
    ;

stmtList
    : (stmt SEMI)*
    ;

stmt
    : varAssign
    | memberAccess
    | compoundStatement
    | ifStmt
    | whileStmt
    | forStmt
    | /* empty */
    ;

ifStmt
    : IF expr THEN stmt (ELSE stmt)?
    ;

whileStmt
    : WHILE expr DO stmt
    ;

forStmt
    : FOR identifier ASSIGN expr TO expr DO stmt
    ;

varAssign
    : identifier ASSIGN expr
    ;

memberAccess
    : identifier (DOT identifier)*
    | identifier DOT identifier LPAREN argList? RPAREN
    ;

argList
    : expr (COMMA expr)*
    ;

// Expressions
expr
    : simpleExpr
    | complexExpr
    ;

simpleExpr
    : identifier
    | constantValue
    | memberAccess
    ;

complexExpr
    : logicalOrExpr
    ;

logicalOrExpr
    : logicalAndExpr (OR logicalAndExpr)*
    ;

logicalAndExpr
    : equalityExpr (AND equalityExpr)*
    ;

equalityExpr
    : relationalExpr ((EQUAL | NOT_EQUAL) relationalExpr)*
    ;

relationalExpr
    : additiveExpr ((LESS_THAN | GREATER_THAN | LESS_EQUAL | GREATER_EQUAL) additiveExpr)*
    ;

additiveExpr
    : multiplicativeExpr ((PLUS | MINUS) multiplicativeExpr)*
    ;

multiplicativeExpr
    : unaryExpr ((MULTIPLY | DIVIDE) unaryExpr)*
    ;

unaryExpr
    : (PLUS | MINUS | NOT)? primaryExpr
    ;

primaryExpr
    : simpleExpr
    | LPAREN expr RPAREN
    ;

// Basic Elements
identifier
    : IDENT
    ;

label
    : IDENT
    | NUM_INT
    ;

constantValue
    : NUM_INT
    | NUM_REAL
    | STRING
    ;

identifierList
    : identifier (COMMA identifier)*
    ;

typeIdentifier
    : identifier
    ;

// Lexer Rules
PROGRAM     : 'PROGRAM';
UNIT        : 'UNIT';
INTF        : 'INTERFACE';
IMPL        : 'IMPLEMENTATION';
CLASS       : 'CLASS';
EXTENDS     : 'EXTENDS';
CONSTRUCTOR : 'CONSTRUCTOR';
DESTRUCTOR  : 'DESTRUCTOR';
PROCEDURE   : 'PROCEDURE';
FUNCTION    : 'FUNCTION';
PUBLIC      : 'PUBLIC';
PRIVATE     : 'PRIVATE';
PROTECTED   : 'PROTECTED';
TYPE        : 'TYPE';
CONST       : 'CONST';
VAR         : 'VAR';
BEGIN       : 'BEGIN';
END         : 'END';
LABEL       : 'LABEL';
USES        : 'USES';
IF          : 'IF';
THEN        : 'THEN';
ELSE        : 'ELSE';
FOR         : 'FOR';
TO          : 'TO';
DO          : 'DO';
WHILE       : 'WHILE';
AND         : 'AND';
OR          : 'OR';
NOT         : 'NOT';

DOT         : '.';
COLON       : ':';
SEMI        : ';';
COMMA       : ',';
LPAREN      : '(';
RPAREN      : ')';
ASSIGN      : ':=';
EQUAL       : '=';
NOT_EQUAL   : '<>';
LESS_THAN   : '<';
GREATER_THAN: '>';
LESS_EQUAL  : '<=';
GREATER_EQUAL: '>=';
PLUS        : '+';
MINUS       : '-';
MULTIPLY    : '*';
DIVIDE      : '/';

IDENT       : [a-zA-Z_] [a-zA-Z0-9_]*;
NUM_INT     : [0-9]+;
NUM_REAL    : [0-9]+ '.' [0-9]+;
STRING      : '"' .*? '"';
WS          : [ \t\r\n]+ -> skip;
COMMENT     : '(*' .*? '*)' -> skip;