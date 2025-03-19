package com.example.comparateur.fournisseurs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "fournisseus")
public class Fournisseurs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String nom;

    private String type;

}
