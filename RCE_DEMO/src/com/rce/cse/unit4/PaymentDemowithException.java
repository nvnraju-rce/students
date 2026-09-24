package com.rce.cse.unit4;
import java.util.Scanner;
public class PaymentDemowithException {
    static void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount");
        }
        else if (amount > 50000) {
            System.out.println("Payment limit exceeded");
        }
        else {
            System.out.println("Payment of ₹" + amount + " successful");
        }
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();
        makePayment(amount);
        sc.close();
    }
}
