package com.example.comparateur.forfaitgazelec.controller;

import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.service.ForfaitElecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfaits-electricite")
public class ForfaitElecController {
    @Autowired
    private ForfaitElecService forfaitElectriciteService;

    @GetMapping
    public List<ForfaitE> getAllForfaitsElectricite() {
        return forfaitElectriciteService.getAllForfaitsElectricite();
    }

    @GetMapping("/{id}")
    public ForfaitE getForfaitElectriciteById(@PathVariable UUID id) {
        return forfaitElectriciteService.getForfaitElectriciteById(id);
    }

    @PostMapping
    public ForfaitE createForfaitElectricite(@RequestBody ForfaitE forfaitElectricite,
                                                       @RequestParam UUID typeGazElectriciteId) {
        return forfaitElectriciteService.saveForfaitElectricite(forfaitElectricite, typeGazElectriciteId);
    }

    @DeleteMapping("/{id}")
    public void deleteForfaitElectricite(@PathVariable UUID id) {
        forfaitElectriciteService.deleteForfaitElectricite(id);
    }
}
