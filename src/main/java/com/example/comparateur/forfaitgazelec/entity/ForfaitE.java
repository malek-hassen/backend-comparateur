package com.example.comparateur.forfaitgazelec.entity;

import com.example.comparateur.classes.Fournisseurs;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "forfait_E")
public class ForfaitE {
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

    @Column(name = "duree_enge")
    private Double dureeEng;

    @Column(name = "duree_eng_consommation")
    private Double dureeEngConsommation;

    @Column(name = "puissance_compteur")
    private Double puissanceCompteur;

    @Column(name = "duree_forfait")
    private Double dureeForfait;

    @Column(name = "prix_verte")
    private Double prixverte;

    @Column(name = "source")
    private String source;

    @ManyToOne
    @JoinColumn(name = "fournisseurs_id")
    private Fournisseurs fournisseurs;


    @ManyToOne
    @JoinColumn(name = "type_electricite_id")
    private TypeGE typeElectricite;



//    @Setter
//    @Getter
//    @ManyToMany
//    @JoinTable(
//            name = "boxE_type",
//            joinColumns = @JoinColumn(name = "boxE_id"),
//            inverseJoinColumns = @JoinColumn(name = "type_boxE_id")
//    )
//    private List<TypeGE> typeEelect;


}
