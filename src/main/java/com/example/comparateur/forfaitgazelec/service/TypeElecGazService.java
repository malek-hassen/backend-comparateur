package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.dto.TypeGazElecDto;
import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.forfaitgazelec.mapper.TypeGazElecMapper;
import com.example.comparateur.forfaitgazelec.repository.TypeElecGazRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeElecGazService {

    private final TypeElecGazRepository typeElecGazRepository;
    private final TypeGazElecMapper typeGazElecMapper;

    public TypeElecGazService(TypeElecGazRepository typeElecGazRepository, TypeGazElecMapper typeGazElecMapper) {
        this.typeElecGazRepository = typeElecGazRepository;
        this.typeGazElecMapper = typeGazElecMapper;
    }

    public ResponseEntity<String> createTypeGazElec(TypeGazElecDto typeGazElecDto) {
        if (typeGazElecDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        TypeGE typeGazElec = typeGazElecMapper.toEntity(typeGazElecDto);
        typeElecGazRepository.save(typeGazElec);
        return ResponseEntity.status(HttpStatus.CREATED).body("Type Mobile Created Successfully");
    }


    public ResponseEntity<List<TypeGazElecDto>> getAllTypeGazElec() {
        List<TypeGazElecDto> dtoList = ((List<TypeGE>) typeElecGazRepository.findAll()).stream()
                .map(typeGazElecMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }


    public ResponseEntity<TypeGazElecDto> getTypeGazElecById(UUID typeMid) {
        Optional<TypeGE> typeGazElecOptional = typeElecGazRepository.findByid(typeMid);
        return typeGazElecOptional.map(typeGazElecMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    public ResponseEntity<String> updateTypeGazElec(TypeGazElecDto typeGazElecDTO) {
        if (typeGazElecDTO == null || typeGazElecDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!typeElecGazRepository.existsById(typeGazElecDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        TypeGE typeGazElec = typeGazElecMapper.toEntity(typeGazElecDTO);
        typeElecGazRepository.save(typeGazElec);
        return ResponseEntity.ok("Type Mobile Updated Successfully");
    }


    public ResponseEntity<String> deleteTypeGazElec(UUID typeMid) {
        if (!typeElecGazRepository.existsById(typeMid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        typeElecGazRepository.deleteById(typeMid);
        return ResponseEntity.ok("Type Mobile Deleted Successfully");
    }
}
