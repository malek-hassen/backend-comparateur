package com.example.comparateur.forfaitgazelec.dto;


import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@Builder
public class ForfaitGazDto {
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
    private boolean visibilite;
    private Double abnMensuel;
    private Double prixwattindexe;
    private Double dureeConsommation;
    private Double puissanceCompteur;
    private Double prixverte;
    private String origin;
    private Fournisseurs fournisseurs;
    private List<TypeForfait> typeGaz;
}
