package com.rce.oops.unit5.threads;
// Program 11: Daemon vs user threads
class MyThread2 extends Thread {
    public void run() {
        if (isDaemon()) System.out.println("Daemon thread");
        else System.out.println("User thread");
    }
}
public class DaemonDemo {
    public static void main(String[] a) {
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        t1.setDaemon(true);   // must be before start()
        t1.start();
        t2.start();
    }
}
