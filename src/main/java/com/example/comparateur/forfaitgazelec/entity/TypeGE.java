package com.example.comparateur.forfaitgazelec.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name ="type_gaz_elect")
public class TypeGE {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nom;
    private String discp;

    @ManyToMany(mappedBy = "typeElectricite")
    private List<ForfaitE> typeelectricite;

    @ManyToMany(mappedBy = "typeGaz")
    private List<ForfaitG> typeGaz;
    @Override
    public String toString() {
         return "TypeGazElectrivite{"
                + "id=" + id
                 + ", nom='" + nom + '\''
                 + ", discp='" + discp + '\''
                 + ", typeelectricite=" + typeelectricite
                 + ", typeGaz=" + typeGaz;
    }





}


