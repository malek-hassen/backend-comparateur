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
        ForfaitInternet forfaitInt = new ForfaitInternet();

        // Mapper les champs du DTO vers l'entité
        forfaitInt.setDebit(forfaitInternetDto.getDebit());
        forfaitInt.setDebit(forfaitInternetDto.getDebit());
        forfaitInt.setWithmobile(forfaitInternetDto.isWithmobile());
        forfaitInt.setNbchaine(forfaitInternetDto.getNbchaine());
        forfaitInt.setNbr_Heure(forfaitInternetDto.getNbrheure());
        forfaitInt.setTechnologie(forfaitInternetDto.getTechnologie());
        forfaitInt.setOperateur(forfaitInternetDto.getOperateur());
        forfaitInt.setVitesse(forfaitInternetDto.getVitesse());
        forfaitInt.setWithTV(forfaitInternetDto.isWithTV());
        forfaitInt.setTypeBox(forfaitInternetDto.getTypeBox());

        return forfaitInt;
    }

    // Méthode pour convertir l'entité en DTO
    public ForfaitInternetDto toDto(ForfaitInternet forfaitInt) {

        return ForfaitInternetDto.builder()
                .debit(forfaitInt.getDebit())
                .nbrheure(forfaitInt.getNbr_Heure())
                .withTV(forfaitInt.isWithTV())
                .withmobile(forfaitInt.isWithmobile())
                .nbchaine(forfaitInt.getNbchaine())
                .vitesse(forfaitInt.getVitesse())
                .technologie(forfaitInt.getTechnologie())
                .operateur(forfaitInt.getOperateur())
                .typeBox(forfaitInt.getTypeBox())
                .build();
    }

    public ForfaitInternetResponse toResponse(ForfaitInternet forfait) {
        return ForfaitInternetResponse.builder()
                .id(forfait.getId())
                .build();
    }
}
