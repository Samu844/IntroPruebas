package org.sergiolozanoprofe.model;

public enum OperationType {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    public static OperationType fromString(String s) {
        if (s == null) throw new IllegalArgumentException("Operación nula");
        String t = s.trim().toLowerCase();
        return switch (t) {
            case "+", "add", "suma", "sum" -> ADD;
            case "-", "subtract", "resta", "sub" -> SUBTRACT;
            case "*", "x", "multiply", "multiplica", "multiplicacion", "mul" -> MULTIPLY;
            case "/", "div", "divide", "division", "dividir" -> DIVIDE;
            default -> throw new IllegalArgumentException("Operación inválida: " + s);
        };
    }
}
