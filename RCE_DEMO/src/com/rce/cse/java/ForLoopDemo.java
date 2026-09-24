package com.rce.cse.java;

import java.util.Scanner;

public class ForLoopDemo {
    public static void main(String[] args) {
    	
    //	System.out.prinltln("Enter 5 students marks");

        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];

        System.out.println("Enter marks of 5 students:");
        //for loop 
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println(" With For Each Student Marks:");
        //for each 
        for (int mark : marks) {
            System.out.println(mark);
        }
        
        System.out.println(" with For Loop Student Marks:");
 
        for (int mark =0; mark< marks.length; mark ++) {
        	System.out.println(marks[mark]);
        }

        sc.close();
    }
}
