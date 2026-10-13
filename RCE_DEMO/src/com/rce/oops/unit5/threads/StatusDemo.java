package com.rce.oops.unit5.threads;
// Program 9: isAlive() and join()
public class StatusDemo extends Thread {
    public void run() {
        System.out.println("Thread running...");
        try { Thread.sleep(1000); } catch (Exception e) { }
        System.out.println("Thread finished!");
    }
    public static void main(String[] a) throws Exception {
        StatusDemo t = new StatusDemo();
        System.out.println(t.isAlive());  // false
        t.start();
        System.out.println(t.isAlive());  // true
        t.join();
        System.out.println(t.isAlive());  // false
    }
}
