package com.example.comparateur;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class FlaskClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String flaskUrl = "http://localhost:5000/api/data";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonPayload = "{\"message\": \"Hello from Spring Boot!\"}";

        HttpEntity<String> request = new HttpEntity<>(jsonPayload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, request, String.class);

        System.out.println("Response from Flask: " + response.getBody());
    }
}
