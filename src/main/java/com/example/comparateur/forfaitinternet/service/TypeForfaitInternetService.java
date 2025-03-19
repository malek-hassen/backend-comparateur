package com.example.comparateur.forfaitinternet.service;


import com.example.comparateur.forfaitinternet.dto.TypeInternetDto;
import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import com.example.comparateur.forfaitinternet.mapper.TypeInternetMapper;
import com.example.comparateur.forfaitinternet.repository.TypeIntRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeForfaitInternetService {

  private final TypeIntRepository typeIntRepository;
  private final TypeInternetMapper typeInternetMapper;

    public TypeForfaitInternetService(TypeIntRepository typeIntRepository, TypeInternetMapper typeInternetMapper) {
        this.typeIntRepository = typeIntRepository;
        this.typeInternetMapper = typeInternetMapper;
    }

    public ResponseEntity<String> createTypeInternet(TypeInternetDto typeInternetDTO) {
        if (typeInternetDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        TypeInternet typeInternet = typeInternetMapper.toEntity(typeInternetDTO);
        typeIntRepository.save(typeInternet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Type Mobile Created Successfully");
    }


    public ResponseEntity<List<TypeInternetDto>> getAllTypeInternet() {
        List<TypeInternetDto> dtoList = ((List<TypeInternet>) typeIntRepository.findAll()).stream()
                .map(typeInternetMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }


    public ResponseEntity<TypeInternetDto> getTypeInternetById(UUID typeMid) {
        Optional<TypeInternet> typeInternetOptional = typeIntRepository.findByid(typeMid);
        return typeInternetOptional.map(typeInternetMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    public ResponseEntity<String> updateTypeInternet(TypeInternetDto typeInternetDTO) {
        if (typeInternetDTO == null || typeInternetDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!typeIntRepository.existsById(typeInternetDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        TypeInternet typeInternet = typeInternetMapper.toEntity(typeInternetDTO);
        typeIntRepository.save(typeInternet);
        return ResponseEntity.ok("Type Mobile Updated Successfully");
    }


    public ResponseEntity<String> deleteTypeInternet(UUID typeMid) {
        if (!typeIntRepository.existsById(typeMid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        typeIntRepository.deleteById(typeMid);
        return ResponseEntity.ok("Type Mobile Deleted Successfully");
    }
}
