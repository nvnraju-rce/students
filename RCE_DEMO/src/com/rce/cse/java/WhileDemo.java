package com.rce.cse.java;

import java.util.Scanner;

public class WhileDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to verify :");
        int value = sc.nextInt();

    //    System.out.println("While:");
        while (value < 5) {
            System.out.println("Inside While Loop");
           break;
        }

      //  System.out.println("Do-While:");
        do {
            System.out.println("Inside do-While Loop");
            break;
        } while (value < 5);
    }
}
