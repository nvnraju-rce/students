package com.rce.collections;

import java.util.LinkedHashSet;
/**
LinkedHashSet is a class within the Java Collection Framework that extends 
HashSet and implements the Set interface. Its defining feature is 
that it guarantees unique elements while preserving their insertion order. */
public class LinkedHashSetDemo {
    public static void main(String[] args) {

        LinkedHashSet<String> names = new LinkedHashSet<>();

        names.add("Ravi");
        names.add("Sita");
        names.add("Kiran");
        names.add("Anil");

        System.out.println("Insertion order: " + names);
    }
}
