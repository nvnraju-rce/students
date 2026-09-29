package com.rce.oops.unit2;

//Parent class
//Best practice is to start class name with Uppercase Letter
class Person {

 String name = "Ravi";
 
//Best practice is to start Method /Function name with LoweCase Letter and if it has 2 
 //words use Uppdercase for next one
 void displayName() {
     System.out.println("Name: " + name);
 }
}
//Child class
class Stud extends Person {
 int rollNo = 101;
 void displayStudent() {
     System.out.println("Roll No: " + rollNo);
 }
}

//Main class
public class SingleInhitanceDemo {

 public static void main(String[] args) {

	 Stud s = new Stud();

     // Parent class property/method
     s.displayName();

     // Child class property/method
     s.displayStudent();
 }
}
