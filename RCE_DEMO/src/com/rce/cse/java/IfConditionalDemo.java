package com.rce.cse.java;

public class IfConditionalDemo {

    public static void main(String[] args) {

        // 1. Simple if
        int age = 20;

        if (age >= 18) {
            System.out.println("You are eligible to vote");
        }


        // 2. if-else
        int marks = 35;

        if (marks >= 40) {
            System.out.println("Student Passed");
        } else {
            System.out.println("Student Failed");
        }
        // 3. if-else-if
        int score = 75;
        if (score >= 90) {
            System.out.println("Grade A+");
        } else if (score >= 80) {
            System.out.println("Grade A");
        } else if (score >= 70) {
            System.out.println("Grade B");
        } else if (score >= 60) {
            System.out.println("Grade C");
        } else if (score >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Fail");
        }  
    // nested If
    int attendance = 80;
     marks = 65;

    if (attendance >= 75) {

        System.out.println("Attendance requirement satisfied");

        if (marks >= 40) {
            System.out.println("Student is eligible for exam");
        } else {
            System.out.println("Student failed in internal marks");
        }

    } else {
        System.out.println("Student is not eligible due to low attendance");
    }
    }
}
