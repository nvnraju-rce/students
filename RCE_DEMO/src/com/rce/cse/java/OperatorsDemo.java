package com.rce.cse.java;

public class OperatorsDemo {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // 1. Arithmetic Operators
        System.out.println("=== Arithmetic Operators ===");

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));


        // 2. Relational Operators
        System.out.println("\n=== Relational Operators ===");

        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));


        // 3. Logical Operators
        System.out.println("\n=== Logical Operators ===");

        int age = 20;
        boolean hasID = true;

        System.out.println("age >= 18 && hasID : "
                + (age >= 18 && hasID));

        System.out.println("age < 18 || hasID : "
                + (age < 18 || hasID));

        System.out.println("!hasID : " + (!hasID));


        // 4. Assignment Operators
        System.out.println("\n=== Assignment Operators ===");

        int x = 10;

        x += 5;
        System.out.println("x += 5 : " + x);

        x -= 3;
        System.out.println("x -= 3 : " + x);

        x *= 2;
        System.out.println("x *= 2 : " + x);

        x /= 4;
        System.out.println("x /= 4 : " + x);


        // 5. Increment and Decrement
        System.out.println("\n=== Increment / Decrement ===");

        int n = 5;

        System.out.println("n = " + n);
        System.out.println("n++ = " + n++);
        System.out.println("After n++ = " + n);

        System.out.println("++n = " + (++n));

        System.out.println("n-- = " + n--);
        System.out.println("After n-- = " + n);


        // 6. Ternary Operator
        System.out.println("\n=== Ternary Operator ===");

        int marks = 75;

        String result = (marks >= 40) ? "PASS" : "FAIL";

        System.out.println("Result = " + result);
    }
}
