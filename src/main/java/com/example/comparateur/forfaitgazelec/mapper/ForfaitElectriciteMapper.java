package com.example.comparateur.forfaitgazelec.mapper;

import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfaitgazelec.controller.ForfaitElecResponse;
import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class ForfaitElectriciteMapper {

    public ForfaitE toEntity(Forfait forfait, ForfaitElectriciteDto forfaitElectriciteDto) {
        if (forfaitElectriciteDto == null) {
            return null;
        }
        ForfaitE forfaitE = new ForfaitE();

        // Set inherited attributes
        BeanUtils.copyProperties(forfait, forfaitE);

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
                .id(forfaitE.getId())
                .title(forfaitE.getTitle())
                .description(forfaitE.getDescription())
                .iswitheng(forfaitE.isIswitheng())
                .periodoffre(forfaitE.getPeriodoffre())
                .pricebase(forfaitE.getPricebase())
                .priceoffre(forfaitE.getPriceoffre())
                .dureeofeng(forfaitE.getDureeofeng())
                .visibilite(forfaitE.isVisibilite())
                .lien(forfaitE.getLien())
                .resume(forfaitE.getResume())
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
