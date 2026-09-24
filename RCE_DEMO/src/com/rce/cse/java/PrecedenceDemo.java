package com.rce.cse.java;

public class PrecedenceDemo {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        int c = 2;

        int result1 = a + b * c;

        int result2 = (a + b) * c;

        int result3 = a - b + c;

        int result4 = a / b * c;

        System.out.println("a + b * c     = " + result1);
        System.out.println("(a + b) * c   = " + result2);
        System.out.println("a - b + c      = " + result3);
        System.out.println("a / b * c      = " + result4);
    }
}
