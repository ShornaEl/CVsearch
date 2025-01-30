package com.example.CVsearch.CVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CVParserController {

    @Autowired
    private MistralCVParser cvParser;

    @PostMapping("/parse-cv")
    public ResponseEntity<?> parseCV(@RequestBody Map<String, String> request) {
        String cvText = request.get("cv_text");

        if (cvText == null || cvText.isEmpty()) {
            return ResponseEntity.badRequest().body("CV text is required.");
        }

        try {
            // Sanitize the input by replacing problematic characters
            String sanitizedCVText = cvText.replace("\r", "").replace("\n", "\\n");

            // Pass sanitized text to the parser
            String parsedCV = cvParser.parseCV(sanitizedCVText);

            return ResponseEntity.ok(parsedCV);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error parsing CV: " + e.getMessage());
        }
    }
}
