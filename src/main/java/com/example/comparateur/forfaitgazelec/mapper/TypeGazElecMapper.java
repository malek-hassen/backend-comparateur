package com.example.comparateur.forfaitgazelec.mapper;

import com.example.comparateur.forfaitgazelec.controller.TypeForfaitGazElecResponse;
import com.example.comparateur.forfaitgazelec.dto.TypeGazElecDto;
import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.forfaitgazelec.repository.TypeElecGazRepository;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

@Component
public class TypeGazElecMapper {
    private final TypeElecGazRepository typeGERepository;

    public TypeGazElecMapper(TypeElecGazRepository typeGERepository) {
        this.typeGERepository = typeGERepository;
    }
    public TypeGE toEntity(TypeGazElecDto typeGazElecDto) {


        TypeGE typeGE = (typeGazElecDto.getId() != null)
                ? typeGERepository.findByid(typeGazElecDto.getId()).orElse(new TypeGE())
                : new TypeGE();

        // Mapper les champs du DTO vers l'entité
        typeGE.setId(typeGazElecDto.getId());
        typeGE.setNom(typeGazElecDto.getNom());
        typeGE.setDiscp(typeGazElecDto.getDiscp());

        return typeGE;
    }
    public TypeGazElecDto toDto(TypeGE typeGE) {

        return TypeGazElecDto.builder()
                .id(typeGE.getId())
                .nom(typeGE.getNom())
                .discp(typeGE.getDiscp())
                .build();
    }
    public TypeForfaitGazElecResponse toResponse(TypeGE typeGE) {
        return TypeForfaitGazElecResponse.builder()
                .id(typeGE.getId())
                .nom(typeGE.getNom())
                .build();
    }
}
