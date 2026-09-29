package com.rce.oops.unit2;

//Parent class
class Animals {

 void eat() {
     System.out.println("Animal is eating");
 }
}

//Child 1
class Dogs extends Animals {

 void bark() {
     System.out.println("Dog is barking");
 }
}

//Child 2
class Cats extends Animals {

 void meow() {
     System.out.println("Cat is meowing");
 }
}

//Main class
public class HierarchicalDemo {

 public static void main(String[] args) {

     Dogs d = new Dogs();
     d.eat();   // Inherited from Animal
     d.bark();  // Dog's own method

     Cats c = new Cats();
     c.eat();   // Inherited from Animal
     c.meow();  // Cat's own method
 }
}