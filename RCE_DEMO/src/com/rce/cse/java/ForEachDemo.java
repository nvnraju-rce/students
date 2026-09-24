package com.rce.cse.java;

public class ForEachDemo {
    public static void main(String[] args) {

        String[] students = {
            "Ravi", "Sita", "Rahul", "Priya", "Kiran"
        };
        for (int =0; students.length > i;i++) {
        	System.out.println("Hello " + student[i]);
        }
        for (String student : students) {
            System.out.println("Hello " + student);
        }
    }
}