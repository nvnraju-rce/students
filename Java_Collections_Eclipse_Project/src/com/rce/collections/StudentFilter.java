package com.rce.collections;

import java.util.Arrays;
import java.util.List;

public class StudentFilter {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(101, "Ravi", 85),
                new Student(102, "Sita", 92),
                new Student(103, "Kiran", 56));

        System.out.println("Students with marks >= 80:");

        students.stream()
                .filter(s -> s.marks >= 80)
                .forEach(System.out::println);
    }
}
