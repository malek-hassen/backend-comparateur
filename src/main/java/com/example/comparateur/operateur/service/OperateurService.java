package com.example.comparateur.operateur.service;


import com.example.comparateur.operateur.dto.OperateurDTO;
import com.example.comparateur.operateur.entity.Operateur;
import com.example.comparateur.operateur.mapper.OperateurMapper;
import com.example.comparateur.operateur.repository.OperateurRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OperateurService {

    private final OperateurRepository operateursRepository;

    private final OperateurMapper operateurMapper ;

    public OperateurService(OperateurRepository operateursRepository, OperateurMapper operateurMapper) {
        this.operateursRepository = operateursRepository;
        this.operateurMapper = operateurMapper;
    }

    public List<Operateur> getAllOperateurs() {
        return StreamSupport.stream(operateursRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    public Operateur getOperateursById(UUID id) {

        return operateursRepository.findById(id)
                .orElse(null);
    }
    @Transactional
    public Operateur saveOperateurs(OperateurDTO operateursDto) {
        Operateur operateur = operateurMapper.toEntity(operateursDto);

        return operateursRepository.save(operateur);
    }
    public Operateur updateOperateurs(Operateur operateur) {
        return operateursRepository.save(operateur);
    }

    public void deleteOperateurs(UUID id) {
        operateursRepository.deleteById(id);
    }
}
