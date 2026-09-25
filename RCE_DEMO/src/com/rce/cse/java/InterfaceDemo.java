package com.rce.cse.java;

//Interface tells WHAT to do, while the implementing class decides HOW to do it.
interface Vehicle {
    void start();
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts with a key");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
    //    Vehicle v = new Bike();
        Bike b = new Bike();
        b.start();
    }
}
