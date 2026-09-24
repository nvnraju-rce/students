package com.rce.cse.unit3.arrray;

public class DynamicArray {
	
	public static void main(String args[])
	{
	int array[]= {1,2,3,4,5}; //declare array 
	System.out.println("Before Changing Array Size: array1 = "); 
	display(array); //display array
	array = new int[10]; //Changing array size 
	System.out.println("\nAfter Changing Array Size: array1 = "); 
	display(array);
	}
	// Method to display array elements
	public  static void display(int array[])
	{
					
		for(int i=0;i<array.length;i++)
		{
		System.out.print(array[i]+ "");
		}
	}
}
