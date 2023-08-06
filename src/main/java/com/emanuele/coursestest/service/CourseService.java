package com.emanuele.coursestest.service;

import com.emanuele.coursestest.model.entities.Course;
import com.emanuele.coursestest.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course save(Course course){
        return courseRepository.save(course);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long idCourse) {
        return courseRepository.findById(idCourse);
    }
}
