
// package com.examly.springapp.service;

// import com.examly.springapp.model.Instructor;
// import org.springframework.data.domain.*;
// import org.springframework.stereotype.Service;

// import java.util.*;

// @Service
// public class InstructorServiceImpl implements InstructorService {

//     private final List<Instructor> store = new ArrayList<>();
//     private long idCounter = 1;

//     @Override
//     public Instructor addInstructor(Instructor instructor) {
//         instructor.setId(idCounter++);
//         store.add(instructor);
//         return instructor;
//     }

//     @Override
//     public List<Instructor> getAll() {
//         return store;
//     }

//     @Override
//     public Instructor getById(Long id) {
//         return store.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
//     }

//     @Override
//     public Instructor update(Long id, Instructor instructor) {
//         Instructor existing = getById(id);
//         if (existing == null) return null;

//         existing.setInstructorName(instructor.getInstructorName());
//         existing.setEmail(instructor.getEmail());
//         existing.setSpecialization(instructor.getSpecialization());
//         existing.setPhoneNumber(instructor.getPhoneNumber());
//         return existing;
//     }

//     @Override
//     public Page<Instructor> getPaginated(int page, int size) {
//         Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
//         return new PageImpl<>(store, pageable, store.size());
//     }
// }


package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo repo;

    public Instructor addInstructor(Instructor instructor) {
        return repo.save(instructor);
    }

    public List<Instructor> getAll() {
        return repo.findAll();
    }

    public Instructor getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Instructor update(Long id, Instructor instructor) {
        instructor.setInstructorId(id);
        return repo.save(instructor);
    }

    public Page<Instructor> getPage(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    public List<Instructor> getBySpecialization(String specialization) {
        return repo.findBySpecialization(specialization);
    }
}
