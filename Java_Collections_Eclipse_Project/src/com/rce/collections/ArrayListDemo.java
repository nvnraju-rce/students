package com.rce.collections;

import java.util.ArrayList;
/**	
An ArrayList in Java is a resizable, dynamic array implementation 
provided by the java.util package that implements the List interface. 
Unlike traditional Java arrays, which have a fixed size that cannot be altered after creation, 
an ArrayList automatically grows or shrinks in size as elements are added or removed .
Operations in Array List 
	add()     → Insert
	get()     → Retrieve
	set()     → Update
	remove()  → Delete
	size()    → Number of elements
**/

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Ravi");
        students.add("Sita");
        students.add("Kiran");
        students.add("Anil");

        System.out.println("Students: " + students);
    }
}
