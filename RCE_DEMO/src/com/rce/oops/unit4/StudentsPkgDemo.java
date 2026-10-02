package com.rce.oops.unit4;

public class StudentsPkgDemo {
    int rollNo;
    String name;

    // Constructor
    public StudentsPkgDemo(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Displays the student's details
    public void display() {
        System.out.println("Roll number: " + rollNo);
        System.out.println("Name: " + name);
    }
}
