package com.rce.cse.unit4;

import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMExceptionDemo {

    static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Invalid withdrawal amount");
        }

        if (amount > 5000) {
            throw new IllegalArgumentException(
                    "Maximum withdrawal limit is ₹5000");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }

        balance = balance - amount;

        System.out.println("✅ Please collect your cash");
        System.out.println("Remaining Balance: ₹" + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 10000;

        System.out.println("===== ATM =====");
        System.out.println("Available Balance: ₹" + balance);

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {

            withdraw(balance, amount);

        }
        catch (InsufficientBalanceException e) {

            System.out.println("❌ Transaction Failed");
            System.out.println("Reason: " + e.getMessage());

        }
        catch (IllegalArgumentException e) {

            System.out.println("❌ Invalid Transaction");
            System.out.println("Reason: " + e.getMessage());

        }
        finally {

            System.out.println("Thank you for using our ATM.");
        }

        sc.close();
    }
}
