package com.example.comparateur.forfaitgazelec.service;


import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import com.example.comparateur.forfaitgazelec.repository.TypeElecGazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TypeElecGazService {
    @Autowired
    private TypeElecGazRepository typeGazElectriciteRepository;

    public List<TypeGE> getAllTypesGazElectricite() {
        return typeGazElectriciteRepository.findAll();
    }

    public TypeGE getTypeGazElectriciteById(UUID id) {
        return typeGazElectriciteRepository.findById(id).orElse(null);
    }

    public TypeGE saveTypeGazElectricite(TypeGE typeGazElectricite) {
        return typeGazElectriciteRepository.save(typeGazElectricite);
    }

    public void deleteTypeGazElectricite(UUID id) {
        typeGazElectriciteRepository.deleteById(id);
    }
}
