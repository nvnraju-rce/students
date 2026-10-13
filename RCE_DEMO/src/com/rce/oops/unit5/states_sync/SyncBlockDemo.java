package com.rce.oops.unit5.states_sync;

// Program 17: Synchronized block - lock only the critical section
class Account {
    private int balance = 0;
    void deposit(int amt) {
        // code here needs no lock
        synchronized (this) {
            balance += amt;   // critical section
        }
    }
    int get() {
        synchronized (this) { return balance; }
    }
}
public class SyncBlockDemo {
    public static void main(String[] args) throws Exception {
        Account acc = new Account();
        Runnable r = () -> { for (int i = 0; i < 1000; i++) acc.deposit(1); };
        Thread t1 = new Thread(r), t2 = new Thread(r);
        t1.start(); t2.start();
        t1.join();  t2.join();
        System.out.println("Balance = " + acc.get());   // 2000
    }
}
