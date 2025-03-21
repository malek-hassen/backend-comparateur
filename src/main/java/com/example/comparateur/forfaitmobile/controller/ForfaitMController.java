package com.example.comparateur.forfaitmobile.controller;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfait/forfaits-mobiles")
@RequiredArgsConstructor
public class ForfaitMController {

    private final ForfaitMobileService forfaitMobileService;

    // Create a Forfait Mobile
    @PostMapping("/save")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ForfaitM createForfaitMobile(@RequestBody ForfaitMobileDTO forfaitMobileDTO) {
        return forfaitMobileService.createForfaitMobile(forfaitMobileDTO);
    }

    // Get all Forfaits Mobile
    @GetMapping("/all")
    public List<ForfaitMobileDTO> getAllForfaitsMobile() {
        return forfaitMobileService.getAllForfaitsMobile();
    }

    // Get a Forfait Mobile by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitMobileDTO> getForfaitMobileById(@PathVariable UUID id) {
        return forfaitMobileService.getForfaitMobileById(id);
    }

    // Update Forfait Mobile
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateForfaitMobile(@RequestBody ForfaitMobileDTO forfaitMobileDTO, @PathVariable UUID id) {
        return forfaitMobileService.updateForfaitMobile(forfaitMobileDTO);
    }

    // Delete Forfait Mobile
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteForfaitMobile(@RequestParam UUID id) {
        return forfaitMobileService.deleteForfaitMobile(id);
    }
}
