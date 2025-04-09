package com.example.comparateur.forfaitmobile.controller;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/forfait/forfaits-mobiles")
public class ForfaitMController {

    private final ForfaitMobileService forfaitMobileService;

    @Autowired
    public ForfaitMController(ForfaitMobileService forfaitMobileService) {
        this.forfaitMobileService = forfaitMobileService;
    }

    // Endpoint to create a ForfaitMobile
    @PostMapping("/save")
    public ResponseEntity<ForfaitMobileDTO> createForfaitMobile(@RequestBody ForfaitMobileDTO forfaitMobileDTO) {
        ForfaitMobileDTO createdForfaitMobile = forfaitMobileService.createForfaitMobile(forfaitMobileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForfaitMobile);
    }

    // Endpoint to get all ForfaitMobiles
    @GetMapping("/all")
    public List<ForfaitMobileDTO> getAllForfaits() {
        return forfaitMobileService.getAllForfaits();
    }

    // Endpoint to get a ForfaitMobile by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitMobileDTO> getForfaitMobileById(@PathVariable UUID id) {
        return forfaitMobileService.getForfaitById(id);
    }

    // Endpoint to update a ForfaitMobile
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateForfaitMobile(@RequestBody ForfaitMobileDTO forfaitMobileDTO, @PathVariable UUID id) {
        forfaitMobileDTO.setId(id); // Ensure ID from path is used
        return forfaitMobileService.updateForfaitMobile(forfaitMobileDTO);
    }

    // Endpoint to delete a ForfaitMobile by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteForfaitMobile(@PathVariable UUID id) {
        return forfaitMobileService.deleteForfait(id);
    }
}