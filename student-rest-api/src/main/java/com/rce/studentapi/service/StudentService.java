package com.rce.studentapi.service;

import com.rce.studentapi.entity.Student;
import com.rce.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student input) {
        return repository.findById(id).map(student -> {
            student.setName(input.getName());
            student.setCourse(input.getCourse());
            student.setEmail(input.getEmail());
            return repository.save(student);
        });
    }

    public boolean deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
