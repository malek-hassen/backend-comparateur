package com.example.comparateur.forfaitinternet.controller;

import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.service.ForfaitInternetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfait/forfaits-internet")
public class ForfaitInternetController {


    private final ForfaitInternetService forfaitInternetService;

    public ForfaitInternetController(ForfaitInternetService forfaitInternetService) {
        this.forfaitInternetService = forfaitInternetService;
    }


    @PostMapping("/save")
    public ResponseEntity<ForfaitInternetDto> createForfaitInternet(@RequestBody ForfaitInternetDto forfaitInternetDTO) {
        ForfaitInternetDto createdForfaitInternet = forfaitInternetService.createForfaitInternet(forfaitInternetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForfaitInternet);
    }


    @GetMapping("/all")
    public List<ForfaitInternetDto> getAllForfaitInternet() {
        return forfaitInternetService.getAllForfaitInternet();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ForfaitInternetDto> getForfaitInternetById(@PathVariable UUID id) {
        return forfaitInternetService.getForfaitInternetById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateForfaitInternet(@RequestBody ForfaitInternetDto ForfaitInternetDTO) {
        return forfaitInternetService.updateForfaitInternet(ForfaitInternetDTO);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteForfaitInternet(@PathVariable UUID id) {
        return forfaitInternetService.deleteForfaitInternet(id);
    }

}

