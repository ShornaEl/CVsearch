package com.example.CVsearch.Cotroller;

import com.example.CVsearch.DTO.ApplicantDTO;
import com.example.CVsearch.Model.Applicant;
import com.example.CVsearch.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    // Endpoint to insert an applicant and their skills
    @PostMapping
    public Applicant createApplicant(@RequestBody ApplicantDTO dto) {
        Applicant savedApplicant = applicantService.saveApplicant(dto);
        return savedApplicant;

    }
}
