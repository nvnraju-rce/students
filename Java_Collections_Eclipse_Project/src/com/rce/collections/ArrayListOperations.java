package com.rce.collections;
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

import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Ravi");
        students.add("Sita");
        students.add("Kiran");

        System.out.println("First Student: " + students.get(0));

        students.set(1, "Priya");
        students.remove("Kiran");

        System.out.println("Final List: " + students);
        System.out.println("Size: " + students.size());
    }
}
