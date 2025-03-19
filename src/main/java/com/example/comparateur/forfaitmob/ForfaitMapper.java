package com.example.comparateur.forfaitmob;


import org.springframework.stereotype.Component;

@Component
public class ForfaitMapper {


    public ForfaitDto toDto(ForfaitMobile forfaitM) {
        if (forfaitM == null) {
            return null;
        }

        ForfaitDto dto = new ForfaitDto();
        dto.setId(forfaitM.getId());
        dto.setBlocked(forfaitM.isBlocked());
        dto.setValue(forfaitM.getValue());
        dto.setWith5G(forfaitM.isWith5G());
        dto.setIseng(forfaitM.isIseng());
        dto.setLien(forfaitM.getLien());
        dto.setDebit(forfaitM.getDebit());
        dto.setDescription(forfaitM.getDescription());
        dto.setDureeEng(forfaitM.getDureeEng());
        dto.setTitre(forfaitM.getTitre());
        dto.setTypeDebit(forfaitM.getTypeDebit());
        dto.setNbHeure(forfaitM.getNbHeure());
        dto.setPeriodeOffre(forfaitM.getPeriodeOffre());
        dto.setPrixBase(forfaitM.getPrixBase());
        dto.setPrixSIM(forfaitM.getPrixSIM());
        dto.setPeriodeOffre(forfaitM.getPeriodeOffre());
        dto.setResumer(forfaitM.getResumer());
        dto.setVisibilite(forfaitM.isVisibilite());

        return dto;
    }

    // Convert DTO to Entity
    public ForfaitMobile toEntity(ForfaitDto forfaitMobileDTO) {
        if (forfaitMobileDTO == null) {
            return null;
        }

        ForfaitMobile forfaitM = new ForfaitMobile();
        forfaitM.setId(forfaitMobileDTO.getId());
        forfaitM.setBlocked(forfaitMobileDTO.isBlocked());
        forfaitM.setValue(forfaitMobileDTO.getValue());
        forfaitM.setWith5G(forfaitMobileDTO.isWith5G());
        forfaitM.setIseng(forfaitMobileDTO.isIseng());
        forfaitM.setLien(forfaitMobileDTO.getLien());
        forfaitM.setDebit(forfaitMobileDTO.getDebit());
        forfaitM.setTitre(forfaitMobileDTO.getTitre());
        forfaitM.setTypeDebit(forfaitMobileDTO.getTypeDebit());
        forfaitM.setNbHeure(forfaitMobileDTO.getNbHeure());
        forfaitM.setLien(forfaitMobileDTO.getLien());
        forfaitM.setDescription(forfaitMobileDTO.getDescription());
        forfaitM.setDureeEng(forfaitMobileDTO.getDureeEng());
        forfaitM.setTypeDebit(forfaitMobileDTO.getTypeDebit());
        forfaitM.setPrixBase(forfaitMobileDTO.getPrixBase());
        forfaitM.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        forfaitM.setResumer(forfaitMobileDTO.getResumer());
        forfaitM.setVisibilite(forfaitMobileDTO.isVisibilite());
        forfaitM.setPeriodeOffre(forfaitMobileDTO.getPeriodeOffre());
        forfaitM.setPrixOffre(forfaitMobileDTO.getPrixOffre());


        return forfaitM;
    }
}

