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

    @PostMapping("/save")
    public ForfaitDto createForfait(@RequestBody ForfaitDto forfaitDto, Forfait forfait) {
        return forfaitService.createForfait(forfaitDto,forfait);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ForfaitDto>> getAllForfaits() {
        List<ForfaitDto> forfaits = forfaitService.getAllForfaits();

        // If no forfaits are found, an empty list is returned.
        return ResponseEntity.ok(forfaits);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitDto> getForfaitById(@PathVariable UUID id) {
        return forfaitService.getForfaitById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateForfait(@RequestBody ForfaitDto forfaitDto) {
        return forfaitService.updateForfait(forfaitDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteForfait(@PathVariable UUID id) {
        return forfaitService.deleteForfait(id);
    }
}