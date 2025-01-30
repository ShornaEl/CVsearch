package com.example.CVsearch.Service;


import com.example.CVsearch.DTO.*;
import com.example.CVsearch.Model.*;
import com.example.CVsearch.Model.Skill;
import com.example.CVsearch.Dao.ApplicantRepository;
import com.example.CVsearch.constants.SkillLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;


    public Applicant convertToEntity(ApplicantDTO dto) {
        Applicant applicant = new Applicant();
        applicant.setName(dto.getName());
        applicant.setDob(dto.getDob());
        applicant.setContactNumber(dto.getContactNumber());
        applicant.setEmail(dto.getEmail());
        applicant.setAddress(dto.getAddress());
        applicant.setSummary(dto.getSummary());

        // Add null checks to prevent NullPointerException
        applicant.setSkills(dto.getSkills() != null ?
                dto.getSkills().stream().map(this::convertSkillToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setEducations(dto.getEducations() != null ?
                dto.getEducations().stream().map(this::convertEducationToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setExperiences(dto.getExperiences() != null ?
                dto.getExperiences().stream().map(this::convertExperienceToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setLanguages(dto.getLanguages() != null ?
                dto.getLanguages().stream().map(this::convertLanguageToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setProjects(dto.getProjects() != null ?
                dto.getProjects().stream().map(this::convertProjectToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setReferences(dto.getReferences() != null ?
                dto.getReferences().stream().map(this::convertReferenceToEntity).collect(Collectors.toList()) :
                List.of());

        applicant.setVersions(dto.getVersions() != null ?
                dto.getVersions().stream().map(this::convertVersionToEntity).collect(Collectors.toList()) :
                List.of());

        return applicant;
    }


    private Skill convertSkillToEntity(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setSkillName(dto.getSkillName());
        skill.setSkillsLevel(dto.getSkillsLevel());
        return skill;
    }

    private Education convertEducationToEntity(EducationDTO dto) {
        Education education = new Education();
        education.setDegree(dto.getDegree());
        education.setFieldOfStudy(dto.getFieldOfStudy());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setGrade(dto.getGrade());
        education.setGradeOutOf(dto.getGradeOutOf());

        Institution institution = new Institution();
        institution.setInstitutionName(dto.getInstitution().getInstitutionName());
        institution.setLocation(dto.getInstitution().getLocation());
        education.setInstitutions(institution);

        return education;
    }

    private Experience convertExperienceToEntity(ExperienceDTO dto) {
        Experience experience = new Experience();
        experience.setPosition(dto.getPosition());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setResponsibilities(dto.getResponsibilities());

        Company company = new Company();
        company.setCompanyName(dto.getCompany().getCompanyName());
        company.setIndustry(dto.getCompany().getIndustry());
        company.setLocation(dto.getCompany().getLocation());
        experience.setCompany(company);

        return experience;
    }

    private Language convertLanguageToEntity(LanguageDTO dto) {
        Language language = new Language();
        language.setLanguageName(dto.getLanguageName());
        language.setProficiencyLevel(dto.getProficiencyLevel());
        return language;
    }

    private Project convertProjectToEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setToolsAndTechnology(dto.getToolsAndTechnology());
        project.setProjectSummary(dto.getProjectSummary());
        return project;
    }

    private Reference convertReferenceToEntity(ReferenceDTO dto) {
        Reference reference = new Reference();
        reference.setName(dto.getName());
        reference.setPosition(dto.getPosition());
        reference.setRelation(dto.getRelation());
        return reference;
    }

    private Version convertVersionToEntity(VersionDTO dto) {
        Version version = new Version();
        version.setVersionNumber(dto.getVersionNumber());
        version.setFilePath(dto.getFilePath());
        version.setUploadedAt(dto.getUploadedAt());
        return version;
    }

    public Applicant saveApplicant(ApplicantDTO dto) {
        Applicant applicant = convertToEntity(dto);
        return applicantRepository.save(applicant);
    }

    // Other service methods can be added here
}


