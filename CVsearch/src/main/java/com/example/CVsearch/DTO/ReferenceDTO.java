package com.example.CVsearch.DTO;

import lombok.Data;

@Data


public class ReferenceDTO {
    private String name; // Maps to `refererName`
    private String contactInformation;
    private String position;
    private String companyName; // Fix typo from `comapnyName` to `companyName` in the entity
    private String relation;
}
