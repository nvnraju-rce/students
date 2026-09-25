package com.rce.cse.java;


//The instanceof operator is used to check whether an object is 
//an instance of a particular class or subclass.
//It returns either: true or false
//instanceof is used to check the actual type of an object at runtime.
class Car {

    String color;
    String fuel;
    String brand;

    Car(String brand, String color, String fuel) {
        this.brand = brand;
        this.color = color;
        this.fuel = fuel;
    }

    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Color : " + color);
        System.out.println("Fuel  : " + fuel);
    }
}

class Benz extends Car {

    Benz(String color, String fuel) {
        super("Benz", color, fuel);
    }
}

class BMW extends Car {

    BMW(String color, String fuel) {
        super("BMW", color, fuel);
    }
}

class Ferrari extends Car {

    Ferrari(String color, String fuel) {
        super("Ferrari", color, fuel);
    }
}

public class InstanceOfDemo {

    public static void main(String[] args) {

        Car c1 = new Benz("Black", "Petrol");
        Car c2 = new BMW("White", "Diesel");
        Car c3 = new Ferrari("Red", "Petrol");

        if (c1 instanceof Benz) { //Checking whether object is instace of Benz or not 
            System.out.println("c1 is a Benz");
            c1.display();
        }

        System.out.println();

        if (c2 instanceof BMW) {
            System.out.println("c2 is a BMW");
            c2.display();
        }

        System.out.println();

        if (c3 instanceof Ferrari) {
            System.out.println("c3 is a Ferrari");
            c3.display();
        }
    }
}
