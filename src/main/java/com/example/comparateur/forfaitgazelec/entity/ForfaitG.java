package com.example.comparateur.forfaitgazelec.entity;

import com.example.comparateur.classes.Fournisseurs;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@Table(name = "forfait_G")
public class ForfaitG {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;


    @Column(name = "titre")
    private String titre;

    @Column(name = "visibilite")
    private boolean visibilite;

    @Column(name = "prix_watt_fixe")
    private Double prixwattfixe;

    @Column(name = "abn_mensuel")
    private Double abnMensuel;

    @Column(name = "prix_watt_indexe")
    private Double prixwattindexe;

    @Column(name = "is_eng")
    private boolean iseng;

    @Column(name = "duree_eng")
    private Double dureeEng;

    @Column(name = "duree_eng_consommation")
    private Double dureeEngConsommation;

    @Column(name = "puissance_compteur")
    private Double puissanceCompteur;

    @Column(name = "duree_forfait")
    private Double dureeForfait;

    @Column(name = "prix_verte")
    private Double prixverte;

    @Column(name = "origin")
    private String origin;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseurs fournisseurs;

    @ManyToOne
    @JoinColumn(name = "type_gaz_id")
    private TypeGE typeGaz;

//    @Setter
//    @Getter
//    @ManyToMany
//    @JoinTable(
//            name = "box_type",
//            joinColumns = @JoinColumn(name = "box_id"),
//            inverseJoinColumns = @JoinColumn(name = "type_box_id")
//    )
//        private List<TypeGE> typeGaz;

}
