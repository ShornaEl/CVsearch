package com.example.CVsearch.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Transactional
@NoArgsConstructor

public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Sequential ID
    @Column(name = "applicant_id")
    private Long applicantId;

    private String name;

    private LocalDate dob;

    private String contactNumber;

    @Column(unique = true)
    private String email;

    private String address;

    @Column(length = 1000)
    private String summary;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Skill.class
    )//CasecaseType.ALL when I want to save the data of applicant class it will also save tha data of skills class
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Skill> skills;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Education.class
    )//CasecaseType.ALL when I want to save the data of applicant class it will also save tha data of skills class
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Education> educations;


    // Automatic timestamps

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Experience.class
    )
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Experience> experiences;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Version.class
    )
    @JoinColumn(referencedColumnName = "applicant_id")

    private List<Version> versions;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Reference.class
    )
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Reference> references;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Language.class
    )
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Language> languages;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Project.class
    )
    @JoinColumn(referencedColumnName = "applicant_id")
    private List<Project> projects;
}

