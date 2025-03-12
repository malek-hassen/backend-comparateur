package com.example.comparateur.forfaitinternet.dto;


import com.example.comparateur.Operateur.Operateur;
import com.example.comparateur.forfaitinternet.entity.TypeInternet;
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
    private String titre;
    private boolean visibilite;
    private Integer prixOffre;
    private Integer periodeOffre;
    private Double prixBase;
    private Integer debit;
    private boolean iswitheng;
    private Integer dureeeng;
    private boolean withmobile;
    private Integer vitesse;
    private Integer nbheure;
    private boolean withTV;
    private Integer nbchaine;
    private String lienExterne;
    private String resume;
    private String description;
    @Enumerated(EnumType.STRING)
    private Technologie technologie;
    private Operateur operateur;
    private List<TypeInternet> typeBox;
}
