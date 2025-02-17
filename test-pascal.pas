PROGRAM CompleteClass;
CLASS Rectangle
    PRIVATE
        width, height: Real;
    PUBLIC
        CONSTRUCTOR Create(w, h: Real);
        FUNCTION GetArea: Real;
        DESTRUCTOR Destroy;

    FUNCTION GetArea: Real;
    BEGIN
        GetArea := width * height;
    END;

    CONSTRUCTOR Create(w, h: Real);
    BEGIN
        width := w;
        height := h;
    END;
END;
(*
CLASS Text
    PRIVATE
        text: String;
    PUBLIC
        CONSTRUCTOR Create();
        DESTRUCTOR Destroy;

    CONSTRUCTOR Create;
    BEGIN
        text := System.ReadLn();
    END;

    DESTRUCTOR Destroy;
    BEGIN
        System.PrintLn(text);
    END;
END;
*)
(*
    Declarations:
    : labelDeclPart
    | constDefPart
    | typeDefPart
    | varDeclSection
    | procFuncDeclPart
    | usesUnitsPart
    | IMPL SEMI
*)
BEGIN
    a := 1;
    d := System.ReadLn();
    System.PrintLn(d);

    IF
        a = b
    THEN
        b := 124;

    WHILE
        a < b
    DO
        b := b - 1;

    FOR counter := 0 TO 3
    DO counter := counter + 1;

(*
    Compound Statements -> Statement List -> Statements:
    : varAssign
    | memberAccess
    | compoundStatement
    | ifStmt
    | whileStmt
    | forStmt
    | /* empty */
    ;
*)
END.
