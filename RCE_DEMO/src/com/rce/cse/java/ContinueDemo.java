package com.rce.cse.java;

public class ContinueDemo {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }
    }
}
