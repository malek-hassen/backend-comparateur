package com.example.comparateur.forfaitmobile.service;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.mapper.ForfaitMobileMapper;
import com.example.comparateur.forfaitmobile.repository.ForfaitMRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ForfaitMobileService {

    private final ForfaitMRepository forfaitMRepository;
    private final ForfaitMobileMapper forfaitMobileMapper;

    public ForfaitMobileService(ForfaitMRepository forfaitMRepository,
                                ForfaitMobileMapper forfaitMobileMapper) {
        this.forfaitMRepository = forfaitMRepository;
        this.forfaitMobileMapper = forfaitMobileMapper;
    }

    public ForfaitMobileDTO createForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        // Create a new ForfaitM instance
        ForfaitM forfaitMobile = new ForfaitM();

        // Set basic properties from DTO
        forfaitMobile.setTitle(forfaitMobileDTO.getTitle());
        forfaitMobile.setDescription(forfaitMobileDTO.getDescription());
        forfaitMobile.setLien(forfaitMobileDTO.getLien());
        forfaitMobile.setResume(forfaitMobileDTO.getResume());
        forfaitMobile.setPricebase(forfaitMobileDTO.getPricebase());
        forfaitMobile.setPriceoffre(forfaitMobileDTO.getPriceoffre());
        forfaitMobile.setPeriodoffre(forfaitMobileDTO.getPeriodoffre());
        forfaitMobile.setIswitheng(forfaitMobileDTO.isIswitheng());
        forfaitMobile.setDureeofeng(forfaitMobileDTO.getDureeofeng());
        forfaitMobile.setVisibilite(forfaitMobileDTO.isVisibilite());
        forfaitMobile.setDtype("ForfaitMobile");

        // Set ForfaitM-specific attributes
        forfaitMobile.setDebit(forfaitMobileDTO.getDebit());
        forfaitMobile.setTypeDebit(forfaitMobileDTO.getTypeDebit());
        forfaitMobile.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        forfaitMobile.setHeure(forfaitMobileDTO.getHeure());
        forfaitMobile.setWith5G(forfaitMobileDTO.isWith5G());
        forfaitMobile.setValue(forfaitMobileDTO.getValue());
        forfaitMobile.setIsBlocked(forfaitMobileDTO.isBlocked());
        forfaitMobile.setOperateur(forfaitMobileDTO.getOperateur());
        forfaitMobile.setTypeM(forfaitMobileDTO.getTypeBoxM());

        // Save the ForfaitM entity to the repository
        ForfaitM savedForfaitMobile = forfaitMRepository.save(forfaitMobile);

        return forfaitMobileMapper.toDto(savedForfaitMobile);
    }

    public List<ForfaitMobileDTO> getAllForfaits() {
        List<ForfaitM> entities = forfaitMRepository.findAll();
        return entities.stream()
                .map(forfaitMobileMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<ForfaitMobileDTO> getForfaitById(UUID id) {
        Optional<ForfaitM> forfaitMobileOptional = forfaitMRepository.findById(id);
        return forfaitMobileOptional.map(forfaitMobileMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<String> deleteForfait(UUID id) {
        if (!forfaitMRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        forfaitMRepository.deleteById(id);
        return ResponseEntity.ok("Forfait Mobile Deleted Successfully");
    }

    public ResponseEntity<String> updateForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        if (forfaitMobileDTO == null || forfaitMobileDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        Optional<ForfaitM> forfaitMobileOptional = forfaitMRepository.findById(forfaitMobileDTO.getId());
        if (forfaitMobileOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        ForfaitM existingForfaitMobile = forfaitMobileOptional.get();

        // Update base Forfait properties
        existingForfaitMobile.setTitle(forfaitMobileDTO.getTitle());
        existingForfaitMobile.setDescription(forfaitMobileDTO.getDescription());
        existingForfaitMobile.setLien(forfaitMobileDTO.getLien());
        existingForfaitMobile.setResume(forfaitMobileDTO.getResume());
        existingForfaitMobile.setPricebase(forfaitMobileDTO.getPricebase());
        existingForfaitMobile.setPriceoffre(forfaitMobileDTO.getPriceoffre());
        existingForfaitMobile.setPeriodoffre(forfaitMobileDTO.getPeriodoffre());
        existingForfaitMobile.setIswitheng(forfaitMobileDTO.isIswitheng());
        existingForfaitMobile.setDureeofeng(forfaitMobileDTO.getDureeofeng());
        existingForfaitMobile.setVisibilite(forfaitMobileDTO.isVisibilite());

        // Update ForfaitM-specific properties
        existingForfaitMobile.setDebit(forfaitMobileDTO.getDebit());
        existingForfaitMobile.setTypeDebit(forfaitMobileDTO.getTypeDebit());
        existingForfaitMobile.setPrixSIM(forfaitMobileDTO.getPrixSIM());
        existingForfaitMobile.setHeure(forfaitMobileDTO.getHeure());
        existingForfaitMobile.setWith5G(forfaitMobileDTO.isWith5G());
        existingForfaitMobile.setValue(forfaitMobileDTO.getValue());
        existingForfaitMobile.setIsBlocked(forfaitMobileDTO.isBlocked());
        existingForfaitMobile.setOperateur(forfaitMobileDTO.getOperateur());
        existingForfaitMobile.setTypeM(forfaitMobileDTO.getTypeBoxM());

        // Save the updated entity
        forfaitMRepository.save(existingForfaitMobile);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }
}