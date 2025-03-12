package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.forfaitgazelec.repository.ForfaitElecRepository;
import com.example.comparateur.forfaitgazelec.repository.TypeElecGazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ForfaitElecService {
    @Autowired
    private ForfaitElecRepository forfaitElectriciteRepository;

    @Autowired
    private TypeElecGazRepository typeGazElectriciteRepository;

    public List<ForfaitE> getAllForfaitsElectricite() {
        return forfaitElectriciteRepository.findAll();
    }

    public ForfaitE getForfaitElectriciteById(UUID id) {
        return forfaitElectriciteRepository.findById(id).orElse(null);
    }

    public ForfaitE saveForfaitElectricite(ForfaitE forfaitElectricite, UUID typeGazElectriciteId) {
        TypeGE typeGazElectricite = typeGazElectriciteRepository.findById(typeGazElectriciteId).orElse(null);
        forfaitElectricite.setTypeElectricite(typeGazElectricite);
        return forfaitElectriciteRepository.save(forfaitElectricite);
    }

    public void deleteForfaitElectricite(UUID id) {
        forfaitElectriciteRepository.deleteById(id);
    }
}
