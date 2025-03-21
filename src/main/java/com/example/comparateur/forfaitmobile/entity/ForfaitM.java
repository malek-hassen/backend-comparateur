package com.example.comparateur.forfaitmobile.entity;

import com.example.comparateur.Forfait;
import com.example.comparateur.operateur.entity.Operateur;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;



@Setter
@Getter

@Entity
//@Table(name = "forfait_mobile")
public class ForfaitM  extends Forfait {

    private Integer debit;

    private String typeDebit;


    private Double prixSIM;
    @Column(name = "heure")
    private Integer heure;

    private boolean with5G;

    private Double value;

    private Boolean isBlocked;


    @ManyToOne
    @JoinColumn(name = "operateur_id")
    private Operateur operateur;


    @ManyToMany
    @JoinTable(
            name = "Type_forfaitM",
            joinColumns = { @JoinColumn(name = "forfait_Mobile_id") },
            inverseJoinColumns = { @JoinColumn(name = "type_Mobile_id") }
    )
    private List<TypeM> typeM;


 public String toString() {

     return "forfait mobile: "
             + ", debit=" + debit
             + ", typeDebit='" + typeDebit + '\''
             + ", prixSIM=" + prixSIM
             + ", nbHeure=" + heure
             + ", with5G=" + with5G
             + ", value=" + value
             + ", isBlocked=" + isBlocked
             + ", operateur=" + operateur
             + " , typeforfait=" + typeM;
 }



}
