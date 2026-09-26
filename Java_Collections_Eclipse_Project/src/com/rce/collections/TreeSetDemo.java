package com.rce.collections;

import java.util.TreeSet;
/**
 * TreeSet collection that stores unique elements in sorted order.
 */
public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Sorted unique values: " + numbers);
    }
}
