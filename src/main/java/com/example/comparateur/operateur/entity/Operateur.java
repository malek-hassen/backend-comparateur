package com.example.comparateur.operateur.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "operateur")
public class Operateur {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    @Column(name = "nom")
    private String nom;



}
