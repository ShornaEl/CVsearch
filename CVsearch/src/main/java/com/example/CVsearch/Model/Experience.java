package com.example.CVsearch.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
    private Long experienceId;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(length = 2000)
    private String responsibilities;


    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = Company.class
    )
    @JoinColumn(name = "company_id", nullable = false) // Maps to the primary key in Company
    private Company company;
}

