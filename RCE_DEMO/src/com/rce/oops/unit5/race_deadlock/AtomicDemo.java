package com.rce.oops.unit5.race_deadlock;
import java.util.concurrent.atomic.AtomicInteger;
// Program 21: Alternative fix using AtomicInteger
public class AtomicDemo {
    public static void main(String[] a) throws Exception {
        AtomicInteger count = new AtomicInteger(0);
        Runnable r = () -> { for (int i = 0; i < 10000; i++) count.incrementAndGet(); };
        Thread t1 = new Thread(r), t2 = new Thread(r);
        t1.start(); t2.start();
        t1.join();  t2.join();
        System.out.println(count.get());   // 20000
    }
}
