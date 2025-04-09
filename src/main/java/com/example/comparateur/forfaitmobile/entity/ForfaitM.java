package com.example.comparateur.forfaitmobile.entity;

import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.operateur.entity.Operateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
//@Table(name = "forfait_mobile")
@DiscriminatorValue("forfait Mobiles")
public class ForfaitM extends Forfait {

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
            joinColumns = {@JoinColumn(name = "forfait_Mobile_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_Mobile_id")}
    )
    private List<TypeM> typeM;

    @Override
    public String toString() {
        return "ForfaitM{" +
                "debit=" + debit +
                ", typeDebit='" + typeDebit + '\'' +
                ", prixSIM=" + prixSIM +
                ", heure=" + heure +
                ", with5G=" + with5G +
                ", value=" + value +
                ", isBlocked=" + isBlocked +
                ", operateur=" + operateur +
                ", typeM=" + typeM +
                "} " + super.toString();
    }
}
