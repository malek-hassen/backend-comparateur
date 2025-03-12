package com.example.comparateur.service;


import com.example.comparateur.classes.Fournisseurs;
import com.example.comparateur.repositories.FournisseursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseursService {

        private FournisseursRepository fournisseursRepository;

    public List<Fournisseurs> getAllFournisseurs() {
        return fournisseursRepository.findAll();
    }

    public Fournisseurs getFournisseurById(Long id) {
        return fournisseursRepository.findById(id).orElse(null);
    }

    public Fournisseurs saveFournisseurs(Fournisseurs fournisseurs) {
        return fournisseursRepository.save(fournisseurs);
    }

    public void deleteFournisseurs(Long id) {
        fournisseursRepository.deleteById(id);
    }
}
