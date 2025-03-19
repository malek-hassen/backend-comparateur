package com.example.comparateur.forfaitgazelec.controller;

import com.example.comparateur.forfaitgazelec.dto.TypeGazElecDto;
import com.example.comparateur.forfaitgazelec.service.TypeElecGazService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forfait/type-electricite-gaz")
public class TypeGazElecController {

    private final TypeElecGazService typeElecGazService;



    public TypeGazElecController(TypeElecGazService typeElecGazService) {
        this.typeElecGazService = typeElecGazService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTypeGazElec(@RequestBody TypeGazElecDto typeGazElecDTO) {
        return typeElecGazService.createTypeGazElec(typeGazElecDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TypeGazElecDto>> getAllTypeGazElec() {
        return typeElecGazService.getAllTypeGazElec();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<TypeGazElecDto> getTypeInternetById(@PathVariable UUID id) {
        return typeElecGazService.getTypeGazElecById(id);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateTypeGazElec(@RequestBody TypeGazElecDto typeGazElecDTO) {
        return typeElecGazService.updateTypeGazElec(typeGazElecDTO);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTypeGazElec(@RequestParam UUID id) {
        return typeElecGazService.deleteTypeGazElec(id);
    }

}

