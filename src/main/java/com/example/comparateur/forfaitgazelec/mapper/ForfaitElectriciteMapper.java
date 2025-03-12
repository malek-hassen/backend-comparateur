package com.example.comparateur.forfaitgazelec.mapper;

import com.example.comparateur.forfaitgazelec.controller.ForfaitElecResponse;
import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.repository.ForfaitElecRepository;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

@Component
public class ForfaitElectriciteMapper {
        private final ForfaitElecRepository forfaitElecRepository;
    public ForfaitElectriciteMapper(ForfaitElecRepository forfaitElecRepository) {
        this.forfaitElecRepository = forfaitElecRepository;

    }
    public ForfaitE toEntity(ForfaitElectriciteDto forfaitElectriciteDto) {
        ForfaitE forfaitE = (forfaitElectriciteDto.getId() != null)
                ? forfaitElecRepository.findById(forfaitElectriciteDto.getId()).orElse( new ForfaitE())
                :new ForfaitE();
        forfaitE.setDureeForfait(forfaitElectriciteDto.getDureeForfait());
        forfaitE.setId(forfaitElectriciteDto.getId());
        forfaitE.setIseng(forfaitElectriciteDto.isIseng());
        forfaitE.setAbnMensuel(forfaitElectriciteDto.getAbnMensuel());
        forfaitE.setDureeEngConsommation(forfaitElectriciteDto.getDureeEngConsommation());
        forfaitE.setPrixwattfixe(forfaitElectriciteDto.getPrixwattfixe());
        forfaitE.setPrixverte(forfaitElectriciteDto.getPrixverte());
        forfaitE.setPrixwattindexe(forfaitElectriciteDto.getPrixwattindexe());
        forfaitE.setSource(forfaitElectriciteDto.getSource());
        forfaitE.setTypeElectricite(forfaitElectriciteDto.getTypeElectricite());
        forfaitE.setTitre(forfaitElectriciteDto.getTitre());
        forfaitE.setPuissanceCompteur(forfaitElectriciteDto.getPuissanceCompteur());
        forfaitE.setFournisseurs(forfaitElectriciteDto.getFournisseurs());
        forfaitE.setVisibilite(forfaitElectriciteDto.isVisibilite());
        return forfaitE;
    }
    public ForfaitElectriciteDto toDTO(ForfaitE forfaitE){
        return ForfaitElectriciteDto.builder()
                .id(forfaitE.getId())
                .prixwattfixe(forfaitE.getPrixwattfixe())
                .dureeForfait(forfaitE.getDureeForfait())
                .iseng(forfaitE.isIseng())
                .fournisseurs(forfaitE.getFournisseurs())
                .abnMensuel(forfaitE.getAbnMensuel())
                .dureeEng(forfaitE.getDureeEng())
                .titre(forfaitE.getTitre())
                .dureeEngConsommation(forfaitE.getDureeEngConsommation())
                .prixverte(forfaitE.getPrixverte())
                .visibilite(forfaitE.isVisibilite())
                .puissanceCompteur(forfaitE.getPuissanceCompteur())
                .prixwattindexe(forfaitE.getPrixwattindexe())
                .source(forfaitE.getSource())
                .typeElectricite(forfaitE.getTypeElectricite())
                .build();

    }
    public ForfaitElecResponse toResponse(ForfaitE forfaitE) {
        return ForfaitElecResponse.builder()
                .Id(forfaitE.getId())
                .title(forfaitE.getTitre())
                .build();
    }

}
