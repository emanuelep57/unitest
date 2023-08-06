package com.emanuele.coursestest.controller;

import com.emanuele.coursestest.model.entities.Course;
import com.emanuele.coursestest.model.entities.Student;
import com.emanuele.coursestest.model.dto.SaveStudentDTO;
import com.emanuele.coursestest.service.CourseService;
import com.emanuele.coursestest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping(path = "/students")
@RestController
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @PostMapping(path = "/")
    ResponseEntity<?> addStudent(@RequestBody SaveStudentDTO studentToAdd){

        Optional<Course> course = courseService.findById(studentToAdd.getIdCourse());
        //check if course exists
        if (course.isPresent()){
            Student student = studentService.save(
                new Student(
                    studentToAdd.getName(),
                    studentToAdd.getSurname(),
                    studentToAdd.getIdString(),
                    course.get()
                )
            );
            course.get().addStudent(student);
            return ResponseEntity.ofNullable(student);
        }

        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @GetMapping(path = "/")
    ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }
}
