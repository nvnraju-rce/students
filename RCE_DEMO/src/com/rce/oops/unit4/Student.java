package com.rce.oops.unit4;
import java.util.*;
class Student {
    // Write your code here...
    private String name;
	private int rollNo;
	private String branch;
	private int marks;
	Student(String  name,int rollNo,String branch,int marks){
			this.name = name;
		    this.rollNo = rollNo;
		    this.branch = branch;
		    this.marks = marks;
	}
		Student(){
			this.name = "";
		    this.rollNo = 0;
		    this.branch = "";
		    this.marks = 0;
	}
			Student(String name){
			this.name = name;
		    this.rollNo = 0;
		    this.branch = "";
		    this.marks = 0;
	}
		Student(String name, int rollNo){
			this.name = name;
		    this.rollNo = rollNo;
		    this.branch = "";
		    this.marks = 0;
	}
	 void showStudnetDetails(){
		System.out.println("Student Details");

		  System.out.println("Name: "+this.name);
	  }
    public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		String name = sc.next();
	    System.out.print("Roll Number: ");
		int rollNo = sc.nextInt();
		System.out.print("Branch: ");
		String branch = sc.next();
	    System.out.print("Marks: ");
		int marks = sc.nextInt();
		Student st = new Student(name,rollNo,branch,marks);
		st.showStudnetDetails();
		sc.close();
	}
}