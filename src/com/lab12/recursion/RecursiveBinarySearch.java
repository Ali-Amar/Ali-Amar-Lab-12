package com.lab12.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Implementation of recursive binary search with support for both integers and strings,
 * including functionality to find multiple occurrences.
 */
public class RecursiveBinarySearch {
    
    /**
     * Searches for a target integer in a sorted array using recursive binary search.
     * 
     * @param arr The sorted array to search in
     * @param target The value to search for
     * @return The index of the target value if found, -1 otherwise
     * @throws IllegalArgumentException if the array is null
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        }
        
        if (arr[mid] > target) {
            return binarySearchHelper(arr, target, left, mid - 1);
        }
        
        return binarySearchHelper(arr, target, mid + 1, right);
    }
    
    /**
     * Searches for a target string in a sorted array using recursive binary search.
     * 
     * @param arr The sorted array of strings to search in
     * @param target The string to search for
     * @return The index of the target string if found, -1 otherwise
     * @throws IllegalArgumentException if the array is null or target is null
     */
    public static int binarySearchString(String[] arr, String target) {
        if (arr == null || target == null) {
            throw new IllegalArgumentException("Array and target cannot be null");
        }
        return binarySearchStringHelper(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchStringHelper(String[] arr, String target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        int comparison = arr[mid].compareTo(target);
        
        if (comparison == 0) {
            return mid;
        }
        
        if (comparison > 0) {
            return binarySearchStringHelper(arr, target, left, mid - 1);
        }
        
        return binarySearchStringHelper(arr, target, mid + 1, right);
    }
    
    /**
     * Finds all occurrences of a target value in a sorted array.
     * 
     * @param arr The sorted array to search in
     * @param target The value to search for
     * @return List of indices where the target value appears
     * @throws IllegalArgumentException if the array is null
     */
    public static List<Integer> findAllOccurrences(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        List<Integer> occurrences = new ArrayList<>();
        findAllOccurrencesHelper(arr, target, 0, arr.length - 1, occurrences);
        return occurrences;
    }
    
    private static void findAllOccurrencesHelper(int[] arr, int target, int left, int right, List<Integer> occurrences) {
        if (left > right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            occurrences.add(mid);
            // Search both sides for more occurrences
            findAllOccurrencesHelper(arr, target, left, mid - 1, occurrences);
            findAllOccurrencesHelper(arr, target, mid + 1, right, occurrences);
        } else if (arr[mid] > target) {
            findAllOccurrencesHelper(arr, target, left, mid - 1, occurrences);
        } else {
            findAllOccurrencesHelper(arr, target, mid + 1, right, occurrences);
        }
    }
    
    public static void main(String[] args) {
        // Test integer binary search
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 7;
        
        System.out.println("Testing Integer Binary Search:");
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println("Searching for: " + target);
        int result = binarySearchRecursive(sortedArray, target);
        System.out.println("Found at index: " + result);
        
        // Test string binary search
        String[] sortedStrings = {"apple", "banana", "cherry", "date", "elderberry"};
        String targetString = "cherry";
        
        System.out.println("\nTesting String Binary Search:");
        System.out.println("Array: " + Arrays.toString(sortedStrings));
        System.out.println("Searching for: " + targetString);
        int stringResult = binarySearchString(sortedStrings, targetString);
        System.out.println("Found at index: " + stringResult);
        
        // Test multiple occurrences
        int[] arrayWithDuplicates = {1, 2, 2, 2, 3, 4, 4, 5};
        int targetDuplicate = 2;
        
        System.out.println("\nTesting Multiple Occurrences Search:");
        System.out.println("Array: " + Arrays.toString(arrayWithDuplicates));
        System.out.println("Searching for all occurrences of: " + targetDuplicate);
        List<Integer> occurrences = findAllOccurrences(arrayWithDuplicates, targetDuplicate);
        System.out.println("Found at indices: " + occurrences);
    }
}