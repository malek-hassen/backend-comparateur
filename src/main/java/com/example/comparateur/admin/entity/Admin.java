package com.example.comparateur.admin.entity;

import com.example.comparateur.avis.entity.Avis;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private UUID id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;


    @ManyToOne
    @JoinColumn(name = "avis")
    private Avis avis;
}
