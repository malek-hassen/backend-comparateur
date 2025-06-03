package com.example.comparateur.forfaitmobile.dto;


import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.operateur.entity.Operateur;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForfaitMobileDTO {
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
    private Integer debit;
    private String typeDebit;
    private Double prixSIM;
    private Integer heure;
    private boolean with5G;
    private Double value;
    private boolean isBlocked;
    private int internet;
    private String NomOperateur;
    private String urlOperateur;
    private Operateur operateur;
    private List<TypeForfait> typeBoxM;



}
