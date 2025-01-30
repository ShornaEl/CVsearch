package com.example.CVsearch.ImageExtraction;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.util.stream.StreamSupport;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import java.util.Iterator;

//public class ImageExtractor {
//
//    public static List<File> extractImages(File pdfFile, String outputDir) throws IOException {
//        List<File> imageFiles = new ArrayList<>();
//        try (PDDocument document = PDDocument.load(pdfFile)) {
//            PDFRenderer pdfRenderer = new PDFRenderer(document);
//
//            for (int page = 0; page < document.getNumberOfPages(); page++) {
//                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300); // High DPI for better quality
//                File imageFile = new File(outputDir, "page-" + (page + 1) + ".png");
//                ImageIO.write(image, "png", imageFile);
//                imageFiles.add(imageFile);
//            }
//        }
//        return imageFiles;
//    }
//}
//
//package com.example.cv_bank.utils;




public class ImageExtractor {

    /**
     * Extracts the first embedded image (likely the profile picture) from the PDF.
     *
     * @param pdfFile   PDF file from which to extract the image.
     * @param outputDir Directory where the image will be saved.
     * @return File of the extracted image, or null if no image is found.
     * @throws IOException if an error occurs during PDF processing.
     */
    public static File extractProfileImage(File pdfFile, String outputDir) throws IOException {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            Iterator<PDPage> pages = document.getPages().iterator();

            while (pages.hasNext()) {
                PDPage page = pages.next();

                PDXObject xObject = StreamSupport.stream(page.getResources().getXObjectNames().spliterator(), false)
                        .map(name -> {
                            try {
                                return page.getResources().getXObject(name);
                            } catch (IOException e) {
                                return null;
                            }
                        })
                        .filter(x -> x instanceof PDImageXObject)
                        .findFirst()
                        .orElse(null);


                if (xObject instanceof PDImageXObject image) {
                    BufferedImage bufferedImage = image.getImage();

                    // Save the image as a file
                    String imageName = "profile-image.png";
                    File outputFile = new File(outputDir, imageName);
                    ImageIO.write(bufferedImage, "png", outputFile);

                    return outputFile; // Return the first image (likely the profile picture)
                }
            }
        }
        return null; // No image found
    }
}

