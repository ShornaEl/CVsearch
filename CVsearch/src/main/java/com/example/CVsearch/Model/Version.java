package com.example.CVsearch.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long versionId;

    private Integer versionNumber;

    private String filePath;

    private LocalDateTime uploadedAt;
}

