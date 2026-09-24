package com.rce.cse.unit3.arrray;

import java.util.Arrays;

public class SortingArray {
		public static void main(String args[])
		{
		// Initial array with unsorted elements 
			int array[] = {5, 8, 9, 2, 4, 1, 7, 6};
		System.out.println("Before Sorting: array = "); 
		display(array); // Display the array before sorting
		int temp; // Temporary variable for swapping
		for (int i = 0; i < array.length; i++)
		{
		for (int j = array.length - 1; j > i; j--)
		{
		// Swap elements if they are in the wrong order
		if (array[j - 1] > array[j])
		{
		temp = array[j]; 
		array[j] = array[j - 1];
		array[j - 1] = temp;
		}	}	}
		//Arrays.sort(array);
		System.out.println("\nAfter Sorting: array1 = "); 
		display(array); // Display the array after sorting
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
		

