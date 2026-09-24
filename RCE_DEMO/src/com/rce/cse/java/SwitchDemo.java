package com.rce.cse.java;
import java.util.Scanner;


public class SwitchDemo {
	
    public static void main(String[] args) {

        int choice = 0; 
        System.out.println("Enter Choice :");
        Scanner sc = new Scanner(System.in);
        choice =  sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Check Balance");
                break;

            case 2:
                System.out.println("Withdraw Money");
                break;

            case 3:
                System.out.println("Deposit Money");
                break;

            case 4:
                System.out.println("Change PIN"); 
                break;

            case 5:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}
