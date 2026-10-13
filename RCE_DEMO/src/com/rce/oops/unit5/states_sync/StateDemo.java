package com.rce.oops.unit5.states_sync;

// Program 13: Thread states using getState()
public class StateDemo extends Thread {
    public void run() {
        try { sleep(300); } catch (Exception e) { }
    }
    public static void main(String[] a) throws Exception {
        StateDemo t = new StateDemo();
        System.out.println(t.getState());   // NEW
        t.start();
        System.out.println(t.getState());   // RUNNABLE
        Thread.sleep(100);
        System.out.println(t.getState());   // TIMED_WAITING
        t.join();
        System.out.println(t.getState());   // TERMINATED
    }
}
