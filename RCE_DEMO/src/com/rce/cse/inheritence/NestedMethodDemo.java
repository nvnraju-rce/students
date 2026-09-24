package com.rce.cse.inheritence;

class NestedMethodDemo {

    void method1() {

        void method2() {       // ❌ Not allowed
            System.out.println("Hello");
        }

    }