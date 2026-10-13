package com.rce.oops.unit5.intro;
// Program 3: Multi-core demo - sum 1..N using 1 thread vs many threads
public class ParallelSum {
    static long partial(long from, long to) {
        long s = 0;
        for (long i = from; i <= to; i++) s += i;
        return s;
    }
    public static void main(String[] args) throws Exception {
        final long N = 2_000_000_000L;
        int cores = Runtime.getRuntime().availableProcessors();

        long t0 = System.currentTimeMillis();
        long single = partial(1, N);
        long t1 = System.currentTimeMillis();
        System.out.println("Single thread : " + single + "  time = " + (t1 - t0) + " ms");

        final long[] result = new long[cores];
        Thread[] ts = new Thread[cores];
        long chunk = N / cores;
        t0 = System.currentTimeMillis();
        for (int i = 0; i < cores; i++) {
            final int id = i;
            final long from = id * chunk + 1;
            final long to = (id == cores - 1) ? N : (id + 1) * chunk;
            ts[i] = new Thread(() -> result[id] = partial(from, to));
            ts[i].start();
        }
        long total = 0;
        for (int i = 0; i < cores; i++) { ts[i].join(); total += result[i]; }
        t1 = System.currentTimeMillis();
        System.out.println(cores + " threads    : " + total + "  time = " + (t1 - t0) + " ms");
    }
}
