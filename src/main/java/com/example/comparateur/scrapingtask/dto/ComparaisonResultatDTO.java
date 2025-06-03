package com.example.comparateur.scrapingtask.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ComparaisonResultatDTO {
    private List<NewMobileOfferDTO> newMobileOffers;
    private List<NewInternetOfferDTO> newInternetOffers;
    private LocalDateTime timestamp;
    private int totalNewOffers;

}