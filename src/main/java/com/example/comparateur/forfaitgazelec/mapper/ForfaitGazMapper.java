package com.example.comparateur.forfaitgazelec.mapper;


import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfaitgazelec.controller.ForfaitGazResponse;

import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;

import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.repository.ForfaitGazRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

@Component
public class ForfaitGazMapper {

    public ForfaitG toEntity(Forfait forfait, ForfaitGazDto forfaitGazDto) {
        if (forfaitGazDto == null) {
            return null;
        }
        ForfaitG forfaitG =new ForfaitG();

        BeanUtils.copyProperties(forfait, forfaitG);

        forfaitG.setFournisseurs(forfaitGazDto.getFournisseurs());
        forfaitG.setAbnMensuel(forfaitGazDto.getAbnMensuel());
        forfaitG.setDureeConsommation(forfaitGazDto.getDureeConsommation());
        forfaitG.setPrixverte(forfaitGazDto.getPrixverte());
        forfaitG.setPrixwattindexe(forfaitGazDto.getPrixwattindexe());
        forfaitG.setOrigin(forfaitGazDto.getOrigin());
        forfaitG.setTypeGaz(forfaitGazDto.getTypeGaz());
        forfaitG.setPuissanceCompteur(forfaitGazDto.getPuissanceCompteur());
        return forfaitG;
    }
    public ForfaitGazDto toDTO(ForfaitG forfaitG){
        return ForfaitGazDto.builder()
                .id(forfaitG.getId())
                .title(forfaitG.getTitle())
                .description(forfaitG.getDescription())
                .iswitheng(forfaitG.isIswitheng())
                .periodoffre(forfaitG.getPeriodoffre())
                .pricebase(forfaitG.getPricebase())
                .priceoffre(forfaitG.getPriceoffre())
                .dureeofeng(forfaitG.getDureeofeng())
                .visibilite(forfaitG.isVisibilite())
                .lien(forfaitG.getLien())
                .resume(forfaitG.getResume())
                .fournisseurs(forfaitG.getFournisseurs())
                .abnMensuel(forfaitG.getAbnMensuel())
                .dureeConsommation(forfaitG.getDureeConsommation())
                .prixverte(forfaitG.getPrixverte())
                .puissanceCompteur(forfaitG.getPuissanceCompteur())
                .prixwattindexe(forfaitG.getPrixwattindexe())
                .origin(forfaitG.getOrigin())
                .typeGaz(forfaitG.getTypeGaz())
                .build();

    }
    public ForfaitGazResponse toResponse(ForfaitG forfaitG) {
        return ForfaitGazResponse.builder()
                .Id(forfaitG.getId())
                .build();
    }

}
