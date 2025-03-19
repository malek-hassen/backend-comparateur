package com.example.comparateur.forfaitinternet.controller;

import com.example.comparateur.forfaitinternet.dto.TypeInternetDto;
import com.example.comparateur.forfaitinternet.service.TypeForfaitInternetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfait/type-internet")
public class TypeInternetController {
    private final TypeForfaitInternetService typeInternetService;

    public TypeInternetController(TypeForfaitInternetService typeInternetService) {
        this.typeInternetService = typeInternetService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTypeInternet(@RequestBody TypeInternetDto typeInternetDTO) {
        return typeInternetService.createTypeInternet(typeInternetDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TypeInternetDto>> getAllTypeInternet() {
        return typeInternetService.getAllTypeInternet();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<TypeInternetDto> getTypeInternetById(@PathVariable UUID id) {
        return typeInternetService.getTypeInternetById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateTypeInternet(@RequestBody TypeInternetDto typeInternetDTO) {
        return typeInternetService.updateTypeInternet(typeInternetDTO);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTypeInternet(@RequestParam UUID id) {
        return typeInternetService.deleteTypeInternet(id);
    }
}
