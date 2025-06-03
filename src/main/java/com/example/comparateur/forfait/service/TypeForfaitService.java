package com.example.comparateur.forfait.service;


import com.example.comparateur.forfait.dto.TypeForfaitDTO;
import com.example.comparateur.forfait.entity.TypeForfait;
import com.example.comparateur.forfait.mapper.TypeForfaitMapper;
import com.example.comparateur.forfait.repository.TypeForfaitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeForfaitService {

    private final TypeForfaitRepository typeFRepository;
    private final TypeForfaitMapper typeFMapper;

    public TypeForfaitService(TypeForfaitRepository typeFRepository, TypeForfaitMapper typeFMapper) {
        this.typeFRepository = typeFRepository;
        this.typeFMapper = typeFMapper;
    }


    public ResponseEntity<String> createType(TypeForfaitDTO typeForfaitDTO) {
        if (typeForfaitDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        TypeForfait typeF = typeFMapper.toEntity(typeForfaitDTO);
        typeFRepository.save(typeF);
        return ResponseEntity.status(HttpStatus.CREATED).body("Type  Created Successfully");
    }


    public ResponseEntity<List<TypeForfaitDTO>> getAllType() {
        List<TypeForfaitDTO> dtoList = ((List<TypeForfait>) typeFRepository.findAll()).stream()
                .map(typeFMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }


    public ResponseEntity<TypeForfaitDTO> getTypeById(UUID id) {
        Optional<TypeForfait> typeInternetOptional = typeFRepository.findByid(id);
        return typeInternetOptional.map(typeFMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    public ResponseEntity<String> updateType(TypeForfaitDTO typeForfaitDTO) {
        if (typeForfaitDTO == null || typeForfaitDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!typeFRepository.existsById(typeForfaitDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Typenot found");
        }

        TypeForfait typeForfait = typeFMapper.toEntity(typeForfaitDTO);
        typeFRepository.save(typeForfait);
        return ResponseEntity.ok("Type Updated Successfully");
    }


    public ResponseEntity<String> deleteType(UUID id) {
        if (!typeFRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Typenot found");
        }

        typeFRepository.deleteById(id);
        return ResponseEntity.ok("Type Deleted Successfully");
    }
}
