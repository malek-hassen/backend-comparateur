package com.example.comparateur.forfaitgazelec.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class TypeGazElecDto {
    private UUID id;
    private String nom;
    private String discp;


}
