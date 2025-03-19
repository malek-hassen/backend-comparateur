package com.example.comparateur.forfaitmobile.service;


import com.example.comparateur.forfaitmobile.dto.TypeMobileDTO;
import com.example.comparateur.forfaitmobile.entity.TypeM;
import com.example.comparateur.forfaitmobile.mapper.TypeMobileMapper;
import com.example.comparateur.forfaitmobile.repository.TypeMobRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeForfaitMService {

    private final TypeMobRepository typeMobRepository;
    private final TypeMobileMapper typeMobileMapper;

    // Create a TypeMobile
    public ResponseEntity<String> createTypeMobile(TypeMobileDTO typeMobileDTO) {
        if (typeMobileDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        TypeM typeMobile = typeMobileMapper.toEntity(typeMobileDTO);
        typeMobRepository.save(typeMobile);
        return ResponseEntity.status(HttpStatus.CREATED).body("Type Mobile Created Successfully");
    }

    // Get all TypeMobiles
    public ResponseEntity<List<TypeMobileDTO>> getAllTypeMobiles() {
        List<TypeMobileDTO> dtoList = ((List<TypeM>) typeMobRepository.findAll()).stream()
                .map(typeMobileMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    // Get TypeMobile by ID
    public ResponseEntity<TypeMobileDTO> getTypeMobileById(UUID typeMid) {
        Optional<TypeM> typeMOptional = typeMobRepository.findByTypeMid(typeMid);
        return typeMOptional.map(typeMobileMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update TypeMobile
    public ResponseEntity<String> updateTypeMobile(TypeMobileDTO typeMobileDTO) {
        if (typeMobileDTO == null || typeMobileDTO.getTypeMid() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!typeMobRepository.existsByTypeMid(typeMobileDTO.getTypeMid())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        TypeM typeMobile = typeMobileMapper.toEntity(typeMobileDTO);
        typeMobRepository.save(typeMobile);
        return ResponseEntity.ok("Type Mobile Updated Successfully");
    }

    // Delete TypeMobile
    public ResponseEntity<String> deleteTypeMobile(UUID typeMid) {
        if (!typeMobRepository.existsByTypeMid(typeMid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeMobile not found");
        }

        typeMobRepository.deleteByTypeMid(typeMid);
        return ResponseEntity.ok("Type Mobile Deleted Successfully");
    }
}

