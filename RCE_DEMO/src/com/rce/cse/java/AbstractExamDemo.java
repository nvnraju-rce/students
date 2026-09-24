package com.rce.cse.java;

class A {
	int x = 10 ;
}
 class B extends A {
	 int x=20;
 } 
public class AbstractExamDemo {
	
	public static void main(String args[]) {
		
		A obj = new B();
		System.out.println(obj.x);
		
		A obj1 = new A();
		System.out.println(obj1.x);
		
		B obj2 = new B();
		
		System.out.println(obj2.x);				
	}
}
