package org.sergiolozanoprofe;

import org.sergiolozanoprofe.model.OperationType;
import org.sergiolozanoprofe.service.CalculatorService;
import org.sergiolozanoprofe.util.InputParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService service = new CalculatorService();

        try {
            System.out.print("Introduce el primer entero: ");
            String aStr = scanner.nextLine();
            int a = InputParser.parseInt(aStr);

            System.out.print("Introduce la operación (+, -, *, / o palabra): ");
            String opStr = scanner.nextLine();
            OperationType op = InputParser.parseOperation(opStr);

            System.out.print("Introduce el segundo entero: ");
            String bStr = scanner.nextLine();
            int b = InputParser.parseInt(bStr);

            double result = service.compute(a, op, b);

            System.out.println("Resultado: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: entrada no numérica -> " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: operación inválida -> " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: operación aritmética -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}