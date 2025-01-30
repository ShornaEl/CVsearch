package com.example.CVsearch.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDTO {
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
    private String gradeOutOf;
    private InstitutionDTO institution;
}
