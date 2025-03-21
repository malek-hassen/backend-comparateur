package com.example.comparateur.forfait.mapper;

import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import org.springframework.stereotype.Component;


@Component
public class ForfaitMapper {
    // Méthode pour convertir le DTO en entité
    public Forfait toEntity(ForfaitDto forfaitDTO) {
        if (forfaitDTO == null) {
            return null;
        }
        Forfait forfait = new Forfait();

        // Mapper les champs du DTO vers l'entité
        forfait.setId(forfaitDTO.getId());
        forfait.setDescription(forfaitDTO.getDescription());
        forfait.setLien(forfaitDTO.getLien());
        forfait.setDureeofeng(forfaitDTO.getDureeofeng());
        forfait.setIswitheng(forfaitDTO.isIswitheng());
        forfait.setPeriodoffre(forfaitDTO.getPeriodoffre());
        forfait.setPricebase(forfaitDTO.getPricebase());
        forfait.setPriceoffre(forfaitDTO.getPriceoffre());
        forfait.setTitle(forfaitDTO.getTitle());
        forfait.setResume(forfaitDTO.getResume());
        forfait.setVisibilite(forfaitDTO.isVisibilite());
        return forfait;
    }

    // Méthode pour convertir l'entité en DTO
    public ForfaitDto toDto(Forfait forfait) {
        if (forfait == null) {
            return null;
        }
        ForfaitDto dto = new ForfaitDto();
        dto.setId(forfait.getId());
        dto.setDescription(forfait.getDescription());
        dto.setLien(forfait.getLien());
        dto.setDureeofeng(forfait.getDureeofeng());
        dto.setIswitheng(forfait.isIswitheng());
        dto.setPeriodoffre(forfait.getPeriodoffre());
        dto.setPricebase(forfait.getPricebase());
        dto.setPriceoffre(forfait.getPriceoffre());
        dto.setTitle(forfait.getTitle());
        dto.setResume(forfait.getResume());
        dto.setVisibilite(forfait.isVisibilite());

        return dto;
    }

}
