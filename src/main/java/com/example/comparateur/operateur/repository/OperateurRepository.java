package com.example.comparateur.operateur.repository;

import com.example.comparateur.operateur.entity.Operateur;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, UUID> {

    Optional<Operateur> findById(UUID operateursId);
}



