package com.lab12.recursion;

/**
 * Implements recursive calculation of sum of digits in a number,
 * with support for both positive and negative numbers.
 */
public class RecursiveDigitSum {
    
    /**
     * Calculates the sum of digits in a number recursively.
     * 
     * @param number The number to sum digits of
     * @return The sum of all digits in the number
     */
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting to positive
        number = Math.abs(number);
        
        // Base case: single digit number
        if (number < 10) {
            return number;
        }
        
        // Recursive case: sum last digit with sum of remaining digits
        return (number % 10) + sumOfDigits(number / 10);
    }
    
    /**
     * Calculates the sum of digits for a long number recursively.
     * Useful for very large numbers.
     * 
     * @param number The long number to sum digits of
     * @return The sum of all digits in the number
     */
    public static long sumOfDigitsLong(long number) {
        // Handle negative numbers
        number = Math.abs(number);
        
        // Base case
        if (number < 10) {
            return number;
        }
        
        // Recursive case
        return (number % 10) + sumOfDigitsLong(number / 10);
    }
    
    /**
     * Analyzes the time complexity for a given number.
     * 
     * @param number The number to analyze
     * @return The number of recursive calls needed
     */
    public static int analyzeComplexity(long number) {
        number = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        // Number of digits = floor(log10(n)) + 1
        return (int) Math.floor(Math.log10(number)) + 1;
    }
    
    public static void main(String[] args) {
 
        System.out.println("Enter a number (or 'exit' to quit):");
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nEnter number: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                long number = Long.parseLong(input);
                System.out.printf("Sum of digits: %d%n", sumOfDigitsLong(number));
                System.out.printf("Number of digits: %d%n", analyzeComplexity(number));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
            }
        }
        
        scanner.close();
        System.out.println("Program terminated.");
    }
}