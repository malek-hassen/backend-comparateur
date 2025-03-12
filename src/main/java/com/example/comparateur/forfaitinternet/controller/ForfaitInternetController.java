package com.example.comparateur.forfaitinternet.controller;

import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.service.ForfaitInternetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfaits-internet")
public class ForfaitInternetController {

    private ForfaitInternetService forfaitInternetService;

    @GetMapping
    public List<ForfaitInternet> getAllForfaitsInternet() {
        return forfaitInternetService.getAllForfaitsInternet();
    }

    @GetMapping("/{id}")
    public ForfaitInternet getForfaitInternetById(@PathVariable UUID id) {
        return forfaitInternetService.getForfaitInternetById(id);
    }


    @PostMapping
    public ForfaitInternet createForfaitInternet(@RequestBody ForfaitInternet forfaitInternet,
                                                 @RequestParam UUID typeForfaitInternetId,
                                                 @RequestParam UUID operateursId) {
        return forfaitInternetService.saveForfaitInternet(forfaitInternet, typeForfaitInternetId, operateursId);
    }

    @DeleteMapping("/{id}")
    public void deleteForfaitInternet(@PathVariable UUID id) {
        forfaitInternetService.deleteForfaitInternet(id);
    }
}

