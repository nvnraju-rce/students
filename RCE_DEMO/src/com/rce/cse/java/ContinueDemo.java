package com.rce.cse.java;
//The continue keyword is used inside loops to 
//skip the current iteration and move to the next iteration.
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
