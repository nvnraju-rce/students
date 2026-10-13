package com.rce.oops.unit5.threads;
// Program 5: Creating a thread by extending Thread
class MyThread extends Thread {
    public void run() { System.out.println("thread running.."); }
}
public class MyThreadDemo {
    public static void main(String[] a) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
