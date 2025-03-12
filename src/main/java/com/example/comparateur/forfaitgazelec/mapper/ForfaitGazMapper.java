package com.example.comparateur.forfaitgazelec.mapper;


import com.example.comparateur.forfaitgazelec.controller.ForfaitGazResponse;

import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;

import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.repository.ForfaitGazRepository;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

@Component
public class ForfaitGazMapper {
    private final ForfaitGazRepository forfaitGazRepository;
    public ForfaitGazMapper(ForfaitGazRepository forfaitGazRepository) {
        this.forfaitGazRepository = forfaitGazRepository;

    }
    public ForfaitG toEntity(ForfaitGazDto forfaitGazDto) {
        ForfaitG forfaitG = (forfaitGazDto.getId() != null)
                ? forfaitGazRepository.findById(forfaitGazDto.getId()).orElse( new ForfaitG())
                :new ForfaitG();
        forfaitG.setId(forfaitGazDto.getId());
        forfaitG.setIseng(forfaitGazDto.isIseng());
        forfaitG.setDureeForfait(forfaitGazDto.getDureeForfait());
        forfaitG.setFournisseurs(forfaitGazDto.getFournisseurs());
        forfaitG.setAbnMensuel(forfaitGazDto.getAbnMensuel());
        forfaitG.setDureeEngConsommation(forfaitGazDto.getDureeEngConsommation());
        forfaitG.setPrixwattfixe(forfaitGazDto.getPrixwattfixe());
        forfaitG.setPrixverte(forfaitGazDto.getPrixverte());
        forfaitG.setPrixwattindexe(forfaitGazDto.getPrixwattindexe());
        forfaitG.setOrigin(forfaitGazDto.getOrigin());
        forfaitG.setTypeGaz(forfaitGazDto.getTypeGaz());
        forfaitG.setTitre(forfaitGazDto.getTitre());
        forfaitG.setPuissanceCompteur(forfaitGazDto.getPuissanceCompteur());
        forfaitG.setVisibilite(forfaitGazDto.isVisibilite());
        return forfaitG;
    }
    public ForfaitGazDto toDTO(ForfaitG forfaitG){
        return ForfaitGazDto.builder()
                .id(forfaitG.getId())
                .dureeForfait(forfaitG.getDureeForfait())
                .prixwattfixe(forfaitG.getPrixwattfixe())
                .iseng(forfaitG.isIseng())
                .fournisseurs(forfaitG.getFournisseurs())
                .abnMensuel(forfaitG.getAbnMensuel())
                .dureeEng(forfaitG.getDureeEng())
                .titre(forfaitG.getTitre())
                .dureeEngConsommation(forfaitG.getDureeEngConsommation())
                .prixverte(forfaitG.getPrixverte())
                .visibilite(forfaitG.isVisibilite())
                .puissanceCompteur(forfaitG.getPuissanceCompteur())
                .prixwattindexe(forfaitG.getPrixwattindexe())
                .origin(forfaitG.getOrigin())
                .typeGaz(forfaitG.getTypeGaz())
                .build();

    }
    public ForfaitGazResponse toResponse(ForfaitG forfaitG) {
        return ForfaitGazResponse.builder()
                .Id(forfaitG.getId())
                .title(forfaitG.getTitre())
                .build();
    }

}
