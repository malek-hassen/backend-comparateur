package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.mapper.ForfaitElectriciteMapper;
import com.example.comparateur.forfaitgazelec.repository.ForfaitElecRepository;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
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

    public ForfaitE createForfaitElectricite(ForfaitElectriciteDto forfaitElectriciteDto) {
        return  forfaitElectriciteRepository.save(forfaitElectriciteMapper.toEntity(forfaitElectriciteDto));
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



    public ResponseEntity<String> updateForfaitElectricite(ForfaitElectriciteDto forfaitElectriciteDTO) {
        if (forfaitElectriciteDTO == null || forfaitElectriciteDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (! forfaitElectriciteRepository.existsById(forfaitElectriciteDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Electricite not found");
        }

        ForfaitE forfaitE =forfaitElectriciteMapper.toEntity(forfaitElectriciteDTO);
        forfaitE =  forfaitElectriciteRepository.findById(forfaitE.getId())
                .orElseThrow(() -> new RuntimeException("Forfait not found")); // Fetch entity
        forfaitElectriciteRepository.save(forfaitE);

        return ResponseEntity.ok("Forfait Electricite Updated Successfully");
    }



    public ResponseEntity<String> deleteForfaitElectricite (UUID id) {
        if (! forfaitElectriciteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Internet not found");
        }

        forfaitElectriciteRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Internet Deleted Successfully");
    }
}
