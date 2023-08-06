package com.emanuele.coursestest.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @NaturalId
    private String identificationString;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(String name, String surname, String identificationString) {
        this.name = name;
        this.surname = surname;
        this.identificationString = identificationString;
    }

    public Student(String name, String surname, String identificationString, Course course) {
        this.name = name;
        this.surname = surname;
        this.identificationString = identificationString;
        this.course = course;
    }
}
