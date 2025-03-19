package com.example.comparateur.operateur.controller;



import com.example.comparateur.operateur.dto.OperateurDTO;
import com.example.comparateur.operateur.entity.Operateur;
import com.example.comparateur.operateur.mapper.OperateurMapper;
import com.example.comparateur.operateur.service.OperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/operateur")
public class OperateurController {

    private final OperateurService operateurService;
    private final OperateurMapper operateurMapper;


    @Autowired
    public OperateurController(OperateurService operateurService, OperateurMapper operateurMapper) {
        this.operateurService = operateurService;
        this.operateurMapper = operateurMapper;
    }
    @PreAuthorize("@privilegeService.hasPrivilege('MANAGEMENT', 'BUILDINGS', 'READ')")
    @GetMapping
    public ResponseEntity<List<OperateurDTO>> getAllOperateurs() {
        List<OperateurDTO> dtos = operateurService.getAllOperateurs()
                .stream()
                .map(operateurMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }
    @PreAuthorize("@privilegeService.hasPrivilege('MANAGEMENT', 'BUILDINGS', 'READ')")
    @GetMapping("/{id}")
    public ResponseEntity<OperateurDTO> getOperateurById(@PathVariable UUID id) {
        Operateur operateur = operateurService.getOperateursById(id);
        if (operateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operateurMapper.toDto(operateur));
    }

    @PreAuthorize("@privilegeService.hasPrivilege('MANAGEMENT', 'BUILDINGS', 'WRITE')")
    @PostMapping("/create_operator")
    public ResponseEntity<OperateurDTO> createOperateur(@RequestBody OperateurDTO dto) {
        Operateur operateur = operateurService.saveOperateurs(dto);
        return ResponseEntity.ok(operateurMapper.toDto(operateur));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<OperateurDTO> updateOperateur(@PathVariable UUID id, @RequestBody OperateurDTO dto) {
        Operateur existingOperateur = operateurService.getOperateursById(id);
        if (existingOperateur == null) {
            return ResponseEntity.notFound().build();
        }

        existingOperateur.setNom(dto.getNom());
        Operateur updatedOperateur = operateurService.updateOperateurs(existingOperateur);
        return ResponseEntity.ok(operateurMapper.toDto(updatedOperateur));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOperateur(@PathVariable UUID id) {
        Operateur existingOperateur = operateurService.getOperateursById(id);
        if (existingOperateur == null) {
            return ResponseEntity.notFound().build();
        }

        operateurService.deleteOperateurs(id);
        return ResponseEntity.noContent().build();
    }
}
