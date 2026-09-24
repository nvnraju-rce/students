package com.rce.cse.unit3.arrray;

public class StringDemo {
	//String is a sequence of characters and its class
	
	public static void main (String[] args) {
		
		// String Intro 
		char ch[ ]={'j','a','v','a'};
		String s=new String(ch);
		
		String str = new String("RCE");
		String strn = "RCE";
			
		String s1 = "Java";
		String s2 = "Java";
		
		System.out.println("StringEqual"+ s1.equals(s2));  //checks whether the actual characters/content are the same.

		System.out.println("String =="+s1 == s2);  //checks whether both variables refer to the same String object.
			
		String s3 = new String("Java");
		String s4 = new String("Java");

		System.out.println(s3.equals(s4)); 
		System.out.println(s3 == s4);      
		
		String s5 = "Apple";
		String s6 = "Banana";

		System.out.println("String Compare"+s5.compareTo(s6));
	//	equals() and compareTo() both examine String content, whereas == compares object references.
		
		System.out.println(s5.charAt(2));
		System.out.println(s5.getBytes());
		System.out.println(s5.toCharArray());
		String strin = "WELCOME TO RCE";
		char dst[] = new char[10];
		strin.getChars(1, 5, dst,3);

	}

}

