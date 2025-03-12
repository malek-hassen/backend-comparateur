package com.example.comparateur.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "scraping_task")
public class ScrapingTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID id;

    @Column(name = "url_source")
    private String urlSource;

    @Column(name = "date_execution")
    private Date dateExecution;

    @Column(name = "statut")
    private String statut;

}
