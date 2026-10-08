package com.rce.oops.unit4;

interface MyInterface {

    // Abstract method
    void show();

    // Default method
    default void display() {
        System.out.println("This is a default method");
    }
}

class MyClass implements MyInterface {

    // Implementing abstract method
    @Override
    public void show() {
        System.out.println("This is the implementation of show()");
    }
}

public class DefaultMethodsInterfaceDemo {

    public static void main(String[] args) {

        MyClass obj = new MyClass();

        // Calling implemented abstract method
        obj.show();

        // Calling default method of interface
        obj.display();
    }
}