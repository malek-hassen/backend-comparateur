package com.example.comparateur.forfait.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "forfait")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Forfait {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String dtype;
    private String title;
    private String description;
    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Invalid URL format"
    )
    private String lien;
    private String resume;
    private Double pricebase;
    private Double priceoffre;
    private Double periodoffre;
    @Column(nullable = false)
    private boolean iswitheng;
    private Double dureeofeng;
    private boolean visibilite;
}
