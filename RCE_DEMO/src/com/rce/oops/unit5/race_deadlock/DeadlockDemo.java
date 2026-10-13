package com.rce.oops.unit5.race_deadlock;

// Program 22: DEADLOCK - this program hangs on purpose. Press the red Terminate button.
public class DeadlockDemo {
    static void pause() { try { Thread.sleep(100); } catch (InterruptedException e) { } }
    public static void main(String[] args) {
        Object r1 = new Object();
        Object r2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("T1 locked r1");
                pause();
                synchronized (r2) { System.out.println("T1 locked r2"); }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("T2 locked r2");
                pause();
                synchronized (r1) { System.out.println("T2 locked r1"); }   // waits forever
            }
        });
        t1.start(); t2.start();
    }
}
