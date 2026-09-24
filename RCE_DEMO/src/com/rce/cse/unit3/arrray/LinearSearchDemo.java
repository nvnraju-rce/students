package com.rce.cse.unit3.arrray;
import java.util.Scanner;
public class LinearSearchDemo {
	  public static void main(String[] args) {
	        int[] a = {10, 25, 30, 45, 50};
	        Scanner sc  = new Scanner(System.in);
	        System.out.println("Enter Number to Search in Array:");
	        int key = sc.nextInt();

	        boolean found = false; //Flag to indicate if the key is found
	        for (int i = 0; i < a.length; i++) {

	            if (a[i] == key) {
	                System.out.println("Element found at index: " + i);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("Element not found");
	        }
	    }
	}

