package com.rce.oops.unit5.states_sync;
// Program 14: Observe BLOCKED and WAITING states
public class BlockedWaitingDemo {
    public static void main(String[] args) throws Exception {
        final Object lock = new Object();
        Thread holder = new Thread(() -> {
            synchronized (lock) {
                try { Thread.sleep(1000); } catch (InterruptedException e) { }
            }
        });
        Thread blocked = new Thread(() -> { synchronized (lock) { } });
        holder.start();
        Thread.sleep(100);
        blocked.start();
        Thread.sleep(100);
        System.out.println("blocked thread state : " + blocked.getState());  // BLOCKED

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try { lock.wait(); } catch (InterruptedException e) { }
            }
        });
        holder.join();
        waiter.start();
        Thread.sleep(200);
        System.out.println("waiting thread state : " + waiter.getState());   // WAITING
        synchronized (lock) { lock.notify(); }
    }
}
