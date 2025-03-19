package com.example.comparateur.forfaitinternet.dto;


import com.example.comparateur.operateur.entity.Operateur;
import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import com.example.comparateur.forfaitinternet.enumtech.Technologie;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ForfaitInternetDto {
    private UUID id;
    private Integer debit;
    private boolean withmobile;
    private Integer vitesse;
    private Integer nbrheure;
    private boolean withTV;
    private Integer nbchaine;
    @Enumerated(EnumType.STRING)
    private Technologie technologie;
    private Operateur operateur;
    private List<TypeInternet> typeBox;
}
