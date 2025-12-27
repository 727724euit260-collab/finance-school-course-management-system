

package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Course;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAll();
    Course getById(Long id);
    Course update(Long id, Course course);
    List<Course> getByInstructor(Long instructorId);
    List<Course> getByLevel(String level);
}
