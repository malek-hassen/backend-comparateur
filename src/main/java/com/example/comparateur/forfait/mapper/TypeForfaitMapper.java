package com.example.comparateur.forfait.mapper;

import com.example.comparateur.forfait.dto.TypeForfaitDTO;
import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.forfait.repository.TypeForfaitRepository;
import org.springframework.stereotype.Component;


@Component
public class TypeForfaitMapper {

    private final TypeForfaitRepository typeFRepository;

    public TypeForfaitMapper(TypeForfaitRepository typeFRepository) {
        this.typeFRepository = typeFRepository;
    }


    public TypeForfait toEntity(TypeForfaitDTO typeForfaitDTO) {


        TypeForfait typeF = (typeForfaitDTO.getId() != null)
                ? typeFRepository.findByid(typeForfaitDTO.getId()).orElse(new TypeForfait())
                : new TypeForfait();

        // Mapper les champs du DTO vers l'entité
        typeF.setId(typeForfaitDTO.getId());
        typeF.setType(typeForfaitDTO.getType());
        typeF.setNom(typeForfaitDTO.getNom());
        typeF.setDiscp(typeForfaitDTO.getDiscp());
        typeF.setForfait(typeForfaitDTO.getForfait());

        return typeF;
    }
    public TypeForfaitDTO toDto(TypeForfait typeF) {

        return TypeForfaitDTO.builder()
                .id(typeF.getId())
                .type(typeF.getType())
                .nom(typeF.getNom())
                .discp(typeF.getDiscp())
                .forfait(typeF.getForfait())
                .build();
    }
//    public TypeInternetResponse toResponse(TypeInternet typeI) {
//        return TypeInternetResponse.builder()
//                .id(typeI.getId())
//                .nom(typeI.getNom())
//                .build();
//    }
}
