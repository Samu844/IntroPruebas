package org.sergiolozanoprofe.util;

public class InputParser {

    private InputParser() {
        // utilidad estática
    }

    public static int parseInt(String s) {
        if (s == null) throw new NumberFormatException("Entrada nula");
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("No es un entero válido: '" + s + "'");
        }
    }

    public static org.sergiolozanoprofe.model.OperationType parseOperation(String s) {
        return org.sergiolozanoprofe.model.OperationType.fromString(s);
    }
}
