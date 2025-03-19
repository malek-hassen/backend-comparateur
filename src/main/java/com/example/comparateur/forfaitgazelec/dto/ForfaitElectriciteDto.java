package com.example.comparateur.forfaitgazelec.dto;


import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ForfaitElectriciteDto {
    private UUID id;
    private Double abnMensuel;
    private Double prixwattindexe;
    private Double dureeConsommation;
    private Double puissanceCompteur;
    private Double prixverte;
    private String source;
    private Fournisseurs fournisseurs;
    private List<TypeGE> typeElectricite;

}
