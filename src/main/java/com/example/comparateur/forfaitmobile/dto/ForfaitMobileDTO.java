package com.example.comparateur.forfaitmobile.dto;


import com.example.comparateur.forfaitmobile.entity.TypeM;
import com.example.comparateur.operateur.entity.Operateur;
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
public class ForfaitMobileDTO {
    private UUID id;
    private Integer debit;
    private Double prixSIM;
    private Integer heure;
    private boolean with5G;
    private Double value;
    private boolean isBlocked;
    private Operateur operateur;
    private List<TypeM> typeBoxM;


}
