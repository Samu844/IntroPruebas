package org.sergiolozanoprofe.service;

import org.sergiolozanoprofe.model.OperationType;

public class CalculatorService {

    // Método que recibe la operación y delega en los métodos individuales
    public double compute(int a, OperationType op, int b) {
        return switch (op) {
            case ADD -> add(a, b);
            case SUBTRACT -> subtract(a, b);
            case MULTIPLY -> multiply(a, b);
            case DIVIDE -> divide(a, b);
        };
    }

    // Métodos individuales para cada operación
    public double add(int a, int b) {
        return (double) a + b;
    }

    public double subtract(int a, int b) {
        return (double) a - b;
    }

    public double multiply(int a, int b) {
        return (double) a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return (double) a / b;
    }
}
