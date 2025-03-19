package com.example.comparateur.forfaitinternet.service;

import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.mapper.ForfaitInternetMapper;
import com.example.comparateur.forfaitinternet.repository.ForfaitInternetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForfaitInternetService {


    private final ForfaitInternetRepository forfaitInternetRepository;
    private final ForfaitInternetMapper forfaitInternetMapper;

    public ForfaitInternetService(ForfaitInternetRepository forfaitInternetRepository, ForfaitInternetMapper forfaitInternetMapper) {
        this.forfaitInternetRepository = forfaitInternetRepository;
        this.forfaitInternetMapper = forfaitInternetMapper;
    }

    public ForfaitInternet createForfaitInternet(ForfaitInternetDto forfaitInternetDTO) {
        return forfaitInternetRepository.save(forfaitInternetMapper.toEntity(forfaitInternetDTO));
    }


    public List<ForfaitInternetDto> getAllForfaitInternet() {
        List<ForfaitInternet> forfaits = new ArrayList<>();
        forfaitInternetRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitInternetMapper::toDto)
                .toList();
    }


    public ResponseEntity<ForfaitInternetDto> getForfaitInternetById(UUID id) {
        Optional<ForfaitInternet> forfaitInternetOptional = forfaitInternetRepository.findById(id);
        return forfaitInternetOptional.map(forfaitInternetMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    public ResponseEntity<String> updateForfaitInternet(ForfaitInternetDto forfaitInternetDTO) {
        if (forfaitInternetDTO == null || forfaitInternetDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        if (!forfaitInternetRepository.existsById(forfaitInternetDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        ForfaitInternet forfaitInternet =forfaitInternetMapper.toEntity(forfaitInternetDTO);
        forfaitInternet= forfaitInternetRepository.findById(forfaitInternet.getId())
                .orElseThrow(() -> new RuntimeException("Forfait not found")); // Fetch entity
        forfaitInternetRepository.save(forfaitInternet);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }



    public ResponseEntity<String> deleteForfaitInternet (UUID id) {
        if (!forfaitInternetRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Internet not found");
        }

        forfaitInternetRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Internet Deleted Successfully");
    }
}

