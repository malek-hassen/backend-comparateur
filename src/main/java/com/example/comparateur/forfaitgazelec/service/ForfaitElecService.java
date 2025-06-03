package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.mapper.ForfaitElectriciteMapper;
import com.example.comparateur.forfaitgazelec.repository.ForfaitElecRepository;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForfaitElecService {

    private ForfaitElecRepository forfaitElectriciteRepository;


    private final ForfaitElectriciteMapper forfaitElectriciteMapper;


    public ForfaitElecService(ForfaitElecRepository forfaitElectriciteRepository, ForfaitElectriciteMapper forfaitElectriciteMapper) {
        this.forfaitElectriciteRepository = forfaitElectriciteRepository;

        this.forfaitElectriciteMapper = forfaitElectriciteMapper;
    }

    public ForfaitElectriciteDto createForfaitElectricite(ForfaitElectriciteDto forfaitelectriciteDTO) {

        ForfaitE forfaitE = new ForfaitE();


        forfaitE.setTitle(forfaitelectriciteDTO.getTitle());
        forfaitE.setDescription(forfaitelectriciteDTO.getDescription());
        forfaitE.setLien(forfaitelectriciteDTO.getLien());
        forfaitE.setResume(forfaitelectriciteDTO.getResume());
        forfaitE.setPricebase(forfaitelectriciteDTO.getPricebase());
        forfaitE.setPriceoffre(forfaitelectriciteDTO.getPriceoffre());
        forfaitE.setPeriodoffre(forfaitelectriciteDTO.getPeriodoffre());
        forfaitE.setIswitheng(forfaitelectriciteDTO.isIswitheng());
        forfaitE.setDureeofeng(forfaitelectriciteDTO.getDureeofeng());
        forfaitE.setVisibilite(forfaitelectriciteDTO.isVisibilite());
        forfaitE.setDtype("Forfait Electricité");

        // Set ForfaitM-specific attributes

        forfaitE.setAbnMensuel(forfaitelectriciteDTO.getAbnMensuel());
        forfaitE.setDureeConsommation(forfaitelectriciteDTO.getDureeConsommation());
        forfaitE.setPrixverte(forfaitelectriciteDTO.getPrixverte());
        forfaitE.setPrixwattindexe(forfaitelectriciteDTO.getPrixwattindexe());
        forfaitE.setSource(forfaitelectriciteDTO.getSource());
        forfaitE.setTypeElectricite(forfaitelectriciteDTO.getTypeElectricite());
        forfaitE.setPuissanceCompteur(forfaitelectriciteDTO.getPuissanceCompteur());
        forfaitE.setFournisseurs(forfaitelectriciteDTO.getFournisseurs());
        // Save the ForfaitM entity to the repository
        ForfaitE savedForfaitE = forfaitElectriciteRepository.save(forfaitE);

        return forfaitElectriciteMapper.toDTO(savedForfaitE);
    }
    public List<ForfaitElectriciteDto> getAllForfaitElectricite() {
        List<ForfaitE > forfaits = new ArrayList<>();
        forfaitElectriciteRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitElectriciteMapper::toDTO)
                .toList();
    }


    public ResponseEntity<ForfaitElectriciteDto> getForfaitElectriciteById(UUID id) {
        Optional<ForfaitE > ForfaitEOptional =  forfaitElectriciteRepository.findById(id);
        return ForfaitEOptional.map(forfaitElectriciteMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    public ResponseEntity<String> updateForfaitElectricite(ForfaitElectriciteDto forfaitelectriciteDTO) {
        if (forfaitelectriciteDTO == null || forfaitelectriciteDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        Optional<ForfaitE> forfaitEOptional = forfaitElectriciteRepository.findById(forfaitelectriciteDTO.getId());
        if (forfaitEOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        ForfaitE existingForfaitE= forfaitEOptional.get();

        // Update base Forfait properties
        existingForfaitE.setTitle(forfaitelectriciteDTO.getTitle());
        existingForfaitE.setDescription(forfaitelectriciteDTO.getDescription());
        existingForfaitE.setLien(forfaitelectriciteDTO.getLien());
        existingForfaitE.setResume(forfaitelectriciteDTO.getResume());
        existingForfaitE.setPricebase(forfaitelectriciteDTO.getPricebase());
        existingForfaitE.setPriceoffre(forfaitelectriciteDTO.getPriceoffre());
        existingForfaitE.setPeriodoffre(forfaitelectriciteDTO.getPeriodoffre());
        existingForfaitE.setIswitheng(forfaitelectriciteDTO.isIswitheng());
        existingForfaitE.setDureeofeng(forfaitelectriciteDTO.getDureeofeng());
        existingForfaitE.setVisibilite(forfaitelectriciteDTO.isVisibilite());
        existingForfaitE.setDtype("Forfait Electricité");

        // Set ForfaitM-specific attributes

        existingForfaitE.setAbnMensuel(forfaitelectriciteDTO.getAbnMensuel());
        existingForfaitE.setDureeConsommation(forfaitelectriciteDTO.getDureeConsommation());
        existingForfaitE.setPrixverte(forfaitelectriciteDTO.getPrixverte());
        existingForfaitE.setPrixwattindexe(forfaitelectriciteDTO.getPrixwattindexe());
        existingForfaitE.setSource(forfaitelectriciteDTO.getSource());
        existingForfaitE.setTypeElectricite(forfaitelectriciteDTO.getTypeElectricite());
        existingForfaitE.setPuissanceCompteur(forfaitelectriciteDTO.getPuissanceCompteur());
        existingForfaitE.setFournisseurs(forfaitelectriciteDTO.getFournisseurs());

        // Save the updated entity
        forfaitElectriciteRepository.save(existingForfaitE);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }





    public ResponseEntity<String> deleteForfaitElectricite (UUID id) {
        if (! forfaitElectriciteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Internet not found");
        }

        forfaitElectriciteRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Internet Deleted Successfully");
    }
}
