package com.rce.cse.unit3.arrray;

public class StringModDemo {
	
	public static void main(String args[])
	{
	String str = "	WELCOME TO RCE	";
	String result = str.trim();
	System.out.println("Trimmed string: '" + result + "'");
	String str1 = "ELURU";
	String result1 = str.concat(str1);

	System.out.println("Concat string: '" + result1 + "'");
	System.out.println("substring string: '" + str.substring(3) + "'");
	System.out.println("substring string: '" + str.substring(1,4) + "'");
	System.out.println("replace string: '" + str.replace('O', '7')); 
	System.out.println("Lower Case string: '" + str.toLowerCase()); 
	System.out.println("Upper Case string: '" + str.toUpperCase()); 
	//. indexOf() 2. lastIndexOf() 3. charAt() 4. contains()

	}
	}

