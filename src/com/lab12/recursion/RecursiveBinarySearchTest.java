package com.lab12.recursion;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class RecursiveBinarySearchTest {

    @Test
    public void testBinarySearchRecursive() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(4, RecursiveBinarySearch.binarySearchRecursive(arr, 5));
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(arr, 10));
        assertEquals(0, RecursiveBinarySearch.binarySearchRecursive(arr, 1));
        assertEquals(8, RecursiveBinarySearch.binarySearchRecursive(arr, 9));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchRecursiveNull() {
        RecursiveBinarySearch.binarySearchRecursive(null, 5);
    }
    
    @Test
    public void testBinarySearchString() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(0, RecursiveBinarySearch.binarySearchString(arr, "apple"));
        assertEquals(2, RecursiveBinarySearch.binarySearchString(arr, "cherry"));
        assertEquals(-1, RecursiveBinarySearch.binarySearchString(arr, "grape"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchStringNull() {
        RecursiveBinarySearch.binarySearchString(null, "test");
    }
    
    @Test
    public void testFindAllOccurrences() {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5};
        List<Integer> occurrences = RecursiveBinarySearch.findAllOccurrences(arr, 2);
        assertEquals(3, occurrences.size());
        assertTrue(occurrences.contains(1));
        assertTrue(occurrences.contains(2));
        assertTrue(occurrences.contains(3));
        
        occurrences = RecursiveBinarySearch.findAllOccurrences(arr, 4);
        assertEquals(2, occurrences.size());
        assertTrue(occurrences.contains(5));
        assertTrue(occurrences.contains(6));
    }
}