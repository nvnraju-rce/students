package com.rce.cse.java;

import java.util.Scanner;

public class CaliculatorDemo1 {
    //Main method 
	public static void main(String args[]) {
		Calculator obj1 = new Calculator();
		int a ,b;
/*	//	int a  = (int) args[0]; //Wrong 
		int a= Integer.parseInt(args[0]); //Right
		int b = Integer.parseInt(args[1]);;*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two Numbers to Add /Substract");
		 a= sc.nextInt();
		 b= sc.nextInt();
		 
		System.out.println("Additon:"+obj1.add(a, b)); // Print on screen
		
		Calculator obj2 = new Calculator();
		System.out.println("Subtract:"+obj2.subtract(a, b));
		
	}

}
