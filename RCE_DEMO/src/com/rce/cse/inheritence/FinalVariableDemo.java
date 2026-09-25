package com.rce.cse.inheritence;

//Final class → No inheritance
//Final method → No method overriding
//Final variable → No reassignment
class Student {

    final int rollNo = 101;

    void display() {
        System.out.println("Roll No: " + rollNo);
    }
}

public class FinalVariableDemo {

    public static void main(String[] args) {

        Student s = new Student();

        s.display();

        // ❌ Error: Cannot assign a value to final variable
        s.rollNo = 102;
    }
}
