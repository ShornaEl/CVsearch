package com.example.CVsearch.Dao;

import com.example.CVsearch.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
