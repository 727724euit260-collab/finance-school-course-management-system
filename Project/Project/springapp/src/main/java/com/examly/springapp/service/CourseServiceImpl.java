// package com.examly.springapp.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.Course;
// import com.examly.springapp.repository.CourseRepo;

// @Service
// public class CourseServiceImpl implements CourseService {
//     private final CourseRepo courseRepository;
//     public CourseServiceImpl(CourseRepo courseRepository){
//         this.courseRepository=courseRepository;
//     }
//     @Override
//     public List<Course>getAllCourses(){
//         return courseRepository.findAll();
//     }

//     @Override
//     public Course addCourse(Course course) {
//         throw new UnsupportedOperationException("Unimplemented method 'addCourse'");
//     }

//     @Override
//     public Course getCourseById(Long id) {
//         throw new UnsupportedOperationException("Unimplemented method 'getCourseById'");
//     }

//     @Override
//     public Course updateCourse(Long id, Course course) {
  
//         throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
//     }
   
// }


package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo repo;

    public Course addCourse(Course course) { return repo.save(course); }
    public List<Course> getAll() { return repo.findAll(); }
    public Course getById(Long id) { return repo.findById(id).orElse(null); }
    public Course update(Long id, Course course) {
        course.setCourseId(id);
        return repo.save(course);
    }
    public List<Course> getByInstructor(Long id) {
        return repo.findByInstructorInstructorId(id);
    }
    public List<Course> getByLevel(String level) {
        return repo.findByLevel(level);
    }
}
