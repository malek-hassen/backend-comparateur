package com.example.comparateur;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ScheduleJobExecution")
public class ScheduleJobExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sje;

    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    private Integer databaseId;

    @Column
    private Timestamp nextExecution;

    // Getters and Setters
}
