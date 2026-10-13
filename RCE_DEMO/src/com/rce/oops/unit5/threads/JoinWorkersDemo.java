package com.rce.oops.unit5.threads;
// Program 10: join() - wait for all workers before printing the final result
public class JoinWorkersDemo {
    static int total = 0;
    static synchronized void add(int v) { total += v; }
    public static void main(String[] args) throws Exception {
        Thread[] w = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int n = i + 1;
            w[i] = new Thread(() -> { add(n * 10); System.out.println("Worker " + n + " done"); });
            w[i].start();
        }
        for (Thread t : w) t.join();
        System.out.println("Final total = " + total);   // always 60
    }
}
