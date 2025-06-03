package com.example.comparateur.fournisseurs.mapper;

import com.example.comparateur.fournisseurs.dto.FournisseurDto;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import org.springframework.stereotype.Component;



@Component
public class FournisseurMapper {


        public FournisseurDto toDto(Fournisseurs fournisseur) {
            if (fournisseur == null) {
                return null;
            }
            FournisseurDto dto = new FournisseurDto();
            dto.setId(fournisseur.getId());
            dto.setNom(fournisseur.getNom());
            dto.setType(fournisseur.getType());
            dto.setUrl(fournisseur.getUrl());

            return dto;
        }
        public Fournisseurs toEntity(FournisseurDto dto) {
            if (dto == null) {
                return null;
            }
            Fournisseurs fournisseur = new Fournisseurs();
            fournisseur.setId(dto.getId());
            fournisseur.setNom(dto.getNom());
            fournisseur.setType(dto.getType());
            fournisseur.setUrl(dto.getUrl());

            return fournisseur;
        }
    }

