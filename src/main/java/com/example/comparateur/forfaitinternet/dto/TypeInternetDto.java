package com.example.comparateur.forfaitinternet.dto;


import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeInternetDto {
    private UUID id;
    private String nom;
    private String discp;
    private List<ForfaitInternet> forfaitInternet;

}
