package com.example.comparateur.forfaitmobile.controller;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfaits-mobiles")
@RequiredArgsConstructor
public class ForfaitMController {

    private final ForfaitMobileService forfaitMService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ForfaitMController.class);

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createForfaitMobile(@RequestBody ForfaitMobileDTO forfaitMDTO) {
        try {
            forfaitMService.createForfaitMobile(forfaitMDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Forfait créé avec succès");
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid request data: {}", e.getMessage(), e);
            return ResponseEntity.badRequest().body("Invalid request data: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error creating forfait mobile: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating forfait mobile");
        }
    }


    @GetMapping("/paginated")
    public ResponseEntity<Page<ForfaitMobileDTO>> getPaginatedForfaits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ForfaitMobileDTO> forfaitsPage = forfaitMService.getPaginatedForfaits(pageable);
        return ResponseEntity.ok(forfaitsPage);
    }


    @GetMapping("/get")
    public ResponseEntity<List<ForfaitMobileResponse>> getAllForfaits() {
        return forfaitMService.getAllForfaitsMobile();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getForfaitById(@PathVariable UUID id) {
        ForfaitM forfait = forfaitMService.getForfaitMobileById(id);
        if (forfait == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait not found");
        }
        return ResponseEntity.ok(forfait);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateForfait(@PathVariable UUID id, @RequestBody ForfaitMobileDTO forfaitMDTO) {
        ForfaitM existingForfait = forfaitMService.getForfaitMobileById(id);
        if (existingForfait == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait not found");
        }

        forfaitMDTO.setId(id); // Ensure we update the correct entity
        forfaitMService.updateForfaitMobile(forfaitMDTO);
        return ResponseEntity.ok("Forfait mis à jour avec succès");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteForfait(@PathVariable UUID id) {
        try {
            ResponseEntity<String> response = forfaitMService.deleteForfaitMobile(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error deleting forfait mobile with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete forfait mobile");
        }
    }
}
