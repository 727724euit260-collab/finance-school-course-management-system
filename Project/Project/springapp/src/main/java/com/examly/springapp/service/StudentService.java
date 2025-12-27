package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Student;

public interface StudentService {
    Student add(Student s);
    List<Student> getAll();
    Student getById(Long id);
    Student update(Long id, Student s);
    Student getByEmail(String email);
}
