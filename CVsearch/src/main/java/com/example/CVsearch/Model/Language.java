package com.example.CVsearch.Model;


import com.example.CVsearch.constants.ProficiencyLevel;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long languageId;

    private String languageName;

    @Enumerated(EnumType.STRING)
    private ProficiencyLevel proficiencyLevel;


}

