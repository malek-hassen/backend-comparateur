package com.example.comparateur.forfaitgazelec.entity;

import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "forfait_E")
public class ForfaitE  extends Forfait {


    private Double abnMensuel;

    private Double prixwattindexe;
    private Double dureeConsommation;

    private Double puissanceCompteur;


    private Double prixverte;

    private String source;


    @ManyToOne
    @JoinColumn(name = "fournisseurs_id")
    private Fournisseurs fournisseurs;



    @ManyToMany
    @JoinTable(
            name = "Type_forfaitE",
            joinColumns = { @JoinColumn(name = "forfait_E_id") },
            inverseJoinColumns = { @JoinColumn(name = "type_GE_id") }
    )
    private List<TypeGE> typeElectricite;

    @Override
    public String toString() {
        return "ForfaitElectricite{"
                + ", abnMensuel=" + abnMensuel
                + ", prixwattindexe=" + prixwattindexe
                + ", dureeEngConsommation=" + dureeConsommation
                + ", puissanceCompteur=" + puissanceCompteur
                + ", prixverte=" + prixverte
                + ", source='" + source + '\''
                + ", fournisseurs=" + fournisseurs
                + ", typeElectricite=" + typeElectricite;
    }

}
