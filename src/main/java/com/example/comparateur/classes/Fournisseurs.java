package com.example.comparateur.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "fournisseus")
public class Fournisseurs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

}
