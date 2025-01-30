package com.example.CVsearch.CVParser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CVParserConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
