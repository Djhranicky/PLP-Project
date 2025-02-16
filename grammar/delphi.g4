grammar Delphi;
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

// Label Declaration
labelDeclPart
    : LABEL label (COMMA label)* SEMI
    ;

// Constant Definition
constDefPart
    : CONST (constDef SEMI)+
    ;

constDef
    : identifier EQUAL constantValue
    ;

// Type Definition
typeDefPart
    : TYPE (typeDef SEMI)+
    ;

typeDef
    : identifier EQUAL typeIdentifier
    ;

// Variable Declaration
varDeclSection
    : VAR (varDecl SEMI)+
    ;

varDecl
    : identifierList COLON typeIdentifier
    ;

// Procedure and Function Declaration
procFuncDeclPart
    : (procDecl | funcDecl)+
    ;

procDecl
    : PROC identifier LPAREN paramList? RPAREN SEMI block? SEMI
    ;

funcDecl
    : FUNC identifier LPAREN paramList? RPAREN COLON typeIdentifier SEMI block? SEMI
    ;

// Class Definition
classDecl
    : CLASS identifier (EXTENDS identifier)?
      classBlock
      END SEMI
    ;

classBlock
    : (accessSpecifier COLON classMember+)*
    ;

classMember
    : varDecl SEMI
    | methodDecl
    | ctorDecl
    | dtorDecl
    ;

// Constructor and Destructor
ctorDecl
    : CTOR identifier LPAREN paramList? RPAREN SEMI block SEMI
    ;

dtorDecl
    : DTOR identifier SEMI block SEMI
    ;

methodDecl
    : FUNC identifier LPAREN paramList? RPAREN COLON typeIdentifier SEMI block SEMI
    | PROC identifier LPAREN paramList? RPAREN SEMI block SEMI
    ;

<<<<<<< HEAD:grammar/delphi.g4
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

=======
// Uses Units
>>>>>>> parent of da51469 (Update Class Body structure):grammar/Delphi.g4
usesUnitsPart
    : USES identifierList SEMI
    ;

// Access Specifiers
accessSpecifier
    : PUB
    | PRIV
    | PROT
    ;

// Parameter List
paramList
    : identifierList COLON typeIdentifier (SEMI identifierList COLON typeIdentifier)*
    ;

// Statements
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
    | forStmt
    | whileStmt
    | /* empty */
    ;

ifStmt
    : IF expr THEN stmt (ELSE stmt)?
    ;

forStmt
    : FOR identifier ASSIGN expr TO expr DO stmt
    ;

whileStmt
    : WHILE expr DO stmt
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

// Fast path for simple expressions
simpleExpr
    : identifier
    | constantValue
    | memberAccess
    ;

// Full path for complex expressions
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
INTF        : 'INTF';
IMPL        : 'IMPL';
CLASS       : 'CLASS';
EXTENDS     : 'EXTENDS';
CTOR        : 'CONSTRUCTOR';
DTOR        : 'DESTRUCTOR';
PROC        : 'PROCEDURE';
FUNC        : 'FUNCTION';
PUB         : 'PUBLIC';
PRIV        : 'PRIVATE';
PROT        : 'PROTECTED';
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