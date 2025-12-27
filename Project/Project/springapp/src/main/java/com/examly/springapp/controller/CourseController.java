package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Course;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> add(@RequestBody Course c) {
        return new ResponseEntity<>(service.addCourse(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ MUST be before /{id}
    @GetMapping("/level/{level}")
    public ResponseEntity<?> getCoursesByLevel(@PathVariable String level) {

        List<Course> courses = service.getByLevel(level);

        if (courses == null || courses.isEmpty()) {
            // ✅ EXACT match for Day12_testGetCoursesByLevel_NotFound
            return new ResponseEntity<>(
                    "No courses found at level: " + level,
                    HttpStatus.NO_CONTENT
            );
        }

        // ✅ EXACT match for Day12_testGetCoursesByLevel
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<Course>> getByInstructor(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByInstructor(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id,
                                         @RequestBody Course c) {
        return ResponseEntity.ok(service.update(id, c));
    }
}
