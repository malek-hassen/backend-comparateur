package com.example.comparateur.forfaitmobile.service;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.mapper.ForfaitMobileMapper;
import com.example.comparateur.forfaitmobile.repository.ForfaitMRepository;
import com.example.comparateur.forfaitmobile.controller.ForfaitMobileResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ForfaitMobileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForfaitMobileService.class);
    private final ForfaitMobileMapper forfaitMobileMapper;
    private final ForfaitMRepository forfaitMobileRepository;


    public void createForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        if (forfaitMobileDTO == null) {
            LOGGER.error("forfaitMobileDTO is null");
            throw new IllegalArgumentException("forfaitMobileDTO cannot be null");
        }

        // Convert DTO to Entity
        ForfaitM forfaitMobile = forfaitMobileMapper.toEntity(forfaitMobileDTO);

        // Set default values if it's a new entity
        if (forfaitMobile.getId() == null) {
            forfaitMobile.setId(UUID.randomUUID());
            forfaitMobile.setVersion(0);
        }

        try {
            forfaitMobileRepository.save(forfaitMobile);
        } catch (Exception e) {
            LOGGER.error("Error occurred while saving ForfaitMobile: {}", e.getMessage(), e);
            throw new RuntimeException("Error saving forfaitMobile", e);
        }
    }


    public Page<ForfaitMobileDTO> getPaginatedForfaits(Pageable pageable) {
        Page<ForfaitM> forfaitPage = forfaitMobileRepository.findAll(pageable);
        return forfaitPage.map(forfaitMobileMapper::toDto);
    }


    public ResponseEntity<List<ForfaitMobileResponse>> getAllForfaitsMobile() {
        List<ForfaitM> forfaits = forfaitMobileRepository.findAll();
        List<ForfaitMobileResponse> responses = forfaits.stream()
                .map(forfaitMobileMapper::toResponse)
                .toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }


    public ForfaitM getForfaitMobileById(UUID id) {
        return forfaitMobileRepository.findById(id)
                .orElse(null);
    }


    public void updateForfaitMobile(ForfaitMobileDTO forfaitMobileDTO) {
        forfaitMobileRepository.save(forfaitMobileMapper.toEntity(forfaitMobileDTO));
    }


    public ResponseEntity<String> deleteForfaitMobile(UUID id) {
        LOGGER.debug("Attempting to delete forfait mobile with id: {}", id);
        try {
            ForfaitM forfaitMobile = forfaitMobileRepository.findById(id)
                    .orElse(null);

            if (forfaitMobile == null) {
                return new ResponseEntity<>("Forfait not found", HttpStatus.NOT_FOUND);
            }

            // Ensure related records in the join table (box_type) are removed
            forfaitMobile.getTypeBoxM().forEach(typeMobile -> typeMobile.getForfaitMobiles().remove(forfaitMobile));
            forfaitMobile.getTypeBoxM().clear();

            // Delete Forfait Mobile
            forfaitMobileRepository.delete(forfaitMobile);
            LOGGER.info("Successfully deleted forfait mobile with id: {}", id);
            return new ResponseEntity<>("Deleted forfait mobile", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error deleting forfait mobile with id: {}", id, e);
            return new ResponseEntity<>("Failed to delete forfait mobile", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
