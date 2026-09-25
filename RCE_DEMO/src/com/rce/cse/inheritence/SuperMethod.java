package com.rce.cse.inheritence;
//The super keyword is used to refer to the immediate parent class object.
//In inheritance, super is mainly used in 3 ways:
//Access parent class variables
//Call parent class methods
//Call parent class constructor
class Parent12 {
    String name = "Parent";

    void display() {
        System.out.println("This is Parent");
    }
}

class Child12 extends Parent12 {
    String name = "Child";

    void show() {
        System.out.println(name);        // Child
        System.out.println(super.name);  // Parent    
    }
    void display() {
    	super.display(); // ***** Calls Parent method
        System.out.println("This is Child");

    }
}

class SuperMethod {
	public static void main(String args[]) {
		Child12 obj = new Child12();
		obj .display(); // Calls child method 
		
	}
	
}


