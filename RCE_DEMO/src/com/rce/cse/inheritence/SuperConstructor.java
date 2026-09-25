package com.rce.cse.inheritence;
//The super keyword is used to refer to the immediate parent class object.
//In inheritance, super is mainly used in 3 ways:
//Access parent class variables
//Call parent class methods
//Call parent class constructor
class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {

    Child() {
        super();   // **** Calls Parent constructor
        System.out.println("Child Constructor");
    }
}
