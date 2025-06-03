package com.example.comparateur.scrapingtask.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewInternetOfferDTO {
    private String nomOffre;
    private double prix;
    private String typeConnexion;
    private String operateur;
    @JsonProperty("lien_offre")
    private String lienOffre;


}