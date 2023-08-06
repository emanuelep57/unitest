package com.emanuele.coursestest.repository;

import com.emanuele.coursestest.model.entities.Student;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    /*
    @Override
    @Query(value = "SELECT s, c FROM Student s JOIN FETCH s.course c")
    @NonNull
    List<Student> findAll();
    */
}
