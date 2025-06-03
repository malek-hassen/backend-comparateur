
package com.example.comparateur.scrapingtask.controller;

import com.example.comparateur.forfaitinternet.service.ForfaitInternetService;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
import com.example.comparateur.operateur.dto.OperateurDTO;
import com.example.comparateur.operateur.entity.Operateur;
import com.example.comparateur.operateur.service.OperateurService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ExtractedOfferController {
    private final String FLASK_URL = "http://localhost:5000";
    private final OperateurService operatorService;



    public ExtractedOfferController(OperateurService operatorService,
                                          ForfaitMobileService forfaitMobileService,
                                          ForfaitInternetService forfaitInternetService) {
        this.operatorService = operatorService;

    }

    @PostMapping("/extracted-offers")
    public ResponseEntity<String> receiveJson(@RequestBody Map<String, Object> payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("extracted_offers.json");

            // Extraire seulement la partie "data" du payload si elle existe
            Object dataToSave = payload.containsKey("data") ? payload.get("data") : payload;

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, dataToSave);

            return ResponseEntity.ok("Données extraites enregistrées avec succès dans extracted_offers.json");
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body("Erreur lors de l'enregistrement: " + e.getMessage());
        }
    }

    @PostMapping("/trigger-flask-scraping")
    public ResponseEntity<String> triggerFlaskScraping() {
        try {
            // 1. Récupérer la liste des opérateurs avec URLs complètes
            List<Operateur> operators = operatorService.getAllOperateurs();

            if (operators.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Aucun opérateur trouvé en base de données");
            }

            // 2. Préparer les données à envoyer à Flask
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("operators", operators.stream()
                    .map(op -> Map.of(
                            "operateurName", op.getNom(),
                            "urlDuSite", completeUrl(op.getUrl())
                    ))
                    .collect(Collectors.toList()));
            requestBody.put("timestamp", LocalDateTime.now().toString());
            requestBody.put("source", "spring-boot-trigger");

            // 3. Envoyer la requête à Flask
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
            String flaskScrapingUrl = FLASK_URL + "/scrape";

            ResponseEntity<String> response = restTemplate.postForEntity(
                    flaskScrapingUrl,
                    requestEntity,
                    String.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("Scraping déclenché avec succès pour " + operators.size() + " opérateurs");
            } else {
                return ResponseEntity.status(response.getStatusCode())
                        .body("Erreur lors du déclenchement du scraping: " + response.getBody());
            }

        } catch (ResourceAccessException e) {
            return ResponseEntity.status(503)
                    .body("Service Flask indisponible: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Erreur de communication avec le service Flask: " + e.getMessage());
        }
    }

    private String completeUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return "";
        }
        return url.startsWith("http") ? url : "https://" + url;
    }

    @GetMapping("/scraping/status")
    public ResponseEntity<Map<String, Object>> getScrapingStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("flask_service_url", FLASK_URL + "/scrape");
        status.put("operators_count", operatorService.getAllOperateurs().size());
        status.put("timestamp", LocalDateTime.now().toString());

        return ResponseEntity.ok(status);
    }






}