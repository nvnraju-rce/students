package com.rce.cse.unit3.arrray;

public class charSequenceDemo {
	
	public static void main(String[] args) {
		
		//CharSequence is an interface in Java that represents a sequence of characters.
		//It provides a common way to work with different character-based objects such as String , String Buffer and String Builder(Sync):
		CharSequence cs="WELCOME TO CLASS"; 
		System.out.println("LENGHT IS:"+cs.length()); 
		System.out.println("CHAR AT INDEX IS:"+cs.charAt(2));
		System.out.println("SUB SEQUENCE IS:"+cs.subSequence(0,3));
		System.out.println("CHAR SEQUENCE TO STRING IS:"+cs.toString());

	}

}
