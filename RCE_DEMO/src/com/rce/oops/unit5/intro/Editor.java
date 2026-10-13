package com.rce.oops.unit5.intro;
// Program 1: Multithreading intro - two tasks at the same time
class Writer extends Thread {
    public void run() { System.out.println("Writing file..."); }
}
class SpellCheck extends Thread {
    public void run() { System.out.println("Checking spelling..."); }
}
public class Editor {
    public static void main(String[] a) {
        new Writer().start();
        new SpellCheck().start();
        // output order may change on every run
    }
}
