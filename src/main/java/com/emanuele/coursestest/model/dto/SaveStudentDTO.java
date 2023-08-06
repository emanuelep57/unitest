package com.emanuele.coursestest.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SaveStudentDTO {
    @JsonProperty
    private String name;

    @JsonProperty
    private String surname;

    @JsonProperty
    private String idString;

    @JsonProperty
    private Long idCourse;
}
