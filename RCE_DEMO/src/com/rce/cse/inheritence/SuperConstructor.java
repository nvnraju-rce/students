package com.rce.cse.inheritence;

class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {

    Child() {
        super();   // Calls Parent constructor
        System.out.println("Child Constructor");
    }
}
