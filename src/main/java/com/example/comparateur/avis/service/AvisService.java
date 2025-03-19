package com.example.comparateur.avis.service;

import com.example.comparateur.avis.entity.Avis;
import com.example.comparateur.avis.mapper.AvisMapper;
import com.example.comparateur.avis.repository.AvisRepository;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AvisService {
    private final AvisRepository repository;
    private final AvisMapper avisMapper;

    public AvisService(AvisRepository repository, AvisMapper avisMapper) {
        this.repository = repository;
        this.avisMapper = avisMapper;
    }
    public Avis findById(UUID id) {
        return repository.findById(id).orElse(null);
    }
    public Avis save(Avis avis) {
        return repository.save(avis);

    }
    public void delete(Avis avis) {
        repository.delete(avis);
    }
    public List<Avis> findAll() {
        List<Avis> forfaits = new ArrayList<>();
        repository.findAll().forEach(forfaits::add);
        return forfaits.stream()
                .map(avisMapper::toDto)
                .toList();
    }

}
