package com.example.CVsearch.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VersionDTO {
    private Integer versionNumber;
    private String filePath;
    private LocalDateTime uploadedAt;
}
