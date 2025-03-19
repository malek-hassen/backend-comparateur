package com.example.comparateur.forfaitinternet.mapper;

import com.example.comparateur.forfaitinternet.controller.TypeInternetResponse;
import com.example.comparateur.forfaitinternet.dto.TypeInternetDto;
import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import com.example.comparateur.forfaitinternet.repository.TypeIntRepository;
import org.springframework.stereotype.Component;


@Component
public class TypeInternetMapper {

    private final TypeIntRepository typeIRepository;

    public TypeInternetMapper(TypeIntRepository typeIRepository) {
        this.typeIRepository = typeIRepository;
    }
    public TypeInternet toEntity(TypeInternetDto typeInternetDTO) {


        TypeInternet typeI = (typeInternetDTO.getId() != null)
                ? typeIRepository.findByid(typeInternetDTO.getId()).orElse(new TypeInternet())
                : new TypeInternet();

        // Mapper les champs du DTO vers l'entité
        typeI.setId(typeInternetDTO.getId());
        typeI.setNom(typeInternetDTO.getNom());
        typeI.setDiscp(typeInternetDTO.getDiscp());
        typeI.setForfaitInternet(typeInternetDTO.getForfaitInternet());

        return typeI;
    }
    public TypeInternetDto toDto(TypeInternet typeI) {

        return TypeInternetDto.builder()
                .id(typeI.getId())
                .nom(typeI.getNom())
                .discp(typeI.getDiscp())
                .forfaitInternet(typeI.getForfaitInternet())
                .build();
    }
    public TypeInternetResponse toResponse(TypeInternet typeI) {
        return TypeInternetResponse.builder()
                .id(typeI.getId())
                .nom(typeI.getNom())
                .build();
    }
}
