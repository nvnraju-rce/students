package com.rce.collections;

import java.util.LinkedHashMap;
/**
 * hybrid data structure that combines a Hash Table with a Doubly-Linked List to provide 
 * a collection that stores unique elements while strictly maintaining their insertion order
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> students = new LinkedHashMap<>();

        students.put(101, "Ravi");
        students.put(102, "Sita");
        students.put(103, "Kiran");

        System.out.println("Insertion order: " + students);
    }
}
