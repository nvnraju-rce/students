package com.rce.cse.java;

/**
 * Program: CommandLineDemo
 * --------------------------------------------
 * This program demonstrates the use of command-line arguments in Java.
 * It reads two integer values from the command line, adds them,
 * and displays the sum.
 *
 * Example:
 * Compile: javac CommandLineDemo.java
 * Run    : java CommandLineDemo 10 20
 * Output : Sum of Two Numbers Entered = 30
 */

public class CommandLineDemo {

    // The main() method is the entry point of every Java program.
    // The String array 'args' stores the command-line arguments.
    public static void main(String[] args) {

        // Declare integer variables to store the input numbers and their sum.
        int firstNumber, secondNumber, sum;

        // Read the first command-line argument (args[0])
        // Convert it from String to integer.
        firstNumber = Integer.parseInt(args[0]);

        // Read the second command-line argument (args[1])
        // Convert it from String to integer.
        secondNumber = Integer.parseInt(args[1]);

        // Add the two numbers.
        sum = firstNumber + secondNumber;

        // Display the result.
        System.out.println("Sum of Two Numbers Entered = " + sum);
    }
}
