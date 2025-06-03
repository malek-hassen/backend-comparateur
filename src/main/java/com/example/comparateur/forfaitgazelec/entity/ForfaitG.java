package com.example.comparateur.forfaitgazelec.entity;


import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
//@Table(name = "forfait_G")
@DiscriminatorValue("forfait Gaz")
public class ForfaitG extends Forfait {




    private Double abnMensuel;

    private Double prixwattindexe;



    private Double dureeConsommation;

    private Double puissanceCompteur;



    private Double prixverte;

    private String origin;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseurs fournisseurs;


    @ManyToMany
    @JoinTable(
            name = "type_forfaitg",
            joinColumns = @JoinColumn(name = "forfait_gaz_id"),
            inverseJoinColumns = @JoinColumn(name = "type_ge_id")
    )
    private List<TypeForfait> typeGaz;
    @Override
    public String toString() {
        return "ForfaitG{"
                + ", abnMensuel=" + abnMensuel
                + ", prixwattindexe=" + prixwattindexe
                + ", dureeEngConsommation=" + dureeConsommation
                + ", puissanceCompteur=" + puissanceCompteur
                + ", prixverte=" + prixverte
                + ", origin='" + origin + '\''
                + ", fournisseurs=" + fournisseurs
                + ", typeGaz=" + typeGaz;
    }

}
