package com.rce.cse.java;

public class ForEachDemo {
    public static void main(String[] args) {

        String[] students = {
            "Ravi", "Sita", "Rahul", "Priya", "Kiran"
        };
        //USing for loop
        for (int i=0; students.length > i;i++) {
        	System.out.println("Hello " + students[i]);
        }
        //Using for each 
        for (String student : students) {
            System.out.println("Hello " + student);
        }
    }
}