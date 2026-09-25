package com.rce.cse.inheritence;

//Nested Method is not allowed in java Directly 
//Within Method we can call another method .
class NestedMethodDemo {

    void method1() {

        void method2() {       // ❌ Not allowed
            System.out.println("Hello");
        }

    }