package com.example.comparateur.forfaitmobile.mapper;



import com.example.comparateur.forfaitmobile.controller.TypeMobileResponse;
import com.example.comparateur.forfaitmobile.dto.TypeMobileDTO;

import com.example.comparateur.forfaitmobile.entity.TypeM;
import com.example.comparateur.forfaitmobile.repository.TypeMobRepository;
import org.springframework.stereotype.Component;

@Component
public class TypeMobileMapper {
    private final TypeMobRepository typeMobileRepository;

    public TypeMobileMapper(TypeMobRepository typeMobileRepository) {
        this.typeMobileRepository = typeMobileRepository;
    }
    public TypeM toEntity(TypeMobileDTO typeMobileDTO) {


        TypeM typemobile = (typeMobileDTO.getTypeMid() != null)
                ? typeMobileRepository.findByTypeMid(typeMobileDTO.getTypeMid()).orElse(new TypeM())
                : new TypeM();

        // Mapper les champs du DTO vers l'entité
        typemobile.setTypeMid(typeMobileDTO.getTypeMid());
        typemobile.setNom(typeMobileDTO.getNom());
        typemobile.setDiscp(typeMobileDTO.getDiscp());
        typemobile.setTypeMid(typeMobileDTO.getTypeMid());

        return typemobile;
    }
    public TypeMobileDTO toDto(TypeM typemobile) {

        return TypeMobileDTO.builder()
                .typeMid(typemobile.getTypeMid())
                .nom(typemobile.getNom())
                .discp(typemobile.getDiscp())
                .typeMid(typemobile.getTypeMid())
                .build();
    }
    public TypeMobileResponse toResponse(TypeM typemobile) {
        return TypeMobileResponse.builder()
                .typeMid(typemobile.getTypeMid())
                .nom(typemobile.getNom())
                .build();
    }
}
