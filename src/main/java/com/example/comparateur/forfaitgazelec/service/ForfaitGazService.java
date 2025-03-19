package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;

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

    public ForfaitG createForfaitGaz(ForfaitGazDto ForfaitGazDTO) {
        return  forfaitGazRepository.save(forfaitGazMapper.toEntity(ForfaitGazDTO));
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

        if (! forfaitGazRepository.existsById(forfaitGazDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Electricite not found");
        }

        ForfaitG forfaitG =forfaitGazMapper.toEntity(forfaitGazDTO);
        forfaitG =  forfaitGazRepository.findById(forfaitG.getId())
                .orElseThrow(() -> new RuntimeException("Forfait not found")); // Fetch entity
        forfaitGazRepository.save(forfaitG);

        return ResponseEntity.ok("Forfait Gaz Updated Successfully");
    }



    public ResponseEntity<String> deleteForfaitGaz (UUID id) {
        if (! forfaitGazRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Gaz not found");
        }

        forfaitGazRepository.deleteById(id );

        return ResponseEntity.ok("Forfait GazDeleted Successfully");
    }
}
