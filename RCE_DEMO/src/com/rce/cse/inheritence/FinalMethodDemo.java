package com.rce.cse.inheritence;

class Animal {

    final void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    // ❌ Error: Cannot override final method
    void eat() {
        System.out.println("Dog is eating");
    }
}
