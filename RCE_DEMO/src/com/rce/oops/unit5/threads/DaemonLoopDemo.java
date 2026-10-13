package com.rce.oops.unit5.threads;
// Program 12: A daemon thread dies when the last user thread ends
public class DaemonLoopDemo {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("daemon tick " + (++i));
                try { Thread.sleep(300); } catch (InterruptedException e) { }
            }
        });
        d.setDaemon(true);
        d.start();
        Thread.sleep(1000);
        System.out.println("main ends -> JVM exits, daemon stops");
    }
}
