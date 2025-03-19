package com.example.comparateur.forfaitgazelec.mapper;


import com.example.comparateur.forfaitgazelec.controller.ForfaitGazResponse;

import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;

import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.repository.ForfaitGazRepository;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

@Component
public class ForfaitGazMapper {

    public ForfaitG toEntity(ForfaitGazDto forfaitGazDto) {
        ForfaitG forfaitG =new ForfaitG();
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
