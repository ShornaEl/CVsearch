package com.example.CVsearch.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private UUID companyId;

    @Column(unique = true)
    private String companyName;

    private String industry;

    private String location;

}
