package com.example.comparateur.forfaitinternet.dto;


import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.operateur.entity.Operateur;
import com.example.comparateur.forfaitinternet.enumtech.Technologie;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ForfaitInternetDto {
    private UUID id;
    private String title;
    private String description;
    private String lien;
    private String resume;
    private Double pricebase;
    private Double priceoffre;
    private Double periodoffre;
    private boolean iswitheng;
    private Double dureeofeng;
    private String NomOperateur;
    private boolean visibilite;
    private Integer debit;
    private boolean withmobile;
    private Integer vitesse;
    private Integer nbrheure;
    private boolean withTV;
    private Integer nbchaine;
    @Enumerated(EnumType.STRING)
    private Technologie technologie;
    private Operateur operateur;
    private List<TypeForfait> typeBox;
}
