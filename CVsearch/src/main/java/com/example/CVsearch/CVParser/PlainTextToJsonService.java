package com.example.CVsearch.CVParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlainTextToJsonService {

    public String convertCVToJson(String cvText) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a simple map to represent the structure
        Map<String, String> cvMap = new HashMap<>();
        cvMap.put("cv_text", cvText);

        // Convert the map to JSON
        return objectMapper.writeValueAsString(cvMap);
    }
}
