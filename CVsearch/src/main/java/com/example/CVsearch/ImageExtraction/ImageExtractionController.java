package com.example.CVsearch.ImageExtraction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/cv")
public class ImageExtractionController {

    @PostMapping("/extract-images")
    public ResponseEntity<?> extractProfileImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")) {
            return ResponseEntity.badRequest().body("Invalid PDF file.");
        }

        try {
            // Save the uploaded file temporarily
            File tempFile = File.createTempFile("uploaded-", ".pdf");
            file.transferTo(tempFile);

            // Specify the output directory
            String outputDir = System.getProperty("java.io.tmpdir") + "/profile-images";
            File outputDirectory = new File(outputDir);
            if (!outputDirectory.exists()) {
                outputDirectory.mkdirs();
            }

            // Extract the profile image
            File profileImage = ImageExtractor.extractProfileImage(tempFile, outputDir);

            if (profileImage != null) {
                return ResponseEntity.ok("Profile image extracted: " + profileImage.getAbsolutePath());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No profile image found in the document.");
            }

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error extracting profile image: " + e.getMessage());
        }
    }
}

//
//import com.example.cv_bank.ImageExtraction.ImageExtractor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/pdf")
//public class ImageExtractionController {
//
//    @PostMapping("/extract-images")
//    public ResponseEntity<?> extractImages(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")) {
//            return ResponseEntity.badRequest().body("Invalid PDF file.");
//        }
//
//        try {
//            // Save the uploaded file temporarily
//            File tempFile = File.createTempFile("uploaded-", ".pdf");
//            file.transferTo(tempFile);
//
//            // Specify the output directory for images
//            String outputDir = System.getProperty("java.io.tmpdir") + "/pdf-images";
//            File outputDirectory = new File(outputDir);
//            if (!outputDirectory.exists()) {
//                outputDirectory.mkdirs();
//            }
//
//            // Extract images
//            List<File> images = ImageExtractor.extractImages(tempFile, outputDir);
//
//            // Return response with image file paths
//            return ResponseEntity.ok(images);
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error extracting images: " + e.getMessage());
//        }
//    }
//}
//
