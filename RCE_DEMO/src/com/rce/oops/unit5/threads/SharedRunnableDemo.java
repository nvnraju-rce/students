package com.rce.oops.unit5.threads;
// Program 8: One Runnable object shared by several threads
class Printer implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}
public class SharedRunnableDemo {
    public static void main(String[] a) {
        Printer p = new Printer();
        new Thread(p, "Worker-A").start();
        new Thread(p, "Worker-B").start();
        new Thread(p, "Worker-C").start();
    }
}
