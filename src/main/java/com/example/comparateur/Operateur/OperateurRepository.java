package com.example.comparateur.Operateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, UUID> {
    Optional<Operateur> findById(UUID operateursId);
}



