package com.rce.cse.unit3.arrray;

public class StringBuilderDemo {
	
	//StringBuilder and StringBuffer are mutable. 
	//StringBuffer is synchronized and thread-safe, 
	//whereas StringBuilder is not synchronized and is generally faster.
	public static void main(String args[]) {
		//It creates an empty String Builder with the initial capacity of 16.
		StringBuilder sb=new StringBuilder ();
		//It creates a String Builder with the specified string.
		StringBuilder sb1=new StringBuilder ("Hi");
		//It creates an empty String Builder with the specified capacity as length.
		StringBuilder sb2=new StringBuilder (20);

		StringBuilder builder = new StringBuilder("Hello");
		System.out.println(builder);
		System.out.println(builder.append(sb1));
		System.out.println(builder);
		
		builder.reverse(); //Reverse the string System.out.println("Reversed String: " + sb);
		builder.reverse(); // Re-reverse to get back to the original string
		System.out.println("Capacity: " + builder.capacity()); //current capacity of the buffer
		System.out.println("Length: " + builder.length());	//length of the string String substring = sb.substring(0, 5);//substring(int beginIndex, int endIndex)
		System.out.println("Substring (0,5): " + builder.substring(0,5));
		builder.replace(0, 5, "Hi");	//replace(int startIndex, int endIndex, String str)
		System.out.println("After replace: " + builder); 
		builder.delete(2, 5); // delete(int startIndex, int endIndex) System.out.println("After delete: " + sb);
		builder.insert(2, "llo"); //insert(int offset, String str)
		System.out.println("After insert: " + builder);


	}

}
