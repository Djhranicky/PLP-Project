PROGRAM CompleteClass;
CLASS Rectangle
    PRIVATE
        width, height: Real;
    PUBLIC
        CONSTRUCTOR Create(w, h: Real);
        FUNCTION GetArea: Real;

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
BEGIN
END.