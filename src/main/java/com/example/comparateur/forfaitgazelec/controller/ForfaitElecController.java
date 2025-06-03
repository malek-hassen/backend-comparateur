package com.example.comparateur.forfaitgazelec.controller;

import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.service.ForfaitElecService;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfait/forfaits-electricite")
public class ForfaitElecController {


    private final ForfaitElecService forfaitElecService;

    public ForfaitElecController(ForfaitElecService forfaitElecService) {
        this.forfaitElecService = forfaitElecService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ForfaitElectriciteDto> createForfaitElectricite(@RequestBody ForfaitElectriciteDto forfaitElectriciteDto) {
        ForfaitElectriciteDto createdForfaitElectricite = forfaitElecService.createForfaitElectricite(forfaitElectriciteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForfaitElectricite);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public List<ForfaitElectriciteDto> getAllForfaitElec() {
        return forfaitElecService.getAllForfaitElectricite();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitElectriciteDto> getForfaitElectById(@PathVariable UUID id) {
        return forfaitElecService.getForfaitElectriciteById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateForfaitElec(@RequestBody ForfaitElectriciteDto forfaitElectriciteDTO) {
        return forfaitElecService.updateForfaitElectricite(forfaitElectriciteDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteForfaitElec(@RequestParam UUID id) {
        return forfaitElecService.deleteForfaitElectricite(id);
    }
}
