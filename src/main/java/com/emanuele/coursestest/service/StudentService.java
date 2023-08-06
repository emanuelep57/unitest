package com.emanuele.coursestest.service;

import com.emanuele.coursestest.model.dto.GetStudentDTO;
import com.emanuele.coursestest.model.entities.Student;
import com.emanuele.coursestest.model.mapper.GetStudentMapper;
import com.emanuele.coursestest.repository.CourseRepository;
import com.emanuele.coursestest.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    GetStudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, GetStudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentMapper = studentMapper;
    }

    @Transactional
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    public List<GetStudentDTO> findAll(){
        List<GetStudentDTO> students = studentRepository.findAll().stream().map(studentMapper::toDto).toList();
        System.out.println(students);
        return students;
    }

    public Student findById(){
        return studentRepository.findById(1L).get();
    }
}
