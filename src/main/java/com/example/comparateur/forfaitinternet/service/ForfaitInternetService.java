package com.example.comparateur.forfaitinternet.service;

import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import com.example.comparateur.Operateur.Operateur;
import com.example.comparateur.forfaitinternet.repository.ForfaitInternetRepository;
import com.example.comparateur.Operateur.OperateurRepository;
import com.example.comparateur.forfaitinternet.repository.TypeIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ForfaitInternetService {

    @Autowired
    private ForfaitInternetRepository forfaitInternetRepository;

    @Autowired
    private TypeIntRepository typeForfaitInternetRepository;

    @Autowired
    private OperateurRepository operateursRepository;

    public List<ForfaitInternet> getAllForfaitsInternet() {
        return forfaitInternetRepository.findAll();
    }

    public ForfaitInternet getForfaitInternetById(UUID id) {
        return forfaitInternetRepository.findById(id).orElse(null);
    }

    public ForfaitInternet saveForfaitInternet(ForfaitInternet forfaitInternet, UUID typeForfaitInternetId, UUID operateursId) {
        TypeInternet typeInternet = typeForfaitInternetRepository.findById(typeForfaitInternetId).orElse(null);
        Operateur operateurs = operateursRepository.findById(operateursId).orElse(null);
        forfaitInternet.setTypeBox((List<TypeInternet>) typeInternet);
        forfaitInternet.setOperateur(operateurs);
        return forfaitInternetRepository.save(forfaitInternet);
    }

    public void deleteForfaitInternet(UUID id) {
        forfaitInternetRepository.deleteById(id);
    }
}

