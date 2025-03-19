package com.example.comparateur.forfaitgazelec.dto;

import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@Builder
public class TypeGazElecDto {
    private UUID id;
    private String nom;
    private String discp;
    private List<ForfaitE> typeelectricite;
    private List<ForfaitG> typeGaz;

}
