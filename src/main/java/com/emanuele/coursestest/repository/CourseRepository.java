package com.emanuele.coursestest.repository;

import com.emanuele.coursestest.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
