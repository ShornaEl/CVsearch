package com.example.CVsearch.Model;

import com.example.CVsearch.constants.InstitutionType;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Transactional
@NoArgsConstructor
@Data
@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institution_id") // Corrected from "institude_id" to "institution_id"
    private Long institutionId;

    private String institutionName;

    private String location;

    @Enumerated(EnumType.STRING)
    private InstitutionType type;
}

