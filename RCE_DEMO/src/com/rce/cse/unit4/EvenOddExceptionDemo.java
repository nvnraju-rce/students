package com.rce.cse.unit4;
import java.util.InputMismatchException;
//Exception handling is used to handle runtime errors so that 
//the program can respond properly instead of terminating unexpectedly.

import java.util.Scanner;
public class EvenOddExceptionDemo {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // Read a number from the user
	        System.out.print("Enter a number: ");
//	        The try block contains the code that may generate an exception.
	      try {
	        int number = sc.nextInt();
	        // Check whether the number is even or odd
	        if (number % 2 == 0) {
	            System.out.println(number + " is Even");
	        } else {
	            System.out.println(number + " is Odd");
	        }
	      }catch(InputMismatchException ie) { //The catch block is used to handle the exception.
	    	  
	    	  System.out.println("****************** Wrong Data Entered ******************");
	      }catch(Exception e) {
	    	  
		        System.out.println("****************** Wrong Data Entered ******************");

	      } finally { //The finally block contains code that generally needs to execute after the try/catch processing, whether an exception occurs or not.
		        System.out.println("****************** In Finally Block ******************");

	    	  sc.close();
		}
	        System.out.println("****************** End of Program******************");
	    
	    }
	}


