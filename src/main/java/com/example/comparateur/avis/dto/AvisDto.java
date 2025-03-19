package com.example.comparateur.avis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvisDto {
    private UUID id;


    private String commentaire;


    private Integer note;


    private Date date;
}
