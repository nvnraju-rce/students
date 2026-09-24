package com.rce.cse.unit4;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EvenOddExceptionDemo {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // Read a number from the user
	        System.out.print("Enter a number: ");
	      try {
	        int number = sc.nextInt();
	        // Check whether the number is even or odd
	        if (number % 2 == 0) {
	            System.out.println(number + " is Even");
	        } else {
	            System.out.println(number + " is Odd");
	        }
	      }catch(InputMismatchException ie) {
	    	  
	    	  System.out.println("****************** Wrong Data Entered ******************");
	      }catch(Exception e) {
	    	  
		        System.out.println("****************** Wrong Data Entered ******************");

	      } finally {
		        System.out.println("****************** In Finally Block ******************");

	    	  sc.close();
		}
	        System.out.println("****************** End of Program******************");
	    
	    }
	}


