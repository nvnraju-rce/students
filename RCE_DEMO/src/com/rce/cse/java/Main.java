package com.rce.cse.java;

//1. Defining the Class (The Blueprint) or template 
class car {
/*called members of the class :The code is contained within methods, 
the methods and variables defined within a class are */


 // Fields / Attributes (State) //Variables  ---
 String brand;
 String color;
 String model;
 String fuelType;


 // Default Constructor (Used to initialize new objects) 
 public car() {
	 this.brand = "suzuki";
	 this.color = "blue";

 }
 // Constructor (Used to initialize new objects) 
 public car(String brand, String color, String  model , String fuelType) { // car claass , main 
     this.brand 	= brand;
     this.color 	= color;
     this.model 	= model;
     this.fuelType 	= fuelType;
 }

 // Method  //Function
 void displayDetails() {
     System.out.println("Brand: " + brand + " | Color: " + color + " | Model: " + model + " | Fuel Type:"+ fuelType);
 }
}

//2. The Main Class to execute our program
public class Main {
//	The execution of a Java program starts from the main method.
//	Variables declared inside the main method are local to that method.
//	Local variables can be accessed directly within the main method without creating an object.
int x ,y ,z; // non local varables
 public static void main(String[] args) {
	 int a,b,c; // local varaibles 
    // Car car4 = new Car();
     // Creating the first Object (Instance of Car)
     car car1 = new car("Ford", "Green","Mustang","CNG" );
     
     // Creating the second Object (Another Instance of Car)
     car car2 = new car("Toyota", "Red", "-","-");
     // Creating the second Object (Another Instance of Car)
     car car3 = new car("TATA", "Blue", "Safari","Petrol");

     // Interacting with the objects using their methods
     System.out.println("--- Car 1 Information ---");
     car1.displayDetails();

     System.out.println("\n--- Car 2 Information ---");
     car2.displayDetails();
     
     System.out.println("\n--- Car 3 Information ---");
     car3.displayDetails();
 }
 
}