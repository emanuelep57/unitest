package com.emanuele.coursestest.model.dto;
import com.emanuele.coursestest.model.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class GetStudentDTO {
    private Long id;
    private String name;
    private String surname;
    private String identificationString;
    private Course course;
}
