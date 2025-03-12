package com.example.comparateur.Operateur;


import com.example.comparateur.Operateur.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OperateurService {
    @Autowired
    private OperateurRepository operateursRepository;

    public List<Operateur> getAllOperateurs() {
        return operateursRepository.findAll();
    }

    public Operateur getOperateursById(UUID id) {
        return operateursRepository.findById(id).orElse(null);
    }

    public Operateur saveOperateurs(Operateur operateurs) {
        return operateursRepository.save(operateurs);
    }

    public void deleteOperateurs(UUID id) {
        operateursRepository.deleteById(id);
    }
}
