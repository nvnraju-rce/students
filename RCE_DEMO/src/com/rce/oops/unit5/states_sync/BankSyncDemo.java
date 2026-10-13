package com.rce.oops.unit5.states_sync;
// Program 16: Synchronized method - two threads withdraw 80 each from 100
class Bank {
    private int balance = 100;
    synchronized void withdraw(int amt) {
        if (balance >= amt) {
            try { Thread.sleep(50); } catch (InterruptedException e) { }
            balance -= amt;
            System.out.println(Thread.currentThread().getName() + " withdrawn " + amt + ", balance " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient");
        }
    }
}
public class BankSyncDemo {
    public static void main(String[] args) {
        Bank b = new Bank();
        Runnable r = () -> b.withdraw(80);
        new Thread(r, "Person-1").start();
        new Thread(r, "Person-2").start();
        // only one succeeds. Remove 'synchronized' to see both succeed (wrong!)
    }
}
