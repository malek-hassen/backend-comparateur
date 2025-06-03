package com.example.comparateur.fournisseurs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDto {

    private UUID id;

    private String nom;

    private String type;
    private String url;

}
