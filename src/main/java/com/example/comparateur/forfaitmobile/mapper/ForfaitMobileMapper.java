package com.example.comparateur.forfaitmobile.mapper;


import com.example.comparateur.forfaitmobile.controller.ForfaitMobileResponse;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import org.springframework.stereotype.Component;

@Component
public class ForfaitMobileMapper {

    // Méthode pour convertir le DTO en entité
    public ForfaitM toEntity(ForfaitMobileDTO forfaitMobileDTO) {
        if (forfaitMobileDTO == null) {
            return null;
        }
        ForfaitM forfaitMobile = new ForfaitM();

        // Mapper les champs du DTO vers l'entité
        forfaitMobile.setDebit(forfaitMobileDTO.getDebit());
        forfaitMobile.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        forfaitMobile.setWith5G(forfaitMobileDTO.isWith5G());
        forfaitMobile.setHeure(forfaitMobileDTO.getHeure());
        forfaitMobile.setValue(forfaitMobileDTO.getValue());
        forfaitMobile.setIsBlocked(forfaitMobileDTO.isBlocked());
        forfaitMobile.setOperateur(forfaitMobile.getOperateur());
        forfaitMobile.setTypeM(forfaitMobile.getTypeM());
        forfaitMobile.setOperateur(forfaitMobile.getOperateur());

        return forfaitMobile;
    }

    // Méthode pour convertir l'entité en DTO
    public ForfaitMobileDTO toDto(ForfaitM forfaitM) {
        if (forfaitM == null) {
            return null;
        }
        ForfaitMobileDTO dto = new ForfaitMobileDTO();
        dto.setPrixSIM(forfaitM.getPrixSIM());
        dto.setWith5G(forfaitM.isWith5G());
        dto.setHeure(forfaitM.getHeure());
        dto.setValue(forfaitM.getValue());
        dto.setBlocked(forfaitM.getIsBlocked());
        dto.setOperateur(forfaitM.getOperateur());
        dto.setTypeBoxM(forfaitM.getTypeM());
        return dto;
    }

    public ForfaitMobileResponse toResponse(ForfaitM forfait) {
        return ForfaitMobileResponse.builder()
                .Id(forfait.getId())
                .build();
    }
}