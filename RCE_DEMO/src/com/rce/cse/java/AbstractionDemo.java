package com.rce.cse.java;

abstract class Animal {
    // Abstract method
    abstract void sound();

    // Concrete method
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Animal a = new Dog(); //upcasting
        a.sound();
        a.sleep();
    }
}