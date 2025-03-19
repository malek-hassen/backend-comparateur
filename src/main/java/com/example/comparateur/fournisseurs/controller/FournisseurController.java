package com.example.comparateur.fournisseurs.controller;

import com.example.comparateur.fournisseurs.dto.FournisseurDto;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import com.example.comparateur.fournisseurs.mapper.FournisseurMapper;
import com.example.comparateur.fournisseurs.service.FournisseursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

        private final FournisseursService fournisseursService;
        private final FournisseurMapper fournisseurMapper;


        @Autowired
        public FournisseurController(FournisseursService fournisseursService, FournisseurMapper fournisseurMapper) {
            this.fournisseursService = fournisseursService;
            this.fournisseurMapper = fournisseurMapper;
        }

        @GetMapping
        public ResponseEntity<List<FournisseurDto>> getAllFournisseur() {
            List<FournisseurDto> dtos = fournisseursService.getAllFournisseurs()
                    .stream()
                    .map(fournisseurMapper::toDto)
                    .toList();
            return ResponseEntity.ok(dtos);
        }

        @GetMapping("/{id}")
        public ResponseEntity<FournisseurDto> getFournisseursById(@PathVariable UUID id) {
            Fournisseurs fournisseurs = fournisseursService.getFournisseursById(id);
            if (fournisseurs == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(fournisseurMapper.toDto(fournisseurs));
        }


        @PostMapping("/create")
        public ResponseEntity<FournisseurDto> createFournisseurs(@RequestBody FournisseurDto dto) {
            Fournisseurs fournisseurs = fournisseursService.saveFournisseurs(dto);
            return ResponseEntity.ok(fournisseurMapper.toDto(fournisseurs));
        }


        @PutMapping("/update/{id}")
        public ResponseEntity<FournisseurDto> updateFournisseurs(@PathVariable UUID id, @RequestBody FournisseurDto dto) {
            Fournisseurs existingFournisseurs= fournisseursService.getFournisseursById(id);
            if (existingFournisseurs == null) {
                return ResponseEntity.notFound().build();
            }

            existingFournisseurs.setNom(dto.getNom());
            Fournisseurs updatedFournisseurs = fournisseursService.updateFournisseurs(existingFournisseurs);
            return ResponseEntity.ok(fournisseurMapper.toDto(updatedFournisseurs));
        }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteFournisseurs(@PathVariable UUID id) {
            Fournisseurs existingFournisseurs = fournisseursService.getFournisseursById(id);
            if (existingFournisseurs == null) {
                return ResponseEntity.notFound().build();
            }

            fournisseursService.deleteFournisseurs(id);
            return ResponseEntity.noContent().build();
        }
    }


