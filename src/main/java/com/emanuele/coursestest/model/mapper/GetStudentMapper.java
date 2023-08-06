package com.emanuele.coursestest.model.mapper;

import com.emanuele.coursestest.model.dto.GetStudentDTO;
import com.emanuele.coursestest.model.entities.Course;
import com.emanuele.coursestest.model.entities.Student;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Component;

@Component
public class GetStudentMapper {

    public GetStudentDTO toDto(Student student) {
        Long id = student.getId();
        String name = student.getName();
        String surname = student.getSurname();
        String idString = student.getIdentificationString();
        Course course = student.getCourse();
        return new GetStudentDTO(id, name, surname, idString, course);
    }

    public Student toStudent(GetStudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getSurname(), studentDTO.getIdentificationString(), studentDTO.getCourse());
    }
}
