package com.example.comparateur.forfaitinternet.entity;
import com.example.comparateur.forfaitinternet.enumtech.Technologie;
import com.example.comparateur.Operateur.Operateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "forfait_internet")
public class ForfaitInternet {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        private UUID id;

        @Column(name = "titre")
        private String titre;


        @Column(name= "visibilité")
        private boolean visibilite;


        @Column(name= "prix_offre")
        private Integer prixOffre;

        @Column(name= "periode_offre")
        private Integer periodeOffre;

        @Column(name= "prix_base")
        private Double prixBase;

        @Column(name= "debit")
        private Integer debit;


        @Column(name= "is_with_eng")
        private boolean iswitheng;


        @Column(name= "durée_eng")
        private Integer dureeeng;


        @Column(name= "with_mobile")
        private boolean withmobile;

        @Column(name= "vitesse")
        private Integer vitesse;

        @Column(name= "nb_heure")
        private Integer nbheure;

        @Column(name= "with_TV")
        private boolean withTV;


        @Column(name= "nb_chaine")
        private Integer nbchaine;



        @Column(name= "lien_externe")
        @NotBlank(message = "Lien externe is required")
        @Pattern(
                regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
                message = "Invalid URL format"
        )
        private String lienExterne;

        @Column(name= "resume")
        private String resume;

        @Column(name= "description")
        private String description;


        @Column(name= "Technologie")
        @Enumerated(EnumType.STRING)
        private Technologie technologie;


        @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
        @JoinColumn(name = "operateur_id")
        private Operateur operateur;




        @ManyToMany
        @JoinTable(name = "type_Internet")
        private List<TypeInternet> typeBox;


}


