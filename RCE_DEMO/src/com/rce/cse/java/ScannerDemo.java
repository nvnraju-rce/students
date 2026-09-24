package com.rce.cse.java;

import java.util.Scanner;
class ScannerDemo {
		public static void main(String[] args) {
	        // Initialize Scanner to read from standard input stream
	        Scanner scanner = new Scanner(System.in);
	
	        System.out.println("=== Java System.in Demo ===");
	
	        // 1. Reading a String (Single word)
	        System.out.print("Enter your first name: ");
	        String firstName = scanner.next(); 
	
	        // 2. Reading an Integer
	        System.out.print("Enter your age: ");
	        int age = scanner.nextInt();
	
	        // 3. Clear the buffer line break
	        scanner.nextLine(); 
	
	        // 4. Reading a full line of text
	        System.out.print("Enter your favorite Branch: ");
	        String branch = scanner.nextLine();
	
	        // Output the collected data
	        System.out.println("\n--- Summary ---");
	        System.out.println("Name: " + firstName);
	        System.out.println("Age: " + age);
	        System.out.println("Branch: " + branch);
	
	        // Close the scanner resource
	        scanner.close();
	}
}