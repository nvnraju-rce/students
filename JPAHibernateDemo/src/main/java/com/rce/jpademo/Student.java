package com.rce.jpademo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
   // private int age;
  //  private String course;
    private int marks;

    public Student() {
    }

    public Student( int id ,String name, int marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

 
    @Override
    public String toString() {
        return "Student{id=" + id
                + ", name='" + name + "'"
                + ", marks=" + marks
                +  '}';
    }
}
