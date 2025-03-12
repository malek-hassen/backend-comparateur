package com.example.comparateur.forfaitinternet.dto;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class TypeInternetDto {
    private UUID id;
    private String nom;
    private String discp;

}
