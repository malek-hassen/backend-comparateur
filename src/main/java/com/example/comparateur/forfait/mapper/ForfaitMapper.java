package com.example.comparateur.forfait.mapper;

import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import org.springframework.stereotype.Component;


@Component
public class ForfaitMapper {
    // Méthode pour convertir le DTO en entity
    public Forfait toEntity(ForfaitDto forfaitDTO, Forfait forfait) {
        if (forfaitDTO == null) {
            return null;
        }

        forfait = createForfaitByDtype(forfaitDTO.getDtype(), forfait);

        if (forfait == null) {
            throw new IllegalArgumentException("Unknown Forfait type");
        }
        mapDtoToEntity(forfaitDTO, forfait);

        return forfait;
    }

    private Forfait createForfaitByDtype(String dtype, Forfait forfait) {
        if (forfait == null) {
            switch (dtype) {
                case "ForfaitMobile":
                    return new ForfaitM();
                case "ForfaitInternet":
                    return new ForfaitInternet();
                case "ForfaitGaz":
                    return new ForfaitG();
                case "ForfaitElectricité":
                    return new ForfaitE();
                default:
                    return null;
            }
        }
        return forfait;  // If 'forfait' is already passed in, we just use that instance
    }

    private void mapDtoToEntity(ForfaitDto forfaitDTO, Forfait forfait) {
        forfait.setId(forfaitDTO.getId());
        forfait.setDtype(forfaitDTO.getDtype());
        forfait.setDescription(forfaitDTO.getDescription());
        forfait.setLien(forfaitDTO.getLien());
        forfait.setDureeofeng(forfaitDTO.getDureeofeng());
        forfait.setIswitheng(forfaitDTO.isIswitheng());
        forfait.setPeriodoffre(forfaitDTO.getPeriodoffre());
        forfait.setPricebase(forfaitDTO.getPricebase());
        forfait.setPriceoffre(forfaitDTO.getPriceoffre());
        forfait.setTitle(forfaitDTO.getTitle());
        forfait.setResume(forfaitDTO.getResume());
        forfait.setVisibilite(forfaitDTO.isVisibilite());
    }


    public ForfaitDto toDto(Forfait forfait) {
        if (forfait == null) {
            return null;
        }
        ForfaitDto dto = new ForfaitDto();
        dto.setId(forfait.getId());
        dto.setDtype(forfait.getDtype());
        dto.setDescription(forfait.getDescription());
        dto.setLien(forfait.getLien());
        dto.setDureeofeng(forfait.getDureeofeng());
        dto.setIswitheng(forfait.isIswitheng());
        dto.setPeriodoffre(forfait.getPeriodoffre());
        dto.setPricebase(forfait.getPricebase());
        dto.setPriceoffre(forfait.getPriceoffre());
        dto.setTitle(forfait.getTitle());
        dto.setResume(forfait.getResume());
        dto.setVisibilite(forfait.isVisibilite());

        return dto;
    }
}
