package com.example.comparateur.operateur.mapper;

import com.example.comparateur.operateur.dto.OperateurDTO;
import com.example.comparateur.operateur.entity.Operateur;
import org.springframework.stereotype.Component;


@Component
public class OperateurMapper {

    public OperateurDTO toDto(Operateur operateur) {
        if (operateur == null) {
            return null;
        }
        OperateurDTO dto = new OperateurDTO();
        dto.setId(operateur.getId());
        dto.setNom(operateur.getNom());
        dto.setUrl(operateur.getUrl());

        return dto;
    }
    public Operateur toEntity(OperateurDTO dto) {
        if (dto == null) {
            return null;
        }
        Operateur operateur = new Operateur();
        operateur.setId(dto.getId());
        operateur.setNom(dto.getNom());
        operateur.setUrl(dto.getUrl());

        return operateur;
    }
}