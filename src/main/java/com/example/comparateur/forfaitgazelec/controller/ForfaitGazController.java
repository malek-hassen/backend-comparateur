package com.example.comparateur.forfaitgazelec.controller;


import com.example.comparateur.forfaitgazelec.dto.ForfaitElectriciteDto;
import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.service.ForfaitGazService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfait/forfaits-gaz")
public class ForfaitGazController {


    private final ForfaitGazService forfaitGazService;

    public ForfaitGazController(ForfaitGazService forfaitGazService) {
        this.forfaitGazService = forfaitGazService;
    }



    @PostMapping("/save")
    public ResponseEntity<ForfaitGazDto> createForfaitGaz(@RequestBody ForfaitGazDto forfaitGazDto) {
        ForfaitGazDto createdForfaitGaz = forfaitGazService.createForfaitGaz(forfaitGazDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForfaitGaz);
    }



    @GetMapping("/all")
    public List<ForfaitGazDto> getAllForfaitGaz() {
        return forfaitGazService.getAllForfaitGaz();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitGazDto> getForfaitGazById(@PathVariable UUID id) {
        return forfaitGazService.getForfaitGazById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateForfaitGaz(@RequestBody ForfaitGazDto forfaitEGazDTO) {
        return forfaitGazService.updateForfaitGaz(forfaitEGazDTO);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteForfaitElec(@RequestParam UUID id) {
        return forfaitGazService.deleteForfaitGaz(id);
    }
}
