package com.rce.collections;

import java.util.HashMap;

public class HashMapOperations {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ravi");
        students.put(102, "Sita");
        students.put(103, "Kiran");

        if (students.containsKey(102)) {
            System.out.println("Student 102 Found");
        }

        students.remove(103);

        System.out.println("After removal: " + students);
    }
}
