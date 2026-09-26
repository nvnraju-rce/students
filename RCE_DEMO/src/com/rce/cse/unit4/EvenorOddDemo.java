package com.rce.cse.unit4;

import java.util.Scanner;
public class EvenorOddDemo {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // Read a number from the user
	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();
	        // Check whether the number is even or odd
	        if (number % 2 == 0) {
	            System.out.println(number + " is Even");
	        } else {
	            System.out.println(number + " is Odd");
	        }

	    	  sc.close();
		}
	       
	    
	    }




