

package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Instructor;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAll();

    Instructor getById(Long id);

    Instructor update(Long id, Instructor instructor);

    Page<Instructor> getPage(int page, int size);

    List<Instructor> getBySpecialization(String specialization);
}
