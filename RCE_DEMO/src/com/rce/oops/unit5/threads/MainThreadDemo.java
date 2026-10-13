package com.rce.oops.unit5.threads;
// Program 4: The main thread
public class MainThreadDemo {
    public static void main(String[] a) throws Exception {
        Thread t = Thread.currentThread();
        System.out.println(t);            // [name,priority,group]
        t.setName("MyMain");
        System.out.println(t.getName());
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            Thread.sleep(500);
        }
    }
}
