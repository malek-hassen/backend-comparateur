package com.example.comparateur.forfaitinternet.controller;

import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.service.ForfaitInternetService;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import com.example.comparateur.forfaitmobile.service.ForfaitMobileService;
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
    public ForfaitInternet createForfaitInternet(@RequestBody ForfaitInternetDto ForfaitInternetDTO) {
        return forfaitInternetService.createForfaitInternet(ForfaitInternetDTO);
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


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteForfaitInternet(@RequestParam UUID id) {
        return forfaitInternetService.deleteForfaitInternet(id);
    }

}

