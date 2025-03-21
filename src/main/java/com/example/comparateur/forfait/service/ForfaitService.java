package com.example.comparateur.forfait.service;

import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfait.mapper.ForfaitMapper;
import com.example.comparateur.forfait.repository.ForfaitRepository;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForfaitService {


    private final ForfaitRepository forfaitRepository;
    private final ForfaitMapper forfaitMapper;

    public ForfaitService(ForfaitRepository forfaitRepository, ForfaitMapper forfaitMapper) {
        this.forfaitRepository = forfaitRepository;
        this.forfaitMapper = forfaitMapper;
    }
    public Forfait createForfait(ForfaitDto forfaitDTO) {
        return forfaitRepository.save(forfaitMapper.toEntity(forfaitDTO));
    }


    // Get all Forfaits
    public List<ForfaitDto> getAllForfaits() {
        List<Forfait> forfaits = new ArrayList<>();
        forfaitRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitMapper::toDto)
                .toList();
    }
    // Get Forfait by ID

    public ResponseEntity<ForfaitDto> getForfaitById(UUID id) {
        Optional<Forfait> forfaitOptional = forfaitRepository.findById(id);
        return forfaitOptional.map(forfaitMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update Forfait

    public ResponseEntity<String> updateForfait(ForfaitDto forfaitDTO) {
        if (forfaitDTO == null || forfaitDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!forfaitRepository.existsById(forfaitDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        Forfait forfait = forfaitMapper.toEntity(forfaitDTO);
        forfait = forfaitRepository.findById(forfait.getId())
                .orElseThrow(() -> new RuntimeException("Forfait not found")); // Fetch entity
        forfaitRepository.save(forfait);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }

    // Delete Forfait

    public ResponseEntity<String> deleteForfait(UUID id) {
        if (!forfaitRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        forfaitRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Mobile Deleted Successfully");
    }
}
