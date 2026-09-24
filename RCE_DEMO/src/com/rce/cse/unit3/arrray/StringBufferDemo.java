package com.rce.cse.unit3.arrray;

public class StringBufferDemo {
	
	//StringBuilder and StringBuffer are mutable. 
	//StringBuffer is synchronized and thread-safe, 
	//whereas StringBuilder is not synchronized and is generally faster.

	public static void main(String args[]) {
		
		
		//creates an empty string buffer with the initial capacity of 16.
		StringBuffer buff = new StringBuffer();
		//creates an empty string buffer with the specified capacity as length.
		StringBuffer sb=new StringBuffer(20);
		//creates a string buffer with the specified string.
		StringBuffer s1 = new StringBuffer("First ");
		StringBuffer s2 = new StringBuffer("Secound");

		System.out.println(s1.append(s2)); 
		System.out.println(s1.delete(1,4));
		System.out.println(s2.insert(7,"Insert")); 
		System.out.println(buff.capacity()); 
		System.out.println(s1.reverse());

	}

}
