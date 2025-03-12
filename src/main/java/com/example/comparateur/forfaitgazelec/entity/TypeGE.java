package com.example.comparateur.forfaitgazelec.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;


@Entity
@Table(name ="type_gaz_elect")
public class TypeGE {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Getter
    @Setter

    private UUID id;


    @Getter
    @Setter
    @Column(name = "nom")
    private String nom;

    @Setter
    @Getter
    @Column(name = "discp")
    private String discp;

}


