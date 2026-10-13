package com.rce.oops.unit5.threads;
// Program 7: run() vs start() - which thread executes the code?
public class RunVsStartDemo extends Thread {
    public void run() {
        System.out.println("Executed by: " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        RunVsStartDemo t1 = new RunVsStartDemo();
        t1.run();                      // runs in main thread (no new thread!)
        RunVsStartDemo t2 = new RunVsStartDemo();
        t2.start();                    // runs in a new thread
    }
}
