package com.example.comparateur.avis.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "avis")
public class Avis {
    @Id
    @GeneratedValue(generator = "UUID")

    private UUID id;


    private String commentaire;


    private Integer note;


    private Date date;
//
//    @ManyToOne
//    @JoinColumn(name = "forfaitI_id")
//    private ForfaitInternet forfaitI;
//
//    @ManyToOne
//    @JoinColumn(name = "forfaitM_id")
//    private ForfaitM forfaitM;
//
//    @ManyToOne
//    @JoinColumn(name = "forfaitG_id")
//    private ForfaitG forfaitG;
//
//    @ManyToOne
//    @JoinColumn(name = "forfaitE_id")
//    private ForfaitE forfaitE;


}
