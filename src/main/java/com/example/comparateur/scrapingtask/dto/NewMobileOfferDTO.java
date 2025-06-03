package com.example.comparateur.scrapingtask.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewMobileOfferDTO {
    private String nomOffre;
    private double prix;
    private int dataGo;
    private String operateur;
    @JsonProperty("lien_offre")
    private String lienOffre;;


}