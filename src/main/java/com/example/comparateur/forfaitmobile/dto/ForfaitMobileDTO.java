package com.example.comparateur.forfaitmobile.dto;

import com.example.comparateur.forfaitmobile.entity.TypeM;
import com.example.comparateur.Operateur.Operateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ForfaitMobileDTO {

    private UUID id;
    private String titre;
    private Integer version;
    private Double prixOffre;
    private boolean visibilite;
    private Double periodeOffre;
    private Integer debit;
    private String typeDebit;
    private Double prixBase;
    private boolean iseng;
    private Integer dureeEng;
    private String lien;
    private String description;
    private String resumer;
    private Double prixSIM;
    private Integer nbHeure;
    private boolean with5G;
    private Double value;
    private boolean isBlocked;
    private Operateur operateur;
    private List<TypeM> typeBoxM;


}
