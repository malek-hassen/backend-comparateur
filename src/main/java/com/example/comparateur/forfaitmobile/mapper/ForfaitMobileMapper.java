package com.example.comparateur.forfaitmobile.mapper;

import com.example.comparateur.forfaitmobile.controller.ForfaitMobileResponse;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.repository.ForfaitMRepository;
import org.springframework.stereotype.Component;

@Component
public class ForfaitMobileMapper {

    private final ForfaitMRepository forfaitMobileRepository;

    public ForfaitMobileMapper(ForfaitMRepository forfaitMobileRepository) {
        this.forfaitMobileRepository = forfaitMobileRepository;
    }

    // Méthode pour convertir le DTO en entité
    public ForfaitM toEntity(ForfaitMobileDTO forfaitMobileDTO) {
        // Récupérer ou créer une nouvelle entité ForfaitMobile
//        ForfaitM forfaitMobile = (forfaitMobileDTO.getId() != null)
//                ? forfaitMobileRepository.findById(forfaitMobileDTO.getId()).orElse(new ForfaitM())
//                : new ForfaitM();
        ForfaitM forfaitMobile = new ForfaitM();

        // Mapper les champs du DTO vers l'entité
        forfaitMobile.setId(forfaitMobileDTO.getId());
        forfaitMobile.setTitre(forfaitMobileDTO.getTitre());
        forfaitMobile.setVersion(forfaitMobileDTO.getVersion());
        forfaitMobile.setPrixOffre(forfaitMobileDTO.getPrixOffre());
        forfaitMobile.setVisibilite(forfaitMobileDTO.isVisibilite());
        forfaitMobile.setPeriodeOffre(forfaitMobileDTO.getPeriodeOffre());
        forfaitMobile.setDebit(forfaitMobileDTO.getDebit());
        forfaitMobile.setTypeDebit(forfaitMobileDTO.getTypeDebit());
        forfaitMobile.setPrixBase(forfaitMobileDTO.getPrixBase());
        forfaitMobile.setIseng(forfaitMobileDTO.isIseng());
        forfaitMobile.setDureeEng(forfaitMobileDTO.getDureeEng());
        forfaitMobile.setLien(forfaitMobileDTO.getLien());
        forfaitMobile.setDescription(forfaitMobileDTO.getDescription());
        forfaitMobile.setResumer(forfaitMobileDTO.getResumer());
        forfaitMobile.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        forfaitMobile.setWith5G(forfaitMobileDTO.isWith5G());
        forfaitMobile.setNbHeure(forfaitMobileDTO.getNbHeure());
        forfaitMobile.setValue(forfaitMobileDTO.getValue());
        forfaitMobile.setIsBlocked(forfaitMobileDTO.isBlocked());
        forfaitMobile.setOperateur(forfaitMobileDTO.getOperateur());
        forfaitMobile.setTypeBoxM(forfaitMobileDTO.getTypeBoxM());

        return forfaitMobile;
    }

    // Méthode pour convertir l'entité en DTO
    public ForfaitMobileDTO toDto(ForfaitM forfaitMobile) {
        if (forfaitMobile == null) {
            return null;
        }

        return ForfaitMobileDTO.builder()
                .id(forfaitMobile.getId())
                .version(forfaitMobile.getVersion())
                .titre(forfaitMobile.getTitre())
                .prixOffre(forfaitMobile.getPrixOffre())
                .visibilite(forfaitMobile.isVisibilite())
                .periodeOffre(forfaitMobile.getPeriodeOffre())
                .debit(forfaitMobile.getDebit())
                .typeDebit(forfaitMobile.getTypeDebit())
                .prixBase(forfaitMobile.getPrixBase())
                .iseng(forfaitMobile.isIseng())
                .dureeEng(forfaitMobile.getDureeEng())
                .lien(forfaitMobile.getLien())
                .description(forfaitMobile.getDescription())
                .resumer(forfaitMobile.getResumer())
                .prixSIM(forfaitMobile.getPrixSIM())
                .nbHeure(forfaitMobile.getNbHeure())
                .with5G(forfaitMobile.isWith5G())
                .value(forfaitMobile.getValue())
                .isBlocked(forfaitMobile.getIsBlocked())
                .operateur(forfaitMobile.getOperateur())
                .typeBoxM(forfaitMobile.getTypeBoxM())
                .build();
    }

    public ForfaitMobileResponse toResponse(ForfaitM forfait) {
        return ForfaitMobileResponse.builder()
                .Id(forfait.getId())
                .titre(forfait.getTitre())
                .build();
    }
}