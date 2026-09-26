package com.rce.collections;

import java.util.ArrayList;

public class StudentList {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Ravi", 85));
        students.add(new Student(102, "Sita", 92));
        students.add(new Student(103, "Kiran", 76));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
