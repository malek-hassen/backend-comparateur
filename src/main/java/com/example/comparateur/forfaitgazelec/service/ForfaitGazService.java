package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;

import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.mapper.ForfaitGazMapper;
import com.example.comparateur.forfaitgazelec.repository.ForfaitGazRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForfaitGazService {
    private final ForfaitGazRepository forfaitGazRepository;
    private final ForfaitGazMapper forfaitGazMapper;

    public ForfaitGazService(ForfaitGazRepository forfaitGazRepository, ForfaitGazMapper forfaitGazMapper) {
        this.forfaitGazRepository = forfaitGazRepository;
        this.forfaitGazMapper = forfaitGazMapper;
    }

    public ForfaitGazDto createForfaitGaz(ForfaitGazDto forfaiteGazDTO) {

        ForfaitG forfaitG = new ForfaitG();


        forfaitG.setTitle(forfaiteGazDTO.getTitle());
        forfaitG.setDescription(forfaiteGazDTO.getDescription());
        forfaitG.setLien(forfaiteGazDTO.getLien());
        forfaitG.setResume(forfaiteGazDTO.getResume());
        forfaitG.setPricebase(forfaiteGazDTO.getPricebase());
        forfaitG.setPriceoffre(forfaiteGazDTO.getPriceoffre());
        forfaitG.setPeriodoffre(forfaiteGazDTO.getPeriodoffre());
        forfaitG.setIswitheng(forfaiteGazDTO.isIswitheng());
        forfaitG.setDureeofeng(forfaiteGazDTO.getDureeofeng());
        forfaitG.setVisibilite(forfaiteGazDTO.isVisibilite());
        forfaitG.setDtype("Forfait Gaz");

        // Set ForfaitM-specific attributes

        forfaitG.setAbnMensuel(forfaiteGazDTO.getAbnMensuel());
        forfaitG.setDureeConsommation(forfaiteGazDTO.getDureeConsommation());
        forfaitG.setPrixverte(forfaiteGazDTO.getPrixverte());
        forfaitG.setPrixwattindexe(forfaiteGazDTO.getPrixwattindexe());
        forfaitG.setOrigin(forfaiteGazDTO.getOrigin());
        forfaitG.setTypeGaz(forfaiteGazDTO.getTypeGaz());
        forfaitG.setPuissanceCompteur(forfaiteGazDTO.getPuissanceCompteur());
        forfaitG.setFournisseurs(forfaiteGazDTO.getFournisseurs());
        // Save the ForfaitM entity to the repository
        ForfaitG savedForfaitG = forfaitGazRepository.save(forfaitG);

        return forfaitGazMapper.toDTO(savedForfaitG);
    }


    public List<ForfaitGazDto> getAllForfaitGaz() {
        List<ForfaitG > forfaits = new ArrayList<>();
        forfaitGazRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitGazMapper::toDTO)
                .toList();
    }


    public ResponseEntity<ForfaitGazDto> getForfaitGazById(UUID id) {
        Optional<ForfaitG > ForfaitGazOptional =  forfaitGazRepository.findById(id);
        return ForfaitGazOptional.map(forfaitGazMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    public ResponseEntity<String> updateForfaitGaz(ForfaitGazDto forfaitGazDTO) {
        if (forfaitGazDTO == null || forfaitGazDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        Optional<ForfaitG> forfaitGOptional = forfaitGazRepository.findById(forfaitGazDTO.getId());
        if (forfaitGOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Gaz not found");
        }

        ForfaitG existingForfaitG= forfaitGOptional.get();

        // Update base Forfait properties
        existingForfaitG.setTitle(forfaitGazDTO.getTitle());
        existingForfaitG.setDescription(forfaitGazDTO.getDescription());
        existingForfaitG.setLien(forfaitGazDTO.getLien());
        existingForfaitG.setResume(forfaitGazDTO.getResume());
        existingForfaitG.setPricebase(forfaitGazDTO.getPricebase());
        existingForfaitG.setPriceoffre(forfaitGazDTO.getPriceoffre());
        existingForfaitG.setPeriodoffre(forfaitGazDTO.getPeriodoffre());
        existingForfaitG.setIswitheng(forfaitGazDTO.isIswitheng());
        existingForfaitG.setDureeofeng(forfaitGazDTO.getDureeofeng());
        existingForfaitG.setVisibilite(forfaitGazDTO.isVisibilite());
        existingForfaitG.setDtype("Forfait Gaz");

        // Set ForfaitM-specific attributes

        existingForfaitG.setAbnMensuel(forfaitGazDTO.getAbnMensuel());
        existingForfaitG.setDureeConsommation(forfaitGazDTO.getDureeConsommation());
        existingForfaitG.setPrixverte(forfaitGazDTO.getPrixverte());
        existingForfaitG.setPrixwattindexe(forfaitGazDTO.getPrixwattindexe());
        existingForfaitG.setOrigin(forfaitGazDTO.getOrigin());
        existingForfaitG.setTypeGaz(forfaitGazDTO.getTypeGaz());
        existingForfaitG.setPuissanceCompteur(forfaitGazDTO.getPuissanceCompteur());
        existingForfaitG.setFournisseurs(forfaitGazDTO.getFournisseurs());

        // Save the updated entity
        forfaitGazRepository.save(existingForfaitG);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }



    public ResponseEntity<String> deleteForfaitGaz (UUID id) {
        if (! forfaitGazRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Gaz not found");
        }

        forfaitGazRepository.deleteById(id );

        return ResponseEntity.ok("Forfait GazDeleted Successfully");
    }
}
