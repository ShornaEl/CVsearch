package com.example.CVsearch.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "education_id")
    private Long educationId;

    private String degree;

    private String fieldOfStudy;

    private LocalDate startDate;

    private LocalDate endDate;

    private String grade;

    private String gradeOutOf;


    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = Institution.class
    )
    @JoinColumn(name = "institution_id", nullable = false) // Maps to the primary key in Company
    private Institution institutions;
}
