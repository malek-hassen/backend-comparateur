package com.example.comparateur.forfait.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForfaitDto {
    private UUID id;
    private String dtype;
    private String title;
    private String description;
    private String lien;
    private String resume;
    private Double pricebase;
    private Double priceoffre;
    private Double periodoffre;
    private boolean iswitheng;
    private Double dureeofeng;
    private boolean visibilite;
}
