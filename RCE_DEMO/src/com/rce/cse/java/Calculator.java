package com.rce.cse.java;
import java.time.LocalDateTime;
import java.util.*;
/**
 * Utility class for mathematical calculations.
 * 
 * Version Control History:
 * -------------------------------------------------------------------------
 * Version  Date        Author          Description
 * -------------------------------------------------------------------------
 * 1.0.0    2026-01-15  Venkata Raju    Initial creation. Added add().
 * 1.1.0    2026-03-22  Chaitanya       Added subtract() and divide().
 * 1.1.1    2026-05-10  Adithya         Fixed Bug #402: Divide by zero crash.
 * 2.0.0    2026-08-04  Sarath          Refactored to use Java 8 Time API.
 * -------------------------------------------------------------------------
 */
/*
 *  Block Comments 
 */
//Line comments 
public class Calculator {

    /**
     * Adds two integers.
     * @since 1.0.0
     */
    public int add(int a, int b) {
        return a + b;
    }
  // Single line Comments
    /**
     * Subtracts b from a.
     * @since 1.1.0
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Divides a by b. 
     * Throws IllegalArgumentException if dividing by zero.
     * @since 1.1.0
     * @version 1.1.1 (Updated error handling)
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     * Logs the current operation time.
     * @since 2.0.0
     */
    public void logExecution() {
        System.out.println("Executed at: " + LocalDateTime.now());
    }
}

 class CaliculatorDemo  {
    //Main method 
	public static void main(String args[]) {
		Calculator obj1 = new Calculator();
		int a  ;
		int b ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two Numbers to Add /Substract");R
		 a= sc.nextInt();
		 b= sc.nextInt();
		 
		System.out.println("Additon:"+obj1.add(a, b)); // Print on screen
		
		Calculator obj2 = new Calculator();
		System.out.println("Subtract:"+obj2.subtract(a, b));
		
	}
}

