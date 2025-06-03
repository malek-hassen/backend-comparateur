package com.example.comparateur.scrapingtask.mapper;


import com.example.comparateur.scrapingtask.dto.NewInternetOfferDTO;
import com.example.comparateur.scrapingtask.dto.NewMobileOfferDTO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OfferComparaisonMapper {

    public NewMobileOfferDTO mapToNewMobileOfferDTO(Map<String, Object> jsonOffer) {
        NewMobileOfferDTO dto = new NewMobileOfferDTO();
        dto.setNomOffre((String) jsonOffer.get("nom_offre"));
        dto.setPrix((double) jsonOffer.get("prix"));
        dto.setDataGo((int) jsonOffer.get("data_go"));
        dto.setOperateur(normalizeOperatorName((String) jsonOffer.get("source_operator")));
        dto.setLienOffre((String) jsonOffer.get("lien_offre"));
        return dto;
    }

    public NewInternetOfferDTO mapToNewInternetOfferDTO(Map<String, Object> jsonOffer) {
        NewInternetOfferDTO dto = new NewInternetOfferDTO();
        dto.setNomOffre((String) jsonOffer.get("nom_offre"));
        dto.setPrix((double) jsonOffer.get("prix"));
        dto.setTypeConnexion((String) jsonOffer.get("type_connexion"));
        dto.setOperateur(normalizeOperatorName((String) jsonOffer.get("source_operator")));
        dto.setLienOffre((String) jsonOffer.get("lien_offre"));
        return dto;
    }

    public String normalizeOperatorName(String operatorName) {
        if (operatorName == null) return "";
        return operatorName.trim()
                .replace("RED by ", "")
                .replace(" by SFR", "")
                .replace("Telecom", "")
                .replace("SFR", "sfr")
                .replace("Bouygues", "Bouygues Telecom")
                .replace("Nordnet", "nordnet")
                .toLowerCase();
    }
}