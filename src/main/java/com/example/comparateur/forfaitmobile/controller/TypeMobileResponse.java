package com.example.comparateur.forfaitmobile.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class TypeMobileResponse {
    private UUID typeMid;
    private String nom;
}
