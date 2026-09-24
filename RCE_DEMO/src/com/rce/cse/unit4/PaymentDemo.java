package com.rce.cse.unit4;

import java.util.Scanner;

public class PaymentDemo {

    static void makePayment(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }

        if (amount > 50000) {
            throw new IllegalArgumentException(
                "Payment limit exceeded. Maximum allowed is ₹50,000"
            );
        }

        System.out.println("Payment of ₹" + amount + " successful");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter payment amount: ");
            double amount = sc.nextDouble();

            makePayment(amount);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }
        finally {
            System.out.println("Payment process completed.");
        }

        sc.close();
    }
}