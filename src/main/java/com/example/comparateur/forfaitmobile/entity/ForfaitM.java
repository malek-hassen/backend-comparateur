package com.example.comparateur.forfaitmobile.entity;

import com.example.comparateur.Operateur.Operateur;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forfait_mobile")
public class ForfaitM  implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Version
    @Builder.Default
    @Column(name = "version")
    private Integer version =0;

    @Column(name = "titre")
    private String titre;

    @Column(name = "prix_offre")
    private Double prixOffre;

    @Column(name = "visibilite")
    private boolean visibilite;

    @Column(name = "periode_offre")
    private Double periodeOffre;

    @Column(name = "debit")
    private Integer debit;

    @Column(name = "type_debit")
    private String typeDebit;

    @Column(name = "prix_base")
    private Double prixBase;

    @Column(name = "is_eng")
    private boolean iseng;

    @Column(name = "duree_eng")
    private Integer dureeEng;

    @Column(name = "lien")
    private String lien;

    @Column(name = "description")
    private String description;

    @Column(name = "resumer")
    private String resumer;

    @Column(name = "prix_SIM")
    private Double prixSIM;

    @Column(name = "nb_heure")
    private Integer nbHeure;

    @Column(name = "with_5G")
    private boolean with5G;

    @Column(name = "value")
    private Double value;

    @Column(name = "is_blocked")
    private Boolean isBlocked;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "operateur_id")
    private  Operateur operateur;


    @ManyToMany(mappedBy = "forfaitMobiles")
    private List<TypeM> typeBoxM;

}
