package com.rce.oops.unit5.states_sync;

// Program 18: Multiplication tables - synchronized output never mixes
class Table {
    synchronized void print(int n) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
    }
}
public class TableDemo {
    public static void main(String[] args) {
        Table t = new Table();
        new Thread(() -> t.print(5)).start();
        new Thread(() -> t.print(100)).start();
        // try removing 'synchronized' and run again
    }
}
