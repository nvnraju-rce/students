package com.rce.cse.java;

public class TypeCastingDemo {
    public static void main(String[] args) {

        int a = 10;
        double b = 20.75;

        // Widening
        double x = a;

        // Narrowing
        int y = (int) b;

        System.out.println("Original int    : " + a);
        System.out.println("After widening  : " + x);

        System.out.println("Original double : " + b);
        System.out.println("After narrowing : " + y);
    }
}
