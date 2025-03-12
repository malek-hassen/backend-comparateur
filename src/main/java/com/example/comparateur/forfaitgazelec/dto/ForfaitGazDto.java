package com.example.comparateur.forfaitgazelec.dto;

import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.classes.Fournisseurs;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class ForfaitGazDto {
    private UUID id;
    private String titre;
    private boolean visibilite;
    private Double prixwattfixe;
    private Double abnMensuel;
    private Double prixwattindexe;
    private boolean iseng;
    private Double dureeEng;
    private Double dureeEngConsommation;
    private Double puissanceCompteur;
    private Double dureeForfait;
    private Double prixverte;
    private String origin;
    private Fournisseurs fournisseurs;
    private TypeGE typeGaz;
}
