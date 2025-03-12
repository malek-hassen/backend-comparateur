package com.example.comparateur.forfaitgazelec.controller;

import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.service.ForfaitGazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfaits-gaz")
public class ForfaitGazController {

    @Autowired
    private ForfaitGazService forfaitGazService;

    @GetMapping
    public List<ForfaitG> getAllForfaitsGaz() {
        return forfaitGazService.getAllForfaitsGaz();
    }

    @GetMapping("/{id}")
    public ForfaitG getForfaitGazById(@PathVariable UUID id) {
        return forfaitGazService.getForfaitGazById(id);
    }

    @PostMapping
    public ForfaitG createForfaitGaz(@RequestBody ForfaitG forfaitGaz,
                                       @RequestParam UUID typeGazElectriciteId) {
        return forfaitGazService.saveForfaitGaz(forfaitGaz, typeGazElectriciteId);
    }

    @DeleteMapping("/{id}")
    public void deleteForfaitGaz(@PathVariable UUID id) {
        forfaitGazService.deleteForfaitGaz(id);
    }
}
