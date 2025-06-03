package com.example.comparateur.forfait.dto;

import com.example.comparateur.forfait.entity.Forfait;
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
public class TypeForfaitDTO {
    private UUID id;
    private String type;
    private String nom;
    private String discp;
    private List<Forfait> forfait;
}
