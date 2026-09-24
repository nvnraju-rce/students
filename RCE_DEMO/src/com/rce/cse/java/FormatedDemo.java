package com.rce.cse.java;

/**
 * Program: FormattedDemo
 * ------------------------------------------------------
 * Aim:
 * To demonstrate the use of formatted output in Java
 * using the printf() method.
 *
 * Description:
 * This program declares variables of different data types
 * (int, double, char, String, and boolean) and displays
 * their values using appropriate format specifiers.
 *
 * Format Specifiers:
 * %d - Integer
 * %f - Floating-point number
 * %c - Character
 * %s - String
 * %b - Boolean
 */

class FormattedDemo {

    // Main method - Program execution starts here.
    public static void main(String[] args) {

        // Declare and initialize an integer variable.
        int a = 10;

        // Declare and initialize a double variable.
        double f = 1.23;

        // Declare and initialize a character variable.
        char ch = 's';

        // Declare and initialize a string variable.
        String name = "RamaChandra Engineering College";

        // Declare and initialize a boolean variable.
        boolean b = true;

        // Print the integer value using %d.
        System.out.printf("%d\n", a);

        // Print the double value using %f.
        System.out.printf("%f\n", f);

        // Print the character value using %c.
        System.out.printf("%c\n", ch);

        // Print the string value using %s.
        System.out.printf("%s\n", name);

        // Print the boolean value using %b.
        System.out.printf("%b\n", b);
    }
}
