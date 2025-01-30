package com.example.CVsearch.CVParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class MistralCVParser{
    @Autowired
    private RestTemplate restTemplate;
    private String apiKey = "PS26yTgqhcz2CKqwcwWtrCuq9iB7jh7Q";

    private static final String BASE_URL = "https://api.mistral.ai/v1/agents/completions";

    public String parseCV(String cvText) {
        String agentId = "ag:c2928aea:20250116:untitled-agent:11cdedb3"; // Replace with your new agent ID

        // Set up the request payload
        String requestBody = """
                {
                    "agent_id": "%s",
                    "messages": [{"role": "user", "content": "%s"}]
                }
                """.formatted(agentId, cvText);

        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + apiKey);

        // Create the HTTP entity with headers and payload
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Make the API call
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL, entity, String.class);

        String jsonResponse;

        if (response.getStatusCode() == HttpStatus.OK) {
            jsonResponse = response.getBody();
        } else {
            throw new RuntimeException("Failed to call Mistral API: " + response.getStatusCode());
        }

        try {
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode contentNode = rootNode.path("choices").get(0).path("message").path("content");
            return contentNode.asText();
        } catch (JsonMappingException e) {
            throw new RuntimeException("Error mapping JSON response", e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }
    }
}

