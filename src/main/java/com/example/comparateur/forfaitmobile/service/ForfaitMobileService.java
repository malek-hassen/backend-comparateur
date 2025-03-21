package com.example.comparateur.forfaitmobile.service;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.mapper.ForfaitMobileMapper;
import com.example.comparateur.forfaitmobile.repository.ForfaitMRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ForfaitMobileService {

    private final ForfaitMRepository forfaitMRepository;
    private final ForfaitMobileMapper forfaitMobileMapper;

    public ForfaitM createForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        return forfaitMRepository.save(forfaitMobileMapper.toEntity(forfaitMobileDTO));
    }

    // Get all Forfaits Mobile
    public List<ForfaitMobileDTO> getAllForfaitsMobile() {
        List<ForfaitM> forfaits = new ArrayList<>();
        forfaitMRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitMobileMapper::toDto)
                .toList();
    }
        // Get Forfait Mobile by ID

    public ResponseEntity<ForfaitMobileDTO> getForfaitMobileById(UUID id) {
        Optional<ForfaitM> forfaitMOptional = forfaitMRepository.findById(id);
        return forfaitMOptional.map(forfaitMobileMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update Forfait Mobile

    public ResponseEntity<String> updateForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        // Validate input data
        if (forfaitMobileDTO == null || forfaitMobileDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!forfaitMRepository.existsById(forfaitMobileDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        ForfaitM forfaitM = forfaitMobileMapper.toEntity(forfaitMobileDTO);

        forfaitMRepository.save(forfaitM);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }


    // Delete Forfait Mobile

    public ResponseEntity<String> deleteForfaitMobile(UUID id) {
        if (!forfaitMRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        forfaitMRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Mobile Deleted Successfully");
    }
}
