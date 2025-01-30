package com.example.CVsearch.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    private String title;

    @Column(length = 1000)
    private String toolsAndTechnology;

    @Column(length = 2000)
    private String projectSummary;


}
