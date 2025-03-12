package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.forfaitgazelec.repository.ForfaitGazRepository;
import com.example.comparateur.forfaitgazelec.repository.TypeElecGazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ForfaitGazService {
    @Autowired
    private ForfaitGazRepository forfaitGazRepository;

    @Autowired
    private TypeElecGazRepository typeGazElectriciteRepository;

    public List<ForfaitG> getAllForfaitsGaz() {
        return forfaitGazRepository.findAll();
    }

    public ForfaitG getForfaitGazById(UUID id) {
        return forfaitGazRepository.findById(id).orElse(null);
    }

    public ForfaitG saveForfaitGaz(ForfaitG forfaitGaz, UUID typeGazElectriciteId) {
        TypeGE typeGazElectricite = typeGazElectriciteRepository.findById(typeGazElectriciteId).orElse(null);
        forfaitGaz.setTypeGaz(typeGazElectricite);
        return forfaitGazRepository.save(forfaitGaz);
    }

    public void deleteForfaitGaz(UUID id) {
        forfaitGazRepository.deleteById(id);
    }
}
