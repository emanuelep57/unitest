package com.emanuele.coursestest.controller;

import com.emanuele.coursestest.model.entities.Course;
import com.emanuele.coursestest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addCourse(@RequestBody Course course2Add){
        return ResponseEntity.ofNullable(
            courseService.save(course2Add)
        );
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }
}
