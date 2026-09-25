package com.rce.cse.inheritence;

//Final class → No inheritance
//Final method → No method overriding
//Final variable → No reassignment
final class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
}

// ❌ Error: Cannot inherit from final class
class Dog extends Animal {

}
