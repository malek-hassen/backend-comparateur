package com.example.comparateur.scrapingtask.service;


import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.service.ForfaitInternetService;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
import com.example.comparateur.scrapingtask.dto.ComparaisonResultatDTO;
import com.example.comparateur.scrapingtask.dto.NewInternetOfferDTO;
import com.example.comparateur.scrapingtask.dto.NewMobileOfferDTO;
import com.example.comparateur.scrapingtask.mapper.OfferComparaisonMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ComparaisonService {
    private final ForfaitMobileService mobileService;
    private final ForfaitInternetService internetService;
    private final OfferComparaisonMapper mapper;
    private final ObjectMapper objectMapper;
    private final String JSON_FILE_PATH;


    public ComparaisonService(ForfaitMobileService mobileService,
                                  ForfaitInternetService internetService,
                                  OfferComparaisonMapper mapper,
                                  ObjectMapper objectMapper) {
        this.mobileService = mobileService;
        this.internetService = internetService;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
        this.JSON_FILE_PATH = System.getProperty("user.dir") + "/extracted_offers.json";
    }

    public ComparaisonResultatDTO compareOffersFromJsonFile() throws IOException {
        File jsonFile = new File(JSON_FILE_PATH);
        if (!jsonFile.exists()) {
            throw new IOException("Aucun fichier d'offres trouvé à l'emplacement: " + JSON_FILE_PATH);
        }

        Map<String, Object> jsonData = objectMapper.readValue(jsonFile, new TypeReference<>() {
        });

        // Extraction des données depuis le champ "data"
        Map<String, Object> data = (Map<String, Object>) jsonData.get("data");
        if (data == null) {
            data = jsonData; // Fallback si pas de champ "data"
        }

        List<ForfaitMobileDTO> existingMobileOffers = mobileService.getAllForfaits();
        List<ForfaitInternetDto> existingInternetOffers = internetService.getAllForfaitInternet();

        List<Map<String, Object>> jsonMobileOffers = (List<Map<String, Object>>) data.getOrDefault("mobile_offers", new ArrayList<>());
        List<Map<String, Object>> jsonInternetOffers = (List<Map<String, Object>>) data.getOrDefault("internet_offers", new ArrayList<>());

        ComparaisonResultatDTO result = new ComparaisonResultatDTO();
        result.setNewMobileOffers(filterNewMobileOffers(existingMobileOffers, jsonMobileOffers));
        result.setNewInternetOffers(filterNewInternetOffers(existingInternetOffers, jsonInternetOffers));
        result.setTimestamp(LocalDateTime.now());
        result.setTotalNewOffers(result.getNewMobileOffers().size() + result.getNewInternetOffers().size());

        return result;
    }

    private List<NewMobileOfferDTO> filterNewMobileOffers(List<ForfaitMobileDTO> existingOffers,
                                                          List<Map<String, Object>> jsonOffers) {
        return jsonOffers.stream()
                .map(mapper::mapToNewMobileOfferDTO)
                .filter(dto -> !existsInMobileOffers(existingOffers, dto))
                .collect(Collectors.toList());
    }

    private List<NewInternetOfferDTO> filterNewInternetOffers(List<ForfaitInternetDto> existingOffers,
                                                              List<Map<String, Object>> jsonOffers) {
        return jsonOffers.stream()
                .map(mapper::mapToNewInternetOfferDTO)
                .filter(dto -> !existsInInternetOffers(existingOffers, dto))
                .collect(Collectors.toList());
    }

    private boolean existsInMobileOffers(List<ForfaitMobileDTO> existingOffers, NewMobileOfferDTO newOffer) {
        return existingOffers.stream()
                .anyMatch(existing -> {
                    boolean operatorMatch = mapper.normalizeOperatorName(existing.getNomOperateur())
                            .equalsIgnoreCase(newOffer.getOperateur());
                    boolean priceMatch = Math.abs(existing.getPricebase() - newOffer.getPrix()) < 0.01;
                    boolean dataMatch = existing.getInternet() == newOffer.getDataGo();

                    System.out.printf("Comparing: %s vs %s | operator: %b, price: %b, data: %b%n",
                            existing.getNomOperateur(), newOffer.getOperateur(),
                            operatorMatch, priceMatch, dataMatch);

                    return operatorMatch && priceMatch && dataMatch;
                });
    }

    private boolean existsInInternetOffers(List<ForfaitInternetDto> existingOffers, NewInternetOfferDTO newOffer) {
        return existingOffers.stream()
                .anyMatch(existing ->
                        mapper.normalizeOperatorName(existing.getNomOperateur()).equalsIgnoreCase(newOffer.getOperateur()) &&
                                Math.abs(existing.getPricebase() - newOffer.getPrix()) < 0.01 &&
                                existing.getTechnologie().name().equalsIgnoreCase(newOffer.getTypeConnexion().toUpperCase())
                );
    }



    public void deleteMobileOffer(NewMobileOfferDTO offerToDelete) throws IOException {
        File jsonFile = new File(JSON_FILE_PATH);
        if (!jsonFile.exists()) {
            throw new IOException("Aucun fichier d'offres trouvé");
        }

        Map<String, Object> jsonData = objectMapper.readValue(jsonFile, new TypeReference<>() {});
        Map<String, Object> data = (Map<String, Object>) jsonData.getOrDefault("data", jsonData);

        List<Map<String, Object>> mobileOffers = (List<Map<String, Object>>) data.getOrDefault("mobile_offers", new ArrayList<>());

        // Filtrer l'offre à supprimer
        List<Map<String, Object>> updatedOffers = mobileOffers.stream()
                .filter(offer -> !isSameMobileOffer(offer, offerToDelete))
                .collect(Collectors.toList());

        data.put("mobile_offers", updatedOffers);
        jsonData.put("data", data);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
    }

    public void deleteInternetOffer(NewInternetOfferDTO offerToDelete) throws IOException {
        File jsonFile = new File(JSON_FILE_PATH);
        if (!jsonFile.exists()) {
            throw new IOException("Aucun fichier d'offres trouvé");
        }

        Map<String, Object> jsonData = objectMapper.readValue(jsonFile, new TypeReference<>() {});
        Map<String, Object> data = (Map<String, Object>) jsonData.getOrDefault("data", jsonData);

        List<Map<String, Object>> internetOffers = (List<Map<String, Object>>) data.getOrDefault("internet_offers", new ArrayList<>());

        // Filtrer l'offre à supprimer
        List<Map<String, Object>> updatedOffers = internetOffers.stream()
                .filter(offer -> !isSameInternetOffer(offer, offerToDelete))
                .collect(Collectors.toList());

        data.put("internet_offers", updatedOffers);
        jsonData.put("data", data);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
    }

    private boolean isSameMobileOffer(Map<String, Object> offer, NewMobileOfferDTO offerToDelete) {
        return mapper.normalizeOperatorName((String) offer.get("source_operator")).equalsIgnoreCase(offerToDelete.getOperateur()) &&
                ((double) offer.get("prix")) == offerToDelete.getPrix() &&
                ((int) offer.get("data_go")) == offerToDelete.getDataGo() &&
                ((String) offer.get("nom_offre")).equalsIgnoreCase(offerToDelete.getNomOffre());
    }

    private boolean isSameInternetOffer(Map<String, Object> offer, NewInternetOfferDTO offerToDelete) {
        return mapper.normalizeOperatorName((String) offer.get("source_operator")).equalsIgnoreCase(offerToDelete.getOperateur()) &&
                ((double) offer.get("prix")) == offerToDelete.getPrix() &&
                ((String) offer.get("type_connexion")).equalsIgnoreCase(offerToDelete.getTypeConnexion()) &&
                ((String) offer.get("nom_offre")).equalsIgnoreCase(offerToDelete.getNomOffre());
    }
}