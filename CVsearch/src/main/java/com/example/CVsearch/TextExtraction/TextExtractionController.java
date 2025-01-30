package com.example.CVsearch.TextExtraction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@RestController
@RequestMapping("/api")
public class TextExtractionController {

    @PostMapping("/extract-text")
    public Map<String, String> extractTextFromPdf(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();

        try {
            // Check if file is empty
            if (file.isEmpty()) {
                response.put("error", "No file uploaded");
                return response;
            }

            // Read the PDF file
            InputStream inputStream = file.getInputStream();
            PDDocument document = PDDocument.load(inputStream);
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Extract text from the PDF
            String text = pdfStripper.getText(document);

            // Close the document
            document.close();

            // Prepare JSON response
            response.put("cv_text", text.trim());
            return response;

        } catch (IOException e) {
            // Handle exceptions
            response.put("error", "An error occurred while processing the PDF: " + e.getMessage());
            return response;
        }
    }
}
