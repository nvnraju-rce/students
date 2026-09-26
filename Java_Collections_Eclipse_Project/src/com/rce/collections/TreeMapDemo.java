package com.rce.collections;

import java.util.TreeMap;
/**
 TreeMap is a Map implementation that stores key–value pairs sorted by key.
 
 */
public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Kiran");
        students.put(101, "Ravi");
        students.put(102, "Sita");

        System.out.println("Sorted by key: " + students);
    }
}
