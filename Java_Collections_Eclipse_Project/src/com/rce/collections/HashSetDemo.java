package com.rce.collections;

import java.util.HashSet;
/**
 * HashSet is a class in the Java Collections Framework 
 * used to store a collection of unique elements.

 * HashSet does not allow duplicate elements.
 */
public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        System.out.println("Unique values: " + numbers);
    }
}
