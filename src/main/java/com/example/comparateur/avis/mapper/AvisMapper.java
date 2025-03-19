package com.example.comparateur.avis.mapper;


import com.example.comparateur.avis.dto.AvisDto;
import com.example.comparateur.avis.entity.Avis;
import org.springframework.stereotype.Component;

@Component
public class AvisMapper {
    public Avis toDto(Avis avis) {
        if (avis == null) {
            return null;
        }
        Avis avisDto = new Avis();
        avisDto.setId(avis.getId());
        avisDto.setCommentaire(avis.getCommentaire());
        avisDto.setNote(avis.getNote());
        return avisDto;

    }
    public Avis toEntity(AvisDto avisDto) {
        if (avisDto == null) {
            return null;
        }
        Avis avis = new Avis();
        avis.setId(avisDto.getId());
        avis.setCommentaire(avisDto.getCommentaire());
        avis.setNote(avisDto.getNote());
        return avis;
    }
}
