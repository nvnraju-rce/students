package com.rce.cse.java;

/**
 * Program: VariableDemo
 * ---------------------------------------------------------
 * Aim:
 * To demonstrate the three types of variables in Java:
 * 1. Local Variable
 * 2. Instance Variable
 * 3. Static Variable
 */

public class VariableDemo {

    // ---------------------------------------------------------
    // Instance Variable
    // Belongs to an object. Each object has its own copy.
    // ---------------------------------------------------------
    int instanceVar = 100;

    // ---------------------------------------------------------
    // Static Variable
    // Belongs to the class. Shared by all objects.
    // ---------------------------------------------------------
    static int staticVar = 500;

    // Method to demonstrate local variable
    void display() {

        // -----------------------------------------------------
        // Local Variable
        // Declared inside a method.
        // Accessible only within this method.
        // -----------------------------------------------------
        int localVar = 50;

        System.out.println("Local Variable    : " + localVar);
        System.out.println("Instance Variable : " + instanceVar);
        System.out.println("Static Variable   : " + staticVar);
    }

    public static void main(String[] args) {

        // Creating first object
        VariableDemo obj1 = new VariableDemo();

        // Creating second object
        VariableDemo obj2 = new VariableDemo();

        // Changing values
        obj1.instanceVar = 200;
        obj2.instanceVar = 300;


        // Static variable is shared by all objects
        VariableDemo.staticVar = 1000;

        System.out.println("------ Object 1 ------");
        obj1.display();

        System.out.println("\n------ Object 2 ------");
        obj2.display();
    }
}