package com.example.comparateur.forfaitinternet.entity;
import com.example.comparateur.Forfait;
import com.example.comparateur.forfaitinternet.enumtech.Technologie;
import com.example.comparateur.operateur.entity.Operateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "forfait_internet")
public class ForfaitInternet extends Forfait {


        private Integer debit;
        private boolean withmobile;
        private Integer vitesse;
        private Integer nbr_Heure;
        private boolean withTV;
        private Integer nbchaine;
        @Enumerated(EnumType.STRING)
        private Technologie technologie;


        @ManyToOne
        @JoinColumn(name = "operateur_id")
        private Operateur operateur;




        @ManyToMany
        @JoinTable(
                name = "Type_forfaitI",
                joinColumns = { @JoinColumn(name = "forfait_internet_id") },
                inverseJoinColumns = { @JoinColumn(name = "type_internet_id") }
        )
        private List<TypeInternet> typeBox;

        @Override
        public String toString() {
                return "ForfaitInternet{"
                        + ", debit=" + debit
                        + ", withmobile=" + withmobile
                        + ", vitesse=" + vitesse
                        + ", nbheure=" + nbr_Heure
                        + ", withTV=" + withTV
                        + ", nbchaine=" + nbchaine
                        + ", technologies=" + technologie
                        + ", operateur=" + operateur
                        + ", typeBox=" + typeBox;
        }


}


