package com.rce.oops.unit5.race_deadlock;

// Program 20: Race condition fixed with synchronized
class SafeCounter {
    private int count = 0;
    synchronized void increment() { count++; }
    int get() { return count; }
}
public class RaceFixedDemo {
    public static void main(String[] a) throws Exception {
        SafeCounter c = new SafeCounter();
        Runnable r = () -> { for (int i = 0; i < 10000; i++) c.increment(); };
        Thread t1 = new Thread(r), t2 = new Thread(r);
        t1.start(); t2.start();
        t1.join();  t2.join();
        System.out.println(c.get());   // 20000 every time
    }
}
