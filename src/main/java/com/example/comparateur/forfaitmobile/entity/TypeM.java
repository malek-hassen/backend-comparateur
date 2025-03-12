package com.example.comparateur.forfaitmobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name= "type_mobile")
public class TypeM {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "type_mid")
    private UUID typeMid;



    @Column(name = "nom")
    private String nom;


    @Column(name = "discp")
    private String discp;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "box_type",
            joinColumns = @JoinColumn(name = "id"), // Referencing the `id` column from the `ForfaitM` entity
            inverseJoinColumns = @JoinColumn(name = "typeMid") // Referencing the `typeMid` column from the `TypeM` entity
    )
    private List<ForfaitM> forfaitMobiles;


}


