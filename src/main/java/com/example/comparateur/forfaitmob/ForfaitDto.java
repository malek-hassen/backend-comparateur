package com.example.comparateur.forfaitmob;


import lombok.Data;

import java.util.UUID;

@Data
public class ForfaitDto {
    private UUID id;
    private String titre;
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
}
