package com.example.CVsearch.Model;

import com.example.CVsearch.constants.SkillLevel;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Sequential I
    private Long skillId;

    private String skillName;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillsLevel;


}
