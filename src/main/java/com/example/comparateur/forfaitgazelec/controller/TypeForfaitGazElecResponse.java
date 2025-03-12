package com.example.comparateur.forfaitgazelec.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class TypeForfaitGazElecResponse {
    private UUID id;
    private String nom;
}
