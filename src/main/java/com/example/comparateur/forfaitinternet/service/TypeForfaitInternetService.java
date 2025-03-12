package com.example.comparateur.forfaitinternet.service;


import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import com.example.comparateur.forfaitinternet.repository.TypeIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TypeForfaitInternetService {
    @Autowired
    private TypeIntRepository typeForfaitInternetRepository;

    public List<TypeInternet> getAllTypesForfaitInternet() {
        return typeForfaitInternetRepository.findAll();
    }

    public TypeInternet getTypeForfaitInternetById(UUID id) {
        return typeForfaitInternetRepository.findById(id).orElse(null);
    }

    public TypeInternet saveTypeForfaitInternet(TypeInternet typeForfaitInternet) {
        return typeForfaitInternetRepository.save(typeForfaitInternet);
    }

    public void deleteTypeForfaitInternet(UUID id) {
        typeForfaitInternetRepository.deleteById(id);
    }
}
