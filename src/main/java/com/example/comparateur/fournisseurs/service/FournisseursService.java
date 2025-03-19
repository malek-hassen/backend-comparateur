package com.example.comparateur.fournisseurs.service;

import com.example.comparateur.fournisseurs.dto.FournisseurDto;
import com.example.comparateur.fournisseurs.entity.Fournisseurs;
import com.example.comparateur.fournisseurs.mapper.FournisseurMapper;
import com.example.comparateur.fournisseurs.repository.FournisseursRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FournisseursService {

    private final FournisseursRepository fournisseursRepository;


    private final FournisseurMapper fournisseurMapper ;

    public FournisseursService(FournisseursRepository fournisseursRepository, FournisseurMapper fournisseurMapper) {
        this.fournisseursRepository = fournisseursRepository;
        this.fournisseurMapper= fournisseurMapper;
    }

    public List<Fournisseurs> getAllFournisseurs() {
        return StreamSupport.stream(fournisseursRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    public Fournisseurs getFournisseursById(UUID id) {

        return fournisseursRepository.findById(id)
                .orElse(null);
    }
    @Transactional
    public Fournisseurs saveFournisseurs(FournisseurDto fournisseursDto) {
        Fournisseurs fournisseurs = fournisseurMapper.toEntity(fournisseursDto);

        return fournisseursRepository.save(fournisseurs);
    }
    public Fournisseurs updateFournisseurs(Fournisseurs fournisseurs) {
        return fournisseursRepository.save(fournisseurs);
    }

    public void deleteFournisseurs(UUID id) {
        fournisseursRepository.deleteById(id);
    }
}
