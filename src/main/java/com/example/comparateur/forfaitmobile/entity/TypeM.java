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

    @Column(name = "type_mid")
    private UUID typeMid;



    @Column(name = "nom")
    private String nom;


    @Column(name = "discp")
    private String discp;

    @ManyToMany(mappedBy = "typeM")
    private List<ForfaitM> forfaitMobiles;

    @Override
    public String toString() {
        return "TypeMobile{" + "id=" + typeMid
                + ", nom=" + nom
                + ", discp=" + discp
                + ", forfaitMobile=" + forfaitMobiles;
    }


}


