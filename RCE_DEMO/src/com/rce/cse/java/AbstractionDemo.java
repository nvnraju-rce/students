package com.rce.cse.java;
//An abstract class is a class that cannot be used to create objects directly.
//The abstract keyword is used when we want to create a general/partially implemented class or method.
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