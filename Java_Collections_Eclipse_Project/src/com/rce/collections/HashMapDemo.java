package com.rce.collections;

/**
 * HashMap is a class in the Java Collections Framework 
 * used to store data in key-value pairs.
 * put()
 * get()
 */
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ravi");
        students.put(102, "Sita");
        students.put(103, "Kiran");

        System.out.println("Students: " + students);
        System.out.println("Student 102: " + students.get(102));
    }
}
