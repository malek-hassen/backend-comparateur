package com.example.comparateur.avis.entity;



import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "avis")
public class Avis {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "note")
    private Integer note;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "forfaitI_id")
    private ForfaitInternet forfaitI;

    @ManyToOne
    @JoinColumn(name = "forfaitM_id")
    private ForfaitM forfaitM;

    @ManyToOne
    @JoinColumn(name = "forfaitG_id")
    private ForfaitG forfaitG;

    @ManyToOne
    @JoinColumn(name = "forfaitE_id")
    private ForfaitE forfaitE;


}
