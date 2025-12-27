package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    public Student add(Student s) { return repo.save(s); }
    public List<Student> getAll() { return repo.findAll(); }
    public Student getById(Long id) { return repo.findById(id).orElse(null); }
    public Student update(Long id, Student s) {
        s.setStudentId(id);
        return repo.save(s);
    }
    public Student getByEmail(String email) {
        return repo.findByEmail(email);
    }
}
