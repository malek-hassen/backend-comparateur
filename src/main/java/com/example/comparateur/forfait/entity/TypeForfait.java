package com.example.comparateur.forfait.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "type_forfait")
public class TypeForfait {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name="type")
    private String type;

    @Column(name = "nom")
    private String nom;


    @Column(name = "discp")
    private String discp;


    @ManyToMany(mappedBy = "typeBox")
    private List<Forfait> forfait;

    @Override
    public String toString() {
        return "TypeInternet{" + "id=" + id
                + ", type=" + type
                + ", nom=" + nom
                + ", discp=" + discp
                + ", forfait=" + forfait;
    }

}

