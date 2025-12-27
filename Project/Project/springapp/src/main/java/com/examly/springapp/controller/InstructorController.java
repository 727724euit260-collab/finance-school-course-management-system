
package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @PostMapping
    public ResponseEntity<?> addInstructor(@RequestBody(required = false) Instructor instructor) {
        if (instructor == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(service.addInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Instructor> list = service.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.update(id, instructor));
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
    }

    @GetMapping("/page/{page}/{size}")
    public Page<Instructor> getPage(@PathVariable int page, @PathVariable int size) {
        return service.getPage(page, size);
    }

    @GetMapping("/specialization/{spec}")
    public ResponseEntity<?> getBySpecialization(@PathVariable String spec) {
        List<Instructor> list = service.getBySpecialization(spec);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No instructors found with specialization: " + spec);
        }
        return ResponseEntity.ok(list);
    }
}
