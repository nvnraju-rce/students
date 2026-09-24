package com.rce.cse.inheritence;

//Grandparent class
 class GrandPerson {

 void displayPerson() {
     System.out.println("I am a Person");
 }
}

//Parent class
class Employee extends GrandPerson {

 void displayEmployee() {
     System.out.println("I am an Employee");
 }
}

//Child class
class Manager extends Employee {

 void displayManager() {
     System.out.println("I am a Manager");
 }
}

//Main class
public class MultilevelDemo {

 public static void main(String[] args) {

     Manager m = new Manager();

     m.displayPerson();    // From Person
     m.displayEmployee();  // From Employee
     m.displayManager();   // From Manager
 }
}
