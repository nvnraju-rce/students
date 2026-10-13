package com.rce.oops.unit5.states_sync;

// Program 15: Thread priority (only a hint to the scheduler)
public class PriorityDemo extends Thread {
    public void run() {
        System.out.println(getName() + " " + getPriority());
    }
    public static void main(String[] a) {
        PriorityDemo t1 = new PriorityDemo();
        PriorityDemo t2 = new PriorityDemo();
        t1.setName("Low");  t1.setPriority(Thread.MIN_PRIORITY);
        t2.setName("High"); t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        System.out.println("main priority = " + Thread.currentThread().getPriority());
    }
}
