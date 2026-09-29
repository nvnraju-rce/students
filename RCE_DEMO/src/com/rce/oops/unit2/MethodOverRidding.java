package com.rce.oops.unit2;

class Pets {

    void sound() {
        System.out.println("Pets makes a sound");
    }
}

class PetDog extends Pets {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverRidding {

    public static void main(String[] args) {

    	PetDog d = new PetDog();
        d.sound();
    }
}


