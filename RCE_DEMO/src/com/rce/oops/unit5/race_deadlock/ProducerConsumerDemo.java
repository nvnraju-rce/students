package com.rce.oops.unit5.race_deadlock;

// Program 25: Classic Producer-Consumer using wait()/notify()
class Buffer {
    private int data;
    private boolean full = false;
    synchronized void put(int v) throws InterruptedException {
        while (full) wait();
        data = v; full = true;
        System.out.println("Produced " + v);
        notify();
    }
    synchronized int get() throws InterruptedException {
        while (!full) wait();
        full = false;
        System.out.println("Consumed " + data);
        notify();
        return data;
    }
}
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) b.put(i); } catch (InterruptedException e) { }
        }, "Producer").start();
        new Thread(() -> {
            try { for (int i = 1; i <= 5; i++) b.get(); } catch (InterruptedException e) { }
        }, "Consumer").start();
    }
}
