package com.rce.oops.unit5.race_deadlock;

// Program 24: Inter-thread communication with wait() / notify()
class Shared {
    boolean ready = false;
    synchronized void await() throws Exception {
        while (!ready) wait();
        System.out.println("Notified!");
    }
    synchronized void give() {
        ready = true;
        notify();
    }
}
public class InterThreadDemo {
    public static void main(String[] args) throws Exception {
        Shared s = new Shared();
        Thread waiter = new Thread(() -> {
            try { s.await(); } catch (Exception e) { }
        });
        waiter.start();
        Thread.sleep(500);
        s.give();
    }
}
