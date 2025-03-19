package com.example.comparateur.forfaitmob;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="forfait")
public class ForfaitMobile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titre;
    private Double prixOffre;
    private boolean visibilite;
    private Double periodeOffre;
    private Integer debit;
    private String typeDebit;
    private Double prixBase;
    private boolean iseng;
    private Integer dureeEng;
    private String lien;
    private String description;
    private String resumer;
    private Double prixSIM;
    private Integer nbHeure;
    private boolean with5G;
    private Double value;
    private boolean isBlocked;
    @Override
    public String toString() {

        return "forfait mobile: "
                + "id=" + id
                + ", titre='" + titre + '\''
                + ", prixOffre=" + prixOffre
                + ", visibilite=" + visibilite
                + ", periodeOffre=" + periodeOffre
                + ", debit=" + debit
                + ", typeDebit='" + typeDebit + '\''
                + ", prixBase=" + prixBase
                + ", iseng=" + iseng
                + ", dureeEng=" + dureeEng
                + ", lien='" + lien + '\''
                + ", description='" + description + '\''
                + ", resumer='" + resumer + '\''
                + ", prixSIM=" + prixSIM
                + ", nbHeure=" + nbHeure
                + ", with5G=" + with5G
                + ", value=" + value
                + ", isBlocked=" + isBlocked;
    }


}
