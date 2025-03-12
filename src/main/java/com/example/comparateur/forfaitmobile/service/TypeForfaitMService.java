package com.example.comparateur.forfaitmobile.service;


import com.example.comparateur.forfaitmobile.dto.TypeMobileDTO;
import com.example.comparateur.forfaitmobile.entity.TypeM;
import com.example.comparateur.forfaitmobile.mapper.TypeMobileMapper;
import com.example.comparateur.forfaitmobile.repository.TypeMobRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeForfaitMService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeForfaitMService.class);
    private final TypeMobRepository typeMobRepository;
    private final TypeMobileMapper typeMobileMapper;

    // Create a TypeMobile
    public ResponseEntity<String> createTypeMobile(TypeMobileDTO typeMobileDTO) {
        if (typeMobileDTO == null) {
            LOGGER.error("TypeMobileDTO is null");
            return new ResponseEntity<>("Invalid request data", HttpStatus.BAD_REQUEST);
        }

        TypeM typeMobile = typeMobileMapper.toEntity(typeMobileDTO);
        typeMobRepository.save(typeMobile);
        return new ResponseEntity<>("Type Mobile Created Successfully", HttpStatus.CREATED);
    }

    // Get all TypeMobiles
    public ResponseEntity<List<TypeMobileDTO>> getAllTypeMobiles() {
        List<TypeM> typeMobiles = typeMobRepository.findAll();
        List<TypeMobileDTO> dtoList = typeMobiles.stream()
                .map(typeMobileMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    // Get TypeMobile by ID
    public ResponseEntity<TypeMobileDTO> getTypeMobileById(UUID typeMid) {
        return typeMobRepository.findByTypeMid(typeMid)
                .map(typeMobileMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update TypeMobile
    public ResponseEntity<String> updateTypeMobile(TypeMobileDTO typeMobileDTO) {
        if (typeMobileDTO == null || typeMobileDTO.getTypeMid() == null) {
            return new ResponseEntity<>("Invalid request data", HttpStatus.BAD_REQUEST);
        }

        if (!typeMobRepository.existsByTypeMid(typeMobileDTO.getTypeMid())) {
            return new ResponseEntity<>("TypeMobile not found", HttpStatus.NOT_FOUND);
        }

        TypeM typeMobile = typeMobileMapper.toEntity(typeMobileDTO);
        typeMobRepository.save(typeMobile);
        return new ResponseEntity<>("Type Mobile Updated Successfully", HttpStatus.OK);
    }

    // Delete TypeMobile
    public ResponseEntity<String> deleteTypeMobile(UUID typeMid) {
        if (!typeMobRepository.existsByTypeMid(typeMid)) {
            return new ResponseEntity<>("TypeMobile not found", HttpStatus.NOT_FOUND);
        }

        typeMobRepository.deleteByTypeMid(typeMid);
        return new ResponseEntity<>("Type Mobile Deleted Successfully", HttpStatus.OK);
    }
}
