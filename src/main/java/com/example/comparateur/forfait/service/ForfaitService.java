package com.example.comparateur.forfait.service;

import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface ForfaitService {
    ForfaitDto createForfait(ForfaitDto forfaitDto, Forfait forfait);
    ResponseEntity<String> updateForfait(ForfaitDto forfaitDto);
    List<ForfaitDto> getAllForfaits();
    ResponseEntity<ForfaitDto> getForfaitById(UUID id);
    ResponseEntity<String> deleteForfait(UUID id);
}
