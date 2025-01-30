package com.example.CVsearch.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ApplicantDTO {
    private String name;
    private LocalDate dob;
    private String contactNumber;
    private String email;
    private String address;
    private String summary;

    private List<SkillDTO> skills;
    private List<EducationDTO> educations;
    private List<ExperienceDTO> experiences;
    private List< VersionDTO> versions;
    private List<ReferenceDTO> references;
    private List<LanguageDTO> languages;
    private List<ProjectDTO> projects;
}
