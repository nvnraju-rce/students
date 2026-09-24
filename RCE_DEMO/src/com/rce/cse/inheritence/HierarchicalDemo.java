package com.rce.cse.inheritence;

//Parent class
class Animal {

 void eat() {
     System.out.println("Animal is eating");
 }
}

//Child 1
class Dog extends Animal {

 void bark() {
     System.out.println("Dog is barking");
 }
}

//Child 2
class Cat extends Animal {

 void meow() {
     System.out.println("Cat is meowing");
 }
}

//Main class
public class HierarchicalDemo {

 public static void main(String[] args) {

     Dog d = new Dog();
     d.eat();   // Inherited from Animal
     d.bark();  // Dog's own method

     Cat c = new Cat();
     c.eat();   // Inherited from Animal
     c.meow();  // Cat's own method
 }
}