package com.example.comparateur.forfaitmobile.dto;


import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;



@Data
@Builder
public class TypeMobileDTO {

    private UUID typeMid;
    private String nom;
    private String discp;
    private List<ForfaitM> forfaitM;
}
