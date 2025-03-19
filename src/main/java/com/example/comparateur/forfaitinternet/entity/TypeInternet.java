package com.example.comparateur.forfaitinternet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "type_internet")
public class TypeInternet {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private UUID id;

    @Column(name = "nom")
    private String nom;


    @Column(name = "discp")
    private String discp;


    @ManyToMany(mappedBy = "typeBox")
    private List<ForfaitInternet> forfaitInternet;

    @Override
    public String toString() {
        return "TypeInternet{" + "id=" + id
                + ", nom=" + nom
                + ", discp=" + discp
                + ", forfaitInternet=" + forfaitInternet;
    }

}
