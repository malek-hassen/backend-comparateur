package com.example.comparateur.scrapingtask;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "scraping_task")
public class ScrapingTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String urlSource;

    private Date dateExecution;

    private String statut;

}
