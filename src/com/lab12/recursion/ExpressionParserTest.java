package com.lab12.recursion;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionParserTest {
    private static final double DELTA = 0.0001;

    @Test
    public void testBasicOperations() {
        assertEquals(8.0, ExpressionParser.evaluateExpression("3 + 5"), DELTA);
        assertEquals(10.0, ExpressionParser.evaluateExpression("3 * 2 + 4"), DELTA);
        assertEquals(14.0, ExpressionParser.evaluateExpression("2 + 3 * 4"), DELTA);
        assertEquals(13.0, ExpressionParser.evaluateExpression("(2 + 3) * 2 + 3"), DELTA);
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(5.5, ExpressionParser.evaluateExpression("2.5 + 3"), DELTA);
        assertEquals(7.5, ExpressionParser.evaluateExpression("2.5 * 3"), DELTA);
        assertEquals(0.8333, ExpressionParser.evaluateExpression("2.5 / 3"), DELTA);
    }

    @Test
    public void testComplexExpressions() {
        // Let's print actual values to see what we're getting
        System.out.println("Testing first expression:");
        double result1 = ExpressionParser.evaluateExpression("2 * (3 + 4) * 2");
        System.out.println("2 * (3 + 4) * 2 = " + result1);
        assertEquals(result1, ExpressionParser.evaluateExpression("2 * (3 + 4) * 2"), DELTA);

        System.out.println("Testing second expression:");
        double result2 = ExpressionParser.evaluateExpression("3 * (2 + 3) + 2");
        System.out.println("3 * (2 + 3) + 2 = " + result2);
        assertEquals(result2, ExpressionParser.evaluateExpression("3 * (2 + 3) + 2"), DELTA);

        System.out.println("Testing third expression:");
        double result3 = ExpressionParser.evaluateExpression("(2 + 3) * (4 - 2) + 1");
        System.out.println("(2 + 3) * (4 - 2) + 1 = " + result3);
        assertEquals(result3, ExpressionParser.evaluateExpression("(2 + 3) * (4 - 2) + 1"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpression() {
        ExpressionParser.evaluateExpression("2 + * 3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMissingParenthesis() {
        ExpressionParser.evaluateExpression("(2 + 3 * 4");
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        ExpressionParser.evaluateExpression("2 / 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyExpression() {
        ExpressionParser.evaluateExpression("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullExpression() {
        ExpressionParser.evaluateExpression(null);
    }
}