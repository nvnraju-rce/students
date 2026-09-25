package com.rce.cse.inheritence;
//Class with in another class in Nested Class
class OuterClass { // Outer Class

	int x = 10;
	class InnerClass //Inner Class
	{
	int y = 5;
	}
	}

	
class NestedClassDemo
	{
	public static void main(String[] args)
	{
	// Creating an instance of OuterClass
	 OuterClass objout = new OuterClass(); 
	 // Creating an instance of InnerClass using the OuterClass instance 
	   OuterClass.InnerClass objin = objout.new InnerClass();
	// Accessing the variables from OuterClass and InnerClass
	System.out.println("Sum of x and y: " + (objout.x + objin.y));
	}

}

