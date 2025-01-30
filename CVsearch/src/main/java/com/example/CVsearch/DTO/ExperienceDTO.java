package com.example.CVsearch.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceDTO {
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;
    private String responsibilities;
    private CompanyDTO company;
}
