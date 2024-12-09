package com.lab12.recursion;

/**
 * A recursive parser for mathematical expressions that handles basic arithmetic operations
 * with proper operator precedence.
 */
public class ExpressionParser {
    private int pos = 0;
    private String expression;
    
    public ExpressionParser(String expression) {
        this.expression = expression.replaceAll("\\s+", "");
    }
    
    public static double evaluateExpression(String expr) {
        if (expr == null || expr.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }
        return new ExpressionParser(expr).parseExpression();
    }
    
    private double parseExpression() {
        double result = parseTerm();
        
        while (pos < expression.length()) {
            char operator = expression.charAt(pos);
            if (operator != '+' && operator != '-') {
                break;
            }
            pos++;
            if (operator == '+') {
                result += parseTerm();
            } else {
                result -= parseTerm();
            }
        }
        
        return result;
    }
    
    private double parseTerm() {
        double result = parseFactor();
        
        while (pos < expression.length()) {
            if (pos >= expression.length()) break;
            
            char operator = expression.charAt(pos);
            if (operator != '*' && operator != '/') {
                break;
            }
            pos++;
            
            if (operator == '*') {
                result *= parseFactor();
            } else {
                double divisor = parseFactor();
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result /= divisor;
            }
        }
        
        return result;
    }
    
    private double parseFactor() {
        char currentChar = expression.charAt(pos);
        
        // Handle parentheses
        if (currentChar == '(') {
            pos++; // Skip '('
            double result = parseExpression();
            
            if (pos >= expression.length() || expression.charAt(pos) != ')') {
                throw new IllegalArgumentException("Missing closing parenthesis");
            }
            pos++; // Skip ')'
            return result;
        }
        
        // Handle negative numbers and negative expressions
        boolean isNegative = false;
        if (currentChar == '-') {
            isNegative = true;
            pos++;
            currentChar = expression.charAt(pos);
        }
        
        // Parse number
        StringBuilder numberStr = new StringBuilder();
        
        // Handle parentheses after negative sign
        if (currentChar == '(') {
            pos++; // Skip '('
            double result = parseExpression();
            if (pos >= expression.length() || expression.charAt(pos) != ')') {
                throw new IllegalArgumentException("Missing closing parenthesis");
            }
            pos++; // Skip ')'
            return isNegative ? -result : result;
        }
        
        // Parse regular number
        while (pos < expression.length() && 
               (Character.isDigit(expression.charAt(pos)) || 
                expression.charAt(pos) == '.')) {
            numberStr.append(expression.charAt(pos));
            pos++;
        }
        
        if (numberStr.length() == 0) {
            throw new IllegalArgumentException("Invalid number format");
        }
        
        double value = Double.parseDouble(numberStr.toString());
        return isNegative ? -value : value;
    }
    
    public static void main(String[] args) {
        System.out.println("Enter an expression (or 'exit' to quit):");
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nEnter expression: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                double result = evaluateExpression(input);
                System.out.printf("Result: %.2f%n", result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Program terminated.");
    }
}