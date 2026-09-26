package com.rce.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapIteration {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ravi");
        students.put(102, "Sita");
        students.put(103, "Kiran");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
