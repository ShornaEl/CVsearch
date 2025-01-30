package com.example.CVsearch.TextExtraction;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TextExtractionService {

    public String extractTextFromPDF(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")) {
            throw new IllegalArgumentException("Invalid file. Please upload a PDF.");
        }

        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper textStripper = new PDFTextStripper();
            return textStripper.getText(document);
        }
    }
}
