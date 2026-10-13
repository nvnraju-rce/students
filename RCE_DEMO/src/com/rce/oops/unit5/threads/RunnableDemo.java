package com.rce.oops.unit5.threads;
// Program 6: Creating a thread by implementing Runnable (class and lambda)
class Task implements Runnable {
    public void run() { System.out.println("Runnable running"); }
}
public class RunnableDemo {
    public static void main(String[] a) {
        Task t = new Task();
        Thread th = new Thread(t);
        th.start();
        new Thread(() -> System.out.println("Hi from lambda")).start();
    }
}
