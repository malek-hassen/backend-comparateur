package com.example.comparateur.scrapingtask.controller;


import com.example.comparateur.scrapingtask.dto.ComparaisonResultatDTO;
import com.example.comparateur.scrapingtask.dto.NewInternetOfferDTO;
import com.example.comparateur.scrapingtask.dto.NewMobileOfferDTO;
import com.example.comparateur.scrapingtask.service.ComparaisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/offers")
public class ComparaisonController {
    private static final String JSON_FILE_PATH = "exracted_offers.json";
    private final ComparaisonService comparaisonService;

    public ComparaisonController(ComparaisonService comparaisonService) {
        this.comparaisonService = comparaisonService;
    }


    @GetMapping("/compare")
    public ResponseEntity<Map<String, Object>> compareOffers() {
        Map<String, Object> response = new HashMap<>();

        try {
            ComparaisonResultatDTO result = comparaisonService.compareOffersFromJsonFile();
            response.put("status", "success");
            response.put("data", result);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping("/mobile-offers/delete")
    public ResponseEntity<Map<String, Object>> deleteMobileOffer(@RequestBody NewMobileOfferDTO offer) {
        Map<String, Object> response = new HashMap<>();

        try {
            comparaisonService.deleteMobileOffer(offer);
            response.put("status", "success");
            response.put("message", "Offre mobile supprimée avec succès");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping("/internet-offers/delete")
    public ResponseEntity<Map<String, Object>> deleteInternetOffer(@RequestBody NewInternetOfferDTO offer) {
        Map<String, Object> response = new HashMap<>();

        try {
            comparaisonService.deleteInternetOffer(offer);
            response.put("status", "success");
            response.put("message", "Offre internet supprimée avec succès");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

}