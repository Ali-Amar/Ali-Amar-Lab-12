package com.lab12.recursion;

import static org.junit.Assert.*;
import org.junit.Test;

public class RecursiveDigitSumTest {
    
    @Test
    public void testBasicSumOfDigits() {
        assertEquals(6, RecursiveDigitSum.sumOfDigits(123));
        assertEquals(15, RecursiveDigitSum.sumOfDigits(456));
        assertEquals(24, RecursiveDigitSum.sumOfDigits(789));
    }
    
    @Test
    public void testZeroAndSingleDigit() {
        assertEquals(0, RecursiveDigitSum.sumOfDigits(0));
        assertEquals(5, RecursiveDigitSum.sumOfDigits(5));
    }
    
    @Test
    public void testNegativeNumbers() {
        assertEquals(6, RecursiveDigitSum.sumOfDigits(-123));
        assertEquals(15, RecursiveDigitSum.sumOfDigits(-456));
    }
    
    @Test
    public void testLargeNumbers() {
        assertEquals(45, RecursiveDigitSum.sumOfDigitsLong(123456789L)); 
        assertEquals(81, RecursiveDigitSum.sumOfDigitsLong(999999999L)); 
    }
    
    @Test
    public void testComplexityAnalysis() {
        assertEquals(1, RecursiveDigitSum.analyzeComplexity(0));
        assertEquals(1, RecursiveDigitSum.analyzeComplexity(9));
        assertEquals(2, RecursiveDigitSum.analyzeComplexity(10));
        assertEquals(3, RecursiveDigitSum.analyzeComplexity(100));
        assertEquals(10, RecursiveDigitSum.analyzeComplexity(1234567890L));
    }
}