package com.example.comparateur.forfaitmobile.mapper;


import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.operateur.repository.OperateurRepository;
import com.example.comparateur.forfaitmobile.controller.ForfaitMobileResponse;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.operateur.entity.Operateur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class ForfaitMobileMapper {

    private OperateurRepository operateurRepository;

    // Méthode pour convertir le DTO en entité
    public ForfaitM toEntity(Forfait forfait, ForfaitMobileDTO forfaitMobileDTO) {
        if (forfaitMobileDTO == null) {
            return null;
        }
        ForfaitM forfaitMobile = new ForfaitM();
        UUID operateurId = forfaitMobileDTO.getOperateur().getId();
        Operateur operateur = operateurRepository.findById(operateurId)
                .orElseThrow(() -> new RuntimeException("Operateur not found with id: " + operateurId));

        // Set inherited attributes
        BeanUtils.copyProperties(forfait, forfaitMobile);

        // Set ForfaitM-specific attributes
        forfaitMobile.setDebit(forfaitMobileDTO.getDebit());
        forfaitMobile.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        forfaitMobile.setWith5G(forfaitMobileDTO.isWith5G());
        forfaitMobile.setHeure(forfaitMobileDTO.getHeure());
        forfaitMobile.setValue(forfaitMobileDTO.getValue());
        forfaitMobile.setIsBlocked(forfaitMobileDTO.isBlocked());
        forfaitMobile.setOperateur(operateur);
        forfaitMobile.setNomOperateur(forfaitMobileDTO.getNomOperateur());
        forfaitMobile.setUrlOperateur(forfaitMobileDTO.getUrlOperateur());
        forfaitMobile.setTypeM(forfaitMobileDTO.getTypeBoxM());

        return forfaitMobile;
    }


    // Méthode pour convertir l'entité en DTO
    public ForfaitMobileDTO toDto(ForfaitM forfaitM) {
        if (forfaitM == null) {
            return null;
        }

        return ForfaitMobileDTO.builder()
                .id(forfaitM.getId())
                .title(forfaitM.getTitle())
                .description(forfaitM.getDescription())
                .lien(forfaitM.getLien())
                .resume(forfaitM.getResume())
                .pricebase(forfaitM.getPricebase())
                .priceoffre(forfaitM.getPriceoffre())
                .periodoffre(forfaitM.getPeriodoffre())
                .iswitheng(forfaitM.isIswitheng())
                .dureeofeng(forfaitM.getDureeofeng())
                .visibilite(forfaitM.isVisibilite())
                .debit(forfaitM.getDebit())
                .typeDebit(forfaitM.getTypeDebit())
                .prixSIM(forfaitM.getPrixSIM())
                .heure(forfaitM.getHeure())
                .with5G(forfaitM.isWith5G())
                .value(forfaitM.getValue())
                .isBlocked(forfaitM.getIsBlocked())
                .operateur(forfaitM.getOperateur())
                .typeBoxM(forfaitM.getTypeM())
                .NomOperateur(forfaitM.getNomOperateur())
                .urlOperateur(forfaitM.getUrlOperateur())
                .build();
    }

    public ForfaitMobileResponse toResponse(ForfaitM forfait) {
        return ForfaitMobileResponse.builder()
                .Id(forfait.getId())
                .build();
    }
}