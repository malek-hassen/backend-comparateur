package com.example.comparateur.forfaitgazelec.mapper;

import com.example.comparateur.forfaitgazelec.controller.ForfaitElecResponse;
import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import org.springframework.stereotype.Component;


@Component
public class ForfaitElectriciteMapper {

    public ForfaitE toEntity(ForfaitElectriciteDto forfaitElectriciteDto) {
        ForfaitE forfaitE = new ForfaitE();
        forfaitE.setAbnMensuel(forfaitElectriciteDto.getAbnMensuel());
        forfaitE.setDureeConsommation(forfaitElectriciteDto.getDureeConsommation());
        forfaitE.setPrixverte(forfaitElectriciteDto.getPrixverte());
        forfaitE.setPrixwattindexe(forfaitElectriciteDto.getPrixwattindexe());
        forfaitE.setSource(forfaitElectriciteDto.getSource());
        forfaitE.setTypeElectricite(forfaitElectriciteDto.getTypeElectricite());
        forfaitE.setPuissanceCompteur(forfaitElectriciteDto.getPuissanceCompteur());
        forfaitE.setFournisseurs(forfaitElectriciteDto.getFournisseurs());
        return forfaitE;
    }
    public ForfaitElectriciteDto toDTO(ForfaitE forfaitE){
        return ForfaitElectriciteDto.builder()
                .fournisseurs(forfaitE.getFournisseurs())
                .abnMensuel(forfaitE.getAbnMensuel())
                .dureeConsommation(forfaitE.getDureeConsommation())
                .prixverte(forfaitE.getPrixverte())
                .puissanceCompteur(forfaitE.getPuissanceCompteur())
                .prixwattindexe(forfaitE.getPrixwattindexe())
                .source(forfaitE.getSource())
                .typeElectricite(forfaitE.getTypeElectricite())
                .build();

    }
    public ForfaitElecResponse toResponse(ForfaitE forfaitE) {
        return ForfaitElecResponse.builder()
                .Id(forfaitE.getId())
                .build();
    }

}
