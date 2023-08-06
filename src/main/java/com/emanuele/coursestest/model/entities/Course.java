package com.emanuele.coursestest.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "course_name")
    private String courseName;

    @Column(nullable = false, name = "description")
    private String description;


    @OneToMany(mappedBy = "course", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonBackReference
    private Set<Student> courseStudents;

    public void addStudent(Student student){
        if(courseStudents == null)
            courseStudents = new HashSet<>();

        courseStudents.add(student);
    }

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
}
