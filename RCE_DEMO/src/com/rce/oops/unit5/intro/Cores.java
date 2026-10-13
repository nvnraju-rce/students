package com.rce.oops.unit5.intro;
// Program 2: How many cores does this machine have?
public class Cores {
    public static void main(String[] a) {
        int n = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores: " + n);
    }
}
