package com.example.comparateur.forfait.controller;

import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfait.service.ForfaitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfait")
@RequiredArgsConstructor

public class ForfaitController {
    private final ForfaitService forfaitService;

    // Create a Forfait
    @PostMapping("/save")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public Forfait createForfait(@RequestBody ForfaitDto forfaitDTO) {
        return forfaitService.createForfait(forfaitDTO);
    }

    // Get all Forfaits
    @GetMapping("/all")
    public List<ForfaitDto> getAllForfaits() {
        return forfaitService.getAllForfaits();
    }

    // Get a Forfait  by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitDto> getForfaitById(@PathVariable UUID id) {
        return forfaitService.getForfaitById(id);
    }

    // Update Forfait
    @PutMapping("/update")
    public ResponseEntity<String> updateForfait(@RequestBody ForfaitDto forfaitDTO) {
        return forfaitService.updateForfait(forfaitDTO);
    }

    // Delete Forfait
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteForfait(@RequestParam UUID id) {
        return forfaitService.deleteForfait(id);
    }
}
