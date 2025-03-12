package com.example.comparateur.forfaitinternet.mapper;

import com.example.comparateur.forfaitinternet.controller.ForfaitInternetResponse;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.repository.ForfaitInternetRepository;
import org.springframework.stereotype.Component;

@Component
public class ForfaitInternetMapper {



    private final ForfaitInternetRepository forfaitInternetRepository;


    public ForfaitInternetMapper(ForfaitInternetRepository forfaitInternetRepository) {
        this.forfaitInternetRepository = forfaitInternetRepository;

    }

    // Méthode pour convertir le DTO en entité
    public ForfaitInternet toEntity(ForfaitInternetDto forfaitInternetDto) {

        // Récupérer ou créer une nouvelle entité ForfaitMobile
        ForfaitInternet forfaitInt = (forfaitInternetDto.getId() != null)
                ? forfaitInternetRepository.findById(forfaitInternetDto.getId()).orElse(new ForfaitInternet())
                : new ForfaitInternet();

        // Mapper les champs du DTO vers l'entité
        forfaitInt.setId(forfaitInternetDto.getId());
        forfaitInt.setPeriodeOffre(forfaitInternetDto.getPrixOffre());
        forfaitInt.setVisibilite(forfaitInternetDto.isVisibilite());
        forfaitInt.setDebit(forfaitInternetDto.getDebit());
        forfaitInt.setPrixOffre(forfaitInternetDto.getPrixOffre());
        forfaitInt.setDebit(forfaitInternetDto.getDebit());
        forfaitInt.setLienExterne(forfaitInternetDto.getLienExterne());
        forfaitInt.setIswitheng(forfaitInternetDto.isIswitheng());
        forfaitInt.setWithmobile(forfaitInternetDto.isWithmobile());
        forfaitInt.setDescription(forfaitInternetDto.getDescription());
        forfaitInt.setDureeeng(forfaitInternetDto.getDureeeng());
        forfaitInt.setPrixBase(forfaitInternetDto.getPrixBase());
        forfaitInt.setNbchaine(forfaitInternetDto.getNbchaine());
        forfaitInt.setNbheure(forfaitInternetDto.getNbheure());
        forfaitInt.setTitre(forfaitInternetDto.getTitre());
        forfaitInt.setTechnologie(forfaitInternetDto.getTechnologie());
        forfaitInt.setOperateur(forfaitInternetDto.getOperateur());
        forfaitInt.setResume(forfaitInternetDto.getResume());
        forfaitInt.setVitesse(forfaitInternetDto.getVitesse());
        forfaitInt.setWithTV(forfaitInternetDto.isWithTV());
        forfaitInt.setTypeBox(forfaitInternetDto.getTypeBox());// Associer les types à ce forfait

        return forfaitInt;
    }

    // Méthode pour convertir l'entité en DTO
    public ForfaitInternetDto toDto(ForfaitInternet forfaitInt) {

        return ForfaitInternetDto.builder()
                .id(forfaitInt.getId())
                .periodeOffre(forfaitInt.getPeriodeOffre())
                .description(forfaitInt.getDescription())
                .debit(forfaitInt.getDebit())
                .lienExterne(forfaitInt.getLienExterne())
                .nbheure(forfaitInt.getNbheure())
                .dureeeng(forfaitInt.getDureeeng())
                .prixBase(forfaitInt.getPrixBase())
                .withTV(forfaitInt.isWithTV())
                .iswitheng(forfaitInt.isIswitheng())
                .withmobile(forfaitInt.isWithmobile())
                .visibilite(forfaitInt.isVisibilite())
                .resume(forfaitInt.getResume())
                .titre(forfaitInt.getTitre())
                .nbchaine(forfaitInt.getNbchaine())
                .vitesse(forfaitInt.getVitesse())
                .technologie(forfaitInt.getTechnologie())
                .prixOffre(forfaitInt.getPrixOffre())
                .operateur(forfaitInt.getOperateur())
                .typeBox(forfaitInt.getTypeBox())
                .build();
    }

    public ForfaitInternetResponse toResponse(ForfaitInternet forfait) {
        return ForfaitInternetResponse.builder()
                .id(forfait.getId())
                .title(forfait.getTitre())
                .build();
    }
}
