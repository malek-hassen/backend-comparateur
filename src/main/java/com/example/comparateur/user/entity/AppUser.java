package com.example.comparateur.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String favori;

    private String lieuHabitation;

    private Double consommation;

}
