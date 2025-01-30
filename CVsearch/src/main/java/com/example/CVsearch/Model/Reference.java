package com.example.CVsearch.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Transactional
@NoArgsConstructor
@Data
@Entity
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long referenceId;
    private String  name;
    private  String contactInformation;
    private String position;
    private String comapnyName;
    private String relation;


}
