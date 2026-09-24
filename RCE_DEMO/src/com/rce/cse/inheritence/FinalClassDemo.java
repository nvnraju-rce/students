package com.rce.cse.inheritence;

final class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
}

// ❌ Error: Cannot inherit from final class
class Dog extends Animal {

}
