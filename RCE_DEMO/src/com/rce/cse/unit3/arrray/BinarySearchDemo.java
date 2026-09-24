package com.rce.cse.unit3.arrray;
public class BinarySearchDemo {
	public static void main(String args[])
	{
		int[] a = {10, 20, 30, 40, 50, 60};
		int key = 50;
		int low = 0;
		int high = a.length - 1; // index starts with 0
	
		while (low <= high) {
		    int mid = (low + high) / 2;
		    if (a[mid] == key) {
		        System.out.println("Found at index " + mid);
		        break;
		    } 
		    else if (key > a[mid]) {
		        low = mid + 1;
		    } 
		    else {
		        high = mid - 1;
		    }
		}
	}

}
