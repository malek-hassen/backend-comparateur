package com.example.comparateur.forfaitmobile.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Data
@Builder
public class TypeMobileDTO {

    private UUID typeMid;
    private String nom;
    private String discp;
}
