package com.rce.cse.inheritence;

//The this keyword refers to the current object.
class Resource {
    String name;
    int age;

    Resource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}

public class Thisdemo {
    public static void main(String[] args) {
    	Resource s = new Resource("Harish", 20);
        s.display();
    }
}



