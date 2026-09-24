package com.rce.cse.unit3.arrray;

public class ArraryDemo {	
	 public static void main(String[] args){
	           // Primitive array
		    int ar[] ; // Declared only 
		    ar = new int[6]; // Memory Allocated 
		    ar =  new int[]{10, 20, 30, 50, 40, 80}; //Initialization
		    	    
	        int[] arr = {10, 20, 30, 40}; // Declare ,Intailazation in single step
	        int n = arr.length; // To Find Length of Array

	        System.out.print("Primitive Array -> ");
	        for (int i = 0; i < n; i++)
	            System.out.println(arr[i] + " ");

	 
	        // Non-primitive array (String objects)
	        String[] names = {"Lakshit", "Rahul", "Pankaj"};

	        System.out.print("Non-Primitive Array -> ");
	        for (int i = 0; i < names.length; i++)
	            System.out.print(names[i] + " ");
	        
	        String s = "Java PRgramming";
	        System.out.println(s.substring(5,13));
	        
	    }
	}


