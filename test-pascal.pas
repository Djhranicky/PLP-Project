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
CLASS Square
    PRIVATE
        side: Real;
    PUBLIC
        CONSTRUCTOR Create(s: Real);
        FUNCTION GetArea: Real;
        FUNCTION GetPerimeter: Real;
        Destructor Destroy;

    CONSTRUCTOR Create(s: Real);
    BEGIN
        side := s;
    END;

    FUNCTION GetArea: Real;
    BEGIN
        GetArea := side * side;
    END;

    FUNCTION GetPerimeter: Real;
    BEGIN
        GetPerimeter := side * 4;
    END;
END;
BEGIN
    a := 10;
    b := 5;
    c := a + b - 1;
    System.PrintLn(c);
    d := a / b * 17;
    System.PrintLn(d);
    e := System.ReadLn();
    System.PrintLn(e);

    rect := Rectangle.Create(1, 2);
    area := rect.GetArea();
    rect.Destroy;

    IF a > b
    THEN a := a - 1
    ELSE a := a + 1;

    triangle := 0;
    WHILE b > 0
    DO
    BEGIN
        triangle := triangle + b;
        b := b - 1;
    END;

    FOR counter := 0 TO 5
    DO counter := counter - 1;
END.
