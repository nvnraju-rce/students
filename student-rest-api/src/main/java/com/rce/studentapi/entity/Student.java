package com.rce.studentapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Table name :student
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String course;
    private String email;

    public Student() {}

    public Student(String name, String course, String email) {
        this.name = name;
        this.course = course;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setEmail(String email) { this.email = email; }
}
