package com.rce.oops.unit5.race_deadlock;

// Program 19: Race condition - count++ from two threads (LOST UPDATES)
class Counter {
    int count = 0;
    void increment() { count++; }
}
public class RaceDemo {
    public static void main(String[] a) throws Exception {
        Counter c = new Counter();
        Runnable r = () -> { for (int i = 0; i < 10000; i++) c.increment(); };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start(); t2.start();
        t1.join();  t2.join();
        System.out.println(c.count);   // usually less than 20000
    }
}
