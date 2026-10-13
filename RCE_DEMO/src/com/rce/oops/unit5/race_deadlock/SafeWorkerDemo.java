package com.rce.oops.unit5.race_deadlock;

// Program 26: Safe way to pause / resume / stop (instead of deprecated suspend/resume/stop)
class Worker extends Thread {
    volatile boolean running = true;
    boolean paused = false;
    public void run() {
        while (running) {
            synchronized (this) {
                while (paused)
                    try { wait(); } catch (Exception e) { }
            }
            System.out.println("working...");
            try { sleep(300); } catch (Exception e) { }
        }
        System.out.println("worker stopped");
    }
    synchronized void pauseIt()  { paused = true; }
    synchronized void resumeIt() { paused = false; notify(); }
    void stopIt() { running = false; }
}
public class SafeWorkerDemo {
    public static void main(String[] args) throws Exception {
        Worker w = new Worker();
        w.start();
        Thread.sleep(1000);
        System.out.println(">> pause");  w.pauseIt();
        Thread.sleep(1000);
        System.out.println(">> resume"); w.resumeIt();
        Thread.sleep(1000);
        System.out.println(">> stop");   w.stopIt();
    }
}
