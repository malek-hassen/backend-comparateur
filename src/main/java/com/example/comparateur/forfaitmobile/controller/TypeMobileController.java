package com.example.comparateur.forfaitmobile.controller;




import com.example.comparateur.forfaitmobile.dto.TypeMobileDTO;
import com.example.comparateur.forfaitmobile.service.TypeForfaitMService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/type-mobiles")
@RequiredArgsConstructor
public class TypeMobileController {
    private final TypeForfaitMService typeMobileService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeMobileController.class);

    // Create a TypeMobile
    @PostMapping("/create")
    public ResponseEntity<String> createTypeMobile(@RequestBody TypeMobileDTO typeMobileDTO) {
        return typeMobileService.createTypeMobile(typeMobileDTO);
    }

    // Get all TypeMobiles
    @GetMapping("/all")
    public ResponseEntity<List<TypeMobileDTO>> getAllTypeMobiles() {
        return typeMobileService.getAllTypeMobiles();
    }

    // Get a TypeMobile by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<TypeMobileDTO> getTypeMobileById(@PathVariable UUID id) {
        return typeMobileService.getTypeMobileById(id);
    }

    // Update TypeMobile
    @PutMapping("/update")
    public ResponseEntity<String> updateTypeMobile(@RequestBody TypeMobileDTO typeMobileDTO) {
        return typeMobileService.updateTypeMobile(typeMobileDTO);
    }

    // Delete TypeMobile
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTypeMobile(@RequestParam UUID id) {
        return typeMobileService.deleteTypeMobile(id);
    }
}

