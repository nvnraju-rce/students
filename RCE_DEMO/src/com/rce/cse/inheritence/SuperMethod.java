package com.rce.cse.inheritence;

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
    	super.display();                 // Calls Parent method
        System.out.println("This is Child");

    }
}

class SuperMethod {
	public static void main(String args[]) {
		Child12 obj = new Child12();
		obj .display(); // Calls child method 
		
	}
	
}


