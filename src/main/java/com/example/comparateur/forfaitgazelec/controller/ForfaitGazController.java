package com.example.comparateur.forfaitgazelec.controller;


import com.example.comparateur.forfaitgazelec.dto.ForfaitGazDto;
import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.service.ForfaitGazService;
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
    public ForfaitG createForfaitGaz(@RequestBody ForfaitGazDto forfaitGazDTO) {
        return forfaitGazService.createForfaitGaz(forfaitGazDTO);
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
