package com.rce.cse.inheritence;

//Final class → No inheritance
//Final method → No method overriding
//Final variable → No reassignment
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
