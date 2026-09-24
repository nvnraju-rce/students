package com.rce.cse.java;

//Class for Addtion of 2 number and 3 numbers
class Addition {
	
	//Addition of 2 Numbers Polymorphism
    int add(int a, int b) {
        return a + b;
    }
    //Addition of 3 Numbers - Polymorphism
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class PolymorDemo {
    public static void main(String[] args) {
    	//Creating Object
        Addition obj = new Addition();

        System.out.println(obj.add(10, 20));  //Polymorphism
        System.out.println(obj.add(10, 20, 30));  //Polymorphism
    }
}