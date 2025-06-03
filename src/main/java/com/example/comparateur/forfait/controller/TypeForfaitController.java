package com.example.comparateur.forfait.controller;

import com.example.comparateur.forfait.dto.TypeForfaitDTO;
import com.example.comparateur.forfait.service.TypeForfaitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfait/type-forfait")
public class TypeForfaitController {
    private final TypeForfaitService typeFService;

    public TypeForfaitController(TypeForfaitService typeFService) {
        this.typeFService = typeFService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createType(@RequestBody TypeForfaitDTO typeForfaitDTO) {
        return typeFService.createType(typeForfaitDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TypeForfaitDTO>> getAllType() {
        return typeFService.getAllType();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<TypeForfaitDTO> getTypeById(@PathVariable UUID id) {
        return typeFService.getTypeById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateType(@RequestBody TypeForfaitDTO typeForfaitDTO) {
        return typeFService.updateType(typeForfaitDTO);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteType(@RequestParam UUID id) {
        return typeFService.deleteType(id);
    }
}
