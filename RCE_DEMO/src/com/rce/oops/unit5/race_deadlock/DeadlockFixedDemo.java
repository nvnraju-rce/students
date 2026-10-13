package com.rce.oops.unit5.race_deadlock;

// Program 23: Deadlock prevented - both threads lock r1 first, then r2
public class DeadlockFixedDemo {
    static void pause() { try { Thread.sleep(100); } catch (InterruptedException e) { } }
    public static void main(String[] args) {
        Object r1 = new Object();
        Object r2 = new Object();
        Runnable job = () -> {
            synchronized (r1) {
                pause();
                synchronized (r2) {
                    System.out.println(Thread.currentThread().getName() + " got both locks");
                }
            }
        };
        new Thread(job, "T1").start();
        new Thread(job, "T2").start();
    }
}
