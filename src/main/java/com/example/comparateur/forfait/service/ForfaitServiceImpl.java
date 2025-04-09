package com.example.comparateur.forfait.service;


import com.example.comparateur.forfait.dto.ForfaitDto;
import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfait.mapper.ForfaitMapper;
import com.example.comparateur.forfait.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ForfaitServiceImpl implements ForfaitService {
    private final ForfaitRepository forfaitRepository;
    private final ForfaitMapper forfaitMapper;

    @Autowired
    public ForfaitServiceImpl(ForfaitRepository forfaitRepository, ForfaitMapper forfaitMapper) {
        this.forfaitRepository = forfaitRepository;
        this.forfaitMapper = forfaitMapper;
    }

    @Override
    public ForfaitDto createForfait(ForfaitDto forfaitDto, Forfait forfaits) {
        Forfait forfait = forfaitMapper.toEntity(forfaitDto, forfaits);
        Forfait savedForfait = forfaitRepository.save(forfait);
        return forfaitMapper.toDto(savedForfait);
    }

    @Override
    public ResponseEntity<String> updateForfait(ForfaitDto forfaitDto) {
        return null;
    }

    // Update other methods to use instance methods too
    @Override
    public ResponseEntity<ForfaitDto> getForfaitById(UUID id) {
        return forfaitRepository.findById(id)
                .map(forfait -> ResponseEntity.ok(forfaitMapper.toDto(forfait)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<ForfaitDto> getAllForfaits() {
        List<Forfait> forfaits = forfaitRepository.findAll();
        return forfaits.stream()
                .map(forfait -> forfaitMapper.toDto(forfait))
                .collect(Collectors.toList());
    }


    @Override
    public ResponseEntity<String> deleteForfait(UUID id) {
        forfaitRepository.deleteById(id);
        return ResponseEntity.ok("Forfait deleted");
    }
}